package hiveProduction;

import java.util.ArrayList;
import dataColmena.DatosGlobales;
import java.util.Random;

import hiveProduction.Colmena;

public class Finca {
//	private DatosGlobales globalConfig;
	private ArrayList<Colmena> arrayColmenas;
	private int NumeroFinca;
	
	public Finca(int pNumeroFinca) {
		DatosGlobales data = DatosGlobales.getInstancia();
		NumeroFinca = pNumeroFinca;
/*	
		for(int i = 0; i < DatosGlobales.getCantidadColmenasXFinca(); i++) {
			Colmena colmena = crearColmenaRandom();
			agregarElemento(colmena);
		}
*/
	}
	
	public void initColmenas() {
		DatosGlobales data = DatosGlobales.getInstancia();
//		System.out.println("Llegó");
		arrayColmenas = new ArrayList<>();
/*
		int b = data.getCantidadColmenasXFinca();
		int a = DatosGlobales.getCantidadColmenasXFinca();
		System.out.println(b);
*/
		for(int i = 0; i < DatosGlobales.getCantidadColmenasXFinca(); i++) {
			Colmena colmena = crearColmenaRandom();
//			colmena.iniciarThreads();
			agregarElemento(colmena);
		}
	}
	
	public Colmena crearColmenaRandom() {
		Random rand = new Random();
		
//		System.out.println("Creó colmena");
		int numeroFinca = NumeroFinca;
		int minProduccion = DatosGlobales.getMinProduccion();
		int maxProduccion = DatosGlobales.getMaxProduccion();
		int minParedes = DatosGlobales.getMinTiempoParedes();
		int maxParedes = DatosGlobales.getMaxTiempoParedes();
		int minVentilacion = DatosGlobales.getMinTiempoVentilacion();
		int maxVentilacion = DatosGlobales.getMaxTiempoVentilacion();
		int minComederos = DatosGlobales.getMinTiempoComederos();
		int maxComederos = DatosGlobales.getMaxTiempoComederos();
		int minPParedes = DatosGlobales.getMinPosibilidadParedes();
		int maxPParedes = DatosGlobales.getMaxPosibilidadParedes();
		int minPVentilacion = DatosGlobales.getMinPosibilidadVentilacion();
		int maxPVentilacion = DatosGlobales.getMaxPosibilidadVentilacion();
		int minPComederos = DatosGlobales.getMinPosibilidadComederos();
		int maxPComederos = DatosGlobales.getMaxPosibilidadComederos();
		
		int tiempoMielR = rand.nextInt(Math.min(minProduccion, maxProduccion), Math.max(minProduccion, maxProduccion));
		int tiempoAislamientoR = rand.nextInt(Math.min(minParedes, maxParedes), Math.max(minParedes, maxParedes));
		int posibilidadAislamientoR = rand.nextInt(Math.min(minPParedes, maxPParedes), Math.max(minPParedes, maxPParedes));
		int tiempoVentilacionR = rand.nextInt(Math.min(minVentilacion, maxVentilacion), Math.max(minVentilacion, maxVentilacion));
		int posibilidadVentilacionR = rand.nextInt(Math.min(minPVentilacion, maxPVentilacion), Math.max(minPVentilacion, maxPVentilacion));
		int tiempoComederosR = rand.nextInt(Math.min(minComederos, maxComederos), Math.max(minComederos, maxComederos));
		int posibilidadComederosR = rand.nextInt(Math.min(minPComederos, maxPComederos), Math.max(minPComederos, maxPComederos));
		
		int IDColmena = rand.nextInt(9000) + 1000;
		
		
		Sector[] sectores = Sector.values();
		
		int randomValue = rand.nextInt(sectores.length);
		
		Sector sectorAleatorio = sectores[randomValue];
		
		Colmena colmena = new Colmena(numeroFinca, IDColmena, sectorAleatorio, tiempoMielR, tiempoVentilacionR, tiempoComederosR, tiempoAislamientoR, posibilidadAislamientoR, posibilidadVentilacionR, posibilidadComederosR);
		
		return colmena;
	}
	
	public void agregarElemento(Colmena pColmena) {
		arrayColmenas.add(pColmena);
	}

	public ArrayList<Colmena> getArrayColmenas() {
		return arrayColmenas;
	}

	public int getIDFinca() {
		return NumeroFinca;
	}
	
}
