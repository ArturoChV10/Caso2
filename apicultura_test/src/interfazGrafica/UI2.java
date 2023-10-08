package interfazGrafica;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import reparacion.Tecnico;
import interfazGrafica.ColmenaUI;
import jsonLoader.ConfigHive;
import colmena.Colmena;
import dataColmena.DatosGlobales;


public class UI2 extends JFrame {
//	private JTextArea textArea;
//	private JButton button2;
	private ConfigHive Configuracion;
//	private ArrayList<Colmena> arrayColmenas;
	private ArrayList<ColmenaUI> arrayColmenasUI;
	private JComboBox<String> comboBox;
	private int casillaNumero;

	public ArrayList<ColmenaUI> getArrayColmenasUI() {
		return arrayColmenasUI;
	}
/*
	public ArrayList<Colmena> getArrayColmenas() {
		return arrayColmenas;
	}
*/
	public int getCasillaNumero() {
		return casillaNumero;
	}
/*
	public void setArrayColmenas(ArrayList<Colmena> arrayColmenas) {
		this.arrayColmenas = arrayColmenas;
	}
*/
	public void setArrayColmenasUI(ArrayList<ColmenaUI> arrayColmenasUI) {
		this.arrayColmenasUI = arrayColmenasUI;
	}

	public UI2() {
		
		//Establecer título de la ventana
		setTitle("Producción apícola");
		//Establecer tamaño de la ventana inicial
		setSize(625, 400);
		//Para establecer si se puede modificar o no el tamaño de la ventana se usa setResizable(false/true);, en este caso no deseo que sea modificable
		setResizable(false);
		//Cerrará el programa para no dejar operaciones en segundo plano
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Establece donde se abrirá la ventana cuando se corra el programa
        setLocation(50, 60);
        
        UI2.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
                
        //Crea un label
        JLabel label = new JLabel("Colmenas de Costa Rica");
        //Le establece una fuente, en este caso el primer parámetro equivale a la fuente, el segundo al tipo de letra (BOLD = negrita, PLAIN = normal, ITALIC = cursiva) y por último el tamaño de la fuente
        label.setFont(new Font("Arial", Font.BOLD, 28));
        //Se ubica el label dentro de la ventana, en este caso, e primer parámetro equivale a la ubicación en x, el segundo parámetro a la ubicación en y, el tercer parámetro a la anchura del label y el último a la altura
        label.setBounds(140, 10, 330, 40);
        
        //La siguiente instrucción se divide en 2 partes, la primera getContentPane() es usada para "llamar" a la ventana, esto para poder aplicarle setLayout(null) que lo que significa es que los elementos (botones, label etc) serán agregados de manera normal y no de manera automática
        getContentPane().setLayout(null);
        //Se vuelve a "llamar" a la ventana para agregarle el label
        getContentPane().add(label);
        
        comboBox = new JComboBox<>();
        ArrayList<Colmena> arrayColmenas = DatosGlobales.getArrayColmenas();
        arrayColmenasUI = new ArrayList<>();
        
        Configuracion = new ConfigHive();
        
        //Considero que puedo hacer una clase que sea configLoader, misma cargará todos estos datos.
        
        Tecnico tecnicoColmena = new Tecnico();
        
        tecnicoColmena.setCantidadTecnicos(Configuracion.getCantidadTecnicos());
        
        for(int i=0; i < Configuracion.getCantidadColmenas(); i++) {
        	
        	Colmena colmena = new Colmena();
        	
        	ColmenaUI interfazDeColmena = new ColmenaUI();
        	
        	interfazDeColmena.setEstadoParedesS(true);
        	interfazDeColmena.setEstadoBebederosS(true);
        	interfazDeColmena.setEstadoVentilacionS(true);
    		
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

    		colmena.setTiempoMiel(tiempoMielR);
    		colmena.setTiempoDañoAislamiento(tiempoAislamientoR);
    		colmena.setTiempoDañoVentilacion(tiempoVentilacionR);
    		colmena.setTiempoDañoComederos(tiempoComederosR);
    		colmena.setEstadoAislamiento(true);
    		colmena.setEstadoComederos(true);
    		colmena.setEstadoVentilacion(true);

        	arrayColmenas.add(colmena);
        	String numero = Integer.toString(i+1); 
        	comboBox.addItem("Colmena" + numero);
        	arrayColmenasUI.add(interfazDeColmena);
        }
        
        comboBox.setBounds(100, 130, 300, 70);
        
        getContentPane().add(comboBox);
        
        JButton boton = new JButton("Visitar");
        
        boton.addActionListener(e ->visitar());
        
        boton.setBounds(420, 140, 100, 50);
        
        getContentPane().add(boton);

	}
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			UI2 frame = new UI2();
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}
	
	public void visitar() {
		int casilla = obtener();
		System.out.println("==================");
		System.out.println(casilla);
		System.out.println("==================");
		ArrayList<Colmena> arrayColmenas = DatosGlobales.getArrayColmenas();
		Colmena colmena = arrayColmenas.get(casilla);
		DatosGlobales.setCasillaActual(casilla);
		colmena.main(null);
	}
	public int obtener() {
		int casillaSeleccionada = comboBox.getSelectedIndex();
		this.casillaNumero = casillaSeleccionada;
		System.out.println(casillaSeleccionada);
		return casillaSeleccionada;
	}
}