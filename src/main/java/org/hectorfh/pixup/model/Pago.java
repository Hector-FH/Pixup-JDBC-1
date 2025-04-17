package org.hectorfh.pixup.model;

public class Pago extends Catalogo{

    private String num_tarjeta;
    private String fecha;
    private Integer orden_id;

    public Pago() {
    }

    public String getNum_tarjeta() {
        return num_tarjeta;
    }
    public String getFecha() {
        return fecha;
    }
    public Integer getOrden_id() {
        return orden_id;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setOrden_id(Integer orden_id) {
        this.orden_id = orden_id;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "num_tarjeta='" + num_tarjeta + '\'' +
                ", fecha='" + fecha + '\'' +
                ", orden_id=" + orden_id +
                ", id=" + id +
                '}';
    }
}
