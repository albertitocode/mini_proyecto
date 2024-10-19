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
import modelo.Clientes;
import modelo.Login;
import modelo.RopaVenta;
import modelo.Usuarios;
import modelo.UsuariosDao;
import modelo.Venta;
import modelo.VentaDao;
import vista.VistaClientes;
import vista.VistaReparaciones;
import vista.VistaUsuarios;
import vista.VistaVenta;

/**
 *
 * @author hgust
 */
public class ControladorVenta implements ActionListener {
    public Usuarios vendedor = new Usuarios();
    public Clientes client = new Clientes();
    public Login login = new Login();
    public VentaDao dao1 = new VentaDao();
    public Venta ven = new Venta();
    public VistaVenta vista1 = new VistaVenta();
//    public RopaVenta rp = new RopaVenta();
//    DefaultTableModel modelito=new DefaultTableModel();

    public ControladorVenta() {
    }

    public ControladorVenta(VistaVenta visvent, Login log) {
        this.login = log;
        this.vista1 = visvent;
        this.vista1.ventas.addActionListener(this);
        this.vista1.vender.addActionListener(this);
        this.vista1.btnReparaciones.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista1.ventas) {
            int id_v = Integer.parseInt(vista1.tid.getText().toString());
            mostrarPrenda(id_v);
//             dao1.getPrenda(id_v);
        }
        if (ae.getSource() == vista1.vender) {
            String vend = login.getCorreo();
            int cliente = Integer.parseInt(JOptionPane.showInputDialog("Inserte el id del cliente"));
            client = dao1.cliente(cliente);
            
            if (client == null) {
                JOptionPane.showMessageDialog(vista1, "El cliente con id " + cliente + " no se encuentra registrado en el sistema\n"
                        + "a continuacion seras redirigido a registrar el cliente");
                VistaClientes vistaC = new VistaClientes();
                ControladorClientes conC = new ControladorClientes(vistaC);
                vistaC.setVisible(true);
                vistaC.setSize(880, 600);
                vistaC.setLocationRelativeTo(null);
                vista1.dispose();
                vistaC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            } else {
                vendedor=dao1.usuario(vend);
                int id_v = Integer.parseInt(vista1.tid.getText().toString());
                setVenta(client.getCliente_id(),vendedor.getUsuario_id(), id_v);
                JOptionPane.showMessageDialog(vista1, "Venta registrada  "+id_v+"\n"+client.getCliente_id()+"\n"+vendedor.getUsuario_id());

                

            }

        }
        if(ae.getSource()==vista1.btnReparaciones){
        VistaReparaciones vistrepair = new VistaReparaciones();
        ControladorReparaciones conesuper = new ControladorReparaciones(vistrepair);
        vistrepair.setVisible(true);
        vistrepair.setSize(900, 650);
        vistrepair.setLocation(300, 10);
        vista1.dispose();
        vistrepair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public void setVenta(int c, int v, int p){
       int resultado;

       resultado=dao1.getVenta(c, v, p);
 
       if(resultado==1){
           dao1.stockRopaVenta(p);
           JOptionPane.showMessageDialog(vista1,"Se ingreso correctamente");
       }else{
           if(resultado==0){
           JOptionPane.showMessageDialog(vista1,"Error de insercion "+JOptionPane.ERROR_MESSAGE);
           }
       }
     }
    public void mostrarPrenda(int id) {

        RopaVenta rp = dao1.getPrenda(id);
        if (rp != null) {
            vista1.lnombre.setText(rp.getRp_nombre());
            vista1.ldescri.setText(rp.getRp_descripcion());
            vista1.lpre.setText("" + rp.getRpv_precio());
            vista1.lstock.setText("" + rp.getRpv_stock());

        } else {
            JOptionPane.showMessageDialog(vista1, "No se encontró la prenda");
        }

    }
}
