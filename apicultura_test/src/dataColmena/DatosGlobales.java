package dataColmena;

import colmena.Colmena;

import java.util.ArrayList;

public class DatosGlobales {
	private static int casillaActual; // Campo para almacenar el número

    public static int getCasillaActual() {
        return casillaActual;
    }

    public static void setCasillaActual(int pNumero) {
    	casillaActual = pNumero;
    }
    
    private static ArrayList<Colmena> arrayColmenas = new ArrayList<>();
    // Otros campos y métodos necesarios
    
    public static ArrayList<Colmena> getArrayColmenas() {
        return arrayColmenas;
    }

    public static void setArrayColmenas(ArrayList<Colmena> colmenas) {
        arrayColmenas = colmenas;
    }
}
