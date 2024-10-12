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


import modelo.RopaVDao;
import modelo.RopaVenta;

import vista.VistaRopaVenta;

/**
 *
 * @author hgust
 */
public class ControladorRopaVenta implements ActionListener {
    boolean flag=false;
    public RopaVDao da5=new RopaVDao();
    public RopaVenta rpv= new RopaVenta();
    public VistaRopaVenta vista5 = new VistaRopaVenta();
    DefaultTableModel modelito5=new DefaultTableModel();

    public ControladorRopaVenta(VistaRopaVenta visrpv) {
        this.vista5=visrpv;
        this.vista5.buscar.addActionListener(this);
        this.vista5.insertar.addActionListener( this);
        this.vista5.actualizar.addActionListener(this);
        this.vista5.eliminar.addActionListener( this);
        this.vista5.enviar.addActionListener( this);
        da5.listaCategoria(this.vista5.tcategoria);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista5.buscar){
            limpiarTabla();
            getListar(vista5.mitabla);
            JOptionPane.showMessageDialog(vista5, "Consulta exitosa");
        }
        if (ae.getSource()==vista5.insertar){
          if(!vista5.tid.getText().toString().isBlank()&&
             !vista5.tidventa.getText().toString().isBlank()&&
             !vista5.tnombre.getText().toString().isBlank()&&
             !vista5.tmarca.getText().toString().isBlank()&&
             !vista5.tdescripcion.getText().toString().isBlank()&&
             !vista5.tcolor.getText().toString().isBlank()&&
             !vista5.tcategoria.getSelectedItem().toString().isBlank()&&
             !vista5.tprecio.getText().toString().isBlank()&&
             !vista5.tstock.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
              limpiarTabla();
             getListar(vista5.mitabla);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista5,"Vamos");
          }
          
        }
        
        if(ae.getSource()==vista5.actualizar){
         flag=true;
         int fila=vista5.mitabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista5,"debe selecionar una fila");
            }else{
                int rp_id=Integer.parseInt(vista5.mitabla.getValueAt(fila, 0).toString());
                int rpv_id=Integer.parseInt(vista5.mitabla.getValueAt(fila, 1).toString());
                String rp_nombre=vista5.mitabla.getValueAt(fila, 2).toString();
                String rp_marca=vista5.mitabla.getValueAt(fila, 3).toString();
                String rp_descripcion=vista5.mitabla.getValueAt(fila, 4).toString();
                String rp_color=vista5.mitabla.getValueAt(fila, 5).toString();
                String rp_categoria=vista5.mitabla.getValueAt(fila, 6).toString();
                int rpv_precio=Integer.parseInt(vista5.mitabla.getValueAt(fila, 7).toString());
                int rpv_stock=Integer.parseInt(vista5.mitabla.getValueAt(fila,8).toString());
                
                
              vista5.tid.setText(""+rp_id);vista5.tid.setEditable(false);
              vista5.tidventa.setText(""+rpv_id);vista5.tidventa.setEditable(false);
              vista5.tnombre.setText(rp_nombre);
              vista5.tmarca.setText(rp_marca);
              vista5.tdescripcion.setText(rp_descripcion);
              vista5.tcolor.setText(rp_color);
              vista5.tcategoria.setSelectedItem(rp_categoria);
              vista5.tprecio.setText(""+rpv_precio);
              vista5.tstock.setText(""+rpv_stock);
              
              vista5.enviar.setEnabled(flag);
            }
        }
        
    
        if(ae.getSource()==vista5.eliminar){
            int fila = vista5.mitabla.getSelectedRow();
            if(!vista5.tid.getText().isBlank()){
                int rpv_id=Integer.parseInt(vista5.tid.getText().toString());
                setEliminar(rpv_id);
                limpiarTabla();
                getListar(vista5.mitabla);
            }
            
        }
        if(ae.getSource()==vista5.enviar && flag==true){
            int id=Integer.parseInt(vista5.tidventa.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vista5.mitabla);
            vista5.enviar.setEnabled(flag);
            vista5.tid.setEditable(true);
            vista5.tidventa.setEditable(true);
            
            
        }
    
    }
     public void getListar(JTable tabla){
        modelito5=(DefaultTableModel) tabla.getModel();
        List<RopaVenta>lista = da5.listar();
        Object[] object=new Object[9];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getRp_id();
            object[1]=lista.get(indice).getRpv_id();
            object[2]=lista.get(indice).getRp_nombre();
            object[3]=lista.get(indice).getRp_marca();
            object[4]=lista.get(indice).getRp_descripcion();
            object[5]=lista.get(indice).getRp_color();
            object[6]=lista.get(indice).getRp_categoria();
            object[7]=lista.get(indice).getRpv_precio();
            object[8]=lista.get(indice).getRpv_stock();
            
            modelito5.addRow(object);
        }
        vista5.mitabla.setModel(modelito5);
    }
    public void setAgregar(){
       int resultado;
       
       int rp_id=Integer.parseInt(vista5.tid.getText().toString());
       int rpv_id=Integer.parseInt(vista5.tidventa.getText().toString());
       String rp_nombre=vista5.tnombre.getText().toString();
       String rp_marca=vista5.tmarca.getText().toString();
       String rp_descripcion=vista5.tdescripcion.getText().toString();
       String rp_color=vista5.tcolor.getText().toString();
       String rp_categoria=vista5.tcategoria.getSelectedItem().toString();
       int rpv_precio=Integer.parseInt(vista5.tprecio.getText().toString());
       int rpv_stock=Integer.parseInt(vista5.tstock.getText().toString());
       
       rpv.setRp_id(rp_id);
       rpv.setRpv_id(rpv_id);
       rpv.setRp_nombre(rp_nombre);
       rpv.setRp_marca(rp_marca);
       rpv.setRp_descripcion(rp_descripcion);
       rpv.setRp_color(rp_color);
       rpv.setRp_categoria(rp_categoria);
       rpv.setRpv_precio(rpv_precio);
       rpv.setRpv_stock(rpv_stock);
      
       
       resultado=da5.setAgregar(rpv);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista5,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista5,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void setActualizar(int r_id){
       int resultado;
       
       int rp_id=Integer.parseInt(vista5.tid.getText().toString());
       int rpv_id=Integer.parseInt(vista5.tidventa.getText().toString());
       String rp_nombre=vista5.tnombre.getText().toString();
       String rp_marca=vista5.tmarca.getText().toString();
       String rp_descripcion=vista5.tdescripcion.getText().toString();
       String rp_color=vista5.tcolor.getText().toString();
       String rp_categoria=vista5.tcategoria.getSelectedItem().toString();
       int rpv_precio=Integer.parseInt(vista5.tprecio.getText().toString());
       int rpv_stock=Integer.parseInt(vista5.tstock.getText().toString());
       
       rpv.setRp_id(rp_id);
       rpv.setRpv_id(rpv_id);
       rpv.setRp_nombre(rp_nombre);
       rpv.setRp_marca(rp_marca);
       rpv.setRp_descripcion(rp_descripcion);
       rpv.setRp_color(rp_color);
       rpv.setRp_categoria(rp_categoria);
       rpv.setRpv_precio(rpv_precio);
      rpv.setRpv_stock(rpv_stock);
       
       resultado=da5.setActualizar(rpv);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista5,"Se actualizó correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista5,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     } 
    public void setEliminar(int r_id){
        int resultado;
        
        resultado=da5.setEliminar(r_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vista5,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vista5,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
      
       vista5.tid.setText("");
       vista5.tidventa.setText("");
       vista5.tnombre.setText("");
       vista5.tmarca.setText("");
       vista5.tdescripcion.setText("");
       vista5.tcolor.setText("");
       vista5.tcategoria.setSelectedItem("");
       vista5.tprecio.setText("");
       vista5.tstock.setText("");
        
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista5.mitabla.getRowCount();i++){
            modelito5.removeRow(i);
            i=i-1;
        }
    }
    
}



