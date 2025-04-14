package org.hectorfh.pixup.model;

import java.sql.Date;

public class Orden extends Catalogo
{
    private Float costoTotal;
    private Date fecha;
    private Integer cantidadTotal;
    private Boolean estatusEnvio;
    private Float costoEnvio;
    private Integer usuario_id;

    public Orden() {
    }

    public void setCostoTotal(Float costoTotal) {
        this.costoTotal = costoTotal;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
    public void setEstatusEnvio(Boolean estatusEnvio) {
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
