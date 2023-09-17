package interfazGrafica;

import javax.swing.*;
import java.awt.*;

import interfazGrafica.ColmenaUI1;

public class ColmenaUI1 extends JFrame {
	
	public ColmenaUI1() {
		
		setTitle("Primer Colmena");
		setSize(600,500);
		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocation(50,60);
		
		JButton paredesAislamiento = new JButton("Paredes y Aislamiento");
		JButton alimentadores = new JButton("Alimentadores y bebederos");
		alimentadores.setFont(new Font("Arial", Font.PLAIN, 14));
		JButton ventilacion = new JButton("Ventilación");
		JLabel labelMiel = new JLabel("86/100");
		labelMiel.setFont(new Font("Arial", Font.BOLD, 70));
		
		getContentPane().setLayout(null);
		
		paredesAislamiento.setBounds(100, 50, 25, 370);
		alimentadores.setBounds(135, 360, 275, 60);
		ventilacion.setBounds(420, 235, 97, 185);
		labelMiel.setBounds(170, 50, 275, 300);
		
		JTextField textBox = new JTextField();
		textBox.setBounds(135, 50, 275, 300);
		
		getContentPane().add(paredesAislamiento);
		getContentPane().add(alimentadores);
		getContentPane().add(ventilacion);
		getContentPane().add(labelMiel);
		getContentPane().add(textBox);
		

	}
}
