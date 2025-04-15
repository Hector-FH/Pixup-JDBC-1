package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Disco;
import org.hectorfh.pixup.model.Disquera;

import java.util.List;

public interface DisqueraJdbc
{

    List<Disquera> findAll();
    boolean save(Disquera disquera);
    boolean update(Disquera disquera);
    boolean delete(Disquera disquera);
    Disquera findById(Integer id);

}
