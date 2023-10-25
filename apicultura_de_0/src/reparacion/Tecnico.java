package reparacion;

import java.util.Random;

import dataColmena.DatosGlobales;
import jsonLoader.ConfigHive;

public class Tecnico {
	private static Tecnico instancia = null;
	private ConfigHive Configuracion;
	
	private boolean estadoTecnico;
	private int cantidadTecnicos;
	
	public boolean isEstadoTecnico() {
		return estadoTecnico;
	}
	public void setEstadoTecnico(boolean estadoTecnico) {
		this.estadoTecnico = estadoTecnico;
	}
	public int getCantidadTecnicos() {
		return cantidadTecnicos;
	}
	public void setCantidadTecnicos(int cantidadTecnicos) {
		this.cantidadTecnicos = cantidadTecnicos;
	}
	
	public static Tecnico getInstancia() {
		if (instancia == null) {
			instancia = new Tecnico(DatosGlobales.getCantidadTecnicos());
		}
		return instancia;
	}
	
	public void reparar() {
		if(getCantidadTecnicos() > 0) {
			cantidadTecnicos--;
			Random rand = new Random();
			int minTecnico = DatosGlobales.getMinTiempoReparacion();
			int maxTecnico = DatosGlobales.getMaxTiempoReparacion();
			int tiempoReparacion = rand.nextInt(Math.min(minTecnico, maxTecnico), Math.max(minTecnico, maxTecnico));
			try {
				Thread.sleep(tiempoReparacion);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cantidadTecnicos++;
		} else {
			try {
				Thread.sleep(10000);
				reparar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	Tecnico(int pTecnicos){
		cantidadTecnicos = pTecnicos;
		estadoTecnico = true;
	}
}
