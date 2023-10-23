package dataColmena;

import hiveProduction.Colmena;
import hiveProduction.Finca;
import jsonLoader.ConfigHive;
import reparacion.Falla;

import java.util.ArrayList;

public class DatosGlobales {
	private static DatosGlobales instancia = null;
	private ConfigHive configuracion;
	private static int cantidadTecnicos;
	private static int cantidadFincas;
	private static int cantidadColmenasXFinca;
	
	private int cantidadFincasActuales;
	private  int casillaFincaActual; // Campo para almacenar el número
	private int casillaColmenaActual; // Campo para almacenar el número
	private ArrayList<Finca> arrayFincas;
	private ArrayList<Falla> arrayFallas;
	private ArrayList<Falla> arrayHistorial;

	private static int hora;
	private static int minProduccion;
	private static int maxProduccion;
	private static int minTiempoParedes;
	private static int maxTiempoParedes;
	private static int minPosibilidadParedes;
	private static int maxPosibilidadParedes;
	private static int minPosibilidadComederos;
	private static int maxPosibilidadComederos;
	private static int minPosibilidadVentilacion;
	private static int maxPosibilidadVentilacion;
	private static int minTiempoComederos;
	private static int maxTiempoComederos;
	private static int minTiempoVentilacion;
	private static int maxTiempoVentilacion;
	private static int minTiempoReparacion;
	private static int maxTiempoReparacion;

	public DatosGlobales() {
		configuracion = new ConfigHive();
		cantidadFincasActuales = 0;
		cantidadTecnicos = configuracion.getCantidadTecnicos();
    	hora = configuracion.getHora();
    	cantidadFincas = configuracion.getCantidadFincas();
    	cantidadColmenasXFinca = configuracion.getCantidadColmenas();
    	minProduccion = configuracion.getMinTiempoMiel();
    	maxProduccion = configuracion.getMaxTiempoMiel();
    	minTiempoParedes = configuracion.getMinTiempoParedes();
    	maxTiempoParedes = configuracion.getMaxTiempoParedes();
    	minPosibilidadParedes = configuracion.getMinPosibilidadParedes();
    	maxPosibilidadParedes = configuracion.getMaxPosibilidadParedes();
    	minTiempoComederos = configuracion.getMinTiempoComederos();
    	maxTiempoComederos = configuracion.getMaxTiempoComederos();
    	minPosibilidadComederos = configuracion.getMinPosibilidadComederos();
    	maxPosibilidadComederos = configuracion.getMaxPosibilidadComederos();
    	minTiempoVentilacion = configuracion.getMinTiempoVentilacion();
    	maxTiempoVentilacion = configuracion.getMaxTiempoVentilacion();
    	minPosibilidadVentilacion = configuracion.getMinPosibilidadVentilacion();
    	maxPosibilidadVentilacion = configuracion.getMaxPosibilidadVentilacion();
    	minTiempoReparacion = configuracion.getMinTiempoReparacion();
    	maxTiempoReparacion = configuracion.getMaxTiempoReparacion();
    }
	
	public static DatosGlobales getInstancia() {
		if (instancia == null) {
			instancia = new DatosGlobales();
		}
		return instancia;
	}
	
	public ArrayList<Finca> getArrayFincas() {
		return arrayFincas;
	}

	public void setArrayFincas(ArrayList<Finca> arrayFincas) {
		this.arrayFincas = arrayFincas;
	}
	
    public int getCasillaFincaActual() {
        return casillaFincaActual;
    }

    public void setCasillaFincaActual(int pNumero) {
    	casillaFincaActual = pNumero;
    }
    
    public int getCasillaColmenaActual() {
        return casillaColmenaActual;
    }

    public void setCasillaColmenaActual(int pNumero) {
    	casillaColmenaActual = pNumero;
    }

	public ConfigHive getConfiguracion() {
		return configuracion;
	}

	public static int getCantidadFincas() {
		return cantidadFincas;
	}

	public static int getCantidadColmenasXFinca() {
		return cantidadColmenasXFinca;
	}

	public static int getHora() {
		return hora;
	}

	public static int getMinProduccion() {
		return minProduccion;
	}

	public static int getMaxProduccion() {
		return maxProduccion;
	}

	public static int getMinTiempoParedes() {
		return minTiempoParedes;
	}

	public static int getMaxTiempoParedes() {
		return maxTiempoParedes;
	}

	public static int getMinTiempoComederos() {
		return minTiempoComederos;
	}

	public static int getMaxTiempoComederos() {
		return maxTiempoComederos;
	}

	public static int getMinTiempoVentilacion() {
		return minTiempoVentilacion;
	}

	public static int getMaxTiempoVentilacion() {
		return maxTiempoVentilacion;
	}

	public static int getMinTiempoReparacion() {
		return minTiempoReparacion;
	}

	public static int getMaxTiempoReparacion() {
		return maxTiempoReparacion;
	}

	public int getCantidadFincasActuales() {
		return cantidadFincasActuales;
	}

	public void setCantidadFincasActuales(int cantidadFincasActuales) {
		this.cantidadFincasActuales = cantidadFincasActuales;
	}

	public static int getCantidadTecnicos() {
		return cantidadTecnicos;
	} 
	
	public void addFalla(Falla pFalla) {
		if(arrayFallas == null) {
			arrayFallas = new ArrayList<>();
		}
		arrayFallas.add(pFalla);
	}
	
	public void removerFalla(int pIndice) {
		if(arrayFallas.size()>0) {
			arrayFallas.remove(pIndice);
		}
	}

	public ArrayList<Falla> getArrayFallas() {
		return arrayFallas;
	}
	
	public void addHistorial(Falla pFalla) {
		if(arrayHistorial == null) {
			arrayHistorial = new ArrayList<>();
		}
		arrayHistorial.add(pFalla);
	}

	public ArrayList<Falla> getArrayHistorial() {
		return arrayHistorial;
	}

	public static int getMinPosibilidadParedes() {
		return minPosibilidadParedes;
	}

	public static int getMaxPosibilidadParedes() {
		return maxPosibilidadParedes;
	}

	public static int getMinPosibilidadComederos() {
		return minPosibilidadComederos;
	}

	public static int getMaxPosibilidadComederos() {
		return maxPosibilidadComederos;
	}

	public static int getMinPosibilidadVentilacion() {
		return minPosibilidadVentilacion;
	}

	public static int getMaxPosibilidadVentilacion() {
		return maxPosibilidadVentilacion;
	}
	
	
	
}
