/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author hgust
 */
public class VistaRopaClinica extends javax.swing.JFrame {

    /**
     * Creates new form VIstprr
     */
    public VistaRopaClinica() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btncerrar = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        btnTrabajadores = new javax.swing.JButton();
        btnInsumos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        lidclinica = new javax.swing.JLabel();
        lnombre = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        idiclinica = new javax.swing.JTextField();
        tnombre = new javax.swing.JTextField();
        lmarca = new javax.swing.JLabel();
        ldescripcion = new javax.swing.JLabel();
        lcolor = new javax.swing.JLabel();
        tmarca = new javax.swing.JTextField();
        tdescripcion = new javax.swing.JTextField();
        tcolor = new javax.swing.JTextField();
        lcategoria = new javax.swing.JLabel();
        lestado = new javax.swing.JLabel();
        ldano = new javax.swing.JLabel();
        tdano = new javax.swing.JTextField();
        ccategoria = new javax.swing.JComboBox<>();
        cestado = new javax.swing.JComboBox<>();
        lusuario = new javax.swing.JLabel();
        cusuario = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        mitabla = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        elminar = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lcliente = new javax.swing.JLabel();
        tcliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(234, 223, 191));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (1).png"))); // NOI18N
        btncerrar.setBorder(null);
        btncerrar.setBorderPainted(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.setFocusPainted(false);

        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setFocusPainted(false);

        btnTrabajadores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTrabajadores.setForeground(new java.awt.Color(255, 255, 255));
        btnTrabajadores.setText("Trabajadores");
        btnTrabajadores.setBorder(null);
        btnTrabajadores.setBorderPainted(false);
        btnTrabajadores.setContentAreaFilled(false);
        btnTrabajadores.setFocusPainted(false);

        btnInsumos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsumos.setForeground(new java.awt.Color(255, 255, 255));
        btnInsumos.setText("Insumos");
        btnInsumos.setBorder(null);
        btnInsumos.setBorderPainted(false);
        btnInsumos.setContentAreaFilled(false);
        btnInsumos.setFocusPainted(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 71, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel1.setText("Ropa a reparar");

        lid.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lid.setText("Id");

        lidclinica.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lidclinica.setText("Id clinica");

        lnombre.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lnombre.setText("Nombre");

        tid.setBackground(new java.awt.Color(234, 223, 191));
        tid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        idiclinica.setBackground(new java.awt.Color(234, 223, 191));
        idiclinica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tnombre.setBackground(new java.awt.Color(234, 223, 191));
        tnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lmarca.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lmarca.setText("Marca");

        ldescripcion.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        ldescripcion.setText("Descripcion");

        lcolor.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lcolor.setText("Color");

        tmarca.setBackground(new java.awt.Color(234, 223, 191));
        tmarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tdescripcion.setBackground(new java.awt.Color(234, 223, 191));
        tdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tcolor.setBackground(new java.awt.Color(234, 223, 191));
        tcolor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lcategoria.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lcategoria.setText("Categoria");

        lestado.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lestado.setText("Estado");

        ldano.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        ldano.setText("Daño");

        tdano.setBackground(new java.awt.Color(234, 223, 191));
        tdano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ccategoria.setBackground(new java.awt.Color(234, 223, 191));
        ccategoria.setAutoscrolls(true);
        ccategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cestado.setBackground(new java.awt.Color(234, 223, 191));
        cestado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lusuario.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lusuario.setText("Tecnico encargado");

        cusuario.setBackground(new java.awt.Color(234, 223, 191));
        cusuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.setBackground(new java.awt.Color(234, 223, 191));

        mitabla.setBackground(new java.awt.Color(234, 223, 191));
        mitabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID CLINICA", "NOMBRE", "MARCA", "DESCRIPCION", "COLOR", "CATEGORIA", "ESTADO", "DAÑO", "USUARIO ENCARGADO", "ID CLIENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(mitabla);

        buscar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        buscar.setText("Buscar");
        buscar.setBorder(null);
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setFocusPainted(false);

        insertar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        insertar.setText("Insertar");
        insertar.setBorder(null);
        insertar.setBorderPainted(false);
        insertar.setContentAreaFilled(false);
        insertar.setFocusPainted(false);

        actualizar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setBorder(null);
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setFocusPainted(false);

        elminar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        elminar.setText("Eliminar");
        elminar.setBorder(null);
        elminar.setBorderPainted(false);
        elminar.setContentAreaFilled(false);
        elminar.setFocusPainted(false);

        enviar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        enviar.setText("Enviar");
        enviar.setBorder(null);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setFocusPainted(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/esquema-de-chico-de-reparacion.png"))); // NOI18N

        lcliente.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lcliente.setText("Id cliente");

        tcliente.setBackground(new java.awt.Color(234, 223, 191));
        tcliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(lusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(lcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buscar)
                                    .addComponent(actualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(insertar)
                                    .addComponent(elminar)
                                    .addComponent(enviar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lidclinica, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idiclinica, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ldano, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tdano, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lcategoria)
                                    .addComponent(lestado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ccategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lid)
                    .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lmarca)
                    .addComponent(tmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lcategoria)
                    .addComponent(ccategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lidclinica)
                    .addComponent(idiclinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ldescripcion)
                    .addComponent(tdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lestado)
                    .addComponent(cestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnombre)
                    .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lcolor)
                    .addComponent(tcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ldano)
                    .addComponent(tdano, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lusuario)
                            .addComponent(cusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lcliente)
                            .addComponent(tcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(enviar)
                        .addGap(18, 18, 18)
                        .addComponent(buscar)
                        .addGap(18, 18, 18)
                        .addComponent(insertar)
                        .addGap(18, 18, 18)
                        .addComponent(actualizar)
                        .addGap(32, 32, 32)
                        .addComponent(elminar)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 920, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaRopaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRopaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRopaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRopaClinica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRopaClinica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton actualizar;
    public javax.swing.JButton btnInicio;
    public javax.swing.JButton btnInsumos;
    public javax.swing.JButton btnTrabajadores;
    public javax.swing.JButton btncerrar;
    public javax.swing.JButton buscar;
    public javax.swing.JComboBox<String> ccategoria;
    public javax.swing.JComboBox<String> cestado;
    public javax.swing.JComboBox<String> cusuario;
    public javax.swing.JButton elminar;
    public javax.swing.JButton enviar;
    public javax.swing.JTextField idiclinica;
    public javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lcategoria;
    private javax.swing.JLabel lcliente;
    private javax.swing.JLabel lcolor;
    private javax.swing.JLabel ldano;
    private javax.swing.JLabel ldescripcion;
    private javax.swing.JLabel lestado;
    private javax.swing.JLabel lid;
    private javax.swing.JLabel lidclinica;
    private javax.swing.JLabel lmarca;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel lusuario;
    public javax.swing.JTable mitabla;
    public javax.swing.JTextField tcliente;
    public javax.swing.JTextField tcolor;
    public javax.swing.JTextField tdano;
    public javax.swing.JTextField tdescripcion;
    public javax.swing.JTextField tid;
    public javax.swing.JTextField tmarca;
    public javax.swing.JTextField tnombre;
    // End of variables declaration//GEN-END:variables
}
