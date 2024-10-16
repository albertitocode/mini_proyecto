/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author hgust
 */
public class RopaCDao implements Crud<RopaClinica>{
     Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    

    
    @Override
    public List listar(){
        List<RopaClinica> datos=new ArrayList<RopaClinica>();
        String sql="select * from ropa_clinica";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                RopaClinica rpc= new RopaClinica();
                rpc.setRp_id(rs.getInt(1));
                rpc.setRpc_id(rs.getInt(2));
                rpc.setRp_nombre(rs.getString(3));
                rpc.setRp_marca(rs.getString(4));
                rpc.setRp_descripcion(rs.getString(5));
                rpc.setRp_color(rs.getString(6));
                rpc.setRp_categoria(rs.getString(7));
                rpc.setRpc_estado(rs.getString(8));
                rpc.setRpc_dano(rs.getString(9));
                rpc.setRpc_usuario(rs.getString(10));
                
                
                datos.add(rpc);
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
    public int setAgregar(RopaClinica rpclinica){
//       int r;
        String sql="INSERT INTO ropa_clinica VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1,rpclinica.getRp_id());
            ps.setInt(2,rpclinica.getRpc_id());
            ps.setString(3, rpclinica.getRp_nombre());
            ps.setString(4, rpclinica.getRp_marca());
            ps.setString(5, rpclinica.getRp_descripcion());
            ps.setString(6, rpclinica.getRp_color());
            ps.setString(7, rpclinica.getRp_categoria());
            ps.setString(8, rpclinica.getRpc_estado());
            ps.setString(9, rpclinica.getRpc_dano());
            ps.setString(10,rpclinica.getRpc_usuario());
            
            
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
    public int setAgregarr(RopaClinica rp, int cat,int esta,int usus){
//       int r;
        String sql="INSERT INTO ropa_venta VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            conex=(Connection) conectar.getConnection();
             if (conex == null) {
            JOptionPane.showMessageDialog(null, "Error: Conexión nula");
            return 0;
        }
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1,rp.getRp_id());
            ps.setInt(2,rp.getRpc_id());
            ps.setString(3, rp.getRp_nombre());
            ps.setString(4, rp.getRp_marca());
            ps.setString(5, rp.getRp_descripcion());
            ps.setString(6, rp.getRp_color());
            ps.setInt(7, cat);
            ps.setInt(8,esta);
            ps.setString(9, rp.getRpc_dano());
            ps.setInt(10, usus);
            
            ps.executeUpdate();
            return 1;
//            if (ps.executeUpdate() > 0) {
//            return 1; // Inserción exitosa
//        } else {
//            JOptionPane.showMessageDialog(null,"No se insertaron filas.");
//            return 0; // No se insertó nada
//        }

            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString(),"Error de Insercion "+e.getMessage(),JOptionPane.ERROR_MESSAGE);
            return 0;
        }finally{
            try{
                if(conex!=null){
                    conex.close();
                }
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,"sql insercion"+sqle.toString());
                }
        }
    }
    @Override
    public int setActualizar(RopaClinica rpc){
        String sql="UPDATE ropa_clinica SET rp_nombre=?,rp_marca=?,rp_descripcion=?,rp_color=?,rp_categoria=?,rpc_estado=?,rpc_dano=?, rpc_usuario WHERE rpc_id="+rpc.getRpc_id();
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setString(1, rpc.getRp_nombre());
            ps.setString(2, rpc.getRp_marca());
            ps.setString(3, rpc.getRp_descripcion());
            ps.setString(4,rpc.getRp_color());
            ps.setString(5,rpc.getRp_categoria());
            ps.setString(8, rpc.getRpc_estado());
            ps.setString(9, rpc.getRpc_dano());
            ps.setString(10,rpc.getRpc_usuario());
            
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
    public int setEliminar(int rpc_id){
        String sql= "DELETE FROM ropa_clinica WHERE rpc_id="+rpc_id;
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
        public int idcategoria(String nombre1){
        
          String sql= "SELECT categoria_id FROM categoria WHERE categoria_nombre=?";
          int id=0;
          
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, nombre1);
            rs=ps.executeQuery();
           
            if(rs.next()){
                
                id=rs.getInt(1);
                
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
      return id;
    }
      public int idestado(String nombre2){
        
          String sql= "SELECT estado_id FROM categoria WHERE estado_nombre=?";
          int id=0;
          
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, nombre2);
            rs=ps.executeQuery();
           
            if(rs.next()){
                
                id=rs.getInt(1);
                
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
      return id;
    }
        public int idUsuario(String nombre3){
        
          String sql= "SELECT usuario_id FROM usuarios WHERE persona_nombre=?";
          int id=0;
          
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, nombre3);
            rs=ps.executeQuery();
           
            if(rs.next()){
                
                id=rs.getInt(1);
                
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
      return id;
    }
}