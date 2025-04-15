package org.hectorfh.pixup.repository.jdbc.impl;
import org.hectorfh.pixup.model.Colonia;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.ColoniaJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColoniaJdbcImpl extends Conexion<Colonia> implements ColoniaJdbc {

    private static ColoniaJdbc coloniaJdbc;

    private ColoniaJdbcImpl() {
    }

    public static ColoniaJdbc getInstance() {
        if (coloniaJdbc == null) {
            coloniaJdbc = new ColoniaJdbcImpl();
        }
        return coloniaJdbc;
    }

    @Override
    public List<Colonia> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Colonia> colonias = null;
        Colonia colonia = null;
        String query = "SELECT * FROM TBL_COLONIA";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            colonias = new ArrayList<>();
            while (resultSet.next()) {
                colonia = new Colonia();
                colonia.setId(resultSet.getInt(1));
                colonia.setNombre(resultSet.getString(2));
                colonia.setCp(resultSet.getString(3));
                colonia.setMunicipio_id(resultSet.getInt(4));
                colonias.add(colonia);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return colonias;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Colonia colonia) {
        String query = "INSERT INTO TBL_COLONIA (NOMBRE, CP, TBL_MUNICIPIO_ID) VALUES (?, ?, ?)";
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, colonia.getNombre());
            preparedStatement.setString(2, colonia.getCp());
            preparedStatement.setInt(3, colonia.getMunicipio_id());
            int res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Colonia colonia) {
        String query = "UPDATE TBL_COLONIA SET NOMBRE = ?, CP = ?, TBL_MUNICIPIO_ID = ? WHERE ID = ?";
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, colonia.getNombre());
            preparedStatement.setString(2, colonia.getCp());
            preparedStatement.setInt(3, colonia.getMunicipio_id());
            preparedStatement.setInt(4, colonia.getId());
            int res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Colonia colonia) {
        String query = "DELETE FROM TBL_COLONIA WHERE ID = ?";
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, colonia.getId());
            int res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Colonia findById(Integer id) {
        String query = "SELECT * FROM TBL_COLONIA WHERE ID = ?";
        Colonia colonia = null;
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                colonia = new Colonia();
                colonia.setId(resultSet.getInt("ID"));
                colonia.setNombre(resultSet.getString("NOMBRE"));
                colonia.setCp(resultSet.getString("CP"));
                colonia.setMunicipio_id(resultSet.getInt("TBL_MUNICIPIO_ID"));
            }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
            return colonia;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    /*
    public static void main(String[] a) {
        ColoniaJdbcImpl
                .getInstance()
                .findAll()
                .forEach(System.out::println);
    }

     */
}