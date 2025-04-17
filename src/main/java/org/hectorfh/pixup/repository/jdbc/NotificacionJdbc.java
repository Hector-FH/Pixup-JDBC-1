package org.hectorfh.pixup.repository.jdbc;

import org.hectorfh.pixup.model.Notificacion;

import java.util.List;

public interface NotificacionJdbc {

    List<Notificacion> findAll( );
    boolean save(Notificacion notificacion);
    boolean update(Notificacion notificacion);
    boolean delete(Notificacion notificacion);
    Notificacion findById(Integer id);


}
