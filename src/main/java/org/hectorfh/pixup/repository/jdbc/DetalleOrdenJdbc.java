package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.DetalleOrden;

import java.util.List;

public interface DetalleOrdenJdbc {

    List<DetalleOrden> findAll( );
    boolean save(DetalleOrden detalleOrden);
    boolean update(DetalleOrden detalleOrden);
    boolean delete(DetalleOrden detalleOrden);
    DetalleOrden findById(Integer id);


}
