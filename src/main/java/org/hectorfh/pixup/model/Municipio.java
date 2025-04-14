package org.hectorfh.pixup.model;

public class Municipio extends Catalogo
{
    private String municipio;
    private Integer estado_id;

    public Municipio() {
    }

    public String getMunicipio() {
        return municipio;
    }
    public Integer getEstado_id() {
        return estado_id;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public void setEstado_id(Integer estado_id) {
        this.estado_id = estado_id;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "municipio='" + municipio + '\'' +
                ", estado_id=" + estado_id +
                ", id=" + id +
                '}';
    }
}
