package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Colonia;
import org.hectorfh.pixup.repository.jdbc.ColoniaJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( ColoniaJdbcImpl.getInstance( ) );
        ColoniaJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        ColoniaJdbc coloniaJdbc = ColoniaJdbcImpl.getInstance();
        List<Colonia> list = coloniaJdbc.findAll();
            assertNotNull(list);
            assertTrue(list.size() >= 0);
            assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Colonia colonia = new Colonia();
        colonia.setNombre("Colonia 1");
        colonia.setCp("12345");
        colonia.setMunicipio_id(1);
        ColoniaJdbc coloniaJdbc = ColoniaJdbcImpl.getInstance();
        boolean res = coloniaJdbc.save(colonia);
        assertTrue(res);

        System.out.println( colonia);
    }

    @Test
    void update() {

        Colonia colonia = new Colonia();
        colonia.setId(1);
        colonia.setNombre("Colonia 2");
        colonia.setCp("54321");
        colonia.setMunicipio_id(1);
        ColoniaJdbc coloniaJdbc = ColoniaJdbcImpl.getInstance();
        boolean res = coloniaJdbc.update(colonia);
        assertTrue(res);

        System.out.println( colonia );
    }

    @Test
    void delete() {

        Colonia colonia = new Colonia();
        colonia.setId(1);

        ColoniaJdbc coloniaJdbc = ColoniaJdbcImpl.getInstance();
        boolean res = coloniaJdbc.delete(colonia);
        assertTrue(res);

    }

    @Test
    void findById() {

        ColoniaJdbc coloniaJdbc = ColoniaJdbcImpl.getInstance();
        Colonia colonia = coloniaJdbc.findById(1);
        assertNotNull(colonia);
        System.out.println(colonia);

    }
}