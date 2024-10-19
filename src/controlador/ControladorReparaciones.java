/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Estado;
import modelo.RopaClinica;
import modelo.Usuarios;
import vista.VistaReparaciones;

/**
 *
 * @author hgust
 */
public class ControladorReparaciones implements ActionListener {
    ControladorRopaClinica controlclinica = new ControladorRopaClinica();
    VistaReparaciones vistarepair = new VistaReparaciones();
    DefaultTableModel modelito5=new DefaultTableModel();
    ControladorEstado contest=new ControladorEstado();
    ControladorUs contusu=new ControladorUs();

    public ControladorReparaciones(VistaReparaciones vistrepair) {
        this.vistarepair=vistrepair;
        this.vistarepair.buscar.addActionListener(this);
        this.vistarepair.btncerrar.addActionListener(this);
       
    }

    public ControladorReparaciones() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vistarepair.buscar){
            limpiarTabla();
            getListar(vistarepair.mitabla);
            JOptionPane.showMessageDialog(vistarepair, "Consulta exitosa");
        }
        
    
    }
     public void getListar(JTable tabla){
        modelito5=(DefaultTableModel) tabla.getModel();
        int client=Integer.parseInt(this.vistarepair.tid.getText().toString());
        List<RopaClinica>lista = this.controlclinica.daClinica.listarPorCliente(client);
        Object[] object=new Object[11];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getRp_id();
            object[1]=lista.get(indice).getRpc_id();
            object[2]=lista.get(indice).getRp_nombre();
            object[3]=lista.get(indice).getRp_marca();
            object[4]=lista.get(indice).getRp_descripcion();
            object[5]=lista.get(indice).getRp_color();
            object[6]=lista.get(indice).getRp_categoria();
            object[7]=lista.get(indice).getRpc_estado();
            object[8]=lista.get(indice).getRpc_dano();
            object[9]=lista.get(indice).getRpc_usuario();
            object[10]=lista.get(indice).getRpc_cliente();
            
            modelito5.addRow(object);
        }
        vistarepair.mitabla.setModel(modelito5);
    }
    public void limpiarTabla(){
        for(int i=0;i<vistarepair.mitabla.getRowCount();i++){
            modelito5.removeRow(i);
            i=i-1;
        }
    }
}
