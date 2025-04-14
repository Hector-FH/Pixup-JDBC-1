package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Municipio;

import java.util.List;

public interface MunicipioJdbc
{
    List<Municipio> findAll();
    boolean save (Municipio municipio);
    boolean update(Municipio municipio);
    boolean delete (Municipio municipio);
    Municipio findById(Integer id);
}
