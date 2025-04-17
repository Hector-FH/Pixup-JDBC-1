package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.TipoDomicilio;
import org.hectorfh.pixup.repository.jdbc.TipoDomicilioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoDomicilioJdbcImplTest {

    TipoDomicilioJdbc tipoDomicilioJdbc;

    @Test
    void getInstance() {

        assertNotNull(TipoDomicilioJdbcImpl.getInstance( ) );
        TipoDomicilioJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        TipoDomicilioJdbc tipoDomicilioJdbc = TipoDomicilioJdbcImpl.getInstance();
        List<TipoDomicilio> list = tipoDomicilioJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        TipoDomicilio tipoDomicilio = new TipoDomicilio();
        boolean res = false;
        TipoDomicilioJdbc tipoDomicilioJdbc = TipoDomicilioJdbcImpl.getInstance();
        tipoDomicilio.setDescripcion ("Tipo 1");
        res = tipoDomicilioJdbc.save( tipoDomicilio );
        assertEquals( true, res);

        System.out.println( tipoDomicilio );
    }

    @Test
    void update() {

        TipoDomicilio tipoDomicilio = new TipoDomicilio();
        boolean res = false;
        tipoDomicilio.setDescripcion("Tipo 2");
        tipoDomicilio.setId(1);
        TipoDomicilioJdbc tipoDomicilioJdbc = TipoDomicilioJdbcImpl.getInstance();
        res = tipoDomicilioJdbc.update( tipoDomicilio );
        assertEquals( true, res);

        System.out.println( tipoDomicilio );
    }

    @Test
    void delete() {

        TipoDomicilio tipoDomicilio = new TipoDomicilio();
        boolean res = false;
        tipoDomicilio.setId(1);
        TipoDomicilioJdbc tipoDomicilioJdbc = TipoDomicilioJdbcImpl.getInstance();
        res = tipoDomicilioJdbc.delete( tipoDomicilio );
        assertEquals( true, res);

        System.out.println("Eliminado");
    }

    @Test
    void findById() {

        TipoDomicilioJdbc tipoDomicilioJdbc = TipoDomicilioJdbcImpl.getInstance();
        TipoDomicilio tipoDomicilio = tipoDomicilioJdbc.findById(1);
        assertNotNull( tipoDomicilio );
        System.out.println( tipoDomicilio );

    }
}