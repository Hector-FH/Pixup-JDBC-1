package org.hectorfh.pixup.model;

public class GeneroMusical extends Catalogo
{
    private String nombre;

    public GeneroMusical() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "GeneroMusical{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
