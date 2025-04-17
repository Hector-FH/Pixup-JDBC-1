package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Estado;
import org.hectorfh.pixup.model.Pago;
import org.hectorfh.pixup.repository.jdbc.Conexion;
import org.hectorfh.pixup.repository.jdbc.PagoJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PagoJdbcImpl extends Conexion<Pago> implements PagoJdbc {

    private static PagoJdbc pagoJdbc;

    public PagoJdbcImpl() {}

    public static PagoJdbc getInstance()
    {
        if ( pagoJdbc == null)
        {
            pagoJdbc = new PagoJdbcImpl();
        }
        return pagoJdbc;
    }

    @Override
    public List<Pago> findAll() {

        Statement statement = null;
        ResultSet resultSet = null;
        List<Pago> pagos = null;
        Pago pago = null;
        String query = "SELECT * FROM TBL_PAGO";

        try {
            if( !openConnection() )
            {
                System.out.println("Error en conexión");
                return null;
            }

            statement = connection.createStatement( );
            resultSet = statement.executeQuery( query );
            pagos = new ArrayList<>( );
            while( resultSet.next() )
            {
                pago = new Pago();
                pago.setId( resultSet.getInt( 1 ) );
                pago.setNum_tarjeta( resultSet.getString( 2 ) );
                pago.setFecha( resultSet.getString( 3 ) );
                pago.setOrden_id( resultSet.getInt( 4 ) );
                pagos.add( pago );
            }
            resultSet.close();
            statement.close();
            closeConnection( );
            return pagos;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean save(Pago pago) {

        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_PAGO (NUMERO_TARJETA, FECHA, TBL_ORDEN_ID) VALUES (?, ?, ?)";
        int res = 0;

        try {
            if (!openConnection())
            {
                System.out.println("Error en Conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pago.getNum_tarjeta( ) );
            preparedStatement.setString(2, pago.getFecha( ) );
            preparedStatement.setInt(3, pago.getOrden_id( ) );
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
    public boolean update(Pago pago) {

        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_PAGO SET NUMERO_TARJETA = ?, FECHA = ?, TBL_ORDEN_ID = ?  WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection())
            {
                System.out.println("Error en Conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pago.getNum_tarjeta( ) );
            preparedStatement.setString(2, pago.getFecha( ) );
            preparedStatement.setInt(3, pago.getOrden_id( ) );
            preparedStatement.setInt(4, pago.getId( ) );
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
    public boolean delete(Pago pago) {

        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_PAGO WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection())
            {
                System.out.println("Error en Conexión");
                return false;
            }

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pago.getId( ) );
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
    public Pago findById(Integer id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Pago pago = null;
        String query = "SELECT * FROM TBL_PAGO WHERE ID = ?";

        try {
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
                pago = new Pago();
                pago.setId( resultSet.getInt( 1 ) );
                pago.setNum_tarjeta( resultSet.getString( 2 ) );
                pago.setFecha( resultSet.getString(3 ) );
                pago.setOrden_id( resultSet.getInt(4) );
            }
            resultSet.close();
            preparedStatement.close();
            closeConnection( );
            return pago;
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
        PagoJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach( System.out::println);
    }
*/

}
