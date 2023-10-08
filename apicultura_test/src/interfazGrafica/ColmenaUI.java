package interfazGrafica;

import javax.swing.*;

import colmena.Colmena;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import interfazGrafica.UI2;

public class ColmenaUI extends JFrame {
	private JButton repararParedes;
	private JButton repararBebederos;
	private JButton repararVentilacion;
	private JTextField estadoParedes;
	private JTextField estadoBebederos;
	private JTextField estadoVentilacion;
	private boolean estadoParedesS;
	private boolean estadoBebederosS;
	private boolean estadoVentilacionS;
	private Colmena objetoClasse;
	
	public boolean isEstadoParedesS() {
		return estadoParedesS;
	}

	public void setEstadoParedesS(boolean estadoParedesS) {
		this.estadoParedesS = estadoParedesS;
	}

	public boolean isEstadoBebederosS() {
		return estadoBebederosS;
	}

	public void setEstadoBebederosS(boolean estadoBebederosS) {
		this.estadoBebederosS = estadoBebederosS;
	}

	public boolean isEstadoVentilacionS() {
		return estadoVentilacionS;
	}

	public void setEstadoVentilacionS(boolean estadoVentilacionS) {
		this.estadoVentilacionS = estadoVentilacionS;
	}
	
	public void setEstadoParedesText(String pTexto) {
		estadoParedes.setText(pTexto);
		repararParedes.setBackground(Color.RED);
	}
	
	public void setEstadoComederosText(String pTexto) {
		estadoBebederos.setText(pTexto);
		repararBebederos.setBackground(Color.RED);
	}
	
	public void setEstadoVentilacionText(String pTexto) {
		estadoVentilacion.setText(pTexto);
		repararVentilacion.setBackground(Color.RED);
	}
	
	public void repararParedes() {
		objetoClasse.repararAislamiento();
	}
	
	public void repararBebederos() {
		objetoClasse.repararComederos();
	}
	
	public void repararVentilacion() {
		objetoClasse.repararVentilacion();
	}
	
	
	public ColmenaUI() {
		setTitle("Colmena");
		setSize(600,500);
		setResizable(false);
/*		
		UI2 instanciaUI = new UI2();
		
		ArrayList<Colmena> arrayColmenas = instanciaUI.getArrayColmenas();
		
		Colmena objetoClasse = arrayColmenas.get(instanciaUI.getCasillaNumero());
*/		
		setLocation(50,60);
		
		JLabel paredesAislamiento = new JLabel("Paredes y Aislamiento");
		paredesAislamiento.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel bebederos = new JLabel("Alimentadores y bebederos");
		bebederos.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel ventilacion = new JLabel("Ventilación");
		ventilacion.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel estado = new JLabel("Estado");
		estado.setFont(new Font("Arial", Font.PLAIN, 14));
		
		estadoParedes = new JTextField("Funcionando");
		estadoBebederos = new JTextField("Funcionando");
		estadoVentilacion = new JTextField("Funcionando");
		
		repararParedes = new JButton("Reparar");
		repararBebederos = new JButton("Reparar");
		repararVentilacion = new JButton("Reparar");
		
		getContentPane().setLayout(null);
		
		paredesAislamiento.setBounds(60, 100, 300, 20);
		bebederos.setBounds(30, 200, 300, 20);
		ventilacion.setBounds(130, 300, 300, 20);
		estado.setBounds(300, 50, 300, 20);
		estadoParedes.setBounds(270, 100, 100, 20);
		estadoBebederos.setBounds(270, 200, 100, 20);
		estadoVentilacion.setBounds(270, 300, 100, 20);
		repararParedes.setBounds(430, 100, 100, 20);
		repararBebederos.setBounds(430, 200, 100, 20);
		repararVentilacion.setBounds(430, 300, 100, 20);
/*		
		this.estadoParedesS = true;
		this.estadoBebederosS = true;
		this.estadoVentilacionS = true;
*/		
		getContentPane().add(paredesAislamiento);
		getContentPane().add(bebederos);
		getContentPane().add(ventilacion);
		getContentPane().add(estado);
		getContentPane().add(estadoParedes);
		getContentPane().add(estadoBebederos);
		getContentPane().add(estadoVentilacion);
		getContentPane().add(repararParedes);
		getContentPane().add(repararBebederos);
		getContentPane().add(repararVentilacion);
		
        // Agrega un WindowListener para manejar el cierre de la ventana
        addWindowListener((WindowListener) new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Hola"); // Imprime "Hola" en la consola al cerrar la ventana
//                objetoClasse.guardar();
                dispose(); // Cierra la ventana
            }
        });
		
	}
}