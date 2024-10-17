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
import modelo.Conexion;
/**
 *
 * @author hgust
 */
public class SupervisorDao {
    Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    
    public int stock(){
        String sql="SELECT COUNT(materia_id) AS total_stock FROM materia_prima WHERE materia_stock <= 5";
        int stock = 0; 
        try{
            conex=(com.mysql.jdbc.Connection) conectar.getConnection();
            ps=(com.mysql.jdbc.PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()){
                stock=rs.getInt(1);
            
                
              
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
        
    
    return stock;
    
    
    }}

