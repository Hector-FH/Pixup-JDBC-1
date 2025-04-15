package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Disco;
import org.hectorfh.pixup.repository.jdbc.DiscoJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull(DiscoJdbcImpl.getInstance( ) );
        DiscoJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        List<Disco> list = discoJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        assertEquals(3,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Disco disco = new Disco();
        boolean res = false;
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();

        disco.setTitulo("PRUEBA DISCO");
        disco.setPrecio(250.0f);
        disco.setExistencia(15);
        disco.setDescuento(10.0f);
        disco.setFechaLanzamiento("2006-10-56");
        disco.setImagen("https://example.com/imagen.jpg");
        disco.setArtista_id(2);
        disco.setDisquera_id(2);
        disco.setGeneroMusical_id(3);

        res = discoJdbc.save(disco);
        assertEquals(true, res);

    }

    @Test
    void update() {

        Disco disco = new Disco();
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        disco.setId(2);
        disco.setTitulo("Título Actualizado");
        disco.setPrecio(300.00f);
        disco.setExistencia(15);
        disco.setDescuento(0.20f);
        disco.setFechaLanzamiento("2024-05-10");
        disco.setImagen("actualizado.jpg");
        disco.setArtista_id(2);
        disco.setDisquera_id(2);
        disco.setGeneroMusical_id(3);
        boolean res = discoJdbc.update(disco);
        assertTrue(res);

    }

    @Test
    void delete() {

        Disco disco = new Disco();
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        disco.setId(2);
        boolean res = discoJdbc.delete(disco);
        assertTrue(res);

    }

    @Test
    void findById() {

        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        Disco disco = discoJdbc.findById(2); // Asegúrate de que el ID exista
        assertNotNull(disco);
        assertEquals(2, disco.getId());
        System.out.println(disco);

    }
}