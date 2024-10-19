/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UsuariosDao implements Crud<Usuarios>{
        
    Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public List listar(){
               List<Usuarios> datos=new ArrayList<Usuarios>();
        String sql="SELECT u.persona_id,u.persona_nombre,u.persona_apellido,u.usuario_id,u.usuario_email,u.usuario_contrasena,u.usuario_telefono,r.rol_nombre FROM usuarios u JOIN rol r ON u.rol_log=r.rol_id";
        try{
            conex=conectar.getConnection();
            ps=conex.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuarios u=new Usuarios();
                u.setPersona_id(rs.getInt(1));
                u.setPersona_nombre(rs.getString(2));
                u.setPersona_apellido(rs.getString(3));
                u.setUsuario_id(rs.getInt(4));
                u.setUsuario_email(rs.getString(5));
                u.setUsuario_contraseña(rs.getString(6));
                u.setUsuario_telefono(rs.getInt(7));
                u.setRol(rs.getString(8));
                
                
                datos.add(u);
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
    public int setAgregar(Usuarios us){
      return 0;
    }
    public int setAgregarr(Usuarios us, int idrol){
//       int r;
       String sql="INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            conex=(com.mysql.jdbc.Connection) conectar.getConnection();
             if (conex == null) {
            JOptionPane.showMessageDialog(null, "Error: Conexión nula");
            return 0;
        }
            ps=(com.mysql.jdbc.PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1,us.getPersona_id());
            ps.setString(2,us.getPersona_nombre());
            ps.setString(3,us.getPersona_apellido());
            ps.setInt(4,us.getUsuario_id());
            ps.setString(5, us.getUsuario_email());
            ps.setString(6, us.getUsuario_contraseña());
            ps.setInt(7, us.getUsuario_telefono());
            ps.setInt(8, idrol);
            
            
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
    public int setActualizar(Usuarios us){
        return 0;
    }
    @Override
    public int setEliminar(int per_id){
        String sql= "DELETE FROM usuarios WHERE usuario_id="+per_id;
        try{
            conex=conectar.getConnection();
            ps=conex.prepareStatement(sql);
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
    public int setActualizarr(Usuarios us,int idrol){
        String sql="UPDATE usuarios SET persona_nombre=?, persona_apellido=?, usuario_email=?, usuario_contrasena=?,usuario_telefono=?, rol=? WHERE persona_id="+us.getPersona_id();
        
        try{
            conex=(com.mysql.jdbc.Connection) conectar.getConnection();
            ps=(com.mysql.jdbc.PreparedStatement) conex.prepareStatement(sql);
            
    
            ps.setString(1,us.getPersona_nombre());
            ps.setString(2,us.getPersona_apellido());
            ps.setString(3, us.getUsuario_email());
            ps.setString(4, us.getUsuario_contraseña());
            ps.setInt(5, us.getUsuario_telefono());
            ps.setInt(6, idrol);
            
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
    public int idro(String nombre){
        
          String sql= "SELECT rol_id FROM rol WHERE rol_nombre=?";
          int id=0;
          
        try{
            conex=(com.mysql.jdbc.Connection) conectar.getConnection();
            ps=(com.mysql.jdbc.PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, nombre);
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
