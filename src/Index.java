
import controlador.ControladorAdmin;
import controlador.ControladorCategoria;
import controlador.ControladorEstado;
import controlador.ControladorLogin;
import controlador.ControladorMp;
import controlador.ControladorRol;
import controlador.ControladorRopaClinica;
import controlador.ControladorRopaVenta;
import controlador.ControladorSupervisor;
import controlador.ControladorTecnico;
import controlador.ControladorUs;
import controlador.ControladorVenta;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.VistaAdmin;
import vista.VistaCategoria;
import vista.VistaEstado;
import vista.VistaLogin;
import vista.VistaMateria;
import vista.VistaRol;
import vista.VistaRopaClini;
import vista.VistaRopaClinica;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;
import vista.VistaTecnico;
import vista.VistaUsuarios;
import vista.VistaVenta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hgust
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        VistaUsuarios vis = new VistaUsuarios();
//        ControladorUs con = new ControladorUs(vis);
//        vis.setVisible(true);
//        vis.setSize(850,600);
//        vis.setLocation(300, 10);
//        
//        vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        VistaRol ro = new VistaRol();
//        ControladorRol con = new ControladorRol(ro);
//        ro.setVisible(true);
//        ro.setSize(850,600);
//        ro.setLocation(300, 10);
//        
//        ro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        VistaCategoria ca = new VistaCategoria();
//        ControladorCategoria con = new ControladorCategoria(ca);
//        ca.setVisible(true);
//        ca.setSize(850,600);
//        ca.setLocation(300, 10);
//        
//        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        VistaMateria mp = new VistaMateria();
//        ControladorMp con = new ControladorMp(mp);
//        mp.setVisible(true);
//        mp.setSize(850,600);
//        mp.setLocation(300, 10);
//        
//        mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        VistaLogin log = new VistaLogin();
//        ControladorLogin con = new ControladorLogin(log);
//        log.setVisible(true);
//        log.setSize(850,600);
//        log.setLocation(300, 10);
//        
//        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        VistaRopaVenta ropv = new VistaRopaVenta();
//        ControladorRopaVenta con = new ControladorRopaVenta(ropv);
//        ropv.setVisible(true);
//        ropv.setSize(850,600);
//        ropv.setLocation(300, 10);
//        
//        ropv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
//       VistaTecnico vistaT = new VistaTecnico();
//        ControladorTecnico con = new ControladorTecnico(vistaT);
//        vistaT.setVisible(true);
//        vistaT.setSize(850,600);
//        vistaT.setLocation(300, 10);
//        
//        vistaT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        VistaRopaClinica ropc = new VistaRopaClinica();
//        ControladorRopaClinica con = new ControladorRopaClinica(ropc);
//        ropc.setVisible(true);
//        ropc.setSize(850,600);
//        ropc.setLocation(300, 10);
//        
//        ropc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         VistaEstado es = new VistaEstado();
//        ControladorEstado con = new ControladorEstado(es);
//        es.setVisible(true);
//        es.setSize(850,600);
//        es.setLocation(300, 10);
           //es.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//            VistaAdmin visadmin = new VistaAdmin();
//             ControladorAdmin coneadmin = new ControladorAdmin(visadmin);
//      visadmin.setVisible(true);
//           visadmin.setSize(850,600);
//                  visadmin.setLocation(300, 10);
//           visadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//           VistaSupervisor visasuper = new VistaSupervisor();
//             ControladorSupervisor conesuper = new ControladorSupervisor(visasuper);
//      visasuper.setVisible(true);
//           visasuper.setSize(900, 650);
//                  visasuper.setLocation(300, 10);
//           visasuper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
            VistaVenta visven = new VistaVenta();
        ControladorVenta conesuper = new ControladorVenta(visven);
        visven.setVisible(true);
        visven.setSize(900, 650);
        visven.setLocation(300, 10);
        visven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}
