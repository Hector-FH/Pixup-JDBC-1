package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Pago;

import java.util.List;

public interface PagoJdbc {

    List<Pago> findAll( );
    boolean save(Pago pago);
    boolean update(Pago pago);
    boolean delete(Pago pago);
    Pago findById(Integer id);


}
