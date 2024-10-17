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
import javax.swing.JOptionPane;

/**
 *
 * @author hgust
 */
public class EstadoDao implements Crud<Estado>{
     Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar(){
        
        List<Estado> datos=new ArrayList<Estado>();
        String sql="select * from estado_ropa";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               
                Estado e= new Estado();
                e.setEstado_id(rs.getInt(1));
                e.setEstado_nombre(rs.getString(2));
                
                datos.add(e);
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
    public int setAgregar(Estado es){
//       int r;
        String sql="INSERT INTO estado_ropa VALUES(?,?)";
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1,es.getEstado_id());
            ps.setString(2,es.getEstado_nombre());
            
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
    public int setActualizar(Estado es){
        String sql="UPDATE estado_ropa SET estado_nombre=? WHERE estado_id="+es.getEstado_id();
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
         
            ps.setString(1,es.getEstado_nombre());
            
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
    public int setEliminar(int estado_id){
        String sql= "DELETE FROM estado_ropa WHERE estado_id="+estado_id;
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
}
