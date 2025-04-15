package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Disco;

import java.util.List;

public interface DiscoJdbc
{

    List<Disco> findAll();
    boolean save(Disco disco);
    boolean update(Disco disco);
    boolean delete(Disco disco);
    Disco findById(Integer id);



}
