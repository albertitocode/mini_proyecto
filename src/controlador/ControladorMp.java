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
import modelo.MateriaDao;
import modelo.MateriaPrima;
import modelo.Rol;

import vista.VistaMateria;


/**
 *
 * @author hgust
 */
public class ControladorMp implements ActionListener {
     boolean flag=false;
    public MateriaDao da4=new MateriaDao();
    public MateriaPrima mp= new MateriaPrima();
    public VistaMateria vista4 = new VistaMateria();
    DefaultTableModel modelito4=new DefaultTableModel();

    public ControladorMp(VistaMateria vism) {
        this.vista4=vism;
        this.vista4.buscar.addActionListener(this);
        this.vista4.insertar.addActionListener(this);
        this.vista4.actualizar.addActionListener(this);
        this.vista4.eliminar.addActionListener(this);
    }
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista4.buscar){
//            limpiarTabla();
            getListar(vista4.mitablita);
            JOptionPane.showMessageDialog(vista4, "Consulta exitosa");
        }
        if (ae.getSource()==vista4.insertar){
          if(!vista4.tid.getText().toString().isBlank()&&
             !vista4.tnombre.getText().toString().isBlank()&&
             !vista4.tstock.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
//              limpiarTabla();
          getListar(vista4.mitablita);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista4,"Vamos");
          }
          
        }
        if(ae.getSource()==vista4.actualizar){
//         flag=true;
         int fila=vista4.mitablita.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista4,"debe selecionar una fila");
            }else{
                int mp_id=Integer.parseInt(vista4.mitablita.getValueAt(fila, 0).toString());
                String mp_nombre=vista4.mitablita.getValueAt(fila, 1).toString();
                int mp_stock=Integer.parseInt(vista4.mitablita.getValueAt(fila, 2).toString());
                
              vista4.tid.setText(""+mp_id);vista4.tid.setEditable(false);
              vista4.tnombre.setText(mp_nombre);
              vista4.tstock.setText(""+mp_stock);
              
            }
        }
        if(ae.getSource()==vista4.eliminar){
            int fila = vista4.mitablita.getSelectedRow();
            if(!vista4.tid.getText().isBlank()){
                int mp_id=Integer.parseInt(vista4.tid.getText().toString());
                setEliminar(mp_id);
            }
            
        }
        
    }
    
    public void getListar(JTable tabla){
        modelito4=(DefaultTableModel) tabla.getModel();
        List<MateriaPrima>lista = da4.listar();
        Object[] object=new Object[3];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getMateria_id();
            object[1]=lista.get(indice).getMateria_nombre();
            object[2]=lista.get(indice).getMateria_stock();
            
            modelito4.addRow(object);
        }
        vista4.mitablita.setModel(modelito4);
    }
    public void setAgregar(){
       int resultado;
       
       int tid=Integer.parseInt(vista4.tid.getText().toString());
       String tnombre=vista4.tnombre.getText().toString();
       int tstock=Integer.parseInt(vista4.tstock.getText().toString());
       
       mp.setMateria_id(tid);
       mp.setMateria_nombre(tnombre);
       mp.setMateria_stock(tstock);
       
       resultado=da4.setAgregar(mp);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista4,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista4,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void setActualizar(int mp_id){
       int resultado;
       
       int tid=Integer.parseInt(vista4.tid.getText().toString());
       String tnombre=vista4.tnombre.getText().toString();
       int tstock=Integer.parseInt(vista4.tstock.getText().toString());
       
       
       mp.setMateria_id(tid);
       mp.setMateria_nombre(tnombre);
       mp.setMateria_stock(tstock);
       
       resultado=da4.setActualizar(mp);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista4,"Se actualizó correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista4,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     } 
    public void setEliminar(int mp_id){
        int resultado;
        
        resultado=da4.setEliminar(mp_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vista4,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vista4,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
        vista4.tid.setText("");
        vista4.tnombre.setText("");
        vista4.tstock.setText("");
        
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista4.mitablita.getRowCount();i++){
            modelito4.removeRow(i);
            i=i-1;
        }
    }
    
    
}
