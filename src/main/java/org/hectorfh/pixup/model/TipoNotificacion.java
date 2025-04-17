package org.hectorfh.pixup.model;

public class TipoNotificacion extends Catalogo{

    private String descripcion;
    private String ruta_plantilla;

    public TipoNotificacion() {
    }

    public String getDescripcion() {
        return descripcion;
    }
    public String getRuta_plantilla() {
        return ruta_plantilla;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setRuta_plantilla(String ruta_plantilla) {
        this.ruta_plantilla = ruta_plantilla;
    }

    @Override
    public String toString() {
        return "TipoNotificacion{" +
                "descripcion='" + descripcion + '\'' +
                ", ruta_plantilla='" + ruta_plantilla + '\'' +
                ", id=" + id +
                '}';
    }
}
