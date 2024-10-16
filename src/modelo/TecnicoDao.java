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
    
     public MateriaPrima mate(String materia_nombre){
        String sql= "SELECT * FROM materia_prima WHERE materia_nombre=?" ;
        MateriaPrima mp=null;
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1,  materia_nombre);
            
       
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
     public void modificar(MateriaPrima mp){
         String sql= "UPDATE materia_prima SET  materia_stock=? WHERE materia_nombre=?";
        
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            
            ps.setInt(1,mp.getMateria_stock());
            ps.setString(2, mp.getMateria_nombre());
            
            ps.executeUpdate();
            
            
            
//         return 1;
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"dao 1"+e.toString());
//         return 0;
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
}
