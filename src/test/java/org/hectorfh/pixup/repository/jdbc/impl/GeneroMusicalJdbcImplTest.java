package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.GeneroMusical;
import org.hectorfh.pixup.repository.jdbc.GeneroMusicalJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroMusicalJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull(GeneroMusicalJdbcImpl.getInstance( ) );
        GeneroMusicalJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        List<GeneroMusical> list = generoMusicalJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        GeneroMusical generoMusical = new GeneroMusical();
        boolean res = false;
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        generoMusical.setDescripcion("Cumbia");
        res = generoMusicalJdbc.save( generoMusical );
        assertEquals( true, res);

        System.out.println( generoMusical );
    }

    @Test
    void update() {

        GeneroMusical generoMusical = new GeneroMusical();
        boolean res = false;
        generoMusical.setDescripcion("Rock");
        generoMusical.setId(1);
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        res = generoMusicalJdbc.update( generoMusical );
        assertEquals( true, res);

        System.out.println( generoMusical );
    }

    @Test
    void delete() {

        GeneroMusical generoMusical = new GeneroMusical();
        boolean res = false;
        generoMusical.setId(1);
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        res = generoMusicalJdbc.delete( generoMusical );
        assertEquals( true, res);

        System.out.println("Eliminado");

    }

    @Test
    void findById() {

        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        GeneroMusical generoMusical = generoMusicalJdbc.findById(1);
        assertNotNull( generoMusical );
        assertEquals(1, generoMusical.getId());
        System.out.println( generoMusical );

    }


}