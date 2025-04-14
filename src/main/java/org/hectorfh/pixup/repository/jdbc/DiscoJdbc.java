package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Disco;

import java.util.List;

public interface DiscoJdbc
{

    List<Disco> findAll();
}
