package org.hectorfh.pixup.model;

public class Disquera extends Catalogo
{
    private String nombre;

    public Disquera() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Disquera{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
