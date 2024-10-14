/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author hgust
 */
public class RopaVDao implements Crud<RopaVenta>{
    Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    

    
    @Override
    public List listar(){
        List<RopaVenta> datos=new ArrayList<RopaVenta>();
        String sql="select * from ropa_venta";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                RopaVenta rpv= new RopaVenta();
                rpv.setRp_id(rs.getInt(1));
                rpv.setRpv_id(rs.getInt(2));
                rpv.setRp_nombre(rs.getString(3));
                rpv.setRp_marca(rs.getString(4));
                rpv.setRp_descripcion(rs.getString(5));
                rpv.setRp_color(rs.getString(6));
                rpv.setRp_categoria(rs.getString(7));
                rpv.setRpv_precio(rs.getInt(8));
                rpv.setRpv_stock(rs.getInt(9));
                
                
                datos.add(rpv);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
                
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, sql.toString());
            }
        }
        return datos;
    }
    @Override
    public int setAgregar(RopaVenta rp){
//       int r;
        String sql="INSERT INTO ropa_venta VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1,rp.getRp_id());
            ps.setInt(2,rp.getRpv_id());
            ps.setString(3, rp.getRp_nombre());
            ps.setString(4, rp.getRp_marca());
            ps.setString(5, rp.getRp_descripcion());
            ps.setString(6, rp.getRp_color());
            ps.setString(7, rp.getRp_categoria());
            ps.setInt(8, rp.getRpv_precio());
            ps.setInt(9, rp.getRpv_stock());
            
            
            ps.executeUpdate();
            return 1;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(),"Error de Insercion"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
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
    @Override
    public int setActualizar(RopaVenta rp){
        String sql="UPDATE ropa_venta SET rp_nombre=?,  rp_marca=?,rp_descripcion=?,rp_color=?,rp_categoria=?,rpv_precio=?,rpv_stock=? WHERE rpv_id="+rp.getRpv_id();
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setString(1, rp.getRp_nombre());
            ps.setString(2, rp.getRp_marca());
            ps.setString(3, rp.getRp_descripcion());
            ps.setString(4,rp.getRp_color());
            ps.setString(5,rp.getRp_categoria());
            ps.setInt(6, rp.getRpv_precio());
            ps.setInt(7,rp.getRpv_stock());
            
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
     @Override
    public int setEliminar(int rpv_id){
        String sql= "DELETE FROM ropa_venta WHERE rpv_id="+rpv_id;
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.executeUpdate();
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(),"Error de eliminacion"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return 0;
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }   
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }
    
    public void listaCategoria(JComboBox tcategoria){
        
        String sql= "SELECT categoria_nombre FROM categoria";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                tcategoria.addItem(rs.getString(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
                
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null, sql.toString());
            }
        }
    }
}
