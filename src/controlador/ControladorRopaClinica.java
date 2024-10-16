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
import modelo.RopaCDao;
import modelo.RopaClinica;
import modelo.RopaVDao;
import modelo.RopaVenta;
import vista.VistaRopaClinica;
import vista.VistaRopaVenta;

/**
 *
 * @author hgust
 */
public class ControladorRopaClinica implements ActionListener {
     boolean flag=false;
    public RopaCDao daClinica=new RopaCDao();
    public RopaClinica rpv= new RopaClinica();
    public VistaRopaClinica vistaclinica = new VistaRopaClinica();
    DefaultTableModel modelito5=new DefaultTableModel();

    
    public static String id_static;
    
    public ControladorRopaClinica(VistaRopaClinica visclinica) {
        this.vistaclinica=visclinica;
        this.vistaclinica.buscar.addActionListener(this);
        this.vistaclinica.insertar.addActionListener(this);
        this.vistaclinica.actualizar.addActionListener(this);
        this.vistaclinica.elminar.addActionListener(this);
        this.daClinica.listaCategoria(this.vistaclinica.ccategoria);
        this.daClinica.listaEstado(this.vistaclinica.cestado);
        this.daClinica.listaUsuario(this.vistaclinica.cusuario);
    }

    public ControladorRopaClinica() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vistaclinica.buscar){
            limpiarTabla();
            getListar(vistaclinica.mitabla);
            JOptionPane.showMessageDialog(vistaclinica, "Consulta exitosa");
        }
        if (ae.getSource()==vistaclinica.insertar){
          if(!vistaclinica.tid.getText().toString().isBlank()&&
             !vistaclinica.idiclinica.getText().toString().isBlank()&&
             !vistaclinica.tnombre.getText().toString().isBlank()&&
             !vistaclinica.tmarca.getText().toString().isBlank()&&
             !vistaclinica.tdescripcion.getText().toString().isBlank()&&
             !vistaclinica.tcolor.getText().toString().isBlank()&&
             !vistaclinica.ccategoria.getSelectedItem().toString().isBlank()&&
             !vistaclinica.cestado.getSelectedItem().toString().isBlank()&&
             !vistaclinica.tdano.getText().toString().isBlank()&&
             !vistaclinica.cusuario.getSelectedItem().toString().isBlank())
          {
              setAgregar();
              nuevo();
              limpiarTabla();
             getListar(vistaclinica.mitabla);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vistaclinica,"Vamos");
          }
          
        }
        
        if(ae.getSource()==vistaclinica.actualizar){
         flag=true;
         int fila=vistaclinica.mitabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vistaclinica,"debe selecionar una fila");
            }else{
                int rp_id=Integer.parseInt(vistaclinica.mitabla.getValueAt(fila, 0).toString());
                int rpc_id=Integer.parseInt(vistaclinica.mitabla.getValueAt(fila, 1).toString());
                String rp_nombre=vistaclinica.mitabla.getValueAt(fila, 2).toString();
                String rp_marca=vistaclinica.mitabla.getValueAt(fila, 3).toString();
                String rp_descripcion=vistaclinica.mitabla.getValueAt(fila, 4).toString();
                String rp_color=vistaclinica.mitabla.getValueAt(fila, 5).toString();
                String rp_categoria=vistaclinica.mitabla.getValueAt(fila, 6).toString();
                String rpc_estado=vistaclinica.mitabla.getValueAt(fila, 7).toString();
                String rpc_dano=vistaclinica.mitabla.getValueAt(fila, 8).toString();
                String rpc_usuario=vistaclinica.mitabla.getValueAt(fila, 9).toString();
                
                
              vistaclinica.tid.setText(""+rp_id);vistaclinica.tid.setEditable(false);
              vistaclinica.idiclinica.setText(""+rpc_id);vistaclinica.idiclinica.setEditable(false);
              vistaclinica.tnombre.setText(rp_nombre);
              vistaclinica.tmarca.setText(rp_marca);
              vistaclinica.tdescripcion.setText(rp_descripcion);
              vistaclinica.tcolor.setText(rp_color);
              vistaclinica.ccategoria.setSelectedItem(rp_categoria);
              vistaclinica.cestado.setSelectedItem(rpc_estado);
              vistaclinica.tdano.setText(rpc_dano);
              vistaclinica.cusuario.setSelectedItem(rpc_usuario);
              
              vistaclinica.enviar.setEnabled(flag);
            }
        }
        
    
        if(ae.getSource()==vistaclinica.elminar){
            int fila = vistaclinica.mitabla.getSelectedRow();
            if(!vistaclinica.tid.getText().isBlank()){
                int rpc_id=Integer.parseInt(vistaclinica.tid.getText().toString());
                setEliminar(rpc_id);
                limpiarTabla();
                getListar(vistaclinica.mitabla);
            }
            
        }
        if(ae.getSource()==vistaclinica.enviar && flag==true){
            int id=Integer.parseInt(vistaclinica.idiclinica.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vistaclinica.mitabla);
            vistaclinica.enviar.setEnabled(flag);
            vistaclinica.tid.setEditable(true);
            vistaclinica.idiclinica.setEditable(true);
            
            
        }
    
    }
     public void getListar(JTable tabla){
        modelito5=(DefaultTableModel) tabla.getModel();
        List<RopaClinica>lista = daClinica.listar();
        Object[] object=new Object[10];
        
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
            
            modelito5.addRow(object);
        }
        vistaclinica.mitabla.setModel(modelito5);
    }
    public void setAgregar(){
       int resultado;
       
       int rp_id=Integer.parseInt(vistaclinica.tid.getText().toString());
       int rpc_id=Integer.parseInt(vistaclinica.idiclinica.getText().toString());
       String rp_nombre=vistaclinica.tnombre.getText().toString();
       String rp_marca=vistaclinica.tmarca.getText().toString();
       String rp_descripcion=vistaclinica.tdescripcion.getText().toString();
       String rp_color=vistaclinica.tcolor.getText().toString();
       String rp_categoria=vistaclinica.ccategoria.getSelectedItem().toString();
       id_static = daClinica.obtenerIdPorNombre(rp_categoria);
       String rpc_estado=vistaclinica.cestado.getSelectedItem().toString();
       String rpc_dano=vistaclinica.tdano.getText().toString();
       String rpc_usuario=vistaclinica.cusuario.getSelectedItem().toString();
       
       rpv.setRp_id(rp_id);
       rpv.setRpc_id(rpc_id);
       rpv.setRp_nombre(rp_nombre);
       rpv.setRp_marca(rp_marca);
       rpv.setRp_descripcion(rp_descripcion);
       rpv.setRp_color(rp_color);
       rpv.setRp_categoria(id_static);
       rpv.setRpc_estado(rpc_estado);
       rpv.setRpc_dano(rpc_dano);
       rpv.setRpc_usuario(rpc_usuario);
       
      
       
       resultado=daClinica.setAgregar(rpv);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vistaclinica,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vistaclinica,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void setActualizar(int r_id){
       int resultado;
       
         int rp_id=Integer.parseInt(vistaclinica.tid.getText().toString());
       int rpc_id=Integer.parseInt(vistaclinica.idiclinica.getText().toString());
       String rp_nombre=vistaclinica.tnombre.getText().toString();
       String rp_marca=vistaclinica.tmarca.getText().toString();
       String rp_descripcion=vistaclinica.tdescripcion.getText().toString();
       String rp_color=vistaclinica.tcolor.getText().toString();
       String rp_categoria=vistaclinica.ccategoria.getSelectedItem().toString();
       String rpc_estado=vistaclinica.cestado.getSelectedItem().toString();
       String rpc_dano=vistaclinica.tdano.getText().toString();
       String rpc_usuario=vistaclinica.cusuario.getSelectedItem().toString();
       
       rpv.setRp_id(rp_id);
       rpv.setRpc_id(rpc_id);
       rpv.setRp_nombre(rp_nombre);
       rpv.setRp_marca(rp_marca);
       rpv.setRp_descripcion(rp_descripcion);
       rpv.setRp_color(rp_color);
       rpv.setRp_categoria(rp_categoria);
       rpv.setRpc_estado(rpc_estado);
       rpv.setRpc_dano(rpc_dano);
       rpv.setRpc_usuario(rpc_usuario);
       
       resultado=daClinica.setActualizar(rpv);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vistaclinica,"Se actualizó correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vistaclinica,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     } 
    public void setEliminar(int c_id){
        int resultado;
        
        resultado=daClinica.setEliminar(c_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vistaclinica,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vistaclinica,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
      
       vistaclinica.tid.setText("");
       vistaclinica.idiclinica.setText("");
       vistaclinica.tnombre.setText("");
       vistaclinica.tmarca.setText("");
       vistaclinica.tdescripcion.setText("");
       vistaclinica.tcolor.setText("");
       vistaclinica.ccategoria.setSelectedItem("");
       vistaclinica.cestado.setSelectedItem("");
       vistaclinica.tdano.setText("");
       vistaclinica.cusuario.setSelectedItem("");
        
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vistaclinica.mitabla.getRowCount();i++){
            modelito5.removeRow(i);
            i=i-1;
        }
    }
    
}
