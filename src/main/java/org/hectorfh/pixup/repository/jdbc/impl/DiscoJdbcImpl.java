package org.hectorfh.pixup.repository.jdbc.impl;


import org.hectorfh.pixup.model.Disco;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.DiscoJdbc;

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
            if (openConnection()) {
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
                disco.setFechaLanzamiento(resultSet.getDate(6));
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

    public static void main(String[] a) {
        DiscoJdbcImpl
                .getInstance()
                .findAll()
                .forEach(System.out::println);
    }
}