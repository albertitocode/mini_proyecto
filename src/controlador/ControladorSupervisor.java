/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.SupervisorDao;
import vista.VistaLogin;
import vista.VistaMateria;
import vista.VistaOrden;
import vista.VistaRopaClinica;
import vista.VistaRopaVenta;
import vista.VistaSupervisor;
import vista.VistaUsuarios;
/**
 *
 * @author hgust
 */
public class ControladorSupervisor implements ActionListener{
    
    
    public VistaSupervisor vistaSupervisor = new VistaSupervisor();
    public SupervisorDao sdao= new SupervisorDao();
    
    
    

    public ControladorSupervisor(VistaSupervisor visS) {
        
        this.vistaSupervisor=visS;
        this.vistaSupervisor.btnOrden.addActionListener(this);
        this.vistaSupervisor.btnUsuarios.addActionListener(this);
       this.vistaSupervisor.btnInsumos.addActionListener(this);
       this.vistaSupervisor.btnRopa.addActionListener(this);
       this.vistaSupervisor.btncerrar.addActionListener(this);
       vistaSupervisor.linsumos.setText("Señor supervisor hay " +sdao.stock()+" insumos con pocas unidades");
       
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vistaSupervisor.btnOrden){
            JOptionPane.showMessageDialog(vistaSupervisor, sdao.stock());
            
            VistaOrden vOrden=new VistaOrden();
            ControladorOrden conO=new ControladorOrden(vOrden);
            vOrden.setVisible(true);
            vOrden.setLocationRelativeTo(null);

            vistaSupervisor.dispose();
        }
        if(e.getSource()==vistaSupervisor.btnUsuarios){
            
            VistaUsuarios vUsu=new VistaUsuarios();
            ControladorUs conU=new ControladorUs(vUsu);
            vUsu.setVisible(true);
            vUsu.setLocationRelativeTo(null);

            vistaSupervisor.dispose();
        }
        if(e.getSource()==vistaSupervisor.btnInsumos){
             VistaMateria vInsu=new VistaMateria();
            ControladorMp conInsu=new ControladorMp(vInsu);
            vInsu.setVisible(true);
            vInsu.setLocationRelativeTo(null);

            vistaSupervisor.dispose();
        }
       
            if (e.getSource()==vistaSupervisor.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vistaSupervisor.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource()==vistaSupervisor.btnRopa){
            VistaRopaClinica ropc = new VistaRopaClinica();
            ControladorRopaClinica con = new ControladorRopaClinica(ropc);
            ropc.setVisible(true);
            ropc.setSize(850, 600);
            ropc.setLocation(300, 10);
            vistaSupervisor.dispose();
            ropc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    public void getStock(){
    
    }
    
}

