/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RopaVenta;
import modelo.Usuarios;
import modelo.UsuariosDao;
import modelo.Venta;
import modelo.VentaDao;
import vista.VistaUsuarios;
import vista.VistaVenta;

/**
 *
 * @author hgust
 */
public class ControladorVenta implements ActionListener{
    
     public VentaDao dao1=new VentaDao();
    public Venta ven= new Venta();
    public VistaVenta vista1 = new VistaVenta();
//    public RopaVenta rp = new RopaVenta();
//    DefaultTableModel modelito=new DefaultTableModel();

    public ControladorVenta(VistaVenta visvent) {
        this.vista1=visvent;
        this.vista1.enviar.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==vista1.enviar){
             int id_v=Integer.parseInt(vista1.tid.getText().toString());
             mostrarPrenda(id_v);
//             dao1.getPrenda(id_v);
         }
     }
    
    
    
    
    public void mostrarPrenda(int id) {
        
        RopaVenta rp= dao1.getPrenda(id);
        if(rp != null){
         vista1.lnombre.setText(rp.getRp_nombre());
        vista1.ldescri.setText(rp.getRp_descripcion());
        vista1.lpre.setText(""+rp.getRpv_precio());
        vista1.lstock.setText(""+rp.getRpv_stock());

        }else{
            JOptionPane.showMessageDialog(vista1,"No se encontró la prenda");
        }
        
        
        
   
    }
}

