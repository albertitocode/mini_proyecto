
import controlador.ControladorCategoria;
import controlador.ControladorMp;
import controlador.ControladorRol;
import controlador.ControladorUs;
import javax.swing.JFrame;
import vista.VistaCategoria;
import vista.VistaMateria;
import vista.VistaRol;
import vista.VistaUsuarios;

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
        VistaUsuarios vis = new VistaUsuarios();
        ControladorUs con = new ControladorUs(vis);
        vis.setVisible(true);
        vis.setSize(850,600);
        vis.setLocation(300, 10);
        
        vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     VistaRol ro = new VistaRol();
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
    }
    
}
