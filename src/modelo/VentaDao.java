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
    
    
     public int stockRopaVenta(int prenda){
        String sql="UPDATE ropa_venta SET rpv_stock=(rpv_stock-1) WHERE rpv_id=?";
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
//           ps.setInt(1,us.getPersona_id());
            ps.setInt(1,prenda);
           
            
            ps.executeUpdate();
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        return 0;
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,sqle.toString());
                }
        }
    }
   
    
    public Usuarios usuario(String correo){
        String sql="SELECT  persona_nombre, persona_apellido, usuario_id FROM usuarios WHERE usuario_email=?";
        Usuarios u= null;
         try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setString(1, correo);
        rs = ps.executeQuery();
        
        if(rs.next()){
            u= new Usuarios();
            
                u.setPersona_nombre(rs.getString(1));
                u.setPersona_apellido(rs.getString(2));
                u.setUsuario_id(rs.getInt(3));
                
            
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
        
         return u;
        
    }
    }

    
    public Clientes cliente(int idCliente){
        String sql="SELECT * FROM clientes WHERE cliente_id=?";
        Clientes cliente= null;
         try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setInt(1, idCliente);
        rs = ps.executeQuery();
        
        if(rs.next()){
            cliente= new Clientes();
            
            cliente.setCliente_id(rs.getInt("cliente_id"));
            cliente.setCliente_direccion(rs.getString("cliente_direccion"));
            cliente.setCliente_telefono(rs.getInt("cliente_telefono"));
            
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
        
         return cliente;
        
    }
    }
    
    
    
    public int getVenta(int cVenta, int vVenta, int pVenta){
        String sql = "INSERT INTO ventas (fecha_venta, cliente_venta, vendedor_venta, prenda_venta) VALUES (CURRENT_TIMESTAMP,?,?,?)";
        
         try {
        conex = (Connection) conectar.getConnection();
        ps = (PreparedStatement) conex.prepareStatement(sql);
        ps.setInt(1, cVenta);
        ps.setInt(2, vVenta);
        ps.setInt(3, pVenta);

        
        ps.executeUpdate();
        return 1;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
        return 0;
    } finally {
        try {
            if (conex != null) {
                conex.close();
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.toString());
        }
    }
    
   }
    
    
    
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

