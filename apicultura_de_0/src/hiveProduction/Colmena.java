package hiveProduction;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;


import java.util.ArrayList;
import java.util.Random;

import jsonLoader.ConfigHive;
import reparacion.Falla;
import dataColmena.DatosGlobales;
import generalTime.Clock;

public class Colmena {
	private int numeroFinca;
	private ConfigHive Configuracion;
	private DatosGlobales GlobalConfig;
	private int ID;
	private Sector sector; //Este, Oeste, Norte, Sur
	private int miel;
	private int tiempoMiel;
	private boolean estadoGeneral;
	private boolean estadoVentilacion;
	private boolean estadoAislamiento;
	private boolean estadoComederos;
	private int tiempoDanoVentilacion;
	private int posibilidadVentilacion;
	private int tiempoDanoAislamiento;
	private int posibilidadAislamiento;
	private int tiempoDanoComederos;
	private int posibilidadComederos;

	public Colmena(int pFinca, int pID, Sector pSector, int pTiempoMiel, int pTiempoV, int pTiempoC, int pTiempoA, int pPosibilidadV, int pPosibilidadA, int pPosibilidadC) {
		numeroFinca = pFinca;
		ID = pID;
		sector = pSector;
		tiempoMiel = pTiempoMiel;
		estadoGeneral = true;
		estadoVentilacion = true;
		estadoAislamiento = true;
		estadoComederos = true;
		tiempoDanoVentilacion = pTiempoV;
		posibilidadVentilacion = pPosibilidadV;
		tiempoDanoAislamiento = pTiempoA;
		posibilidadAislamiento = pPosibilidadA;
		tiempoDanoComederos = pTiempoC;
		posibilidadComederos = pPosibilidadC;
//		System.out.println("Se creó");
		Colmena.this.iniciarThreads();
		
	}
	
	public void iniciarThreads() {
//		System.out.println("Aquí también");
		this.mComprobador();
		this.mMiel();
		this.mAislamiento();
		this.mComederos();
		this.mVentilacion();
		
	}
	
