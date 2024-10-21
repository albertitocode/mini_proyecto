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
import modelo.MateriaDao;
import modelo.MateriaPrima;
import modelo.Rol;
import vista.VistaLogin;

import vista.VistaMateria;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;


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

    public ControladorMp() {
    }
    
    
    
    public ControladorMp(VistaMateria vism) {
        this.vista4=vism;
        this.vista4.buscar.addActionListener(this);
        this.vista4.insertar.addActionListener(this);
        this.vista4.actualizar.addActionListener(this);
        this.vista4.eliminar.addActionListener(this);
        this.vista4.enviar.addActionListener(this);
        this.vista4.enviar.setEnabled(flag);
        this.vista4.btncerrar.addActionListener(this);
        this.vista4.btnInicio.addActionListener(this);
        this.vista4.btnTrabajadores.addActionListener(this);
     this.vista4.btnRopaReparacion.addActionListener(this);
        
//        this.vista4.btnperfil.addActionListener(this);
    }
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista4.buscar){
            limpiarTabla();
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
              limpiarTabla();
          getListar(vista4.mitablita);
          
          
//              JOptionPane.showMessageDialog(vista,"Vamos bien");
          }else{
              JOptionPane.showMessageDialog(vista4,"Vamos");
          }
          
        }
        if(ae.getSource()==vista4.actualizar){
         flag=true;
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
              
              vista4.enviar.setEnabled(flag);
            }
        }
        if(ae.getSource()==vista4.eliminar){
            int fila = vista4.mitablita.getSelectedRow();
            if(!vista4.tid.getText().isBlank()){
                int mp_id=Integer.parseInt(vista4.tid.getText().toString());
                setEliminar(mp_id);
                limpiarTabla();
                getListar(vista4.mitablita);
            }
            
        }
        if(ae.getSource()==vista4.enviar && flag==true){
            int id=Integer.parseInt(vista4.tid.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vista4.mitablita);
            vista4.enviar.setEnabled(flag);
            vista4.tid.setEditable(true);
            
            
        }
        
            if (ae.getSource()==vista4.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(869, 588);
            log.setLocation(300, 10);
            vista4.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
       
            if (ae.getSource()==vista4.btnInicio){
                VistaSupervisor visasuper = new VistaSupervisor();
                ControladorSupervisor conesuper = new ControladorSupervisor(visasuper);
                visasuper.setVisible(true);
                visasuper.setSize(869, 588);
                visasuper.setLocation(300, 10);
                vista4.dispose();
                visasuper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
         if (ae.getSource()==vista4.btnTrabajadores){
              
        }
        if (ae.getSource()==vista4.btnRopaReparacion){
             VistaRopaVenta ropv = new VistaRopaVenta();
            ControladorRopaVenta con = new ControladorRopaVenta(ropv);
            ropv.setVisible(true);
            ropv.setSize(869, 588);
            ropv.setLocation(300, 10);
            vista4.dispose();
            ropv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
