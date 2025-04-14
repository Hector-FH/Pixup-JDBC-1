package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Artista;

import java.util.List;

public interface ArtistaJdbc
{

    List<Artista> findAll();
}
