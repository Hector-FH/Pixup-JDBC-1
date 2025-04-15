package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Domicilio;

import java.util.List;

public interface DomicilioJdbc
{

    List<Domicilio> findAll();
    boolean save(Domicilio domicilio);
    boolean update(Domicilio domicilio);
    boolean delete(Domicilio domicilio);
    Domicilio findById(Integer id);


}
