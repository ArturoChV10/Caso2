package colmena;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import interfazGrafica.ColmenaUI;
import jsonLoader.ConfigHive;

import java.util.ArrayList;
import java.util.Random;

import interfazGrafica.UI2;

public class Colmena extends Thread {
	private ConfigHive Configuracion;
	private int miel;
	private int tiempoMiel;
	private boolean estadoVentilacion;
	private boolean estadoAislamiento;
	private boolean estadoComederos;
	private int tiempoDañoVentilacion;
	private int tiempoDañoAislamiento;
	private int tiempoDañoComederos;


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


	public int getTiempoDañoVentilacion() {
		return tiempoDañoVentilacion;
	}


	public void setTiempoDañoVentilacion(int tiempoDañoVentilacion) {
		this.tiempoDañoVentilacion = tiempoDañoVentilacion;
	}


	public int getTiempoDañoAislamiento() {
		return tiempoDañoAislamiento;
	}


	public void setTiempoDañoAislamiento(int tiempoDañoAislamiento) {
		this.tiempoDañoAislamiento = tiempoDañoAislamiento;
	}


	public int getTiempoDañoComederos() {
		return tiempoDañoComederos;
	}


	public void setTiempoDañoComederos(int tiempoDañoComederos) {
		this.tiempoDañoComederos = tiempoDañoComederos;
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


	//Con este constructor se podrían definir los tiempos de cada cosa si se desease, para esto se definirían en los
	//parámetros las variables necesarias para poder aplicar this.<nombreDelAtributo> = <valorDelParámetro>
	public Colmena() {
/*		
		Configuracion = new ConfigHive();
		
		Random rand = new Random();
		
		int minProduccion = Configuracion.getMinTiempoMiel();
		int maxProduccion = Configuracion.getMaxTiempoMiel();
		int minParedes = Configuracion.getMinTiempoParedes();
		int maxParedes = Configuracion.getMaxTiempoParedes();
		int minVentilacion = Configuracion.getMinTiempoVentilacion();
		int maxVentilacion = Configuracion.getMaxTiempoVentilacion();
		int minComederos = Configuracion.getMinTiempoComederos();
		int maxComederos = Configuracion.getMaxTiempoComederos();

		int tiempoMielR = rand.nextInt(Math.min(minProduccion, maxProduccion), Math.max(minProduccion, maxProduccion));
		int tiempoAislamientoR = rand.nextInt(Math.min(minParedes, maxParedes), Math.max(minParedes, maxParedes));
		int tiempoVentilacionR = rand.nextInt(Math.min(minVentilacion, maxVentilacion), Math.max(minVentilacion, maxVentilacion));
		int tiempoComederosR = rand.nextInt(Math.min(minComederos, maxComederos), Math.max(minComederos, maxComederos));

		setTiempoMiel(tiempoMielR);
		setTiempoDañoAislamiento(tiempoAislamientoR);
		setTiempoDañoVentilacion(tiempoVentilacionR);
		setTiempoDañoComederos(tiempoComederosR);
		setEstadoAislamiento(true);
		setEstadoComederos(true);
		setEstadoVentilacion(true);
*/		
	}
	
	//La cosa no está funcionando porque cada que se accede al main de colmena, se está creando dos nuevos objetos de clase colmena y clase
	//colmenaUI, por lo que los datos no se mantienen, debería de haber una manera de crear una única vez desde el UI normal, para así mantener
	//la información de las colmenas, en este caso, lo ideal sería poder sacar la línea Colmena objetoClasse = new Colmena(); del main de colmena

	
	public static void main(String[] args) {
		
		//Debería añadir un boolean para saber si está corriendo o no
		
		UI2 instanciaUI = new UI2();
		
		ArrayList<Colmena> arrayColmenas = instanciaUI.getArrayColmenas();
		
		Colmena objetoClasse = arrayColmenas.get(instanciaUI.getCasillaNumero());
		
		ArrayList<ColmenaUI> arrayColmenasUI = instanciaUI.getArrayColmenasUI();	
		
		ColmenaUI interfazDeColmena = arrayColmenasUI.get(instanciaUI.getCasillaNumero());
		interfazDeColmena.setVisible(true);
		
		Timer timerMiel = new Timer();
		
		Timer timerAislamiento = new Timer();
		
		Timer timerComederos = new Timer();
		
		Timer timerVentilacion = new Timer();
		
		Timer timerComprobacion = new Timer();
		
		TimerTask comprobador = new TimerTask() {
			
			@Override
			public void run() {
				if(!objetoClasse.isEstadoAislamiento()) {
					interfazDeColmena.setEstadoParedesText("Dañado");
				}else {
					System.out.println("No ha pasado");
				}
				if(!objetoClasse.isEstadoComederos()) {
					interfazDeColmena.setEstadoComederosText("Dañado");
				}else {
					System.out.println("No ha pasado");
				}
				if(!objetoClasse.isEstadoVentilacion()) {
					interfazDeColmena.setEstadoVentilacionText("Dañado");
				}else {
					System.out.println("No ha pasado");
				}
				
			}
		};
		
		TimerTask miel = new TimerTask() {

			@Override
			public void run() {
				int cantMiel = objetoClasse.getMiel();
				if(!objetoClasse.isEstadoAislamiento()||!objetoClasse.isEstadoComederos()||!objetoClasse.isEstadoVentilacion()) {
					System.out.println("La producción de miel ha sido detenida, debido a que alguno de los componentes está dañado");
				}else {
					objetoClasse.setMiel(objetoClasse.getMiel()+1);
					if(cantMiel!=objetoClasse.getMiel()) {
						System.out.println(objetoClasse.getMiel());
					}
					
				}
				
			}
			
		};
		
		TimerTask aislamiento = new TimerTask() {
			
			@Override
			public void run() {
				objetoClasse.setEstadoAislamiento(false);
				interfazDeColmena.setEstadoParedesS(false);
				System.out.println("El estado del aislamiento es deplorable");
			}
		};
		
		TimerTask comederos = new TimerTask() {
			
			@Override
			public void run() {
				objetoClasse.setEstadoComederos(false);
				interfazDeColmena.setEstadoBebederosS(false);
				System.out.println("Los comederos han sido dañados");
			}
		};
		
		TimerTask ventilacion = new TimerTask() {
			
			@Override
			public void run() {
				objetoClasse.setEstadoVentilacion(false);
				interfazDeColmena.setEstadoVentilacionS(false);
				System.out.println("Han arrasado con la ventilación");
			}
		};
		
		timerMiel.schedule(miel, 0, objetoClasse.getTiempoMiel());
		timerAislamiento.schedule(aislamiento, objetoClasse.getTiempoDañoAislamiento(), objetoClasse.getTiempoDañoAislamiento());
		timerComederos.schedule(comederos, objetoClasse.getTiempoDañoComederos(), objetoClasse.getTiempoDañoComederos());
		timerVentilacion.schedule(ventilacion, objetoClasse.getTiempoDañoVentilacion(), objetoClasse.getTiempoDañoVentilacion());
		timerComprobacion.schedule(comprobador, 0, 10000);
	}

}
