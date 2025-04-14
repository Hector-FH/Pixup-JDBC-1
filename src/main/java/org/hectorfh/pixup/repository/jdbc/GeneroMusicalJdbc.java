package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.GeneroMusical;

import java.util.List;

public interface GeneroMusicalJdbc
{

    List<GeneroMusical> findAll();
}
