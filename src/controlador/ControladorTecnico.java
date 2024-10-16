/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MateriaPrima;
import modelo.TecnicoDao;
import modelo.Usuarios;
import vista.VistaTecnico;

/**
 *
 * @author hgust
 */
public class ControladorTecnico implements ActionListener{
    
    ControladorRopaVenta crpv = new ControladorRopaVenta();
    ControladorMp insumos = new ControladorMp();
    VistaTecnico vista5 = new VistaTecnico();
    TecnicoDao daot = new TecnicoDao();
    DefaultTableModel modelito=new DefaultTableModel();
    ControladorUs usu = new ControladorUs();
    
    
    public ControladorTecnico(VistaTecnico visT) {
        this.vista5=visT;
        this.vista5.miScroll.setVisible(false);
//        this.vista5.mitabla.setVisible(false);
        this.vista5.enviar.addActionListener(this);
        this.vista5.tareas.addActionListener(this);
        this.vista5.btnOcultar.addActionListener(this);
        this.insumos.da4.listaInsumos(this.vista5.jinsumo);
        
        
    }
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista5.enviar){
           validar();
            
        }
        if(ae.getSource()==vista5.tareas){
        this.vista5.miScroll.setVisible(true);
//         this.vista5.mitabla.setVisible(true);
         this.insumos.limpiarTabla();
         this.insumos.getListar(this.vista5.mitabla);
        }
         if(ae.getSource()==vista5.btnOcultar){
        this.vista5.miScroll.setVisible(false);
//         this.vista5.mitabla.setVisible(true);
        
        }
    }
    public void getListar(JTable tabla){
        modelito=(DefaultTableModel) tabla.getModel();
        List<MateriaPrima>lista = this.insumos.da4.listar();
        Object[] object=new Object[3];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getMateria_id();
            object[1]=lista.get(indice).getMateria_nombre();
            object[2]=lista.get(indice).getMateria_stock();
            
            modelito.addRow(object);
        }
        vista5.mitabla.setModel(modelito);
    }
    public void validar(){
        String materia_nombre=(String) this.vista5.jinsumo.getSelectedItem();
        int stock=Integer.parseInt(this.vista5.tunidades.getText());
       
        if(stock>0){
        this.insumos.mp = this.daot.mate(materia_nombre);
        
          if(this.insumos.mp.getMateria_nombre()!=null && this.insumos.mp.getMateria_stock()>0){
              if(stock>this.insumos.mp.getMateria_stock()){
                    JOptionPane.showMessageDialog(vista5, "El numero ingresado es mayor a las unidades disponibles");
              }else{
                 int  c=this.insumos.mp.getMateria_stock()-stock;
                  this.insumos.mp.setMateria_stock(c);
                  daot.modificar(this.insumos.mp);
                   JOptionPane.showMessageDialog(vista5, "Breve menor"+this.insumos.mp.getMateria_stock());
                   
              }
          }
        
        
        
        }
        
        
        
    }
            
    
    
}
