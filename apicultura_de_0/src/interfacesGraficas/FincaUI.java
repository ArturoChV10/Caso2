package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hiveProduction.Colmena;
import hiveProduction.Finca;
import hiveProduction.Sector;

public class FincaUI extends JFrame {    
    JFrame frame;
    ArrayList<Colmena> arrayColmenas;
    
    public FincaUI(Finca pFinca){    
    	frame=new JFrame();
    	arrayColmenas = pFinca.getArrayColmenas();
    	String info[][] = {};
    	for(int h=0; h < arrayColmenas.size(); h++) {
    		Colmena colmena = arrayColmenas.get(h);
    		
    		Sector sector = colmena.getSector();
    		
    		String SEstado = new String();
    		
    		boolean estado = colmena.isEstadoGeneral();
    		if(estado == true) {
    			SEstado = "Funcionando";
    		} else {
    			SEstado = "Danado";
    		}
    		
    		String[] parte = {String.valueOf(colmena.getID()), sector.toString(), String.valueOf(colmena.getMiel()), SEstado};
    		
    		String nuevoInfo[][] = new String[info.length + 1][parte.length];
    		
    		System.arraycopy(info, 0, nuevoInfo, 0, info.length);
    		
    		nuevoInfo[info.length] = parte;
    		
    		info = nuevoInfo;
    	}

    	String column[]={"ID de Colmena","Sector","Miel Producida", "Estado General"};         
    	JTable tabla=new JTable(info,column);    
    	tabla.setBounds(30,40,200,300);          
    	JScrollPane scrollPane=new JScrollPane(tabla);    
    	frame.add(scrollPane);          
    	frame.setSize(600,400);    
    	frame.setVisible(true);
    	JButton hola = new JButton("Decir hola");
    	hola.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hola");
			}
    		
    	});
    	JPanel panelBoton = new JPanel();
    	panelBoton.add(hola);
    	panelBoton.setBounds(300, 300, 300, 300);
    	frame.add(panelBoton, BorderLayout.SOUTH);
    }
    
    public void obtenerArray(Finca pFinca) {
    	arrayColmenas = pFinca.getArrayColmenas();
    }
    
    public static void main(String[] args) {    
    	new FincaUI(null);    
    }    
    
}  