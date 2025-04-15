package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Artista;
import org.hectorfh.pixup.model.Disco;
import org.hectorfh.pixup.model.Artista;
import org.hectorfh.pixup.repository.jdbc.ArtistaJdbc;
import org.hectorfh.pixup.repository.jdbc.DiscoJdbc;
import org.hectorfh.pixup.repository.jdbc.ArtistaJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull(ArtistaJdbcImpl.getInstance( ) );
        ArtistaJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        List<Artista> list = artistaJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        assertEquals(1,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Artista artista = new Artista();
        boolean res = false;
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        artista.setNombre ("Emmanuel");
        res = artistaJdbc.save( artista );
        assertEquals( true, res);

    }

    @Test
    void update() {

        Artista artista = new Artista();
        boolean res = false;
        artista.setNombre("Juan Gabriel");
        artista.setId(1);
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        res = artistaJdbc.update( artista );
        assertEquals( true, res);

    }

    @Test
    void delete() {

        Artista artista = new Artista();
        boolean res = false;
        artista.setId(1);
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        res = artistaJdbc.delete( artista );
        assertEquals( true, res);

    }

    @Test
    void findById() {

        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        Artista artista = artistaJdbc.findById(1);
        assertNotNull( artista );
        assertEquals(1, artista.getId());
        System.out.println( artista );

    }
}