package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.TipoDomicilio;

import java.util.List;

public interface TipoDomicilioJdbc {

    List<TipoDomicilio> findAll( );
    boolean save(TipoDomicilio tipoDomicilio);
    boolean update(TipoDomicilio tipoDomicilio);
    boolean delete(TipoDomicilio tipoDomicilio);
    TipoDomicilio findById(Integer id);


}
