
import controlador.ControladorUs;
import javax.swing.JFrame;
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
        vis.setSize(536,720);
        vis.setLocation(300, 10);
        
        vis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
