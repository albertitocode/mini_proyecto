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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author hgust
 */
public class ControladorSupervisor implements ActionListener{
    
    
    public VistaSupervisor vistaSupervisor = new VistaSupervisor();
    public SupervisorDao sdao= new SupervisorDao();
    public ControladorRopaClinica crpc=new ControladorRopaClinica();
    
    

    public ControladorSupervisor(VistaSupervisor visS) {
        
        this.vistaSupervisor=visS;
        this.vistaSupervisor.btnOrden.addActionListener(this);
        this.vistaSupervisor.btnUsuarios.addActionListener(this);
       this.vistaSupervisor.btnInsumos.addActionListener(this);
       this.vistaSupervisor.btnRopa.addActionListener(this);
       this.vistaSupervisor.btncerrar.addActionListener(this);
       vistaSupervisor.linsumos.setText("Señor supervisor hay " +sdao.stock()+" insumos con pocas unidades");
       this.vistaSupervisor.btnPdf.addActionListener(this);
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
            vInsu.setSize(869, 588);
            vInsu.setLocationRelativeTo(null);

            vistaSupervisor.dispose();
        }
       
            if (e.getSource()==vistaSupervisor.btncerrar){
            VistaLogin log = new VistaLogin();
            
            ControladorLogin con = new ControladorLogin(log);
            log.setVisible(true);
            log.setSize(869, 588);
            log.setLocation(300, 10);
            vistaSupervisor.dispose();
            log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource()==vistaSupervisor.btnRopa){
            VistaRopaClinica ropc = new VistaRopaClinica();
            ControladorRopaClinica con = new ControladorRopaClinica(ropc);
            ropc.setVisible(true);
            ropc.setSize(914, 653);
            ropc.setLocation(300, 10);
            vistaSupervisor.dispose();
            ropc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(e.getSource()==vistaSupervisor.btnPdf){
            generarPdf();
        }
    }
    
    public void getStock(){
    
    }
     public void generarPdf() {
         Document documento = new Document();
         
           
        try {
         String lugarGuardado=System.getProperty("user.home");
         File file = new File(lugarGuardado + "/Desktop/ADSO.pdf");
        if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs(); // Crea el directorio si no existe
        }
         PdfWriter.getInstance(documento,new FileOutputStream(lugarGuardado+"/Desktop/ADSO.pdf"));
         documento.open();
         Image img1= Image.getInstance("src/img/grupo.png");
         Date fecha=new Date();
         SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/yyyy");
         String fechaActual= "Fecha "+formatoFecha.format(fecha);
         
         PdfPTable encabezado=new PdfPTable(4);
         encabezado.setWidthPercentage(100);
         encabezado.getDefaultCell().setBorder(0);
         float[] TamañoEncabezado=new float[]{20f,30f,70f,40f};
         encabezado.setWidths(TamañoEncabezado);
//         encabezado.setHorizontalAlignment(All);
         encabezado.addCell(img1);
         String nombre="Kell";
         String codigo="11883758393";
         String telefono="318479889";
         String direccion="Cali/Valle del Cauca";
         encabezado.addCell("");
         encabezado.addCell("Nombre "+nombre+ "\nCodigo "+codigo+ "\nTelefono "+telefono+ "\nDirección "+direccion);
         encabezado.addCell(fechaActual);
         
         Paragraph subtitulo = new Paragraph();
         subtitulo.add("Lista de Ropa en Reparacion\n\n");
         
         documento.add(encabezado);
         documento.add(subtitulo);
         documento.add(this.crpc.daClinica.listarpdf());
        documento.close();
        JOptionPane.showMessageDialog(vistaSupervisor, "Pdf creado");
        } catch ( Exception e) {
            JOptionPane.showMessageDialog(null,"Exception en el controlador"+e.toString());
        }
        
    }
  }
    


