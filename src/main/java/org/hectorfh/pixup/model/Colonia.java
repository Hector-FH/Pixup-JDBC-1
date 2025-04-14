package org.hectorfh.pixup.model;

public class Colonia extends Catalogo
{
    private String nombre;
    private String cp;
    private Integer municipio_id;

    public Colonia() {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public void setMunicipio_id(Integer municipio_id) {
        this.municipio_id = municipio_id;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "nombre='" + nombre + '\'' +
                ", cp='" + cp + '\'' +
                ", municipio_id=" + municipio_id +
                ", id=" + id +
                '}';
    }
}
