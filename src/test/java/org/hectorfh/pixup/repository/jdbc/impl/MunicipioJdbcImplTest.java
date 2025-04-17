package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Municipio;
import org.hectorfh.pixup.repository.jdbc.MunicipioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( MunicipioJdbcImpl.getInstance());
        MunicipioJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        List<Municipio>list = municipioJdbc.findAll();
                assertNotNull(list);
                assertTrue(list.size()>=0);
                assertEquals(0,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Municipio municipio = new Municipio();
        boolean res = false;
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        municipio.setMunicipio("TLALNEPANTLA");
        municipio.setEstado_id(1);
        res = municipioJdbc.save( municipio );
        assertEquals(true, res);

        System.out.println( municipio );
    }

    @Test
    void update() {

        Municipio municipio = new Municipio();
        boolean res = false;
        municipio.setMunicipio("IZTACALCO");
        municipio.setEstado_id(1);
        municipio.setId(1);
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        res = municipioJdbc.update( municipio );
        assertEquals(true, res);

    }

    @Test
    void delete() {

        Municipio municipio = new Municipio();
        boolean res = false;
        municipio.setId(4);
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        res = municipioJdbc.delete( municipio );
        assertEquals( true, res);

    }

    @Test
    void findById()
    {

        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        Municipio municipio = municipioJdbc.findById(1);
        assertNotNull( municipio );
        assertTrue("TLALNEPANTLA".equals(municipio.getMunicipio()));
        assertEquals(1, municipio.getEstado_id());
        assertEquals(1, municipio.getId());
        System.out.println( municipio );

    }
}