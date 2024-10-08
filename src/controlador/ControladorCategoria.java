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
import modelo.Categoria;
import modelo.CategoriaDao;
import modelo.Rol;
import vista.VistaCategoria;


/**
 *
 * @author hgust
 */
public class ControladorCategoria implements ActionListener {
    boolean flag=false;
    public CategoriaDao da3=new CategoriaDao();
    public Categoria c= new Categoria();
    public VistaCategoria vista3 = new VistaCategoria();
    DefaultTableModel modelito2=new DefaultTableModel();

    public ControladorCategoria(VistaCategoria visc) {
        this.vista3=visc;
        this.vista3.buscar.addActionListener(this);
        this.vista3.insertar.addActionListener(this);
        this.vista3.actualizar.addActionListener(this);
        this.vista3.eliminar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista3.buscar){
//            limpiarTabla();
            getListar(vista3.mitabla);
            JOptionPane.showMessageDialog(vista3, "Consulta exitosa");
        }
        if (ae.getSource()==vista3.insertar){
          if(!vista3.tid.getText().toString().isBlank()&&
             !vista3.tnombre.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
//              limpiarTabla();
          getListar(vista3.mitabla);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista3,"Vamos");
          }
          
        }
        
        if(ae.getSource()==vista3.actualizar){
//         flag=true;
         int fila=vista3.mitabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista3,"debe selecionar una fila");
            }else{
                int c_id=Integer.parseInt(vista3.mitabla.getValueAt(fila, 0).toString());
                String c_nombre=vista3.mitabla.getValueAt(fila, 1).toString();
                
                
              vista3.tid.setText(""+c_id);vista3.tid.setEditable(false);
              vista3.tnombre.setText(c_nombre);
              
            }
        }
        if(ae.getSource()==vista3.eliminar){
            int fila = vista3.mitabla.getSelectedRow();
            if(!vista3.tid.getText().isBlank()){
                int c_id=Integer.parseInt(vista3.tid.getText().toString());
                setEliminar(c_id);
            }
            
        }
    }
    public void getListar(JTable tabla){
        modelito2=(DefaultTableModel) tabla.getModel();
        List<Categoria>lista = da3.listar();
        Object[] object=new Object[2];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getCategoria_id();
            object[1]=lista.get(indice).getCategoria_nombre();
            
            modelito2.addRow(object);
        }
        vista3.mitabla.setModel(modelito2);
    }
    public void setAgregar(){
       int resultado;
       
       int tid=Integer.parseInt(vista3.tid.getText().toString());
       String tnombre=vista3.tnombre.getText().toString();
       
       
       c.setCategoria_id(tid);
       c.setCategoria_nombre(tnombre);
       
       resultado=da3.setAgregar(c);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista3,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista3,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void setActualizar(int c_id){
       int resultado;
       
       int tid=Integer.parseInt(vista3.tid.getText().toString());
       String tnombre=vista3.tnombre.getText().toString();
       
       
       c.setCategoria_id(tid);
       c.setCategoria_nombre(tnombre);
       
       resultado=da3.setActualizar(c);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista3,"Se actualizó correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista3,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     } 
    public void setEliminar(int c_id){
        int resultado;
        
        resultado=da3.setEliminar(c_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vista3,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vista3,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
        vista3.tid.setText("");
        vista3.tnombre.setText("");
        
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista3.mitabla.getRowCount();i++){
            modelito2.removeRow(i);
            i=i-1;
        }
    }
    
}
