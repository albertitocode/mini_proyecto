/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Login;
import modelo.LoginDao;
import vista.VistaCategoria;
import vista.VistaLogin;
import vista.VistaPrincipal;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;
import vista.VistaUsuarios;

/**
 *
 * @author hgust
 */
public class ControladorLogin implements ActionListener {
    
    public LoginDao da3=new LoginDao();
    public Login lg= new Login();
    public VistaLogin vista3 = new VistaLogin();
    String prueba;
//    DefaultTableModel modelito2=new DefaultTableModel();

    public ControladorLogin(VistaLogin visl) {
        this.vista3=visl;
        this.vista3.siguiente.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==vista3.siguiente){
            
            validar();
        }
    }
    public void validar(){
        String correo=this.vista3.tcorreo.getText();
        String contrasena=String.valueOf(this.vista3.tcontrasena.getPassword());
        if(!correo.isBlank() || !contrasena.isBlank()){
            lg = this.da3.log(correo, contrasena);

            if(lg.getCorreo()!=null && lg.getContrasena()!=null){
                String rol=lg.getRol();
//                JOptionPane.showMessageDialog(vista3,"funca rol: "+rol);  

                if(rol.equals("Admin")){
                   JOptionPane.showMessageDialog(vista3,"Funciona menor");
                   VistaPrincipal prin=new VistaPrincipal();
                   prin.setVisible(true);
                   
                }else if(rol.equals("Vendedor")){
//                    JOptionPane.showMessageDialog(vista3,"No funca"); 
                    VistaRopaVenta vista=new VistaRopaVenta();
                    vista.setVisible(true);
                }else if(rol.equals("Supervisor")){
//                    JOptionPane.showMessageDialog(vista3,"No funca"); 
                    VistaSupervisor vista=new VistaSupervisor();
                    vista.setVisible(true);
                }
//                JOptionPane.showMessageDialog(vista3,"rol "+lg.getRol());
//                if(lg.getRol().equals("Admin")){
//                 JOptionPane.showMessageDialog(vista3,"Funciona menor");
//                }else{
//                    JOptionPane.showMessageDialog(vista3,"No funca");
//                }
              
               
                
              
            }else{
                JOptionPane.showMessageDialog(vista3,"Error :/ \n Campos no validos ");
                this.vista3.tcorreo.setText("Ingrese su correo");
                this.vista3.tcontrasena.setText("**********");
            }
        }
    }
    
    
}
