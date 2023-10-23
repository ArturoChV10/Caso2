package interfacesGraficas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dataColmena.DatosGlobales;
import hiveProduction.Sector;
import reparacion.Falla;

public class HistorialUI {
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	DatosGlobales data = DatosGlobales.getInstancia();
    	ArrayList<Falla> arrayHistorial = data.getArrayHistorial();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("# de Finca");
        model.addColumn("ID de Colmena");
        model.addColumn("Sector");
        model.addColumn("Componente dañado");
        model.addColumn("Fecha");
        
        for(int h=0; h < arrayHistorial.size(); h++) {
    		Falla falla = arrayHistorial.get(h);
    		
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
                    JOptionPane.showMessageDialog(frame, "Usted ha seleccionado la falla de la finca numero " + numeroF + ", con el número de ID de colmena " + ID + ", ubicada en el sector de " + sector + ", con una falla de " + falla + ", ocurrida el " + fecha);
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
}
