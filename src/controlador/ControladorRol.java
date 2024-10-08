/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Rol;
import modelo.RolDao;
import modelo.Usuarios;
import vista.VistaRol;
import vista.VistaUsuarios;


/**
 *
 * @author hgust
 */
public class ControladorRol implements ActionListener{
    boolean flag=false;
    public RolDao da2=new RolDao();
    public Rol r= new Rol();
    public VistaRol vista2 = new VistaRol();
    DefaultTableModel modelito1=new DefaultTableModel();
    
    public ControladorRol(VistaRol vist){
        this.vista2=vist;
        this.vista2.buscar.addActionListener(this);
        this.vista2.insertar.addActionListener(this);
        this.vista2.actualizar.addActionListener(this);
        this.vista2.eliminar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista2.buscar){
//            limpiarTabla();
            getListar(vista2.mitablita);
            JOptionPane.showMessageDialog(vista2, "Consulta exitosa");
        }
        if (ae.getSource()==vista2.insertar){
          if(!vista2.tid.getText().toString().isBlank()&&
             !vista2.tnombre.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
//              limpiarTabla();
          getListar(vista2.mitablita);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista2,"Vamos");
          }
          
        }
        if(ae.getSource()==vista2.actualizar){
//         flag=true;
         int fila=vista2.mitablita.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista2,"debe selecionar una fila");
            }else{
                int r_id=Integer.parseInt(vista2.mitablita.getValueAt(fila, 0).toString());
                String r_nombre=vista2.mitablita.getValueAt(fila, 1).toString();
                
                
              vista2.tid.setText(""+r_id);vista2.tid.setEditable(false);
              vista2.tnombre.setText(r_nombre);
              
            }
        }
        if(ae.getSource()==vista2.eliminar){
            int fila = vista2.mitablita.getSelectedRow();
            if(!vista2.tid.getText().isBlank()){
                int r_id=Integer.parseInt(vista2.tid.getText().toString());
                setEliminar(r_id);
            }
            
        }
        
    }
     public void getListar(JTable tabla){
        modelito1=(DefaultTableModel) tabla.getModel();
        List<Rol>lista = da2.listar();
        Object[] object=new Object[2];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getRol_id();
            object[1]=lista.get(indice).getRol_nombre();
            
            modelito1.addRow(object);
        }
        vista2.mitablita.setModel(modelito1);
    }
    public void setAgregar(){
       int resultado;
       
       int tid=Integer.parseInt(vista2.tid.getText().toString());
       String tnombre=vista2.tnombre.getText().toString();
       
       
       r.setRol_id(tid);
       r.setRol_nombre(tnombre);
       
       resultado=da2.setAgregar(r);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista2,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista2,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void setActualizar(int r_id){
       int resultado;
       
       int tid=Integer.parseInt(vista2.tid.getText().toString());
       String tnombre=vista2.tnombre.getText().toString();
       
       
       r.setRol_id(tid);
       r.setRol_nombre(tnombre);
       
       resultado=da2.setActualizar(r);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista2,"Se actualizó correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista2,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     } 
    public void setEliminar(int r_id){
        int resultado;
        
        resultado=da2.setEliminar(r_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vista2,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vista2,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
        vista2.tid.setText("");
        vista2.tnombre.setText("");
        
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista2.mitablita.getRowCount();i++){
            modelito1.removeRow(i);
            i=i-1;
        }
    }
}
