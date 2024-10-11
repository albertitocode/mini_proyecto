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
public class MateriaDao implements Crud<MateriaPrima>{
    Conexion conectar= new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;
    
@Override
    public List listar(){
        
        List<MateriaPrima> datos=new ArrayList<MateriaPrima>();
        String sql="select * from materia_prima";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                MateriaPrima mp= new MateriaPrima();
                mp.setMateria_id(rs.getInt(1));
                mp.setMateria_nombre(rs.getString(2));
                mp.setMateria_stock(rs.getInt(3));
                datos.add(mp);
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
    public int setAgregar(MateriaPrima mp){
//       int r;
        String sql="INSERT INTO materia_prima VALUES(?,?,?)";
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1,mp.getMateria_id());
            ps.setString(2,mp.getMateria_nombre());
            ps.setInt(3,mp.getMateria_stock());
            
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
    public int setActualizar(MateriaPrima mp){
        String sql="UPDATE materia_prima SET materia_nombre=?,materia_stock=? WHERE materia_id="+mp.getMateria_id();
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            
            ps.setString(1,mp.getMateria_nombre());
            ps.setInt(2,mp.getMateria_stock());
            
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
    public int setEliminar(int mp_id){
        String sql= "DELETE FROM materia_prima WHERE materia_id="+mp_id;
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