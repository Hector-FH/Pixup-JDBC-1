package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Pago;
import org.hectorfh.pixup.repository.jdbc.PagoJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagoJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( PagoJdbcImpl.getInstance( ) );
        PagoJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        PagoJdbc pagoJdbc = PagoJdbcImpl.getInstance();
        List<Pago> list = pagoJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Pago pago = new Pago();
        boolean res = false;
        PagoJdbc pagoJdbc = PagoJdbcImpl.getInstance();
        pago.setNum_tarjeta ("1234");
        pago.setFecha("2025-10-01");
        pago.setOrden_id(1);
        res = pagoJdbc.save( pago );
        assertEquals( true, res);

        System.out.println( pago );
    }

    @Test
    void update() {

        Pago pago = new Pago();
        boolean res = false;
        pago.setNum_tarjeta ("4321");
        pago.setFecha("2014-10-01");
        pago.setOrden_id(1);
        pago.setId(1); //ID EXISTENTE
        PagoJdbc pagoJdbc = PagoJdbcImpl.getInstance();
        res = pagoJdbc.update( pago );
        assertEquals( true, res);

        System.out.println( pago );
    }

    @Test
    void delete() {

        Pago pago = new Pago();
        boolean res = false;
        pago.setId(1);
        PagoJdbc pagoJdbc = PagoJdbcImpl.getInstance();
        res = pagoJdbc.delete( pago );
        assertEquals( true, res);

        System.out.println("Eliminado");
    }

    @Test
    void findById() {

        PagoJdbc pagoJdbc = PagoJdbcImpl.getInstance();
        Pago pago = pagoJdbc.findById(1);
        assertNotNull(pago);
        System.out.println(pago);

    }
}