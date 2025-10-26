package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();

    }

    public void agregarLibro(Libro libro){
    listaLibros.agregar(libro);
        System.out.println("Se agrego el libro: " + libro.getTitulo());
    }
           
        
    

    public ListaDoble<Libro> obtenerLibros(){
       return listaLibros;

    }

    public boolean agregarLibroCola(Libro libro){
     
        colaLibros.encolar(libro);
        System.out.println("Se encolo correctamente " + libro.getTitulo());
        return true; 
        //utilice el mentodo encolar de la clase vista en clase
    }

    public libro obtenerLibroCola(){
       Libro libro = null;
        if (!colaLibros.esVacia()) {
            try {
             
                libro = colaLibros.getValor(0); 
                colaLibros.remover(0);
                System.out.println("Libro retirado: " + libro.getTitulo());
            } catch (PosicionIlegalException e) {
               //se uso el posiciom ilegal excepcion por si la cola esta vacuia
  }
        }
        
        if (libro == null) {
            System.out.println("No hay libros ");
        }
        return libro;
    }

       
    
    
    public voic obtenerLibroPila(){
       
        Libro libro = pilaLibrosEliminados.cima();
        if (libro != null) {
            System.out.println(" Tope de pila: " + libro.getTitulo());
        } else {
            System.out.println("La pila de los eminiados esta vacia");
        }
        return libro; // Devuelve el tope sin removerlo de la cima
    }


    

    public Lirbo crearLibro(String titulo, String autor, String isbn){
        return new Libro(titulo, autor, isbn);
    }

    public Pedido crearPedido(Libro libro, Fecha fecha){
       
        Pedido nuevoPedido = new Pedido(libro, fecha);
        listaPedidos.agregar(nuevoPedido);
        System.out.println("Pedido registrado correptamente: ");
        return nuevoPedido;
    }

    public boolean devolverLibro(Libro libro) {
       try {
            int posEliminada = listaLibros.remover(libro); 
            if (posEliminada != -1) {
                // Si fue eliminado de la lista principal, lo apilamos.
                pilaLibrosEliminados.apilar(libro);
                System.out.println("🔄 Libro 'devuelto' (eliminado de lista y apilado para deshacer): " + libro.getTitulo());
                return true;
            }
            return false;
        } catch (PosicionIlegalException e) {
            // Este catch no debería ocurrir desde remover(T valor) si maneja el -1.
            return false;
        }
    }

    public Libro eliminarUltimoLibro(){
        
if (listaLibros.esVacia()) {
            System.out.println("La lista de libroes esta vacia");
            return null;
        }
        
        Libro libroEliminado = null;
        try {
            // Eliminar el último elemento de la lista (tamanio - 1)
            int ultimaPosicion = listaLibros.getTamanio() - 1;
            libroEliminado = listaLibros.remover(ultimaPosicion); 
            pilaLibrosEliminados.apilar(libroEliminado);
            System.out.println(" ultimo libro eliminado y apilado: " + libroEliminado.getTitulo());
        } catch (PosicionIlegalException e) {
            // se usa solo encaso de que este vacio
            System.err.println("Error interno al eliminar el último libro.");
        }
        return libroEliminado;
    }
    public Libro deshacerEliminarLibro(){
       if (pilaLibrosEliminados.esVacia()) {
            System.out.println("np hay nada para deshacer");
            return null;
        }
       
        Libro libroDeshecho = null;
   
        if (!pilaLibrosEliminados.esVacia()){
            pilaLibrosEliminados.retirar();
            libroDeshecho = pilaLibrosEliminados.cima(); // obtener el valor antes de retirar
            pilaLibrosEliminados.retirar();             // luego retirar
            listaLibros.agregar(libroDeshecho); 
            System.out.println("eliminacion deshecha: " + libroDeshecho.getTitulo() + " reinsertado.");
        }
        
        return libroDeshecho;
    }

    
public Libro buscarLibro(String isbn) {

        for (int i = 0; i < listaLibros.getTamanio(); i++) {
            try {
                Libro l = listaLibros.getValor(i);
                if (l.getIsbn().equals(isbn)) {
                    System.out.println("libro encontrado: " + l.getTitulo());
                    return l;
                }
            } catch (PosicionIlegalException e) {
               // se usa solo encaso de que no haya nadas
            }
        }
        System.out.println("Libro " + isbn + " no encontrado");
        return null;
    }
}

