package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Usuario;

import java.util.List;

public interface UsuarioJdbc
{

    List<Usuario> findAll();
}
