package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Estado;
import org.hectorfh.pixup.repository.jdbc.EstadoJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstadoJdbcImplTest {

    EstadoJdbc estadoJdbc;

    @Test
    void getInstance() {

        assertNotNull( EstadoJdbcImpl.getInstance( ) );
        EstadoJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        List<Estado>list = estadoJdbc.findAll();
                assertNotNull(list);
                assertTrue(list.size() >= 1);
                assertEquals(3,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save()
    {
        Estado estado = new Estado();
        boolean res = false;
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        estado.setNombre ("MONTERREY");
        res = estadoJdbc.save( estado );
        assertEquals( true, res);


    }

    @Test
    void update()
    {

        Estado estado = new Estado();
        boolean res = false;
        estado.setNombre("JUAREZ");
        estado.setId(1);
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        res = estadoJdbc.update( estado );
        assertEquals( true, res);

    }

    @Test
    void delete()
    {
        Estado estado = new Estado();
        boolean res = false;
        estado.setId(2);
        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        res = estadoJdbc.delete( estado );
        assertEquals( true, res);


    }

@Test
    void findById()
    {

        EstadoJdbc estadoJdbc = EstadoJdbcImpl.getInstance();
        Estado estado = estadoJdbc.findById(1);
        assertNotNull( estado );
        assertTrue("HIDALGO".equals(estado.getNombre()));
        assertEquals(1, estado.getId());
        System.out.println( estado );


    }


}