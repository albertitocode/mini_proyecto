/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MateriaDao;
import modelo.MateriaPrima;
import vista.VistaMateria;
import vista.VistaOrden;
import vista.VistaSupervisor;
/**
 *
 * @author hgust
 */

    public class ControladorOrden implements ActionListener {

    public MateriaDao daoMP = new MateriaDao();
    public MateriaPrima mp = new MateriaPrima();
    public VistaOrden vOrden = new VistaOrden();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorOrden(VistaOrden visOrden) {
        this.vOrden = visOrden;
        getInsumos(vOrden.jtInsumos);
     
        this.vOrden.btnNo.addActionListener(this);
        this.vOrden.btnGenerar.addActionListener(this);
        this.vOrden.btnRegresar.addActionListener(this);
    }

    public ControladorOrden() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vOrden.btnGenerar) {
            getActualizarStock();
            limpiarTabla();
            getInsumos(vOrden.jtInsumos);
            JOptionPane.showMessageDialog(vOrden ,"Orden generada con éxito");
           
        }
        if(e.getSource()== vOrden.btnNo){
             JOptionPane.showMessageDialog(vOrden ,"Orden cancelada");
            VistaSupervisor visasuper = new VistaSupervisor();
            ControladorSupervisor conesuper = new ControladorSupervisor(visasuper);
            visasuper.setVisible(true);
            visasuper.setSize(900, 650);
            visasuper.setLocation(300, 10);
            visasuper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource()== vOrden.btnGenerar){
            VistaSupervisor visasuper = new VistaSupervisor();
            ControladorSupervisor conesuper = new ControladorSupervisor(visasuper);
            visasuper.setVisible(true);
            visasuper.setSize(900, 650);
            visasuper.setLocation(300, 10);
            visasuper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    }

    public void getInsumos(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<MateriaPrima> lista = daoMP.getInsumos();
        Object[] object = new Object[3];

        for (int indice = 0; indice < lista.size(); indice++) {
            object[0] = lista.get(indice).getMateria_id();
            object[1] = lista.get(indice).getMateria_nombre();
            object[2] = lista.get(indice).getMateria_stock();

            modelo.addRow(object);
        }
        vOrden.jtInsumos.setModel(modelo);
    }

    public void getActualizarStock() {
            daoMP.setActualizarStock();
        

    }

    public void limpiarTabla() {
        for (int i = 0; i < vOrden.jtInsumos.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}


