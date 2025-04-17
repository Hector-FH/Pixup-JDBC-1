package org.hectorfh.pixup.model;

public class Notificacion extends Catalogo{

    private String fecha;
    private Integer usuario_id;
    private Integer tipo_notificacion_id;

    public Notificacion() {
    }

    public String getFecha() {
        return fecha;
    }
    public Integer getUsuario_id() {
        return usuario_id;
    }
    public Integer getTipo_notificacion_id() {
        return tipo_notificacion_id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
    public void setTipo_notificacion_id(Integer tipo_notificacion_id) {
        this.tipo_notificacion_id = tipo_notificacion_id;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "fecha='" + fecha + '\'' +
                ", usuario_id=" + usuario_id +
                ", tipo_notificacion_id=" + tipo_notificacion_id +
                ", id=" + id +
                '}';
    }
}
