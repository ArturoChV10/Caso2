package reparacion;

import hiveProduction.Colmena;
import hiveProduction.Sector;

public class Falla {
	private Colmena colmena;
	private int numeroFinca;
	private int IDColmena;
	private Sector sectorColmena;
	private String elementoDanado;
	private String fecha;
	
	public Falla(Colmena pColmena, int pFinca, int pID, Sector pSector, String pElemento, String pFechaDano) {
		colmena = pColmena;
		numeroFinca = pFinca;
		IDColmena = pID;
		sectorColmena = pSector;
		elementoDanado = pElemento;
		fecha = pFechaDano;
	}

	public int getNumeroFinca() {
		return numeroFinca;
	}

	public int getIDColmena() {
		return IDColmena;
	}

	public Sector getSectorColmena() {
		return sectorColmena;
	}

	public String getElementoDanado() {
		return elementoDanado;
	}

	public String getFecha() {
		return fecha;
	}

	public Colmena getColmena() {
		return colmena;
	}

}