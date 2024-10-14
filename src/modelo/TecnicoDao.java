/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author hgust
 */
public class TecnicoDao {
     Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    
     public MateriaPrima mate(JComboBox materia_nombre){
        String sql= "SELECT * FROM materia_prima WHERE materia_nombre=?" ;
        MateriaPrima mp=null;
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, (String) materia_nombre.getSelectedItem());
            
       
            rs=ps.executeQuery();
           if(rs.next()){
                mp=new MateriaPrima();
               mp.setMateria_nombre(rs.getString("materia_nombre"));
               mp.setMateria_stock(rs.getInt("materia_stock"));
               
               
        
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
        
        return mp;
    }
}
