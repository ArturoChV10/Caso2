package hiveManager;

import java.util.ArrayList;
import java.util.Random;


import dataColmena.DatosGlobales;
import generalTime.Clock;
import hiveProduction.Colmena;
import jsonLoader.ConfigHive;
import reparacion.Tecnico;
import hiveProduction.Finca;
import interfacesGraficas.MainUI;

public class Manager {  //Este manager puede ser usado para iniciar todo, como lo que es simulador en estructuras
	private ConfigHive Configuracion;
	private ArrayList<Finca> arrayFincas;
	
	public Manager() {
		
		DatosGlobales data = DatosGlobales.getInstancia();
		Clock reloj = Clock.getInstancia();
		reloj.startClock();

		arrayFincas = new ArrayList<>();
//	    
	    Configuracion = new ConfigHive();
	    
	    //Considero que puedo hacer una clase que sea configLoader, misma cargará todos estos datos.
	    
	    initFincas();
	    
	    data.setArrayFincas(arrayFincas);
	    
/*
	    for (int i=0; i < DatosGlobales.getCantidadFincas(); i++) {
	    	int numero = i + 1;
	    	Finca nuevaFinca = new Finca(numero);
	    	
	    	arrayFincas.add(nuevaFinca);
	    }
*/
	    
	    ArrayList<Finca> pArrayFincas = data.getArrayFincas();
	    MainUI main = new MainUI(pArrayFincas);
	    main.setVisible(true);
//	    MainUI main = new MainUI();
	}
	
	public void initFincas() {
		
//		System.out.println("Inció");
		int a = DatosGlobales.getCantidadFincas();
		System.out.print(a);
	    for (int i=0; i < DatosGlobales.getCantidadFincas(); i++) {
	    	int numero = i + 1;
	    	Finca nuevaFinca = new Finca(numero);
	    	nuevaFinca.initColmenas();
	    	
	    	arrayFincas.add(nuevaFinca);
	    }
	    
	    
	    
	    
	    
	}
}