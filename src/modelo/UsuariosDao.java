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
        String sql="select * from usuarios";
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
       int r;
        String sql="INSERT INTO usuarios VALUES(?,?,?,?,?,?)";
        
        try{
            conex=conectar.getConnection();
            ps=conex.prepareStatement(sql);
            
            ps.setInt(1,us.getPersona_id());
            ps.setString(2,us.getPersona_nombre());
            ps.setString(3,us.getPersona_apellido());
            ps.setInt(4,us.getUsuario_id());
            ps.setString(5, us.getUsuario_email());
            ps.setString(6, us.getUsuario_contraseña());
            ps.setInt(7, us.getUsuario_telefono());
            
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
    public int setActualizar(Usuarios us){
        String sql="UPDATE usuarios SET nombre=?, apellidos?, salario=?, profesion=?, entidad=?";
        
        try{
            conex=conectar.getConnection();
            ps=conex.prepareStatement(sql);
            
           ps.setInt(1,us.getPersona_id());
            ps.setString(2,us.getPersona_nombre());
            ps.setString(3,us.getPersona_apellido());
            ps.setInt(4,us.getUsuario_id());
            ps.setString(5, us.getUsuario_email());
            ps.setString(6, us.getUsuario_contraseña());
            ps.setInt(7, us.getUsuario_telefono());
            
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
    public int setEliminar(int per_id){
        String sql= "DELETE FROM usuarios WHERE persona_id="+per_id;
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
}
