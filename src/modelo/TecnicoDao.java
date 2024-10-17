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
import javax.swing.JLabel;
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
      public void Iniciar(int rc){
         String sql= "UPDATE ropa_clinica SET  rpc_estado=1 WHERE rpc_id=?";
       
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1, rc);
         
            
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
      public void Finalizar(int rc){
         String sql= "UPDATE ropa_clinica SET  rpc_estado=3 WHERE rpc_id=?";
       
         try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
            ps.setInt(1, rc);
         
            
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
     public List listar(String micorreo){
        List<RopaClinica> datos=new ArrayList<RopaClinica>();
        String sql="select rp.rpc_id,rp.rp_nombre,rp.rp_marca,rp.rp_descripcion,rp.rp_color,c.categoria_nombre,es.estado_nombre,rp.rpc_descripcion_dano,us.usuario_email FROM ropa_clinica rp JOIN categoria c ON rp.rp_categoria=c.categoria_id JOIN estado_ropa es ON rp.rpc_estado=es.estado_id JOIN usuarios us ON rp.rpc_usuario=us.usuario_id WHERE us.usuario_email=?";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, micorreo);
            rs=ps.executeQuery();
            while(rs.next()){
                RopaClinica rpc= new RopaClinica();
                
                rpc.setRpc_id(rs.getInt(1));
                rpc.setRp_nombre(rs.getString(2));
                rpc.setRp_marca(rs.getString(3));
                rpc.setRp_descripcion(rs.getString(4));
                rpc.setRp_color(rs.getString(5));
                rpc.setRp_categoria(rs.getString(6));
                rpc.setRpc_estado(rs.getString(7));
                rpc.setRpc_dano(rs.getString(8));
                rpc.setRpc_usuario(rs.getString(9));
                
                
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
        if (micorreo == null){
    JOptionPane.showMessageDialog(null, "El correo electrónico no puede estar vacío.");
    return datos; // Retorna una lista vacía.
    }
//        JOptionPane.showMessageDialog(null, "Datos subidos"+micorreo);
        return datos;
        
    }
     public String nombreUsuario(String nombre){
         String sql="SELECT persona_nombre FROM usuarios WHERE usuario_email=?";
         String nombre_usuario="";
                 try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
           
            if(rs.next()){
                
                nombre=rs.getString(1);
                
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
      return nombre_usuario;
     }
}
