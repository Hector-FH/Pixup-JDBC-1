package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Disquera;
import org.hectorfh.pixup.model.GeneroMusical;

import java.util.List;

public interface GeneroMusicalJdbc
{

    List<GeneroMusical> findAll();
    boolean save(GeneroMusical generoMusical);
    boolean update(GeneroMusical generoMusical);
    boolean delete(GeneroMusical generoMusical);
    GeneroMusical findById(Integer id);

}
