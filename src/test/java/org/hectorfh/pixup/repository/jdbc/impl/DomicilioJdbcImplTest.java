package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Domicilio;
import org.hectorfh.pixup.repository.jdbc.DomicilioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( DomicilioJdbcImpl.getInstance( ) );
        DomicilioJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        List <Domicilio> list = domicilioJdbc.findAll();
        assertNotNull(list );
        assertTrue(list.size() >= 0);
        assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Domicilio domicilio = new Domicilio();
        boolean res = false;
        domicilio.setCalle("Calle 1");
        domicilio.setNumExterior("12A");
        domicilio.setNumInterior("3B");
        domicilio.setColonia_id(1);
        domicilio.setTipoDomicilio_id(1);
        domicilio.setUsuario_id(1);
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        res = domicilioJdbc.save( domicilio );
        assertEquals(true, res);

        System.out.println(domicilio);
    }

    @Test
    void update() {

        Domicilio domicilio = new Domicilio();
        boolean res = false;
        domicilio.setId(3);
        domicilio.setCalle("Calle 2");
        domicilio.setNumExterior("14C");
        domicilio.setNumInterior("5D");
        domicilio.setColonia_id(1);
        domicilio.setTipoDomicilio_id(1);
        domicilio.setUsuario_id(1);
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        res = domicilioJdbc.update( domicilio );
        assertEquals( true, res);

        System.out.println( domicilio );

    }

    @Test
    void delete() {

        Domicilio domicilio = new Domicilio();
        boolean res = false;
        domicilio.setId(3);

        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        res = domicilioJdbc.delete(domicilio);
        assertEquals( true, res);

    }

    @Test
    void findById() {

        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        Domicilio domicilio = domicilioJdbc.findById(3);
        assertNotNull(domicilio);
        System.out.println(domicilio);

    }
}