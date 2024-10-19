/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MateriaPrima;
import modelo.RopaClinica;
import modelo.TecnicoDao;
import modelo.Usuarios;
import vista.VistaLogin;
import vista.VistaTecnico;

/**
 *
 * @author hgust
 */
public class ControladorTecnico implements ActionListener{
    
    ControladorRopaVenta crpv = new ControladorRopaVenta();
    ControladorMp insumos = new ControladorMp();
    VistaTecnico vista5 = new VistaTecnico();
    TecnicoDao daot = new TecnicoDao();
    DefaultTableModel modelito=new DefaultTableModel();
    ControladorUs usu = new ControladorUs();
    ControladorRopaClinica rpc= new ControladorRopaClinica();
    ControladorLogin cont=new ControladorLogin();
    String corre;
    public ControladorTecnico(VistaTecnico visT) {
        this.vista5=visT;
        this.vista5.miScroll.setVisible(false);
//        this.vista5.mitabla.setVisible(false);
        this.vista5.enviar.addActionListener(this);
        this.vista5.tareas.addActionListener(this);
        this.vista5.btnOcultar.addActionListener(this);
        this.vista5.btnIniciar.addActionListener(this);
        this.vista5.btnFinalizar.addActionListener(this);
        this.insumos.da4.listaInsumos(this.vista5.jinsumo);
        String nombre=this.cont.vista3.tcorreo.getText();
        this.vista5.btncerrar.addActionListener(this);
       
        
    }

    public ControladorTecnico() {
    }
    

       public void mostrarCorreo(String correo) {
        vista5.setCorreo(correo); // Método para establecer el correo en la vista
        vista5.setVisible(true);
        vista5.lnombre.setText(correo);
        corre=this.vista5.lnombre.getText(); 
    }
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista5.enviar){
           validar();
            
        }
        if(ae.getSource()==vista5.tareas){
        this.vista5.miScroll.setVisible(true);
//         this.vista5.mitabla.setVisible(true);
         limpiarTabla();
         getListar(this.vista5.mitabla);
        }
         if(ae.getSource()==vista5.btnOcultar){
        this.vista5.miScroll.setVisible(false);
//         this.vista5.mitabla.setVisible(true);
        
        }
        if(ae.getSource()==vista5.btnIniciar){
         int fila=vista5.mitabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista5,"debe selecionar una fila");
            }else{
                int r_id=Integer.parseInt(vista5.mitabla.getValueAt(fila, 0).toString());
                int id=r_id;
                daot.Iniciar(id);
//                nuevo();
                limpiarTabla();
                getListar(vista5.mitabla);
            }
        }
                if(ae.getSource()==vista5.btnFinalizar){
         int fila=vista5.mitabla.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(vista5,"debe selecionar una fila");
            }else{
                int r_id=Integer.parseInt(vista5.mitabla.getValueAt(fila, 0).toString());
                int id=r_id;
                daot.Finalizar(id);
//                nuevo();
                limpiarTabla();
                getListar(vista5.mitabla);
            }
        }
         if(ae.getSource()==vista5.btncerrar){
            if (ae.getSource()==vista5.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vista5.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }
    }
//    public void setActualizar(int r_id){
//       int resultado;
//       
//       int tid=Integer.parseInt(vista2.tid.getText().toString());
//       String tnombre=vista2.tnombre.getText().toString();
//       
//       rh.
//       r.setRol_id(tid);
//       r.setRol_nombre(tnombre);
//       
//       resultado=da2.setActualizar(r);
//       
//       if(resultado==1){
//           JOptionPane.showMessageDialog(vista2,"Se actualizó correctamente");
//       }else{
//           if(resultado==0){
//           JOptionPane.showMessageDialog(vista2,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
//           }
//       }
//     } 
    public void getListar(JTable tabla){
        
        if (corre == null || corre.isEmpty()) {
    JOptionPane.showMessageDialog(null, "El correo no está definido.");
    return; 
       }else{
        modelito=(DefaultTableModel) tabla.getModel();
        List<RopaClinica>lista = daot.listar(corre);
        Object[] object=new Object[9];
        
        for(int indice=0;indice<lista.size();indice++){
            
            object[0]=lista.get(indice).getRpc_id();
            object[1]=lista.get(indice).getRp_nombre();
            object[2]=lista.get(indice).getRp_marca();
            object[3]=lista.get(indice).getRp_descripcion();
            object[4]=lista.get(indice).getRp_color();
            object[5]=lista.get(indice).getRp_categoria();
            object[6]=lista.get(indice).getRpc_estado();
            object[7]=lista.get(indice).getRpc_dano();
            object[8]=lista.get(indice).getRpc_usuario();
            
            modelito.addRow(object);
        }
        vista5.mitabla.setModel(modelito);
    }
    }
    public void limpiarTabla(){
        for(int i=0;i<vista5.mitabla.getRowCount();i++){
            modelito.removeRow(i);
            i=i-1;
        }
    }
    public void validar(){
        String materia_nombre=(String) this.vista5.jinsumo.getSelectedItem();
        int stock=Integer.parseInt(this.vista5.tunidades.getText());
       
        if(stock>0){
        this.insumos.mp = this.daot.mate(materia_nombre);
        
          if(this.insumos.mp.getMateria_nombre()!=null && this.insumos.mp.getMateria_stock()>0){
              if(stock>this.insumos.mp.getMateria_stock()){
                    JOptionPane.showMessageDialog(vista5, "El numero ingresado es mayor a las unidades disponibles");
              }else{
                 int  c=this.insumos.mp.getMateria_stock()-stock;
                  this.insumos.mp.setMateria_stock(c);
                  daot.modificar(this.insumos.mp);
                   JOptionPane.showMessageDialog(vista5, "Breve menor"+this.insumos.mp.getMateria_stock());
                   
              }
          }
        
        
        
        }
        
        
        
    }
            
    
    
}
