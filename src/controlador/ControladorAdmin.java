/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.VistaAdmin;
import vista.VistaCategoria;
import vista.VistaClientes;
import vista.VistaEstado;
import vista.VistaLogin;
import vista.VistaRol;
import vista.VistaUsuarios;

/**
 *
 * @author hgust
 */
public class ControladorAdmin implements ActionListener{
    VistaAdmin visad=new VistaAdmin();

    public ControladorAdmin(VistaAdmin visdmin) {
        this.visad=visdmin;
        this.visad.btncategorias.addActionListener(this);
        this.visad.btnclientes.addActionListener(this);
        this.visad.btnestados.addActionListener(this);
        this.visad.btnperfil.addActionListener(this);
        this.visad.btnroles.addActionListener(this);
        this.visad.btnusuarios.addActionListener(this);
        this.visad.btncategorias.setFocusPainted(false);
        this.visad.btnclientes.setFocusPainted(false);
        this.visad.btnestados.setFocusPainted(false);
        this.visad.btnperfil.setFocusPainted(false);
        this.visad.btnroles.setFocusPainted(false);
        this.visad.btnusuarios.setFocusPainted(false);
        this.visad.btncerrar.addActionListener(this);
    }

    public ControladorAdmin() {
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==visad.btncategorias){
             VistaCategoria ca = new VistaCategoria();
        ControladorCategoria con = new ControladorCategoria(ca);
        ca.setVisible(true);
        ca.setSize(850,600);
        ca.setLocation(300, 10);
         visad.dispose();
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnclientes){
//            JOptionPane.showMessageDialog(visad,"Boton clientes en mantenimiento");
               VistaClientes vclientes = new VistaClientes();
        ControladorClientes concli = new ControladorClientes(vclientes);
        vclientes.setVisible(true);
        vclientes.setSize(850,600);
        vclientes.setLocation(300, 10);
        visad.dispose();
        vclientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnestados){
            VistaEstado es = new VistaEstado();
            ControladorEstado con = new ControladorEstado(es);
            es.setVisible(true);
            es.setSize(850, 600);
            es.setLocation(300, 10);
            visad.dispose();
            es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnperfil){
            JOptionPane.showMessageDialog(visad,"Boton perfil en mantenimiento");
    
        }
        if(ae.getSource()==visad.btnroles){
             VistaRol ro = new VistaRol();
        ControladorRol conrol = new ControladorRol(ro);
        ro.setVisible(true);
        ro.setSize(850,600);
        ro.setLocation(300, 10);
        visad.dispose();
        ro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btnusuarios){
              VistaUsuarios vis = new VistaUsuarios();
            ControladorUs conusu = new ControladorUs(vis);
            
            vis.setVisible(true);
            vis.setSize(850, 600);
            vis.setLocation(300, 10);
            visad.dispose();
            vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==visad.btncerrar){
            if (ae.getSource()==visad.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            visad.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }
    }
    
    
}
