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
import vista.VistaAdmin;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;
import vista.VistaTecnico;
import vista.VistaUsuarios;
import controlador.ControladorTecnico;
import vista.VistaVenta;

/**
 *
 * @author hgust
 */
public class ControladorLogin implements ActionListener {

    public LoginDao da3 = new LoginDao();
    public Login lg = new Login();
    public VistaLogin vista3 = new VistaLogin();

//    DefaultTableModel modelito2=new DefaultTableModel();
    public ControladorLogin(VistaLogin visl) {
        this.vista3 = visl;
        this.vista3.siguiente.addActionListener(this);
    }

    public ControladorLogin() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista3.siguiente) {

            validar();
        }
    }

    public void validar() {
        String correo = this.vista3.tcorreo.getText();
        String contrasena = String.valueOf(this.vista3.tcontrasena.getPassword());
        if (!correo.isBlank() || !contrasena.isBlank()) {
            lg = this.da3.log(correo, contrasena);

            if (lg.getCorreo() != null && lg.getContrasena() != null) {

                String rol = lg.getRol();
//                JOptionPane.showMessageDialog(vista3,"funca rol: "+rol);  

                switch (rol) {
                    case "Admin":
//                        JOptionPane.showMessageDialog(vista3,"Funciona menor");
                        VistaAdmin visadmin = new VistaAdmin();
                        ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
                        visadmin.setVisible(true);
                        visadmin.setSize(869, 588);
                        visadmin.setLocation(300, 10);
                        vista3.dispose();
                        visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    case "Vendedor": {
                        //                    JOptionPane.showMessageDialog(vista3,"No funca");
                        VistaVenta vista = new VistaVenta();
                        ControladorVenta conVenta = new ControladorVenta(vista, lg);
                        vista.setVisible(true);
                        vista.setSize(869, 588);
                        vista.setLocation(300, 10);
                        vista3.dispose();
                        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    }
                    case "Supervisor": {
                        VistaSupervisor visasuper = new VistaSupervisor();
                        ControladorSupervisor conesuper = new ControladorSupervisor(visasuper);
                        visasuper.setVisible(true);
                        visasuper.setSize(880, 730);
                        visasuper.setLocation(300, 10);
                         vista3.dispose();
                        visasuper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    }
                    case "Tecnico": {
                        VistaTecnico vistaT = new VistaTecnico();
                        ControladorTecnico conTecnico = new ControladorTecnico(vistaT);
                        conTecnico.mostrarCorreo(correo);
                        vistaT.setVisible(true);
                        vistaT.setSize(869, 588);
                        vistaT.setLocation(300, 10);
                        vista3.dispose();
                        vistaT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(vista3, "No funca");
                    }
                    break;
                }

            } else {
                JOptionPane.showMessageDialog(vista3, "Error :/ \n Campos no validos ");
                this.vista3.tcorreo.setText("Ingrese su correo");
                this.vista3.tcontrasena.setText("**********");
            }
        }
    }

}
