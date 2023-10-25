package generalTime;

import dataColmena.DatosGlobales;
import java.util.Calendar;

public class Clock {
	private static Clock clock = null;
    private int dia;
    private int mes;
    private int ano;
    private int horaActual;
    private int tiempoHora;
    
    public Clock() {
    	Calendar calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH) + 1;
        ano = calendario.get(Calendar.YEAR);
        horaActual = 0;
        tiempoHora = DatosGlobales.getHora(); // Duración de una hora en milisegundos (aquí, 1000 ms = 1 segundo)
    }
    
    public void startClock() {
        Thread clockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(tiempoHora); // Espera una hora
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Aumento de hora");
                    aumentarHora();
                }
            }
        });
        clockThread.start();
    }
    
    private void aumentarHora() {
        horaActual++;
        if (horaActual >= 24) {
            horaActual = 0;
            aumentarDia();
        }
    }
    
    private void aumentarDia() {
        dia++;
        if (dia > 30) {
            dia = 1;
            aumentarMes();
        }
    }
    
    private void aumentarMes() {
        mes++;
        if (mes > 12) {
            mes = 1;
            aumentarAno();
        }
    }
    
    private void aumentarAno() {
        ano++;
    }
    
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getAno() {
        return ano;
    }
    
    public int getHoraActual() {
        return horaActual;
    }
    
    public String getFecha() {
    	String fecha = Clock.this.getDia() +"/"+ Clock.this.getMes()+"/"+Clock.this.getAno();
    	return fecha;
    }
    
    public static Clock getInstancia() {
    	if(clock == null) {
    		clock = new Clock();
    	}
    	return clock;
    }
}
