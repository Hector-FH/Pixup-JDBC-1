package org.hectorfh.pixup.model;

public class Artista extends Catalogo
{
    private String nombre;

    public Artista() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
