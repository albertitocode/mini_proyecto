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
public class ClientesDao implements Crud<Clientes> {

    Conexion conectar = new Conexion();
    Connection conex;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<Clientes> datos = new ArrayList<Clientes>();
        String sql = "select * from clientes";
        try {
            conex = conectar.getConnection();
            ps = conex.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setPersona_id(rs.getInt(1));
                cliente.setPersona_nombre(rs.getString(2));
                cliente.setPersona_apellido(rs.getString(3));
                cliente.setCliente_id(rs.getInt(4));
                cliente.setCliente_email(rs.getString(5));
                cliente.setCliente_telefono(rs.getInt(6));

                datos.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }

            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sql.toString());
            }
        }
        return datos;
    }

    @Override
    public int setAgregar(Clientes c) {
        String sql = "INSERT INTO clientes VALUES(?,?,?,?,?,?)";

        try {
            conex = conectar.getConnection();
            ps = conex.prepareStatement(sql);

            ps.setInt(1, c.getPersona_id());
            ps.setString(2, c.getPersona_nombre());
            ps.setString(3, c.getPersona_apellido());
            ps.setInt(4, c.getCliente_id());
            ps.setString(5, c.getCliente_direccion());
            ps.setInt(6, c.getCliente_telefono());

            ps.executeUpdate();
            return 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Insercion" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }

    }

    @Override
    public int setActualizar(Clientes c) {
        String sql = "UPDATE clientes SET  cliente_nombre=?, cliente_apellido=?, cliente_direccion=?, cliente_telefono=? WHERE cliente_id=" + c.getCliente_id();

        try {
            conex = conectar.getConnection();
            ps = conex.prepareStatement(sql);
            
            //ps.setInt(1, c.getPersona_id());
            ps.setString(1, c.getPersona_nombre());
            ps.setString(2, c.getPersona_apellido());
           // ps.setInt(4, c.getCliente_id());
            ps.setString(3, c.getCliente_direccion());
            ps.setInt(4, c.getCliente_telefono());

            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 0;
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }

    @Override
    public int setEliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id="+id;
        try {
            conex = conectar.getConnection();
            ps = conex.prepareStatement(sql);
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de eliminacion" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }

}

