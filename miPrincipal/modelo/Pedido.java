package miPrincipal.modelo;

import util.Fecha;

public class Pedido {
    private Libro libro;
    private Fecha fecha;

    public Pedido(Libro libro, Fecha fecha) {
        this.libro = libro;
        this.fecha = fecha;
    }

    public Libro getLibro(){ return libro; } 
    public Fecha getFecha(){ return fecha; } 

    @Override
    public String toString() {
       
        return "Pedido en " + fecha.toString() + " del " + libro.getTitulo();
    }
}