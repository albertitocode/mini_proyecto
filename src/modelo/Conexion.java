/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author hgust
 */
public class Conexion {
    Connection conex;
    String url="jdbc:mysql://localhost:3306/mini_proyecto";
    String pass="";
    String user= "root";
    public Connection getConnection(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conex=DriverManager.getConnection(url,user,pass);
//            JOptionPane.showMessageDialog(null,"Conexion exitosa");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas con "+e.toString());
        }
        return conex;
    }
}
