/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Estado;
import modelo.RopaCDao;
import modelo.RopaClinica;
import modelo.RopaVDao;
import modelo.RopaVenta;
import modelo.Usuarios;
import vista.VistaLogin;
import vista.VistaMateria;

import vista.VistaRopaClinica;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;

/**
 *
 * @author hgust
 */
public class ControladorRopaClinica implements ActionListener {
     boolean flag=false;
    public RopaCDao daClinica=new RopaCDao();
    public RopaClinica rpc= new RopaClinica();
    public VistaRopaClinica vistaclinica = new VistaRopaClinica();
    DefaultTableModel modelito5=new DefaultTableModel();

    
    public ControladorCategoria contcategoria= new ControladorCategoria();
    public ControladorUs contusu= new ControladorUs();
    public ControladorEstado contest=new ControladorEstado();
    
    public ControladorRopaClinica(VistaRopaClinica visclinica) {
        this.vistaclinica=visclinica;
        this.vistaclinica.buscar.addActionListener(this);
        this.vistaclinica.insertar.addActionListener(this);
        this.vistaclinica.actualizar.addActionListener(this);
        this.vistaclinica.elminar.addActionListener(this);
        this.vistaclinica.enviar.addActionListener(this);
        this.vistaclinica.enviar.setEnabled(flag);
        this.vistaclinica.btncerrar.addActionListener(this);
        this.vistaclinica.btnInicio.addActionListener(this);
        this.vistaclinica.btnTrabajadores.addActionListener(this);
        this.vistaclinica.btnInsumos.addActionListener(this);
        categorias();
        estados();
        usuarios();
    }

    public ControladorRopaClinica() {
    }
    public void categorias(){
        ArrayList<Categoria> cate = (ArrayList<Categoria>) this.contcategoria.da3.listar();
        for (Categoria categoria : cate) {
             vistaclinica.ccategoria.addItem(categoria.toString());
        }
    } 
    public void estados(){///ARREGLAR
        ArrayList<Estado> est = (ArrayList<Estado>) this.contest.daestado.listar();
        for (Estado estado : est) {
             vistaclinica.cestado.addItem(estado.toString());
        }
    } 
    public void usuarios(){
        ArrayList<Usuarios> usu = (ArrayList<Usuarios>) this.contusu.dao1.listar();
        for (Usuarios usuario : usu) {
             vistaclinica.cusuario.addItem(usuario.toString());
        }
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
             !vistaclinica.cusuario.getSelectedItem().toString().isBlank()&&
             !vistaclinica.tcliente.getText().toString().isBlank())
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
                int rpc_cliente=Integer.parseInt(vistaclinica.mitabla.getValueAt(fila, 1).toString());
                
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
              vistaclinica.tcliente.setText(""+rpc_cliente);
              
              vistaclinica.enviar.setEnabled(flag);
            }
        }
        
    
        if(ae.getSource()==vistaclinica.elminar){
            int fila = vistaclinica.mitabla.getSelectedRow();
            if(!vistaclinica.idiclinica.getText().isBlank()){
                int rpc_id=Integer.parseInt(vistaclinica.idiclinica.getText().toString());
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
        
            if (ae.getSource()==vistaclinica.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(869, 588);
            log.setLocation(300, 10);
            vistaclinica.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        if (ae.getSource()==vistaclinica.btnInicio){
                VistaSupervisor visasuper = new VistaSupervisor();
                ControladorSupervisor conesuper = new ControladorSupervisor(visasuper);
                visasuper.setVisible(true);
                visasuper.setSize(869, 588);
                visasuper.setLocation(300, 10);
                vistaclinica.dispose();
                visasuper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
         if (ae.getSource()==vistaclinica.btnTrabajadores){
              
        }
         if (ae.getSource()==vistaclinica.btnInsumos){
                VistaMateria vismate = new VistaMateria();
                ControladorMp conesuper = new ControladorMp(vismate);
                vismate.setVisible(true);
                vismate.setSize(869, 588);
                vismate.setLocation(300, 10);
                vistaclinica.dispose();
                vismate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
     public void getListar(JTable tabla){
        modelito5=(DefaultTableModel) tabla.getModel();
        List<RopaClinica>lista = daClinica.listar();
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
       String rpc_estado=vistaclinica.cestado.getSelectedItem().toString();
       String rpc_dano=vistaclinica.tdano.getText().toString();
       String rpc_usuario=vistaclinica.cusuario.getSelectedItem().toString();
       int rpc_cliente=Integer.parseInt(vistaclinica.tcliente.getText().toString());
       
       rpc.setRp_id(rp_id);
       rpc.setRpc_id(rpc_id);
       rpc.setRp_nombre(rp_nombre);
       rpc.setRp_marca(rp_marca);
       rpc.setRp_descripcion(rp_descripcion);
       rpc.setRp_color(rp_color);
       rpc.setRp_categoria(rp_categoria);
       rpc.setRpc_estado(rpc_estado);
       rpc.setRpc_dano(rpc_dano);
       rpc.setRpc_usuario(rpc_usuario);
       rpc.setRpc_cliente(rpc_cliente);
       
      int cate=daClinica.idcategoria(rp_categoria);
      int est=daClinica.idestado(rpc_estado);
      int usu=daClinica.idUsuario(rpc_usuario);
       resultado=daClinica.setAgregarr(rpc,cate,est,usu);
       
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
       int rpc_cliente=Integer.parseInt(vistaclinica.tcliente.getText().toString());
       
       rpc.setRp_id(rp_id);
       rpc.setRpc_id(rpc_id);
       rpc.setRp_nombre(rp_nombre);
       rpc.setRp_marca(rp_marca);
       rpc.setRp_descripcion(rp_descripcion);
       rpc.setRp_color(rp_color);
       rpc.setRp_categoria(rp_categoria);
       rpc.setRpc_estado(rpc_estado);
       rpc.setRpc_dano(rpc_dano);
       rpc.setRpc_usuario(rpc_usuario);
       rpc.setRpc_cliente(rpc_cliente);
       
       int cate=daClinica.idcategoria(rp_categoria);
       int est=daClinica.idestado(rpc_estado);
       int usu=daClinica.idUsuario(rpc_usuario);
       resultado=daClinica.setActualizarr(rpc,cate,est,usu);
       
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
       vistaclinica.tcliente.setText("");
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vistaclinica.mitabla.getRowCount();i++){
            modelito5.removeRow(i);
            i=i-1;
        }
    }
    
}
