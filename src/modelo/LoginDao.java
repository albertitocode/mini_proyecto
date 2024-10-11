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

/**
 *
 * @author hgust
 */
public class LoginDao {
    Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Login log(String correo,String contrasena){
        Login lg=new Login();
        String sql="select * from usuarios WHERE usuario_email=? AND usuario_contrasena=?";
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            rs=ps.executeQuery();
           if(rs.next()){
                
                lg.setCorreo(rs.getString(1));
                lg.setContrasena(rs.getString(2));
                
        
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
        return lg;
    }
}
