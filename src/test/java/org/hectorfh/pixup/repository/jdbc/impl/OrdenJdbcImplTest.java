package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Orden;
import org.hectorfh.pixup.repository.jdbc.OrdenJdbc;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdenJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( OrdenJdbcImpl.getInstance( ) );
        OrdenJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        List<Orden> list = ordenJdbc.findAll();
            assertNotNull(list);
            assertTrue(list.size() >= 0);
            assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Orden orden = new Orden();
        orden.setCostoTotal(1500.5f);
        orden.setFecha("2007-06-40");
        orden.setCantidadTotal(3);
        orden.setEstatusEnvio("Enviado");
        orden.setCostoEnvio(50.0f);
        orden.setUsuario_id(1);

        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        boolean res = ordenJdbc.save(orden);
        assertEquals(true, res);

        System.out.println( orden );
    }

    @Test
    void update() {

        Orden orden = new Orden();
        boolean res = false;
        orden.setId(1);
        orden.setCostoTotal(1600.0f);
        orden.setFecha("2005-10-04");
        orden.setCantidadTotal(4);
        orden.setEstatusEnvio("En Proceso");
        orden.setCostoEnvio(75.0f);
        orden.setUsuario_id(1);

        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        res = ordenJdbc.update(orden);
        assertEquals(true, res);

        System.out.println( orden );
    }

    @Test
    void delete() {

        Orden orden = new Orden();
        orden.setId(1);
        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        boolean res = ordenJdbc.delete(orden);
        assertEquals(true, res);

    }

    @Test
    void findById() {

        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        Orden orden = ordenJdbc.findById(1);
        assertNotNull(orden);
        System.out.println(orden);

    }
}