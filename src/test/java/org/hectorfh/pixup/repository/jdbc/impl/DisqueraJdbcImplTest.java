package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Disquera;
import org.hectorfh.pixup.repository.jdbc.DisqueraJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraJdbcImplTest {


    @Test
    void getInstance() {

        assertNotNull(DisqueraJdbcImpl.getInstance( ) );
        DisqueraJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        List<Disquera> list = disqueraJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        assertEquals(1,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Disquera disquera = new Disquera();
        boolean res = false;
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        disquera.setNombre ("SONY");
        res = disqueraJdbc.save( disquera );
        assertEquals( true, res);

        System.out.println( disquera );
    }

    @Test
    void update() {

        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setNombre("VEVO");
        disquera.setId(1);
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        res = disqueraJdbc.update( disquera );
        assertEquals( true, res);

        System.out.println( disquera );
    }

    @Test
    void delete() {

        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setId(1);
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        res = disqueraJdbc.delete( disquera );
        assertEquals( true, res);

        System.out.println("Eliminado");
    }

    @Test
    void findById() {

        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        Disquera disquera = disqueraJdbc.findById(1);
        assertNotNull( disquera );
        assertEquals(1, disquera.getId());

        System.out.println( disquera );

    }


}