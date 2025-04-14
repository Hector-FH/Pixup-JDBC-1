package org.hectorfh.pixup.repository.jdbc.impl;


import org.hectorfh.pixup.model.GeneroMusical;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.GeneroMusicalJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneroMusicalJdbcImpl extends Conexion<GeneroMusical> implements GeneroMusicalJdbc {
    private static GeneroMusicalJdbc generoMusicalJdbc;

    private GeneroMusicalJdbcImpl() {
    }

    public static GeneroMusicalJdbc getInstance() {
        if (generoMusicalJdbc == null) {
            generoMusicalJdbc = new GeneroMusicalJdbcImpl();
        }
        return generoMusicalJdbc;
    }

    @Override
    public List<GeneroMusical> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<GeneroMusical> generosMusicales = null;
        GeneroMusical generoMusical = null;
        String query = "SELECT * FROM TBL_GENERO_MUSICAL";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            generosMusicales = new ArrayList<>();
            while (resultSet.next()) {
                generoMusical = new GeneroMusical();
                generoMusical.setId(resultSet.getInt(1));
                generoMusical.setNombre(resultSet.getString(2));
                generosMusicales.add(generoMusical);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return generosMusicales;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] a) {
        GeneroMusicalJdbcImpl
                .getInstance()
                .findAll()
                .forEach(System.out::println);
    }
}