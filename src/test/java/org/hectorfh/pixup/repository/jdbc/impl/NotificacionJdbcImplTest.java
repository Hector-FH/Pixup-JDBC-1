package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Notificacion;
import org.hectorfh.pixup.repository.jdbc.NotificacionJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotificacionJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull(NotificacionJdbcImpl.getInstance( ) );
        NotificacionJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        NotificacionJdbc notificacionJdbc = NotificacionJdbcImpl.getInstance();
        List<Notificacion> list = notificacionJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Notificacion notificacion = new Notificacion();
        boolean res = false;
        NotificacionJdbc notificacionJdbc = NotificacionJdbcImpl.getInstance();
        notificacion.setFecha ("2025-10-01");
        notificacion.setUsuario_id(1);
        notificacion.setTipo_notificacion_id(1);
        res = notificacionJdbc.save( notificacion );
        assertEquals( true, res);

        System.out.println( notificacion );

    }

    @Test
    void update() {

        Notificacion notificacion = new Notificacion();
        boolean res = false;
        notificacion.setFecha("2014-10-01");
        notificacion.setUsuario_id(1);
        notificacion.setTipo_notificacion_id(1);
        notificacion.setId(1);
        NotificacionJdbc notificacionJdbc = NotificacionJdbcImpl.getInstance();
        res = notificacionJdbc.update( notificacion );
        assertEquals( true, res);

        System.out.println( notificacion );
    }

    @Test
    void delete() {

        Notificacion notificacion = new Notificacion();
        boolean res = false;
        notificacion.setId(1);
        NotificacionJdbc notificacionJdbc = NotificacionJdbcImpl.getInstance();
        res = notificacionJdbc.delete( notificacion );
        assertEquals( true, res);

        System.out.println("Eliminado");
    }

    @Test
    void findById() {

        NotificacionJdbc notificacionJdbc = NotificacionJdbcImpl.getInstance();
        Notificacion notificacion = notificacionJdbc.findById(1);
        assertNotNull(notificacion);
        System.out.println(notificacion);

    }
}