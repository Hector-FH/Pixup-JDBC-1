package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Artista;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.ArtistaJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistaJdbcImpl extends Conexion<Artista> implements ArtistaJdbc {
    private static ArtistaJdbc artistaJdbc;

    private ArtistaJdbcImpl() {
    }
    public static ArtistaJdbc getInstance() {
        if (artistaJdbc == null) {
            artistaJdbc = new ArtistaJdbcImpl();
        }
        return artistaJdbc;
    }

    @Override
    public List<Artista> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Artista> artistas = null;
        Artista artista = null;
        String query = "SELECT * FROM TBL_ARTISTA";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            artistas = new ArrayList<>();
            while (resultSet.next()) {
                artista = new Artista();
                artista.setId(resultSet.getInt(1));
                artista.setNombre(resultSet.getString(2));
                artistas.add(artista);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return artistas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] a) {
        ArtistaJdbcImpl
                .getInstance()
                .findAll()
                .forEach(System.out::println);
    }
}