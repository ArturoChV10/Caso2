package reparacion;

import jsonLoader.ConfigHive;

public class Tecnico {
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
	
	public void enviarTecnico() {
		
	}
	
	public Tecnico(int pTecnicos){
		cantidadTecnicos = pTecnicos;
		estadoTecnico = true;
	}
}
