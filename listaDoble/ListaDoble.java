package listaDoble;
public class ListaDoble<T>{
    //atributos
    private Nodo<T>cabeza;
    private int tamanio;
    //constructor por defecto
    public ListaDoble(){
        cabeza = null;
        tamanio = 0;
    }
    //getter y setter
    public int getTamanio() {
        return tamanio;
    }
    //Métodos personalizados
    //confirma si la pila esta vacia
    public boolean esVacia(){    
        return cabeza == null;
    }
    //agrega un nuevo nodo al fina de la lista
    public void agregar(T valor){
        Nodo<T> nuevo = new Nodo<>();
        //fija el valor al nuevo
        nuevo.setValor(valor);
        if (esVacia()){
            //cabeza apunta al nuevo
            cabeza = nuevo;
            //cola apunta a nuevo
            
        }else{
            //se agrega al fina de la lista
            Nodo<T> aux = cabeza;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo); 
            
        }
        tamanio++;
    }
    /*
     * Inserta un nuevo nodo en la lista
     * @param valor: valor a agregar
     * @param pos: indica la posicion en donde se insertará el nodo
     * @throws : PosicionIlegalException en caso de que la posicion no exista
     */
    public void insertar(T valor, int pos) throws PosicionIlegalException{
        if (pos>=0 && pos<=tamanio){
            Nodo<T> nuevo = new Nodo<>();
            nuevo.setValor(valor);
            if(pos==0){//insertar al principo
               
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;

            }else{
                if(pos == tamanio){ // al final
                    Nodo<T> aux = cabeza;
                    while (aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo); 
                    

                }else{ // en medio
                    Nodo<T> aux = cabeza;
                    for (int i=0;i<=pos-2;i++){
                        aux = aux.getSiguiente();

                    }
                    Nodo<T> siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                    

                }

            }
            tamanio++;

        }else{
            throw new PosicionIlegalException();
        }

    }
    /*
     * Elimina un nodo de una determinada posicion
     * @param pos: posicion a eliminar
     * @throws PosicionIlegalException
     */

    public T remover(int pos) throws PosicionIlegalException{
        if (pos < 0 || pos >= tamanio) {
            throw new PosicionIlegalException();
        }

        T valor;
        Nodo<T> auxremov;

        if (pos == 0) { // Eliminar la cabeza
            auxremov = cabeza;
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null); // Enlace doble
            } else {
                cola = null; // La lista queda vacía
            }
        } else {
            // Buscar el nodo a eliminar (Optimizamos el recorrido)
            auxremov = (pos<tamanio/2) ?cabeza : cola;
            
            if (pos<tamanio/2) {
                 for (int i= 0; i< pos; i++) auxremov = auxremov.getSiguiente();
            } else {
                 for (int i=tamanio-1; i>pos; i--) auxremov = auxremov.getAnterior();
            }
            
            Nodo<T> anterior = auxremov.getAnterior();
            Nodo<T> siguiente = auxremov.getSiguiente();

            anterior.setSiguiente(siguiente);
            if (siguiente != null) {
                siguiente.setAnterior(anterior); 
            } else {
                cola = anterior; 
            }
        }
        
        valor = auxremov.getValor();
        tamanio--;
        return valor;
        
    }
     /*
     * Elimina un nodo que contiene un T valor
     * @param T: valor a eliminar
     * @return: si lo encuentra retorna la posicion a eliminar,si no retorna -1
     * @throws PosicionIlegalException
     */

    
     
     public int remover(T valor) throws PosicionIlegalException{
        Nodo<T> aux = cabeza;
        int pos = 0;

        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                try {
                    remover(pos); // Llama al método remover por posición
                    return pos;
                } catch (PosicionIlegalException e) {
                    return -1;
                }
            }
            aux = aux.getSiguiente();
            pos++;
        }
        return -1; // Valor no encontrado
    }
    

    /*
     * Devuelve el valor de una determinada posicion
     * @param pos: posicion
     * @return : el valor de tipo T
     * @throws PosicionIlegalException
     */
    public T getValor(int pos) throws PosicionIlegalException{
        if(pos>=0 && pos<tamanio){//es una posicion válida
            T valor;
            if(pos ==0){
                valor = cabeza.getValor();
                return valor;

            }else{
                Nodo<T> aux = cabeza;
                for(int i=0;i<=pos-1;i++){
                    aux = aux.getSiguiente();
                }
                valor = aux.getValor();
                return valor;
            }

        }else{//es una posicion inválida
            throw new PosicionIlegalException();

        }
        
    }
    public void limpiar(){
        cabeza = null;
        tamanio = 0;
    }

    /*
     * Regresa todos los datos de la lista en forma de String
     */

    @Override
    public String toString() {
       String resultado = "["; // Se crea el primer objeto String
        
        if (esVacia()) {
            return "Lista Vacia";
        }
        
        Nodo<T> aux = cabeza;
        while (aux != null) {
            // caada que se usa + se crea un strinmg 
            resultado = resultado + aux.getValor().toString(); 
            
            if (aux.getSiguiente() != null) {
                resultado = resultado + ", "; // Se crea otro nuevo objeto String
            }
            aux = aux.getSiguiente();
        }
        
        resultado = resultado + "]"; // Se crea el objeto String final
        return resultado;
    }
    
    
    /*
     * busca un valor en la lista
     * @return true si contiene ese valor
     * si no regresa false
     */
    public boolean contiene(T valor){
        Nodo<T> aux = cabeza;
        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
        
    }
    
    
