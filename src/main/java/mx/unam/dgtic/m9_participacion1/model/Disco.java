package mx.unam.dgtic.m9_participacion1.model;

import java.time.LocalDate;

public class Disco {

    private Integer id;
    private String titulo;
    private String artista;
    private LocalDate anioLanzamiento;

    public Disco() {
    }

    public Disco(Integer id, String titulo, String artista, LocalDate anioLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.anioLanzamiento = anioLanzamiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public LocalDate getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(LocalDate anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    @Override
    public String toString() {
        return "Disco {" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                '}';
    }
}
