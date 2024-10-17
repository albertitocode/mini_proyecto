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
import modelo.Usuarios;
import modelo.UsuariosDao;
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
public class ControladorUs implements ActionListener{
    boolean flag=false;
    public UsuariosDao dao1=new UsuariosDao();
    public Usuarios us= new Usuarios();
    public VistaUsuarios vista1 = new VistaUsuarios();
    DefaultTableModel modelito=new DefaultTableModel();
    
    public ControladorUs(VistaUsuarios vis){
        this.vista1=vis;
        this.vista1.Ubuscar.addActionListener(this);
        this.vista1.Uinsertar.addActionListener(this);
        this.vista1.Uactualizar.addActionListener(this);
        this.vista1.Ueliminar.addActionListener(this);
        this.vista1.enviar.addActionListener(this);
        this.vista1.enviar.setEnabled(flag);
        dao1.listaRol(this.vista1.trol);
        this.vista1.btncerrar.addActionListener(this);
        this.vista1.btncategorias.addActionListener(this);
        this.vista1.btnclientes.addActionListener(this);
        this.vista1.btnestados.addActionListener(this);
        this.vista1.btnperfil.addActionListener(this);
        this.vista1.btnroles.addActionListener(this);
        this.vista1.btninicio.addActionListener(this);
        
    }

