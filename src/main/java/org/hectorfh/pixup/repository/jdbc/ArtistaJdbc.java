package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Artista;
import org.hectorfh.pixup.model.Colonia;

import java.util.List;

public interface ArtistaJdbc
{

    List<Artista> findAll();
    boolean save(Artista artista);
    boolean update(Artista artista);
    boolean delete(Artista artista);
    Artista findById(Integer id);

}
