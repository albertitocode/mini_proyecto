/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.ClientesDao;
import modelo.Usuarios;
import modelo.UsuariosDao;
import vista.VistaClientes;
import vista.VistaLogin;
import vista.VistaUsuarios;
/**
 *
 * @author hgust
 */
public class ControladorClientes implements ActionListener {

    boolean flag = false;
    public ClientesDao daoClientes = new ClientesDao();
    public Clientes c = new Clientes();
    public VistaClientes vistaC = new VistaClientes();
    DefaultTableModel modelito = new DefaultTableModel();

    public ControladorClientes(VistaClientes vistaC) {
        this.vistaC = vistaC;
        this.vistaC.btnConsultar.addActionListener(this);
        this.vistaC.btnInsertar.addActionListener(this);
        this.vistaC.btnActualizar.addActionListener(this);
        this.vistaC.btnEliminar.addActionListener(this);
        this.vistaC.btnEnviar.addActionListener(this);
        this.vistaC.btnEnviar.setEnabled(flag);
        this.vistaC.btncerrar.addActionListener(this);
//        this.vistaC.btnperfil.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if (ae.getSource() == vistaC.btnConsultar) {
            limpiarTabla();
            getListar(vistaC.jtClientes);
            JOptionPane.showMessageDialog(vistaC, "Consulta exitosa");

        }

        if (ae.getSource() == vistaC.btnInsertar) {
            if (!vistaC.tid.getText().toString().isBlank()
                    && !vistaC.tnombre.getText().toString().isBlank()
                    && !vistaC.tapellido.getText().toString().isBlank()
                    && !vistaC.tidcliente.getText().toString().isBlank()
                    && !vistaC.tdireccion.getText().toString().isBlank()
                    && !vistaC.ttelefono.getText().toString().isBlank()) {
                setAgregar();
                nuevo();
                limpiarTabla();
                getListar(vistaC.jtClientes);

//              JOptionPane.showMessageDialog(vista,"Vamos bien");
            } else {
                JOptionPane.showMessageDialog(vistaC, "Vamos");
            }

        }

        if (ae.getSource() == vistaC.btnActualizar) {
            flag = true;
            int fila = vistaC.jtClientes.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vistaC, "debe selecionar una fila");
            } else {
                int id =Integer.parseInt( vistaC.jtClientes.getValueAt(fila, 0).toString());
                String p_nombre = vistaC.jtClientes.getValueAt(fila, 1).toString();
                String p_apellido = vistaC.jtClientes.getValueAt(fila, 2).toString();
                int c_id = Integer.parseInt(vistaC.jtClientes.getValueAt(fila, 3).toString());
//                String c_email=vistaC.jtClientes.getValueAt(fila, 4).toString();
                String c_direccion = vistaC.jtClientes.getValueAt(fila, 4).toString();
                int c_telefono = Integer.parseInt(vistaC.jtClientes.getValueAt(fila, 5).toString());

                vistaC.tid.setText(""+id); vistaC.tid.setEditable(false);
                vistaC.tnombre.setText(p_nombre);
                vistaC.tapellido.setText(p_apellido);
                vistaC.tidcliente.setText("" + c_id);vistaC.tidcliente.setEditable(false);
//              vistaC.jtextCorreo.setText(c_email);
                vistaC.tdireccion.setText(c_direccion);
                vistaC.ttelefono.setText("" + c_telefono);

              vistaC.btnEnviar.setEnabled(flag);
            }
        }

        if (ae.getSource() == vistaC.btnEliminar) {
            int fila = vistaC.jtClientes.getSelectedRow();

            if (!vistaC.tid.getText().isBlank()) {
                int id = Integer.parseInt(vistaC.tid.getText().toString());

                setEliminar(id);
                limpiarTabla();
                getListar(vistaC.jtClientes);

            }
        }
            if(ae.getSource()==vistaC.btnEnviar && flag==true){
            int id=Integer.parseInt(vistaC.tid.getText());
            setActualizar(id);
            flag=false;
            nuevo();
            limpiarTabla();
            getListar(vistaC.jtClientes);
            vistaC.btnEnviar.setEnabled(flag);
            vistaC.tid.setEditable(true);
            vistaC.tidcliente.setEditable(true);

        }
