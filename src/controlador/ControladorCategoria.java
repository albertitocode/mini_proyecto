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
import modelo.Categoria;
import modelo.CategoriaDao;
import modelo.Rol;
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
public class ControladorCategoria implements ActionListener {
    boolean flag=false;
    public CategoriaDao da3=new CategoriaDao();
    public Categoria c= new Categoria();
    public VistaCategoria vista3 = new VistaCategoria();
    DefaultTableModel modelito2=new DefaultTableModel();

    public ControladorCategoria() {
    }

    
    public ControladorCategoria(VistaCategoria visc) {
        this.vista3=visc;
        this.vista3.buscar.addActionListener(this);
        this.vista3.insertar.addActionListener(this);
        this.vista3.actualizar.addActionListener(this);
        this.vista3.eliminar.addActionListener(this);
        this.vista3.enviar.addActionListener(this);
        this.vista3.enviar.setEnabled(flag);
        this.vista3.btncerrar.addActionListener(this);
       this.vista3.btnclientes.addActionListener(this);
        this.vista3.btnestados.addActionListener(this);
        this.vista3.btnperfil.addActionListener(this);
        this.vista3.btnroles.addActionListener(this);
        this.vista3.btnusuarios.addActionListener(this);
        this.vista3.btninicio.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista3.buscar){
            limpiarTabla();
            getListar(vista3.mitabla);
            JOptionPane.showMessageDialog(vista3, "Consulta exitosa");
        }
        if (ae.getSource()==vista3.insertar){
          if(!vista3.tid.getText().toString().isBlank()&&
             !vista3.tnombre.getText().toString().isBlank())
          {
              setAgregar();
              nuevo();
              limpiarTabla();
          getListar(vista3.mitabla);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista3,"Vamos");
          }
          
        }
        
        if(ae.getSource()==vista3.actualizar){
         flag=true;
         int fila=vista3.mitabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista3,"debe selecionar una fila");
            }else{
                int c_id=Integer.parseInt(vista3.mitabla.getValueAt(fila, 0).toString());
                String c_nombre=vista3.mitabla.getValueAt(fila, 1).toString();
                
                
              vista3.tid.setText(""+c_id);vista3.tid.setEditable(false);
              vista3.tnombre.setText(c_nombre);
              
              vista3.enviar.setEnabled(flag);
            }
        }
        if(ae.getSource()==vista3.eliminar){
            int fila = vista3.mitabla.getSelectedRow();
            if(!vista3.tid.getText().isBlank()){
                int c_id=Integer.parseInt(vista3.tid.getText().toString());
                setEliminar(c_id);
                limpiarTabla();
                getListar(vista3.mitabla);
            }
            
        }
        if(ae.getSource()==vista3.enviar && flag==true){
            int id=Integer.parseInt(vista3.tid.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vista3.mitabla);
            vista3.enviar.setEnabled(flag);
            vista3.tid.setEditable(true);
            
            
        }
          if(ae.getSource()==vista3.btninicio){
            VistaAdmin visadmin = new VistaAdmin();
                        ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
                        visadmin.setVisible(true);
                        visadmin.setSize(850,600);
                        visadmin.setLocation(300, 10);
                        vista3.dispose();
                        visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista3.btncerrar){
            if (ae.getSource()==vista3.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vista3.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
         if(ae.getSource()==vista3.btnclientes){
              VistaClientes vclientes = new VistaClientes();
             ControladorClientes concli = new ControladorClientes(vclientes);
             vclientes.setVisible(true);
             vclientes.setSize(850, 600);
             vclientes.setLocation(300, 10);
             vista3.dispose();
             vclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista3.btnestados){
            VistaEstado es = new VistaEstado();
            ControladorEstado con = new ControladorEstado(es);
            es.setVisible(true);
            es.setSize(850, 600);
            es.setLocation(300, 10);
            vista3.dispose();
            es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista3.btnperfil){
            JOptionPane.showMessageDialog(vista3,"Boton perfil en mantenimiento");
        }
        if(ae.getSource()==vista3.btnroles){
             VistaRol ro = new VistaRol();
        ControladorRol conrol = new ControladorRol(ro);
        ro.setVisible(true);
        ro.setSize(850,600);
        ro.setLocation(300, 10);
        vista3.dispose();
        ro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==vista3.btnusuarios){
              VistaUsuarios vis = new VistaUsuarios();
            ControladorUs conusu = new ControladorUs(vis);
            
            vis.setVisible(true);
            vis.setSize(850, 600);
            vis.setLocation(300, 10);
            vista3.dispose();
            vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