	public void mComprobador() {
		Timer comprobador = new Timer();
		comprobador.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int a = ID;
				System.out.println(a);
				if(!isEstadoAislamiento()||!isEstadoComederos()||!isEstadoVentilacion()) {
					estadoGeneral = false;
//					System.out.println(estadoGeneral);
				}else {
					if(isEstadoAislamiento()&&isEstadoComederos()&&isEstadoVentilacion()) {
						estadoGeneral = true;
//						System.out.println(estadoGeneral);
					}
				}
/*
				if(!estadoAislamiento) {
//					System.out.println("Estado Aislamiento");
					System.out.println(estadoAislamiento);
				}else {
//					System.out.println("Estado Aislamiento");
					System.out.println(estadoAislamiento);
				}
				if(!estadoComederos) {
//					System.out.println("Estado Comederos");
					System.out.println(estadoComederos);
				}else {
//					System.out.println("Estado Comederos");
					System.out.println(estadoComederos);
				}
				if(!estadoVentilacion) {
//					System.out.println("Estado Ventilacion");
					System.out.println(estadoVentilacion);
				}else {
//					System.out.println("Estado Ventilacion");
					System.out.println(estadoVentilacion);
				}
*/
				
			}
		}, 0, 10000);
	}
	
	public void mMiel() {
        Timer timerMiel = new Timer();
        timerMiel.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				int cantMiel = getMiel();
				if(cantMiel < 101) {
					if(!isEstadoAislamiento()||!isEstadoComederos()||!isEstadoVentilacion()) {
						System.out.println("La producción de miel ha sido detenida, debido a que alguno de los componentes está dañado");
					}else {
						int nMiel = cantMiel + 1;
						setMiel(nMiel);
						System.out.println(getMiel());
					}
				} else {
					
				}
			}
		}, 0, tiempoMiel);
	}
	
	public void mAislamiento() {
		Timer timerAislamiento = new Timer();
		timerAislamiento.scheduleAtFixedRate(new TimerTask() {
			DatosGlobales data = DatosGlobales.getInstancia();
            @Override
            public void run() {
            	Random random = new Random();
                int numeroAleatorio = random.nextInt(101);
                if(numeroAleatorio<posibilidadAislamiento) {
                	if(isEstadoAislamiento()) {
                    	setEstadoAislamiento(false);
                    	Clock reloj = Clock.getInstancia();
                    	String fecha = reloj.getFecha();
                    	System.out.println(fecha);
                    	Falla falla = new Falla(Colmena.this, numeroFinca, ID, sector, "Aislamiento", fecha);
//                    GlobalConfig.addFalla(falla);
                    	data.addFalla(falla);            		
                	}
                	
                } else {
                	System.out.println("Funcionó");             
                }

            }
        
        }, tiempoDanoAislamiento, tiempoDanoAislamiento);
	}
	
	public void mComederos() {
		Timer timerComederos = new Timer();
		timerComederos.scheduleAtFixedRate(new TimerTask() {
			DatosGlobales data = DatosGlobales.getInstancia();
            @Override
            public void run() {
            	Random random = new Random();
                int numeroAleatorio = random.nextInt(101);
                if(numeroAleatorio<posibilidadComederos) {
                   	if(isEstadoComederos()) {
                		setEstadoComederos(false);
                    	Clock reloj = Clock.getInstancia();
                    	String fecha = reloj.getFecha();
                    	System.out.println(fecha);
                        Falla falla = new Falla(Colmena.this, numeroFinca, ID, sector, "Comederos", fecha);
//                        GlobalConfig.addFalla(falla);
                        data.addFalla(falla);
                	}
                   	
                } else {
                	System.out.println("Funcionó");             
                }
 
            }
        
        }, tiempoDanoComederos, tiempoDanoComederos);
	}
	
	public void mVentilacion() {
		Timer timerVentilacion = new Timer();
		timerVentilacion.scheduleAtFixedRate(new TimerTask() {
			DatosGlobales data = DatosGlobales.getInstancia();
            @Override
            public void run() {
            	Random random = new Random();
                int numeroAleatorio = random.nextInt(101);
                if(numeroAleatorio<posibilidadVentilacion) {
                	if(isEstadoVentilacion()) {
                        setEstadoVentilacion(false);
                    	Clock reloj = Clock.getInstancia();
                    	String fecha = reloj.getFecha();
                    	System.out.println(fecha);
                        Falla falla = new Falla(Colmena.this, numeroFinca, ID, sector, "Ventilacion", fecha);
//                        GlobalConfig.addFalla(falla);
                        data.addFalla(falla);
                	}
                	
                } else {
                	System.out.println("Funcionó");             
                }
                
            }
        
        }, tiempoDanoVentilacion, tiempoDanoVentilacion);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getTiempoMiel() {
		return tiempoMiel;
	}

	public void setTiempoMiel(int tiempoMiel) {
		this.tiempoMiel = tiempoMiel;
	}

	public int getMiel() {
		return miel;
	}

	public void setMiel(int miel) {
		this.miel = miel;
	}

	public boolean isEstadoVentilacion() {
		return estadoVentilacion;
	}

	public void setEstadoVentilacion(boolean estadoVentilacion) {
		this.estadoVentilacion = estadoVentilacion;
	}

	public boolean isEstadoAislamiento() {
		return estadoAislamiento;
	}

	public void setEstadoAislamiento(boolean estadoAislamiento) {
		this.estadoAislamiento = estadoAislamiento;
	}

	public boolean isEstadoComederos() {
		return estadoComederos;
	}

	public void setEstadoComederos(boolean estadoComederos) {
		this.estadoComederos = estadoComederos;
	}

	public int getTiempoDanoVentilacion() {
		return tiempoDanoVentilacion;
	}

	public void setTiempoDanoVentilacion(int tiempoDanoVentilacion) {
		this.tiempoDanoVentilacion = tiempoDanoVentilacion;
	}

	public int getTiempoDanoAislamiento() {
		return tiempoDanoAislamiento;
	}

	public void setTiempoDanoAislamiento(int tiempoDanoAislamiento) {
		this.tiempoDanoAislamiento = tiempoDanoAislamiento;
	}

	public int getTiempoDanoComederos() {
		return tiempoDanoComederos;
	}

	public void setTiempoDanoComederos(int tiempoDanoComederos) {
		this.tiempoDanoComederos = tiempoDanoComederos;
	}
	
	public void repararAislamiento() {
		this.estadoAislamiento = true;
	}
	
	public void repararComederos() {
		this.estadoComederos = true;
	}
	
	public void repararVentilacion() {
		this.estadoVentilacion = true;
	}
	
	public void printHola() {
		System.out.println("Hola");
	}

	public void setEstadoGeneral(boolean estadoGeneral) {
		this.estadoGeneral = estadoGeneral;
	}

	public boolean isEstadoGeneral() {
		return estadoGeneral;
	}
	
	public Sector getSector() {
		return sector;
	}

	public int getNumeroFinca() {
		return numeroFinca;
	}
	
}
