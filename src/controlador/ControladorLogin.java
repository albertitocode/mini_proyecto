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
import vista.VistaUsuarios;

/**
 *
 * @author hgust
 */
public class ControladorLogin implements ActionListener {
    boolean flag=false;
    public LoginDao da3=new LoginDao();
    public Login lg= new Login();
    public VistaLogin vista3 = new VistaLogin();
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
        if(!correo.isBlank() || contrasena.isBlank()){
            lg = this.da3.log(correo, contrasena);
            if(lg.getCorreo()!=null && lg.getContrasena()!=null){
                VistaCategoria ca = new VistaCategoria();
                ControladorCategoria con = new ControladorCategoria(ca);
                ca.setVisible(true);
                ca.setSize(850,600);
                ca.setLocation(300, 10);
        
               ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.vista3.dispose();
            }else{
                JOptionPane.showMessageDialog(vista3,"Erro :/ \n Campos no validos ");
                this.vista3.tcorreo.setText("Ingrese su correo");
                this.vista3.tcontrasena.setText("**********");
            }
        }
    }
    
    
}
