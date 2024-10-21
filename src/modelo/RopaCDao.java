/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import com.itextpdf.text.pdf.PdfPTable;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
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
        String sql="select rp.rp_id,rp.rpc_id,rp.rp_nombre,rp.rp_marca,rp.rp_descripcion,rp.rp_color,c.categoria_nombre,es.estado_nombre,rp.rpc_descripcion_dano,us.persona_nombre,rp.rpc_cliente FROM ropa_clinica rp JOIN categoria c ON rp.rp_categoria=c.categoria_id JOIN estado_ropa es ON rp.rpc_estado=es.estado_id JOIN usuarios us ON rp.rpc_usuario=us.usuario_id";
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
                rpc.setRpc_cliente(rs.getInt(11));
                
                
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
    public PdfPTable listarpdf() throws DocumentException{
        BaseColor verdi= new BaseColor(0,102,0);
        Font letraBlanca = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
         PdfPTable mitablapdf= new PdfPTable(11);   
//         float[] TamanoTabla=new float[]{10f,10f,10f};
//         mitablapdf.setWidths(TamanoTabla);
         PdfPCell cel1=new PdfPCell(new Phrase("Id",letraBlanca));
         cel1.setBackgroundColor(verdi);
         PdfPCell cel2=new PdfPCell(new Phrase("Id Clinica",letraBlanca));
         cel2.setBackgroundColor(verdi);
         PdfPCell cel3=new PdfPCell(new Phrase("Nombre",letraBlanca));
         cel3.setBackgroundColor(verdi);
         PdfPCell cel4=new PdfPCell(new Phrase("Marca",letraBlanca));
         cel4.setBackgroundColor(verdi);
         PdfPCell cel5=new PdfPCell(new Phrase("Dirección",letraBlanca));
         cel5.setBackgroundColor(verdi);
         PdfPCell cel6=new PdfPCell(new Phrase("Color",letraBlanca));
         cel6.setBackgroundColor(verdi);
         PdfPCell cel7=new PdfPCell(new Phrase("Categoria",letraBlanca));
         cel7.setBackgroundColor(verdi);
         PdfPCell cel8=new PdfPCell(new Phrase("Estado",letraBlanca));
         cel8.setBackgroundColor(verdi);
         PdfPCell cel9=new PdfPCell(new Phrase("Daño",letraBlanca));
         cel9.setBackgroundColor(verdi);
         PdfPCell cel10=new PdfPCell(new Phrase("Usuario",letraBlanca));
         cel10.setBackgroundColor(verdi);
         PdfPCell cel11=new PdfPCell(new Phrase("Cliente",letraBlanca));
         cel11.setBackgroundColor(verdi);
         mitablapdf.addCell(cel1);
         mitablapdf.addCell(cel2);
         mitablapdf.addCell(cel3);
         mitablapdf.addCell(cel4);
         mitablapdf.addCell(cel5);
         mitablapdf.addCell(cel6);
         mitablapdf.addCell(cel7);
         mitablapdf.addCell(cel8);
         mitablapdf.addCell(cel9);
         mitablapdf.addCell(cel10);
         mitablapdf.addCell(cel11);
        String sql="select rp.rp_id,rp.rpc_id,rp.rp_nombre,rp.rp_marca,rp.rp_descripcion,rp.rp_color,c.categoria_nombre,es.estado_nombre,rp.rpc_descripcion_dano,us.persona_nombre,rp.rpc_cliente FROM ropa_clinica rp JOIN categoria c ON rp.rp_categoria=c.categoria_id JOIN estado_ropa es ON rp.rpc_estado=es.estado_id JOIN usuarios us ON rp.rpc_usuario=us.usuario_id";
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()){
//                PdfPTable tablapdf= new PdfPTable(11);
                do{
                    mitablapdf.addCell(rs.getString(1));
                    mitablapdf.addCell(rs.getString(2));
                    mitablapdf.addCell(rs.getString(3));
                    mitablapdf.addCell(rs.getString(4));
                    mitablapdf.addCell(rs.getString(5));
                    mitablapdf.addCell(rs.getString(6));
                    mitablapdf.addCell(rs.getString(7));
                    mitablapdf.addCell(rs.getString(8));
                    mitablapdf.addCell(rs.getString(9));
                    mitablapdf.addCell(rs.getString(10));
                    mitablapdf.addCell(rs.getString(11));
                }while(rs.next());
//                documento.add(tablapdf);
               
            }
        }catch( Exception e){
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
        return mitablapdf;
    }
    public List listarPorCliente(int cliente){
        List<RopaClinica> datos=new ArrayList<RopaClinica>();
        String sql="select rp.rp_id,rp.rpc_id,rp.rp_nombre,rp.rp_marca,rp.rp_descripcion,rp.rp_color,c.categoria_nombre,es.estado_nombre,rp.rpc_descripcion_dano,us.persona_nombre,rp.rpc_cliente FROM ropa_clinica rp JOIN categoria c ON rp.rp_categoria=c.categoria_id JOIN estado_ropa es ON rp.rpc_estado=es.estado_id JOIN usuarios us ON rp.rpc_usuario=us.usuario_id WHERE rpc_cliente="+cliente;
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
                rpc.setRpc_cliente(rs.getInt(11));
                
                
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
        String sql="INSERT INTO ropa_clinica VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
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
            ps.setInt(11, rpclinica.getRpc_cliente());
            
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
        String sql="INSERT INTO ropa_clinica VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
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
            ps.setInt(11, rp.getRpc_cliente());
            
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
     public int setActualizarr(RopaClinica rp,int cat,int esta,int usus){
        String sql="UPDATE ropa_clinica SET rp_nombre=?,rp_marca=?,rp_descripcion=?,rp_color=?,rp_categoria=?,rpc_estado=?,rpc_descripcion_dano=?,rpc_usuario=?,rpc_cliente=? WHERE rpc_id="+rp.getRpc_id();
        
        try{
            conex=(Connection) conectar.getConnection();
            ps=(PreparedStatement) conex.prepareStatement(sql);
            
         
            ps.setString(1, rp.getRp_nombre());
            ps.setString(2, rp.getRp_marca());
            ps.setString(3, rp.getRp_descripcion());
            ps.setString(4, rp.getRp_color());
            ps.setInt(5, cat);
            ps.setInt(6,esta);
            ps.setString(7, rp.getRpc_dano());
            ps.setInt(8, usus);
            ps.setInt(11, rp.getRpc_cliente());
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
    public int setActualizar(RopaClinica rpc){
      return 1;
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
        
          String sql= "SELECT estado_id FROM estado_ropa WHERE estado_nombre=?";
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