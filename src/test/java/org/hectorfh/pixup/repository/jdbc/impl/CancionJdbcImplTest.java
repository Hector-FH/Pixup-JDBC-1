package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Cancion;
import org.hectorfh.pixup.repository.jdbc.CancionJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CancionJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( CancionJdbcImpl.getInstance() );
        CancionJdbcImpl.getInstance();

    }


    @Test
    void findAll() {

        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        List<Cancion> list = cancionJdbc.findAll();
            assertNotNull(list);
            assertTrue(list.size() >= 0);
            assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save()
    {
        Cancion cancion = new Cancion();
        boolean res = false;
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        cancion.setTitulo("Cancion 1");
        cancion.setDuracion("3:20");
        cancion.setDisco_id(1);
        res = cancionJdbc.save( cancion );
        assertEquals( true, res);

        System.out.println(cancion);

    }

    @Test
    void update()
    {

        Cancion cancion = new Cancion();
        boolean res = false;
        cancion.setTitulo("Cancion 2");
        cancion.setDuracion("1:20");
        cancion.setDisco_id(1);
        cancion.setId(1); //ID EXISTENTE
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        res = cancionJdbc.update( cancion );
        assertEquals( true, res);

        System.out.println( cancion );
    }

    @Test
    void delete()
    {
        Cancion cancion = new Cancion();
        boolean res = false;
        cancion.setId(1);
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        res = cancionJdbc.delete( cancion );
        assertEquals( true, res);

    }

    @Test
    void findById()
    {

        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        Cancion cancion = cancionJdbc.findById(1);
        assertNotNull( cancion );
        assertTrue("Cancion 1".equals(cancion.getTitulo()));
        assertEquals(1, cancion.getId());

        System.out.println( cancion );


    }

}