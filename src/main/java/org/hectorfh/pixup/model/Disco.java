package org.hectorfh.pixup.model;
import java.sql.Date;
public class Disco extends Catalogo
{

    private String titulo;
    private Float precio;
    private Integer existencia;
    private Float descuento;
    private Date fechaLanzamiento;
    private String imagen;
    private Integer artista_id;
    private Integer disquera_id;
    private Integer generoMusical_id;

    public Disco() {
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public void setArtista_id(Integer artista_id) {
        this.artista_id = artista_id;
    }
    public void setDisquera_id(Integer disquera_id) {
        this.disquera_id = disquera_id;
    }
    public void setGeneroMusical_id(Integer generoMusical_id) {
        this.generoMusical_id = generoMusical_id;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                ", descuento=" + descuento +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", imagen='" + imagen + '\'' +
                ", artista_id=" + artista_id +
                ", disquera_id=" + disquera_id +
                ", generoMusical_id=" + generoMusical_id +
                ", id=" + id +
                '}';
    }
}
