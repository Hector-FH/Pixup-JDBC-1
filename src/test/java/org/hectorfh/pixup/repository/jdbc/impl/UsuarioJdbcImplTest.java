package org.hectorfh.pixup.repository.jdbc.impl;

import org.hectorfh.pixup.model.Usuario;
import org.hectorfh.pixup.repository.jdbc.UsuarioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioJdbcImplTest {

    @Test
    void getInstance() {

        assertNotNull( UsuarioJdbcImpl.getInstance( ) );
        UsuarioJdbcImpl.getInstance();

    }

    @Test
    void findAll() {

        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        List<Usuario> list = usuarioJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        assertEquals(2,list.size());
        list.stream().forEach(System.out::println);

    }

    @Test
    void save() {

        Usuario usuario = new Usuario();
        boolean res = false;
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        usuario.setId(2);
        usuario.setNombre("Pedro");
        usuario.setPrimerApellido("PEREZ");
        usuario.setSegundoApellido("LOPEZ");
        usuario.setPassword("123456");
        usuario.setEmail("juan@correo.com");
        res = usuarioJdbc.save(usuario);
        assertEquals(true, res);

    }

    @Test
    void update() {

        Usuario usuario = new Usuario();
        boolean res = false;
        usuario.setId(2);
        usuario.setNombre("CARLOS");
        usuario.setPrimerApellido("RAMIREZ");
        usuario.setSegundoApellido("GOMEZ");
        usuario.setPassword("654321");
        usuario.setEmail("carlos@correo.com");
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        res = usuarioJdbc.update(usuario);
        assertEquals(true, res);

    }

    @Test
    void delete() {

        Usuario usuario = new Usuario();
        boolean res = false;
        usuario.setId(99);
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        res = usuarioJdbc.delete(usuario);
        assertEquals(true, res);

    }

    @Test
    void findById() {

        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        Usuario usuario = usuarioJdbc.findById(2);
        assertNotNull(usuario);
        assertEquals(2, usuario.getId());
        System.out.println(usuario);



    }
}