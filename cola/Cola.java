import cola.Nodo;

public class Cola<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamanio;

    public Cola(){
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    public int getTamanio() {

        return tamanio;
    }

    public boolean esVacia(){

        return(cabeza == null);
    }

    public void encolar(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        
        nuevo.setValor(valor);
        if(esVacia()){
            cabeza = nuevo;
        }else{
          Nodo<T> aux = cabeza;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }

        tamanio++;
    }

    public void insertar(T valor, int pos) throws PosicionIlegalException{
    if(pos >=0 && pos <=tamanio){
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setValor(valor);
        //si se desea insertar al comenzar la lista
        if(pos==0){
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;

        }else{
            // el nodo se quiere inseretar al final de la lista
            if(pos==tamanio){
                Nodo<T> aux= cabeza;
                while(aux.getSiguiente() != null){
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(nuevo);
            }else{
                 //se quiere insertar en medio de la lista
               Nodo<T> aux= cabeza;
               for(int i=0; i<=pos-2; i++){
                    aux= aux.getSiguiente();
               }
               Nodo<T> siguiente = aux.getSiguiente();        
               aux.setSiguiente(nuevo); 
               nuevo.setSiguiente(siguiente);      
            }
        }
        //se puede insertar
        tamanio++;
    }else{
        // es posicion invalida
        throw new PosicionIlegalException();
    }

    }
    /* 
     * Elimina un nodo en determinada posicion
     * @param pos posicion a eliminar
     * @throws PosicionIlegalException si la posicion es invalida
    */
    
    public void remover(int pos) throws PosicionIlegalException{
       
       if(pos>=0 && pos < tamanio){
        if(pos==0){
            //EL nodo a eliminar es el primero
            cabeza = cabeza.getSiguiente();
            tamanio--;
        }else{
            //eliminar al final o en medio
            Nodo<T> aux = cabeza;
            for(int i=0; i<=pos-2; i++){
                aux = aux.getSiguiente();
            }
            Nodo<T> prox = aux.getSiguiente();
            aux.setSiguiente(prox.getSiguiente());
            tamanio--;    
        }
       
            }else{
                throw new PosicionIlegalException();
            }
        }
       
       

    
    /*
     * te devuelve el valor de una determinada posicion
     * @param pos: poscion 
     * @return valor tipo T
     * @throws PosicionIlegalException
     */
   public T getValor(int pos)throws PosicionIlegalException{
        if(pos>=0 && pos < tamanio){
            if(pos==0){
                return cabeza.getValor();
            }else{
                Nodo<T> aux = cabeza;
                for(int i=0; i<=pos-1; i++){
                    aux = aux.getSiguiente();
                }
                return aux.getValor();
                }
            
         
        }else{
            throw new PosicionIlegalException();
        }
    }
}