    public ControladorUs() {
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista1.Ubuscar){
            limpiarTabla();
            getListar(vista1.miTabla);
            JOptionPane.showMessageDialog(vista1, "Consulta exitosa");
            
        }
        if (ae.getSource()==vista1.Uinsertar){
          if(!vista1.Tid.getText().toString().isBlank()&&
             !vista1.TNombre.getText().toString().isBlank()&&
             !vista1.Tapellido.getText().toString().isBlank()&&
             !vista1.Tid_usuario.getText().toString().isBlank()&&
             !vista1.Tcorreo.getText().toString().isBlank()&&
             !vista1.Tcontraseña.getText().toString().isBlank()&&
             !vista1.Ttelefono.getText().toString().isBlank()&&
             !vista1.trol.getSelectedItem().toString().isBlank())
          {
              setAgregar();
              nuevo();
              limpiarTabla();
          getListar(vista1.miTabla);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista1,"Vamos");
          }
          
        }
        if(ae.getSource()==vista1.Uactualizar){
         flag=true;
         int fila=vista1.miTabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista1,"debe selecionar una fila");
            }else{
                int p_id=Integer.parseInt(vista1.miTabla.getValueAt(fila, 0).toString());
                String p_nombre=vista1.miTabla.getValueAt(fila, 1).toString();
                String p_apellido=vista1.miTabla.getValueAt(fila, 2).toString();
                int u_id=Integer.parseInt(vista1.miTabla.getValueAt(fila, 3).toString());
                String u_email=vista1.miTabla.getValueAt(fila, 4).toString();
                String u_contraseña=vista1.miTabla.getValueAt(fila, 5).toString();
                int u_telefono=Integer.parseInt(vista1.miTabla.getValueAt(fila, 6).toString());
                String rol=vista1.miTabla.getValueAt(fila, 7).toString();
                
              vista1.Tid.setText(""+p_id);vista1.Tid.setEditable(false);
              vista1.TNombre.setText(p_nombre);
              vista1.Tapellido.setText(p_apellido);
              vista1.TNombre.setText(p_nombre);
              vista1.Tid_usuario.setText(""+u_id);vista1.Tid_usuario.setEditable(false);
              vista1.Tcorreo.setText(u_email);
              vista1.Tcontraseña.setText(u_contraseña);
              vista1.Ttelefono.setText(""+u_telefono);
              vista1.trol.setSelectedItem(rol);
              
              vista1.enviar.setEnabled(flag);
            }
        }
        if(ae.getSource()==vista1.Ueliminar){
            int fila = vista1.miTabla.getSelectedRow();
            if(!vista1.Tid.getText().isBlank()){
                int p_id=Integer.parseInt(vista1.Tid.getText().toString());
                setEliminar(p_id);
                limpiarTabla();
            getListar(vista1.miTabla);
                
            }
            
        }
        if(ae.getSource()==vista1.enviar && flag==true){
            int id=Integer.parseInt(vista1.Tid.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vista1.miTabla);
            vista1.enviar.setEnabled(flag);
            vista1.Tid.setEditable(true);
            vista1.Tid_usuario.setEditable(true);
            
        }
          if(ae.getSource()==vista1.btninicio){
            VistaAdmin visadmin = new VistaAdmin();
                        ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
                        visadmin.setVisible(true);
                        visadmin.setSize(850,600);
                        visadmin.setLocation(300, 10);
                        vista1.dispose();
                        visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
          if(ae.getSource()==vista1.btncategorias){
             VistaCategoria ca = new VistaCategoria();
        ControladorCategoria con = new ControladorCategoria(ca);
        ca.setVisible(true);
        ca.setSize(850,600);
        ca.setLocation(300, 10);
          vista1.dispose();
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista1.btnclientes){
                  VistaClientes vclientes = new VistaClientes();
        ControladorClientes concli = new ControladorClientes(vclientes);
        vclientes.setVisible(true);
        vclientes.setSize(850,600);
        vclientes.setLocation(300, 10);
        vista1.dispose();
        vclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista1.btnestados){
            VistaEstado es = new VistaEstado();
            ControladorEstado con = new ControladorEstado(es);
            es.setVisible(true);
            es.setSize(850, 600);
            es.setLocation(300, 10);
            vista1.dispose();
            es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista1.btnperfil){
            JOptionPane.showMessageDialog(vista1,"Boton perfil en mantenimiento");
        }
        if(ae.getSource()==vista1.btnroles){
             VistaRol ro = new VistaRol();
        ControladorRol conrol = new ControladorRol(ro);
        ro.setVisible(true);
        ro.setSize(850,600);
        ro.setLocation(300, 10);
        vista1.dispose();
        ro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista1.btncerrar){
            if (ae.getSource()==vista1.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vista1.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }
    }
    
    

    public void getListar(JTable tabla){
        modelito=(DefaultTableModel) tabla.getModel();
        List<Usuarios>lista = dao1.listar();
        Object[] object=new Object[8];
        
        for(int indice=0;indice<lista.size();indice++){
            object[0]=lista.get(indice).getPersona_id();
            object[1]=lista.get(indice).getPersona_nombre();
            object[2]=lista.get(indice).getPersona_apellido();
            object[3]=lista.get(indice).getUsuario_id();
            object[4]=lista.get(indice).getUsuario_email();
            object[5]=lista.get(indice).getUsuario_contraseña();
            object[6]=lista.get(indice).getUsuario_telefono();
            object[7]=lista.get(indice).getRol();
            modelito.addRow(object);
        }
        vista1.miTabla.setModel(modelito);
    }
     public void setAgregar(){
       int resultado;
       
       int tid=Integer.parseInt(vista1.Tid.getText().toString());
       String tnombre=vista1.TNombre.getText().toString();
       String tapellido=vista1.Tapellido.getText().toString();
       int tid_us=Integer.parseInt(vista1.Tid_usuario.getText().toString());
       String tcorreo=vista1.Tcorreo.getText().toString();
       String tcontraseña=vista1.Tcontraseña.getText().toString();
       int telefono=Integer.parseInt(vista1.Ttelefono.getText().toString());
       String trol=vista1.trol.getSelectedItem().toString();
       
       us.setPersona_id(tid);
       us.setPersona_nombre(tnombre);
       us.setPersona_apellido(tapellido);
       us.setUsuario_id(tid_us);
       us.setUsuario_email(tcorreo);
       us.setUsuario_contraseña(tcontraseña);
       us.setUsuario_telefono(telefono);
       us.setRol(trol);
       
       resultado=dao1.setAgregar(us);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista1,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista1,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
     public void setActualizar(int per_id){
        int resultado;
        
       int tid=Integer.parseInt(vista1.Tid.getText().toString());
       String tnombre=vista1.TNombre.getText().toString();
       String tapellido=vista1.Tapellido.getText().toString();
       int tid_us=Integer.parseInt(vista1.Tid_usuario.getText().toString());
       String tcorreo=vista1.Tcorreo.getText().toString();
       String tcontraseña=vista1.Tcontraseña.getText().toString();
       int telefono=Integer.parseInt(vista1.Ttelefono.getText().toString());
       String trol=vista1.trol.getSelectedItem().toString();
       
       us.setPersona_id(tid);
       us.setPersona_nombre(tnombre);
       us.setPersona_apellido(tapellido);
       us.setUsuario_id(tid_us);
       us.setUsuario_email(tcorreo);
       us.setUsuario_contraseña(tcontraseña);
       us.setUsuario_telefono(telefono);
       us.setRol(trol);
       
       resultado=dao1.setActualizar(us);
       
       if(resultado==1){
           JOptionPane.showMessageDialog(vista1,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista1,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
    }
    public void setEliminar(int per_id){
        int resultado;
        
        resultado=dao1.setEliminar(per_id);
        if(resultado==1){
            JOptionPane.showMessageDialog(vista1,"Se eliminó correctamente");
        }else{
            JOptionPane.showMessageDialog(vista1,"Error 404 "+JOptionPane.ERROR_MESSAGE);
        }
                
    }
     public void nuevo(){
        vista1.Tid.setText("");
        vista1.TNombre.setText("");
        vista1.Tapellido.setText("");
        vista1.Tid_usuario.setText("");
        vista1.Tcorreo.setText("");
        vista1.Tcontraseña.setText("");
        vista1.Ttelefono.setText("");
        vista1.trol.setSelectedItem("");
        
        
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista1.miTabla.getRowCount();i++){
            modelito.removeRow(i);
            i=i-1;
        }
    }
}
