package org.hectorfh.pixup.model;

import java.sql.Date;

public class Orden extends Catalogo
{
    private Float costoTotal;
    private String fecha;
    private Integer cantidadTotal;
    private String estatusEnvio;
    private Float costoEnvio;
    private Integer usuario_id;

    public Orden() {
    }

    public Float getCostoTotal() {
        return costoTotal;
    }
    public String getFecha() {
        return fecha;
    }
    public Integer getCantidadTotal() {
        return cantidadTotal;
    }
    public String getEstatusEnvio() {
        return estatusEnvio;
    }
    public Float getCostoEnvio() {
        return costoEnvio;
    }
    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setCostoTotal(Float costoTotal) {
        this.costoTotal = costoTotal;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
    public void setEstatusEnvio(String estatusEnvio) {
        this.estatusEnvio = estatusEnvio;
    }
    public void setCostoEnvio(Float costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "costoTotal=" + costoTotal +
                ", fecha=" + fecha +
                ", cantidadTotal=" + cantidadTotal +
                ", estatusEnvio=" + estatusEnvio +
                ", costoEnvio=" + costoEnvio +
                ", usuario_id=" + usuario_id +
                ", id=" + id +
                '}';
    }
}
