package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Estado;

import java.util.List;

public interface EstadoJdbc
{
    List<Estado> findAll( );
    boolean save(Estado estado);
    boolean update(Estado estado);
    boolean delete(Estado estado);
    Estado findById(Integer id);

}
