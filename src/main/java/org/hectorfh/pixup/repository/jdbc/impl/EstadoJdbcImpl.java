package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Estado;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.EstadoJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoJdbcImpl extends Conexion<Estado> implements EstadoJdbc {

    private static EstadoJdbc estadoJdbc;

    private EstadoJdbcImpl() {
    }

    public static EstadoJdbc getInstance( )
    {
        if( estadoJdbc == null )
        {
            estadoJdbc = new EstadoJdbcImpl( );
        }
        return estadoJdbc;
    }

    @Override
    public List<Estado> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Estado>estados = null;
        Estado estado = null;
        String query = "SELECT * FROM TBL_ESTADO";

        try
        {
            if( !openConnection() )
            {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement( );
            resultSet = statement.executeQuery( query );
            estados = new ArrayList<>( );
            while( resultSet.next() )
            {
                estado = new Estado();
                estado.setId( resultSet.getInt( 1 ) );
                estado.setNombre( resultSet.getString( 2 ) );
                estados.add( estado );
            }
            resultSet.close();
            statement.close();
            closeConnection( );
            return estados;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Estado estado)
    {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_ESTADO (ESTADO) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en Conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, estado.getNombre( ) );
            res = preparedStatement.executeUpdate( );
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
    public boolean update(Estado estado)
    {

        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_ESTADO SET ESTADO = ?  WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en Conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, estado.getNombre( ) );
            preparedStatement.setInt(2, estado.getId( ) );
            res = preparedStatement.executeUpdate( );
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
    public boolean delete(Estado estado) {

        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_ESTADO WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection())
            {
                System.out.println("Error en Conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, estado.getId( ) );
            res = preparedStatement.executeUpdate( );
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
    public Estado findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Estado estado = null;
        String query = "SELECT * FROM TBL_ESTADO WHERE ID = ?";

        try
        {
            if( !openConnection() )
            {
                System.out.println("Error en conexión");
                return null;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery(  );

            if ( resultSet.next() )
            {
                estado = new Estado();
                estado.setId( resultSet.getInt( 1 ) );
                estado.setNombre( resultSet.getString( 2 ) );

            }
            resultSet.close();
            preparedStatement.close();
            closeConnection( );
            return estado;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;

    }



/*
    public static void main( String a[] )
    {
        EstadoJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach( System.out::println);
    }

*/

}
