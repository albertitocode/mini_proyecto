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
import modelo.Estado;
import modelo.EstadoDao;
import modelo.Rol;
import modelo.RolDao;
import vista.VistaAdmin;
import vista.VistaCategoria;
import vista.VistaClientes;
import vista.VistaEstado;
import vista.VistaLogin;
import vista.VistaRol;
import vista.VistaUsuarios;

/**
 *
 * @author hgust
 */
public class ControladorEstado implements ActionListener{
     boolean flag=false;
    public EstadoDao daestado=new EstadoDao();
    public Estado es= new Estado();
    public VistaEstado vistaes = new VistaEstado();
    DefaultTableModel modelito1=new DefaultTableModel();

    public ControladorEstado(VistaEstado visest) {
        this.vistaes=visest;
        this.vistaes.buscar.addActionListener(this);
        this.vistaes.insertar.addActionListener(this);
        this.vistaes.actualizar.addActionListener(this);
        this.vistaes.eliminar.addActionListener(this);
        this.vistaes.enviar.addActionListener(this);
        this.vistaes.enviar.setEnabled(flag);
        this.vistaes.btncerrar.addActionListener(this);
           this.vistaes.btncategorias.addActionListener(this);
        this.vistaes.btnclientes.addActionListener(this);
     this.vistaes.btninicio.addActionListener(this);
        this.vistaes.btnperfil.addActionListener(this);
        this.vistaes.btnroles.addActionListener(this);
        this.vistaes.btnusuarios.addActionListener(this);
    }

    public ControladorEstado() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vistaes.buscar){
            limpiarTabla();
            getListar(vistaes.mitablita);
            JOptionPane.showMessageDialog(vistaes, "Consulta exitosa");
        }
        if (ae.getSource()==vistaes.insertar){
          if(!vistaes.tid.getText().toString().isBlank()&&
             !vistaes.tnombre.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
              limpiarTabla();
          getListar(vistaes.mitablita);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vistaes,"Vamos");
          }
          
        }
        if(ae.getSource()==vistaes.actualizar){
         flag=true;
         int fila=vistaes.mitablita.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vistaes,"debe selecionar una fila");
            }else{
                int es_id=Integer.parseInt(vistaes.mitablita.getValueAt(fila, 0).toString());
                String es_nombre=vistaes.mitablita.getValueAt(fila, 1).toString();
                
                
              vistaes.tid.setText(""+es_id);vistaes.tid.setEditable(false);
              vistaes.tnombre.setText(es_nombre);
              
              vistaes.enviar.setEnabled(flag);
              
            }
        }
        if(ae.getSource()==vistaes.eliminar){
            int fila = vistaes.mitablita.getSelectedRow();
            if(!vistaes.tid.getText().isBlank()){
                int es_id=Integer.parseInt(vistaes.tid.getText().toString());
                setEliminar(es_id);
                limpiarTabla();
                getListar(vistaes.mitablita);
            }
            
        }
        if(ae.getSource()==vistaes.enviar && flag==true){
            int id=Integer.parseInt(vistaes.tid.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vistaes.mitablita);
            vistaes.enviar.setEnabled(flag);
            vistaes.tid.setEditable(true);
            
            
        }
        if(ae.getSource()==vistaes.btninicio){
            VistaAdmin visadmin = new VistaAdmin();
                        ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
                        visadmin.setVisible(true);
                        visadmin.setSize(850,600);
                        visadmin.setLocation(300, 10);
                        vistaes.dispose();
                        visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vistaes.btncerrar){
            if (ae.getSource()==vistaes.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vistaes.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }
         if(ae.getSource()==vistaes.btncategorias){
             VistaCategoria ca = new VistaCategoria();
        ControladorCategoria con = new ControladorCategoria(ca);
        ca.setVisible(true);
        ca.setSize(850,600);
        ca.setLocation(300, 10);
        vistaes.dispose();
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vistaes.btnclientes){
            VistaClientes vclientes = new VistaClientes();
            ControladorClientes concli = new ControladorClientes(vclientes);
            vclientes.setVisible(true);
            vclientes.setSize(850, 600);
            vclientes.setLocation(300, 10);
            vistaes.dispose();
            vclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        if(ae.getSource()==vistaes.btnperfil){
            JOptionPane.showMessageDialog(vistaes,"Boton perfil en mantenimiento");
        }
        if(ae.getSource()==vistaes.btnroles){
             VistaRol ro = new VistaRol();
        ControladorRol conrol = new ControladorRol(ro);
        ro.setVisible(true);
        ro.setSize(850,600);
        ro.setLocation(300, 10);
        vistaes.dispose();
        ro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vistaes.btnusuarios){
              VistaUsuarios vis = new VistaUsuarios();
            ControladorUs conusu = new ControladorUs(vis);
            
            vis.setVisible(true);
            vis.setSize(850, 600);
            vis.setLocation(300, 10);
            vistaes.dispose();
            vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void getListar(JTable tabla){
        modelito1=(DefaultTableModel) tabla.getModel();
        List<Estado>lista = daestado.listar();
        Object[] object=new Object[2];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getEstado_id();
            object[1]=lista.get(indice).getEstado_nombre();
            
            modelito1.addRow(object);
        }
        vistaes.mitablita.setModel(modelito1);
    }
    public void setAgregar(){
       int resultado;
       
       int tid=Integer.parseInt(vistaes.tid.getText().toString());
       String tnombre=vistaes.tnombre.getText().toString();
       
       
       es.setEstado_id(tid);
       es.setEstado_nombre(tnombre);
       
       resultado=daestado.setAgregar(es);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vistaes,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vistaes,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void setActualizar(int r_id){
       int resultado;
       
       int tid=Integer.parseInt(vistaes.tid.getText().toString());
       String tnombre=vistaes.tnombre.getText().toString();
       
       
       es.setEstado_id(tid);
       es.setEstado_nombre(tnombre);
       
       resultado=daestado.setActualizar(es);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vistaes,"Se actualizó correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vistaes,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     } 
    public void setEliminar(int es_id){
        int resultado;
        
        resultado=daestado.setEliminar(es_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vistaes,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vistaes,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
        vistaes.tid.setText("");
        vistaes.tnombre.setText("");
        
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vistaes.mitablita.getRowCount();i++){
            modelito1.removeRow(i);
            i=i-1;
        }
    }
}
