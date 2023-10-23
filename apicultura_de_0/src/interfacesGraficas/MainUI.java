package interfacesGraficas;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

import jsonLoader.ConfigHive;
import dataColmena.DatosGlobales;
import hiveProduction.Finca;


public class MainUI extends JFrame {
	ArrayList<Finca> arrayFincas;
	public MainUI(ArrayList<Finca> pArrayFincas) {
		
		DatosGlobales data = DatosGlobales.getInstancia();
		
		arrayFincas = data.getArrayFincas();
		
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
        
        MainUI.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
                
        //Crea un label
        JLabel label = new JLabel("Fincas de Costa Rica");
        //Le establece una fuente, en este caso el primer parámetro equivale a la fuente, el segundo al tipo de letra (BOLD = negrita, PLAIN = normal, ITALIC = cursiva) y por último el tamaño de la fuente
        label.setFont(new Font("Arial", Font.BOLD, 28));
        //Se ubica el label dentro de la ventana, en este caso, e primer parámetro equivale a la ubicación en x, el segundo parámetro a la ubicación en y, el tercer parámetro a la anchura del label y el último a la altura
        label.setBounds(140, 10, 330, 40);
        
        //La siguiente instrucción se divide en 2 partes, la primera getContentPane() es usada para "llamar" a la ventana, esto para poder aplicarle setLayout(null) que lo que significa es que los elementos (botones, label etc) serán agregados de manera normal y no de manera automática
        getContentPane().setLayout(null);
        
        JComboBox<Finca> comboBox = new JComboBox<Finca>();
        
//        ArrayList<Finca> arrayFincas = data.getArrayFincas();
        
//        ArrayList<Finca> arrayFincas = pArrayFincas;
       
        for(int k=0; k<pArrayFincas.size(); k++) {
        	Finca finca = pArrayFincas.get(k);
        	comboBox.addItem(finca);
        }

/*
        JComboBox<String> comboBox = new JComboBox<String>();
        
        for(int k=0; k<pArrayFincas.size(); k++) {
        	Finca finca = pArrayFincas.get(k);
        	int numero = finca.getIDFinca();
        	comboBox.addItem("Finca " + numero);
        }
*/        
        comboBox.setBounds(100, 130, 300, 70);
        
        JButton boton = new JButton("Visitar");
        
        boton.setBounds(440, 140, 100, 50);
        
        boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object objeto = comboBox.getSelectedItem();
				visitarFinca(objeto);
			}
        });
        
        
        JButton botonHistorial = new JButton("Historial de fallas");
        
        botonHistorial.setBounds(420, 260, 135, 50);
        
        botonHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verHistorial();
			}
        });
        
        JButton botonFallas = new JButton("Fallas actuales");
        
        botonFallas.setBounds(130, 260, 120, 50);
        
        botonFallas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verFallas();
			}
        });
        
        
        //Se vuelve a "llamar" a la ventana para agregarle el label
        getContentPane().add(label);
        getContentPane().add(comboBox);
        getContentPane().add(boton);
        getContentPane().add(botonHistorial);
        getContentPane().add(botonFallas);

	}
	
	private void verFallas() {
		FallaUI.main(null);
	}
	
	private void verHistorial() {
		HistorialUI.main(null);
	}
	
	private void visitarFinca(Object pObjeto) {
		System.out.println("123456789012345678901234567890");
		Finca fincaSeleccionada = (Finca) pObjeto;
		if (pObjeto != null && pObjeto instanceof Finca) {
//		    Finca fincaSeleccionada = (Finca) pObjeto;
	        JOptionPane.showMessageDialog(this, "Visitando la finca: " + fincaSeleccionada.getIDFinca());
	        FincaUI UIFinca = new FincaUI(fincaSeleccionada);
		} else {
		    System.out.println("No ha seleccionado nada del comboBox");
		}
    }
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			MainUI frame = new MainUI(null);
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}
	
}