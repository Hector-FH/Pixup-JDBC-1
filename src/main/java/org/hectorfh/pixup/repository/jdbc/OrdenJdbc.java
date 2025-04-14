package org.hectorfh.pixup.repository.jdbc;


import org.hectorfh.pixup.model.Orden;

import java.util.List;

public interface OrdenJdbc
{
    List<Orden> findAll();
}
