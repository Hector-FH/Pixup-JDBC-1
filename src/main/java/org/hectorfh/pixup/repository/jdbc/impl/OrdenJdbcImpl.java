package org.hectorfh.pixup.repository.jdbc.impl;


import org.hectorfh.pixup.model.Orden;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.OrdenJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdenJdbcImpl extends Conexion<Orden> implements OrdenJdbc {
    private static OrdenJdbc ordenJdbc;

    private OrdenJdbcImpl() {
    }

    public static OrdenJdbc getInstance() {
        if (ordenJdbc == null) {
            ordenJdbc = new OrdenJdbcImpl();
        }
        return ordenJdbc;
    }

    @Override
    public List<Orden> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Orden> ordenes = null;
        Orden orden = null;
        String query = "SELECT * FROM TBL_ORDEN";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ordenes = new ArrayList<>();
            while (resultSet.next()) {
                orden = new Orden();
                orden.setId(resultSet.getInt(1));
                orden.setCostoTotal(resultSet.getFloat(2));
                orden.setFecha(resultSet.getString(3));
                orden.setCantidadTotal(resultSet.getInt(4));
                orden.setEstatusEnvio(resultSet.getString(5));
                orden.setCostoEnvio(resultSet.getFloat(6));
                orden.setUsuario_id(resultSet.getInt(7));
                ordenes.add(orden);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return ordenes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Orden orden) {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_ORDEN (costo_total, fecha, cantidad_total, estatus_envio, costo_envio, tbl_usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en Conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query );
            preparedStatement.setFloat(1, orden.getCostoTotal());
            preparedStatement.setString(2, orden.getFecha());
            preparedStatement.setInt(3, orden.getCantidadTotal());
            preparedStatement.setString(4, orden.getEstatusEnvio());
            preparedStatement.setFloat(5, orden.getCostoEnvio());
            preparedStatement.setInt(6, orden.getUsuario_id());

            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;

        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Orden orden) {

        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_ORDEN SET costo_total = ?, fecha = ?, cantidad_total = ?, estatus_envio = ?, costo_envio = ?, tbl_usuario_id = ? WHERE id = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en Conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, orden.getCostoTotal());
            preparedStatement.setString(2, orden.getFecha());
            preparedStatement.setInt(3, orden.getCantidadTotal());
            preparedStatement.setString(4, orden.getEstatusEnvio());
            preparedStatement.setFloat(5, orden.getCostoEnvio());
            preparedStatement.setInt(6, orden.getUsuario_id());
            preparedStatement.setInt(7, orden.getId());
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
    public boolean delete(Orden orden) {

        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_ORDEN WHERE id = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en Conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orden.getId());
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
    public Orden findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Orden orden = null;
        String query = "SELECT * FROM TBL_ORDEN WHERE id = ?";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                orden = new Orden();
                orden.setId(resultSet.getInt(1));
                orden.setCostoTotal(resultSet.getFloat(2));
                orden.setFecha(resultSet.getString(3));
                orden.setCantidadTotal(resultSet.getInt(4));
                orden.setEstatusEnvio(resultSet.getString(5));
                orden.setCostoEnvio(resultSet.getFloat(6));
                orden.setUsuario_id(resultSet.getInt(7));
            }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
            return orden;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


/*
    public static void main(String[] a) {
        OrdenJdbcImpl
                .getInstance()
                .findAll()
                .forEach(System.out::println);
    }

 */
}