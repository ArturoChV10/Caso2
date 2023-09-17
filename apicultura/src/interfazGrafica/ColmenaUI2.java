package interfazGrafica;

import javax.swing.*;
import java.awt.*;

import interfazGrafica.ColmenaUI2;

public class ColmenaUI2 extends JFrame {
	
	public ColmenaUI2() {
		
		setTitle("Segunda Colmena");
		setSize(600,500);
		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocation(50,60);
		
		JButton paredesAislamiento = new JButton("Paredes y Aislamiento");
		JButton alimentadores = new JButton("Alimentadores y bebederos");
		alimentadores.setFont(new Font("Arial", Font.PLAIN, 14));
		JButton ventilacion = new JButton("Ventilación");
		JTextField textBox = new JTextField();
		
		getContentPane().setLayout(null);
		
		paredesAislamiento.setBounds(100, 50, 25, 370);
		alimentadores.setBounds(135, 360, 275, 60);
		ventilacion.setBounds(420, 235, 97, 185);
		textBox.setBounds(135, 50, 275, 300);
		
		getContentPane().add(paredesAislamiento);
		getContentPane().add(alimentadores);
		getContentPane().add(ventilacion);
		getContentPane().add(textBox);
	}
}
