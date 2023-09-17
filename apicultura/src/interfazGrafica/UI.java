package interfazGrafica;

import javax.swing.*;

import javax.swing.border.*;

import interfazGrafica.UI;

import java.awt.*;

import interfazGrafica.ColmenaUI1;
import interfazGrafica.ColmenaUI2;
import interfazGrafica.ColmenaUI3;

public class UI extends JFrame {
//	private JTextArea textArea;
//	private JButton button2;
	private ColmenaUI1 colmenaUno;
	private ColmenaUI2 colmenaDos;
	private ColmenaUI3 colmenaTres;
	
	public UI() {
		
		//Establecer título de la ventana
		setTitle("Producción apícola");
		//Establecer tamaño de la ventana inicial
		setSize(625, 610);
		//Para establecer si se puede modificar o no el tamaño de la ventana se usa setResizable(flase/true);, en este caso no deseo que sea modificable
		setResizable(false);
		//Cerrará el programa para no dejar operaciones en segundo plano
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        //------------------------------------------------
        
        setBounds(100, 100, 450, 300);
        PanelImagen p = new PanelImagen();
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        p.setLayout(new BorderLayout(0, 0));
        setContentPane(p);
        
        //------------------------------------------------
         */
        //Establece donde se abrirá la ventana cuando se corra el programa
        setLocation(50, 60);
                
        //Crea un label
        JLabel label = new JLabel("Colmenas de Costa Rica");
        //Le establece una fuente, en este caso el primer parámetro equivale a la fuente, el segundo al tipo de letra (BOLD = negrita, PLAIN = normal, ITALIC = cursiva) y por último el tamaño de la fuente
        label.setFont(new Font("Arial", Font.BOLD, 28));
        //Se ubica el label dentro de la ventana, en este caso, e primer parámetro equivale a la ubicación en x, el segundo parámetro a la ubicación en y, el tercer parámetro a la anchura del label y el último a la altura
        label.setBounds(160, 10, 330, 40);
        
        //La siguiente instrucción se divide en 2 partes, la primera getContentPane() es usada para "llamar" a la ventana, esto para poder aplicarle setLayout(null) que lo que significa es que los elementos (botones, label etc) serán agregados de manera normal y no de manera automática
        getContentPane().setLayout(null);
        //Se vuelve a "llamar" a la ventana para agregarle el label
        getContentPane().add(label);
        
        //Crear un botón para poder abir la siguiente ventana, en este caso una colmena
        JButton colmena1 = new JButton("Colmena #1");
        colmena1.setBounds(150, 140, 50, 50);
        
        getContentPane().add(colmena1);
        
        JButton colmena2 = new JButton("Colmena #2");
        colmena2.setBounds(380, 200, 50, 50);
        
        getContentPane().add(colmena2);
        
        JButton colmena3 = new JButton("Colmena #3");
        colmena3.setBounds(420, 370, 50, 50);
        
        getContentPane().add(colmena3);
        
        //Crear label para agregar una imagen de fondo
        JLabel imagen = new JLabel();
        
        //Establecer imagen como fondo para el label
        imagen.setIcon(new ImageIcon("C:/Users/PRINCIPAL/Desktop/Caso2/Caso2/apicultura/siluetaCR.jpg"));
        imagen.setBounds(0, 0, 800, 600);
        
        //Agrega la imagen en la ventana
        getContentPane().add(imagen);

        
        colmena1.addActionListener(e ->colmena1());
        colmena2.addActionListener(e ->colmena2());
        colmena3.addActionListener(e ->colmena3());
        colmenaUno = new ColmenaUI1();
        colmenaDos = new ColmenaUI2();
        colmenaTres = new ColmenaUI3();
        
        
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(() -> {
			//Crea una instancia de la clase UI que será usada para mostrar los elementos
			UI frame = new UI();
			//Establece que cuando se corra el java application se va a mostrar la ventana recién creada, si no se agregara 
	        frame.setVisible(true);
	    });
	}
	
	public void colmena1() {
		colmenaUno.setVisible(true);
	}
	
	public void colmena2() {
		colmenaDos.setVisible(true);
	}
	
	public void colmena3() {
		colmenaTres.setVisible(true);
	}

}
