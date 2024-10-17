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
        this.vista2.enviar.addActionListener(this);
        this.vista2.enviar.setEnabled(flag);
        this.vista2.btncerrar.addActionListener(this);
        this.vista2.btnperfil.addActionListener(this);
         this.vista2.btncategorias.addActionListener(this);
        this.vista2.btnclientes.addActionListener(this);
        this.vista2.btnestados.addActionListener(this);
        this.vista2.btnperfil.addActionListener(this);
        this.vista2.btnusuarios.addActionListener(this);
        this.vista2.btninicio.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista2.buscar){
            limpiarTabla();
            getListar(vista2.mitablita);
            JOptionPane.showMessageDialog(vista2, "Consulta exitosa");
        }
        if (ae.getSource()==vista2.insertar){
          if(!vista2.tid.getText().toString().isBlank()&&
             !vista2.tnombre.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
              limpiarTabla();
          getListar(vista2.mitablita);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista2,"Vamos");
          }
          
        }
        if(ae.getSource()==vista2.actualizar){
         flag=true;
         int fila=vista2.mitablita.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista2,"debe selecionar una fila");
            }else{
                int r_id=Integer.parseInt(vista2.mitablita.getValueAt(fila, 0).toString());
                String r_nombre=vista2.mitablita.getValueAt(fila, 1).toString();
                
                
              vista2.tid.setText(""+r_id);vista2.tid.setEditable(false);
              vista2.tnombre.setText(r_nombre);
              
              vista2.enviar.setEnabled(flag);
              
            }
        }
        if(ae.getSource()==vista2.eliminar){
            int fila = vista2.mitablita.getSelectedRow();
            if(!vista2.tid.getText().isBlank()){
                int r_id=Integer.parseInt(vista2.tid.getText().toString());
                setEliminar(r_id);
                limpiarTabla();
                getListar(vista2.mitablita);
            }
            
        }
        if(ae.getSource()==vista2.enviar && flag==true){
            int id=Integer.parseInt(vista2.tid.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vista2.mitablita);
            vista2.enviar.setEnabled(flag);
            vista2.tid.setEditable(true);
            
            
        }
          if(ae.getSource()==vista2.btninicio){
            VistaAdmin visadmin = new VistaAdmin();
                        ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
                        visadmin.setVisible(true);
                        visadmin.setSize(850,600);
                        visadmin.setLocation(300, 10);
                        vista2.dispose();
                        visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (ae.getSource()==vista2.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vista2.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
         if(ae.getSource()==vista2.btncategorias){
             VistaCategoria ca = new VistaCategoria();
        ControladorCategoria con = new ControladorCategoria(ca);
        ca.setVisible(true);
        ca.setSize(850,600);
        ca.setLocation(300, 10);
         vista2.dispose();
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista2.btnclientes){
                VistaClientes vclientes = new VistaClientes();
        ControladorClientes concli = new ControladorClientes(vclientes);
        vclientes.setVisible(true);
        vclientes.setSize(850,600);
        vclientes.setLocation(300, 10);
        vista2.dispose();
        vclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista2.btnestados){
            VistaEstado es = new VistaEstado();
            ControladorEstado con = new ControladorEstado(es);
            es.setVisible(true);
            es.setSize(850, 600);
            es.setLocation(300, 10);
            vista2.dispose();
            es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista2.btnperfil){
            JOptionPane.showMessageDialog(vista2,"Boton perfil en mantenimiento");
        }
      
        if(ae.getSource()==vista2.btnusuarios){
              VistaUsuarios vis = new VistaUsuarios();
            ControladorUs conusu = new ControladorUs(vis);
            
            vis.setVisible(true);
            vis.setSize(850, 600);
            vis.setLocation(300, 10);
            vista2.dispose();
            vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
