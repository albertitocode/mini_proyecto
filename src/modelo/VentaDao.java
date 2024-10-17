/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.VistaVenta;

/**
 *
 * @author hgust
 */
public class VentaDao {
     Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    VistaVenta venta = new VistaVenta();
    
   public RopaVenta getPrenda(int id) {
    String sql = "SELECT rp_nombre, rp_descripcion, rpv_precio, rpv_stock FROM ropa_venta WHERE rpv_id=?";
   RopaVenta rpv=null;
    try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
        if (rs.next()) { 
          
            String nombre = rs.getString("rp_nombre");
            String descripcion = rs.getString("rp_descripcion");
            int precio = rs.getInt("rpv_precio");
            int stock = rs.getInt("rpv_stock");
            
            rpv=new RopaVenta();
            rpv.setRp_nombre(nombre);
            rpv.setRp_descripcion(descripcion);
            rpv.setRpv_precio(precio);
            rpv.setRpv_stock(stock);
//            venta.lnombre.setText(nombre);
//            venta.ldescri.setText(descripcion);
//            venta.lpre.setText(""+precio);
//            venta.lstock.setText(""+stock);
           
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
    }
    
    return rpv; 
   }
 }

