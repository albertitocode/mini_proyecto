/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.TecnicoDao;
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

    public ControladorTecnico(VistaTecnico visT) {
        this.vista5=visT;
        this.vista5.enviar.addActionListener(this);
        this.vista5.tareas.addActionListener(this);
        this.insumos.da4.listaInsumos(this.vista5.jinsumo);
    }
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista5.enviar){
         
            JOptionPane.showMessageDialog(vista5, "Consulta exitosa");
        }
        if(ae.getSource()==vista5.tareas){
         
            JOptionPane.showMessageDialog(vista5, "Consulta exitosa");
        }
    }
    public void validar(){
        JComboBox materia_nombre=(JComboBox) this.vista5.jinsumo.getSelectedItem();
        int stock=Integer.parseInt(this.vista5.tunidades.getText());
        int cont=0;
        if(stock>0){
        this.insumos.mp = this.daot.mate(materia_nombre);
        
          if(this.insumos.mp.getMateria_nombre()!=null && this.insumos.mp.getMateria_stock()>0){
              if(stock>this.insumos.mp.getMateria_stock()){
                    JOptionPane.showMessageDialog(vista5, "El numero ingresado es mayor a las unidades disponibles");
              }else{
                  cont=this.insumos.mp.getMateria_stock()-stock;
                  
              }
          }
        
        
        
        }
        
        
        
    }
            
    
    
}
