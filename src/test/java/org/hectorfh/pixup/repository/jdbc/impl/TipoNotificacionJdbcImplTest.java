package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.TipoNotificacion;
import org.hectorfh.pixup.repository.jdbc.TipoNotificacionJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoNotificacionJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( TipoNotificacionJdbcImpl.getInstance( ) );
        TipoNotificacionJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        TipoNotificacionJdbc tipoNotificacionJdbc = TipoNotificacionJdbcImpl.getInstance();
        List<TipoNotificacion> list = tipoNotificacionJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        TipoNotificacion tipoNotificacion = new TipoNotificacion();
        boolean res = false;
        TipoNotificacionJdbc tipoNotificacionJdbc = TipoNotificacionJdbcImpl.getInstance();
        tipoNotificacion.setDescripcion ("Tipo 1");
        tipoNotificacion.setRuta_plantilla("Ruta 1");
        res = tipoNotificacionJdbc.save( tipoNotificacion );
        assertEquals( true, res);

        System.out.println( tipoNotificacion );

    }

    @Test
    void update() {

        TipoNotificacion tipoNotificacion = new TipoNotificacion();
        boolean res = false;
        tipoNotificacion.setDescripcion("Tipo 2");
        tipoNotificacion.setRuta_plantilla("Ruta 2");
        tipoNotificacion.setId(1);
        TipoNotificacionJdbc tipoNotificacionJdbc = TipoNotificacionJdbcImpl.getInstance();
        res = tipoNotificacionJdbc.update( tipoNotificacion );
        assertEquals( true, res);

        System.out.println( tipoNotificacion );
    }

    @Test
    void delete() {

        TipoNotificacion tipoNotificacion = new TipoNotificacion();
        boolean res = false;
        tipoNotificacion.setId(1);
        TipoNotificacionJdbc tipoNotificacionJdbc = TipoNotificacionJdbcImpl.getInstance();
        res = tipoNotificacionJdbc.delete( tipoNotificacion );
        assertEquals( true, res);

        System.out.println( tipoNotificacion );

    }

    @Test
    void findById() {

        TipoNotificacionJdbc tipoNotificacionJdbc = TipoNotificacionJdbcImpl.getInstance();
        TipoNotificacion tipoNotificacion = tipoNotificacionJdbc.findById(1);
        assertNotNull(tipoNotificacion);
        System.out.println( tipoNotificacion );

    }
}