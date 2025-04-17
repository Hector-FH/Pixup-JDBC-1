package org.hectorfh.pixup.model;

public class DetalleOrden {

    private Integer id_disco;
    private Integer id_orden;
    private Integer cantidad;
    private Float costo;
    private Integer orden_id;
    private Integer disco_id;

    public DetalleOrden() {
    }

    public Integer getId_disco() {
        return id_disco;
    }
    public Integer getId_orden() {
        return id_orden;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public Float getCosto() {
        return costo;
    }
    public Integer getOrden_id() {
        return orden_id;
    }
    public Integer getDisco_id() {
        return disco_id;
    }

    public void setId_disco(Integer id_disco) {
        this.id_disco = id_disco;
    }
    public void setId_orden(Integer id_orden) {
        this.id_orden = id_orden;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public void setCosto(Float costo) {
        this.costo = costo;
    }
    public void setOrden_id(Integer orden_id) {
        this.orden_id = orden_id;
    }
    public void setDisco_id(Integer disco_id) {
        this.disco_id = disco_id;
    }

    @Override
    public String toString() {
        return "DetalleOrden{" +
                "id_disco=" + id_disco +
                ", id_orden=" + id_orden +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                ", orden_id=" + orden_id +
                ", disco_id=" + disco_id +
                '}';
    }
}
