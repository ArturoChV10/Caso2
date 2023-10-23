package interfacesGraficas;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dataColmena.DatosGlobales;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hiveProduction.Colmena;
import hiveProduction.Finca;
import hiveProduction.Sector;
import reparacion.Falla;

public class FallaUI {
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	DatosGlobales data = DatosGlobales.getInstancia();
    	ArrayList<Falla> arrayFallas = data.getArrayFallas();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("# de Finca");
        model.addColumn("ID de Colmena");
        model.addColumn("Sector");
        model.addColumn("Componente dañado");
        model.addColumn("Fecha");
        
        for(int h=0; h < arrayFallas.size(); h++) {
    		Falla falla = arrayFallas.get(h);
    		
    		Sector pSector = falla.getSectorColmena();
    		
    		model.addRow(new Object[]{falla.getNumeroFinca(), falla.getIDColmena(), pSector.toString(), falla.getElementoDanado(), falla.getFecha()});
        }

        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Modo de selección de una sola fila

        JButton seleccionarButton = new JButton("Seleccionar Fila");
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int numeroF = (int) table.getValueAt(filaSeleccionada, 0);
                    int ID = (int) table.getValueAt(filaSeleccionada, 1);
                    String sector = (String) table.getValueAt(filaSeleccionada, 2);
                    String falla = (String) table.getValueAt(filaSeleccionada, 3);
                    String fecha = (String) table.getValueAt(filaSeleccionada, 4);
                    JOptionPane.showMessageDialog(frame, "Usted ha seleccionado la falla de la finca numero " + numeroF + ", con el número de ID de colmena " + ID + ", ubicada en el sector de " + sector + ", con una falla de " + falla + " y ocurrido el " + fecha);
                    FallaUI.repararError(numeroF, ID, falla);
                    FallaUI.quitarError(numeroF, ID, falla);
                    ((DefaultTableModel) table.getModel()).removeRow(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(frame, "Ninguna fila seleccionada.");
                }
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(seleccionarButton, BorderLayout.SOUTH);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    
    public static void quitarError(int pNumero, int pID, String pFalla) {
    	DatosGlobales data = DatosGlobales.getInstancia();
    	ArrayList<Falla> arrayFallas = data.getArrayFallas();
    	for(int t = 0; t<arrayFallas.size(); t++) {
    		Falla falla = arrayFallas.get(t);
    		if(falla.getNumeroFinca()==pNumero&&falla.getIDColmena()==pID&&falla.getElementoDanado()==pFalla) {
    			data.addHistorial(falla);
    			data.removerFalla(t);
    		}
    	}
    }
    
    public static void repararError(int numeroFinca, int IDColmena, String pFalla) {
    	DatosGlobales data = DatosGlobales.getInstancia();
    	ArrayList<Finca> arrayFincas = data.getArrayFincas();
    	for(int k = 0; k < arrayFincas.size(); k++) {
    		Finca finca = arrayFincas.get(k);
    		if(finca.getIDFinca() == numeroFinca) {
    			ArrayList<Colmena> arrayColmenas = finca.getArrayColmenas();
    			for(int p = 0; p<arrayColmenas.size(); p++) {
    				Colmena colmena = arrayColmenas.get(p);
    				if(colmena.getID() == IDColmena) {
    					if(pFalla == "Ventilacion") {
    						colmena.setEstadoVentilacion(true);
    					}else {
    						if(pFalla == "Aislamiento") {
    							colmena.setEstadoAislamiento(true);
    						} else {
    							if(pFalla == "Comederos") {
    								colmena.setEstadoComederos(true);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    }
}