package tester;

import hiveProduction.Colmena;
import hiveProduction.Sector;
import hiveProduction.Finca;
import hiveManager.Manager;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		Colmena colmena = new Colmena(1234, Sector.Este, 2000, 80000, 140000, 100000);
		Manager manager = new Manager();
		manager.initFincas();
//		Finca finca = new Finca(3);
//		finca.crearColmenaRandom();
	}
}
