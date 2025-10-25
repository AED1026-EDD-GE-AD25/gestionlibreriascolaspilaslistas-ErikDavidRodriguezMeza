package utilerias;

public class Fecha {
	
    private int dia;
    private int mes;
    private int anio;

  
    public Fecha(int dia, int mes, int anio) {
      
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        // Use el String.format() de antiguo codigo para que dia, mes y año tengan
		//dos digitos
        return String.format("%02d/%02d/%d", dia, mes, anio);
    }
}
