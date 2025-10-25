package miPrincipal.modelo;

import utilerias.Fecha;

public class Pedido {
    private Libro libro;
    private Fecha fechaPedido;
public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

   
    public String toString() {
        return "Libro [Título: " + titulo + ", Autor: " + autor + "]";
    }
}
   
