package org.hectorfh.pixup.repository.jdbc.impl;


import org.hectorfh.pixup.model.Disco;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.DiscoJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiscoJdbcImpl extends Conexion<Disco> implements DiscoJdbc {
    private static DiscoJdbc discoJdbc;

    private DiscoJdbcImpl() {
    }

    public static DiscoJdbc getInstance() {
        if (discoJdbc == null) {
            discoJdbc = new DiscoJdbcImpl();
        }
        return discoJdbc;
    }

    @Override
    public List<Disco> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Disco> discos = null;
        Disco disco = null;
        String query = "SELECT * FROM TBL_DISCO";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            discos = new ArrayList<>();
            while (resultSet.next()) {
                disco = new Disco();
                disco.setId(resultSet.getInt(1));
                disco.setTitulo(resultSet.getString(2));
                disco.setPrecio(resultSet.getFloat(3));
                disco.setExistencia(resultSet.getInt(4));
                disco.setDescuento(resultSet.getFloat(5));
                disco.setFechaLanzamiento(resultSet.getString(6));
                disco.setImagen(resultSet.getString(7));
                disco.setArtista_id(resultSet.getInt(8));
                disco.setDisquera_id(resultSet.getInt(9));
                disco.setGeneroMusical_id(resultSet.getInt(10));
                discos.add(disco);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return discos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Disco disco) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_DISCO (titulo, precio, existencia, descuento, fecha_lanzamiento, imagen, tbl_artista_id, tbl_disquera_id, tbl_genero_musical_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disco.getTitulo());
            preparedStatement.setFloat(2, disco.getPrecio());
            preparedStatement.setInt(3, disco.getExistencia());
            preparedStatement.setFloat(4, disco.getDescuento());
            preparedStatement.setString(5, disco.getFechaLanzamiento());
            preparedStatement.setString(6, disco.getImagen());
            preparedStatement.setInt(7, disco.getArtista_id());
            preparedStatement.setInt(8, disco.getDisquera_id());
            preparedStatement.setInt(9, disco.getGeneroMusical_id());

            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Disco disco) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_DISCO SET titulo = ?, precio = ?, existencia = ?, descuento = ?, fecha_lanzamiento = ?, imagen = ?, tbl_artista_id = ?, tbl_disquera_id = ?, tbl_genero_musical_id = ? WHERE id = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disco.getTitulo());
            preparedStatement.setFloat(2, disco.getPrecio());
            preparedStatement.setInt(3, disco.getExistencia());
            preparedStatement.setFloat(4, disco.getDescuento());
            preparedStatement.setString(5, disco.getFechaLanzamiento());
            preparedStatement.setString(6, disco.getImagen());
            preparedStatement.setInt(7, disco.getArtista_id());
            preparedStatement.setInt(8, disco.getDisquera_id());
            preparedStatement.setInt(9, disco.getGeneroMusical_id());
            preparedStatement.setInt(10, disco.getId());

            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Disco disco) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_DISCO WHERE id = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, disco.getId());

            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Disco findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Disco disco = null;
        String query = "SELECT * FROM TBL_DISCO WHERE id = ?";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                disco = new Disco();
                disco.setId(resultSet.getInt(1));
                disco.setTitulo(resultSet.getString(2));
                disco.setPrecio(resultSet.getFloat(3));
                disco.setExistencia(resultSet.getInt(4));
                disco.setDescuento(resultSet.getFloat(5));
                disco.setFechaLanzamiento(resultSet.getString(6));
                disco.setImagen(resultSet.getString(7));
                disco.setArtista_id(resultSet.getInt(8));
                disco.setDisquera_id(resultSet.getInt(9));
                disco.setGeneroMusical_id(resultSet.getInt(10));
            }

            resultSet.close();
            preparedStatement.close();
            closeConnection();
            return disco;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



/*
    public static void main(String[] a) {
        DiscoJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach(System.out::println);
    }


 */
}