//          if(ae.getSource()==vistaC.btnperfil){
//            JOptionPane.showMessageDialog(vistaC,"Boton perfil en mantenimiento");
//        }
         if(ae.getSource()==vistaC.btncerrar){
            if (ae.getSource()==vistaC.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(850, 600);
            log.setLocation(300, 10);
            vistaC.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        }
//            
//             if(ae.getSource()==vista1.enviar && flag==true){
//            int id=Integer.parseInt(vista1.Tid.getText());
//            setActualizar(id);
//            flag=false;
//            nuevo();
//            limpiarTabla();
//            getListar(vista1.miTabla);
//            vista1.enviar.setEnabled(flag);
//            vista1.Tid.setEditable(true);
//            vista1.Tid_usuario.setEditable(true);
//            
//        }

    }

    public void getListar(JTable tabla) {
        modelito = (DefaultTableModel) tabla.getModel();
        List<Clientes> lista = daoClientes.listar();
        Object[] object = new Object[6];

        for (int indice = 0; indice < lista.size(); indice++) {
            object[0] = lista.get(indice).getPersona_id();
            object[1] = lista.get(indice).getPersona_nombre();
            object[2] = lista.get(indice).getPersona_apellido();
            object[3] = lista.get(indice).getCliente_id();
            object[4] = lista.get(indice).getCliente_email();
            object[5] = lista.get(indice).getCliente_telefono();
            modelito.addRow(object);
        }
        vistaC.jtClientes.setModel(modelito);
    }

    public void setAgregar() {
        int resultado;
        int tid = Integer.parseInt(vistaC.tid.getText());
        String tnombre = vistaC.tnombre.getText().toString();
        String tapellido = vistaC.tapellido.getText().toString();
        int tid_c = Integer.parseInt(vistaC.tidcliente.getText().toString());
//       String tcorreo=vistaC.jtextDireccion.getText().toString();
        String tdireccion = vistaC.tdireccion.getText().toString();
        int telefono = Integer.parseInt(vistaC.ttelefono.getText().toString());

        c.setPersona_id(tid);
        c.setPersona_nombre(tnombre);
        c.setPersona_apellido(tapellido);
        c.setCliente_id(tid_c);
//       c.setCliente_email(tcorreo);
        c.setCliente_direccion(tdireccion);
        c.setCliente_telefono(telefono);

        resultado = daoClientes.setAgregar(c);

        if (resultado == 1) {
            JOptionPane.showMessageDialog(vistaC, "Se ingreso correctamente");
        } else {
            if (resultado == 0) {
                JOptionPane.showMessageDialog(vistaC, "Error de insercion " + JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setActualizar(int id) {
        int resultado;

        int tid = Integer.parseInt(vistaC.tid.getText());
        String tnombre = vistaC.tnombre.getText().toString();
        String tapellido = vistaC.tapellido.getText().toString();
        int tid_c = Integer.parseInt(vistaC.tidcliente.getText().toString());
//       String tcorreo=vistaC.jtextDireccion.getText().toString();
        String tdireccion = vistaC.tdireccion.getText().toString();
        int telefono = Integer.parseInt(vistaC.ttelefono.getText().toString());

        c.setPersona_id(tid);
        c.setPersona_nombre(tnombre);
        c.setPersona_apellido(tapellido);
        c.setCliente_id(tid_c);
//       c.setCliente_email(tcorreo);
        c.setCliente_direccion(tdireccion);
        c.setCliente_telefono(telefono);

        resultado = daoClientes.setActualizar(c);

        if (resultado == 1) {
            JOptionPane.showMessageDialog(vistaC, "Se ingreso correctamente");
        } else {
            if (resultado == 0) {
                JOptionPane.showMessageDialog(vistaC, "Error de insercion " + JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setEliminar(int id) {
        int resultado;

        resultado = daoClientes.setEliminar(id);
        if (resultado == 1) {
            JOptionPane.showMessageDialog(vistaC, "Se eliminó correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaC, "Error 404 " + JOptionPane.ERROR_MESSAGE);
        }

    }

    public void nuevo() {
        vistaC.tid.setText("");
        vistaC.tnombre.setText("");
        vistaC.tapellido.setText("");
        vistaC.tidcliente.setText("");
//        vistaC.jtextCorreo.setText("");
        vistaC.tdireccion.setText("");
        vistaC.ttelefono.setText("");

    }

    public void limpiarTabla() {
        for (int i = 0; i < vistaC.jtClientes.getRowCount(); i++) {
            modelito.removeRow(i);
            i = i - 1;
        }
    }

}

