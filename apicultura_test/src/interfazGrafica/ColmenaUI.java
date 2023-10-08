package interfazGrafica;

import javax.swing.*;

import colmena.Colmena;
import dataColmena.DatosGlobales;
import reparacion.Tecnico;
import interfazGrafica.UI2;
import jsonLoader.ConfigHive;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;

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
	private Tecnico tecnico;
	private ConfigHive Configuracion;
	
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
	
	public void setEstadoParedesText2(String pTexto) {
		estadoParedes.setText(pTexto);
		repararParedes.setBackground(null);
	}
	
	public void setEstadoComederosText2(String pTexto) {
		estadoBebederos.setText(pTexto);
		repararBebederos.setBackground(null);
	}
	
	public void setEstadoVentilacionText2(String pTexto) {
		estadoVentilacion.setText(pTexto);
		repararVentilacion.setBackground(null);
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
        // Asigna un ActionListener al botón
        repararParedes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coloca el código que deseas ejecutar cuando se presione el botón aquí
//                JOptionPane.showMessageDialog(null, "¡Botón presionado!");
                ArrayList<Colmena> arrayColmenas = DatosGlobales.getArrayColmenas();
                int casilla = DatosGlobales.getCasillaActual();
                
                Colmena objetoClasse = arrayColmenas.get(casilla);
/*                
                Configuracion = new ConfigHive();
        		
        		Random rand = new Random();
        		
        		int minTiempoArreglo = Configuracion.getMinTiempoMiel();
        		int maxTiempoArreglo = Configuracion.getMinTiempoMiel();

        		int tiempoReparacionR = rand.nextInt(maxTiempoArreglo - minTiempoArreglo + 1) + minTiempoArreglo;
*/                 
                try {
//                	tecnico.setCantidadTecnicos(tecnico.getCantidadTecnicos()-1);
					Thread.sleep(3000);
//					tecnico.setCantidadTecnicos(tecnico.getCantidadTecnicos()+1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                objetoClasse.setEstadoAislamiento(true);
            }
        });
        
        repararBebederos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Colmena> arrayColmenas = DatosGlobales.getArrayColmenas();
                int casilla = DatosGlobales.getCasillaActual();
                
                Colmena objetoClasse = arrayColmenas.get(casilla);
/*                
                Configuracion = new ConfigHive();
        		
        		Random rand = new Random();
        		
        		int minTiempoArreglo = Configuracion.getMinTiempoMiel();
        		int maxTiempoArreglo = Configuracion.getMinTiempoMiel();

        		int tiempoReparacionR = rand.nextInt(maxTiempoArreglo - minTiempoArreglo + 1) + minTiempoArreglo;
*/            
                try {
//                	tecnico.setCantidadTecnicos(tecnico.getCantidadTecnicos()-1);
					Thread.sleep(3000);
//					tecnico.setCantidadTecnicos(tecnico.getCantidadTecnicos()+1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                objetoClasse.setEstadoComederos(true);
            }
        });
        
        repararVentilacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Colmena> arrayColmenas = DatosGlobales.getArrayColmenas();
                int casilla = DatosGlobales.getCasillaActual();
                
                Colmena objetoClasse = arrayColmenas.get(casilla);
/*                
                Configuracion = new ConfigHive();
        		
        		Random rand = new Random();
        		
        		int minTiempoArreglo = Configuracion.getMinTiempoMiel();
        		int maxTiempoArreglo = Configuracion.getMinTiempoMiel();

        		int tiempoReparacionR = rand.nextInt(maxTiempoArreglo - minTiempoArreglo + 1) + minTiempoArreglo;
*/                               
                try {
//                	tecnico.setCantidadTecnicos(tecnico.getCantidadTecnicos()-1);
					Thread.sleep(3000);
//					tecnico.setCantidadTecnicos(tecnico.getCantidadTecnicos()+1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                objetoClasse.setEstadoVentilacion(true);
            }
        });
        
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
/*        
        repararParedes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Colmena> arrayColmenas = DatosGlobales.getArrayColmenas();
                int casilla = DatosGlobales.getCasillaActual();
                
                Colmena objetoClasse = arrayColmenas.get(casilla);
                
                objetoClasse.setEstadoAislamiento(true);
            }
        });
*/        
	}
}