
package Vistas;

import AccesoADatos.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    private Connection conexion;
    private FormularioCliente cliente;
    private FormularioProductos produ;
    private VentaFormulario venta;
    private DetallesVenta detaV;
    private ConsultaProdXVta consultaXVta;
    private ConsultaVtaXFecha consultaXFecha;
    private ConsultaVentaXCliente consultaXCli;
    private ConsultaClienteXProd consultaXprod; 
    
    public MenuPrincipal() {
        
        conexion = Conexion.getConexion();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        ImageIcon icono = new ImageIcon(getClass().getResource("/fravemax/Imagicon/logo.jpg"));
        Image miImagen=icono.getImage();
        escritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){

                g.drawImage(miImagen,0,0,getWidth(),getHeight(), this);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuCliente = new javax.swing.JMenu();
        FormularioCliente = new javax.swing.JMenuItem();
        jmenuProducto = new javax.swing.JMenu();
        FormularioProductos = new javax.swing.JMenuItem();
        jmenuVenta = new javax.swing.JMenu();
        NuevaVenta = new javax.swing.JMenuItem();
        jmenuDetalles = new javax.swing.JMenu();
        DetallesVenta = new javax.swing.JMenuItem();
        jConsultas = new javax.swing.JMenu();
        DetallesVenta1 = new javax.swing.JMenuItem();
        DetallesVenta2 = new javax.swing.JMenuItem();
        DetallesVenta3 = new javax.swing.JMenuItem();
        DetallesVenta4 = new javax.swing.JMenuItem();
        JSalir = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FRAVEMAX");
        setPreferredSize(new java.awt.Dimension(1170, 842));

        escritorio.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        escritorio.setPreferredSize(new java.awt.Dimension(900, 500));
        escritorio.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jmenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/imagicon/Clientes.png"))); // NOI18N
        jmenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuClienteActionPerformed(evt);
            }
        });

        FormularioCliente.setText("Formulario Cliente");
        FormularioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormularioClienteActionPerformed(evt);
            }
        });
        jmenuCliente.add(FormularioCliente);

        jMenuBar1.add(jmenuCliente);

        jmenuProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Productos.png"))); // NOI18N
        jmenuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuProductoActionPerformed(evt);
            }
        });

        FormularioProductos.setText("Formulario Productos");
        FormularioProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormularioProductosActionPerformed(evt);
            }
        });
        jmenuProducto.add(FormularioProductos);

        jMenuBar1.add(jmenuProducto);

        jmenuVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/imagicon/Compras.png"))); // NOI18N
        jmenuVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuVentaActionPerformed(evt);
            }
        });

        NuevaVenta.setText("Nueva Venta");
        NuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaVentaActionPerformed(evt);
            }
        });
        jmenuVenta.add(NuevaVenta);

        jMenuBar1.add(jmenuVenta);

        jmenuDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Venta.png"))); // NOI18N
        jmenuDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuDetallesActionPerformed(evt);
            }
        });

        DetallesVenta.setText("Detalles de Venta");
        DetallesVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesVentaActionPerformed(evt);
            }
        });
        jmenuDetalles.add(DetallesVenta);

        jMenuBar1.add(jmenuDetalles);

        jConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Lista.png"))); // NOI18N
        jConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultasActionPerformed(evt);
            }
        });

        DetallesVenta1.setText("Listar Productos por Venta");
        DetallesVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesVenta1ActionPerformed(evt);
            }
        });
        jConsultas.add(DetallesVenta1);

        DetallesVenta2.setText("Listar Ventas por Fecha");
        DetallesVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesVenta2ActionPerformed(evt);
            }
        });
        jConsultas.add(DetallesVenta2);

        DetallesVenta3.setText("Listar Ventas por Cliente");
        DetallesVenta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesVenta3ActionPerformed(evt);
            }
        });
        jConsultas.add(DetallesVenta3);

        DetallesVenta4.setText("Listar Clientes por Producto");
        DetallesVenta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetallesVenta4ActionPerformed(evt);
            }
        });
        jConsultas.add(DetallesVenta4);

        jMenuBar1.add(jConsultas);

        JSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/imagicon/Salir.png"))); // NOI18N
        JSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(JSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );

        escritorio.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JSalirMouseClicked
        
        try {
            conexion.close();
        } catch (SQLException ex) {}
        
        cliente = null;
        produ = null;
        venta = null;
        detaV = null;
        consultaXVta = null;
        consultaXFecha = null;
        consultaXCli = null;
        consultaXprod = null;
        
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_JSalirMouseClicked

    private void jmenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmenuClienteActionPerformed
    private void jmenuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuProductoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jmenuProductoActionPerformed
    private void jmenuVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuVentaActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jmenuVentaActionPerformed
    private void jmenuDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuDetallesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jmenuDetallesActionPerformed

    private void FormularioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormularioClienteActionPerformed

        escritorio.removeAll();
        escritorio.repaint();
        cliente=new FormularioCliente();
        cliente.setVisible(true);
        //cliente.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(cliente);
        escritorio.moveToFront(cliente);
        cliente.setSize(675, 725);
        JOptionPane.showMessageDialog(this, cliente.getSize()+"");
    }//GEN-LAST:event_FormularioClienteActionPerformed

    private void FormularioProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormularioProductosActionPerformed
 
        escritorio.removeAll();
        escritorio.repaint();
        produ=new FormularioProductos();
        produ.setVisible(true);
        //produ.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(produ);
        escritorio.moveToFront(produ);
    }//GEN-LAST:event_FormularioProductosActionPerformed

    private void NuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaVentaActionPerformed
 
        escritorio.removeAll();
        escritorio.repaint();
        venta=new VentaFormulario();
        venta.setVisible(true);
        venta.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(venta);
        escritorio.moveToFront(venta);
    }//GEN-LAST:event_NuevaVentaActionPerformed

    private void DetallesVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesVentaActionPerformed

        escritorio.removeAll();
        escritorio.repaint();
        detaV=new DetallesVenta();
        detaV.setVisible(true);
        //detaV.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(detaV);
        escritorio.moveToFront(detaV);
    }//GEN-LAST:event_DetallesVentaActionPerformed

    private void jConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultasActionPerformed
      
    }//GEN-LAST:event_jConsultasActionPerformed

    private void DetallesVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesVenta1ActionPerformed

        escritorio.removeAll();
        escritorio.repaint();
        consultaXVta=new ConsultaProdXVta();
        consultaXVta.setVisible(true);
        //consultaXVta.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(consultaXVta);
        escritorio.moveToFront(consultaXVta);
    }//GEN-LAST:event_DetallesVenta1ActionPerformed

    private void DetallesVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesVenta2ActionPerformed

        escritorio.removeAll();
        escritorio.repaint();
        consultaXFecha=new ConsultaVtaXFecha();
        consultaXFecha.setVisible(true);
        //consultaXFecha.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(consultaXFecha);
        escritorio.moveToFront(consultaXFecha);
    }//GEN-LAST:event_DetallesVenta2ActionPerformed

    private void DetallesVenta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesVenta3ActionPerformed

        escritorio.removeAll();
        escritorio.repaint();
        consultaXCli=new ConsultaVentaXCliente();
        consultaXCli.setVisible(true);
        //consultaXCli.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(consultaXCli);
        escritorio.moveToFront(consultaXCli);
    }//GEN-LAST:event_DetallesVenta3ActionPerformed

    private void DetallesVenta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetallesVenta4ActionPerformed

        escritorio.removeAll();
        escritorio.repaint();
        consultaXprod=new ConsultaClienteXProd();
        consultaXprod.setVisible(true);
        //consultaXprod.getContentPane().setBackground(new Color(250,240,240));
        escritorio.add(consultaXprod);
        escritorio.moveToFront(consultaXprod);
    }//GEN-LAST:event_DetallesVenta4ActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DetallesVenta;
    private javax.swing.JMenuItem DetallesVenta1;
    private javax.swing.JMenuItem DetallesVenta2;
    private javax.swing.JMenuItem DetallesVenta3;
    private javax.swing.JMenuItem DetallesVenta4;
    private javax.swing.JMenuItem FormularioCliente;
    private javax.swing.JMenuItem FormularioProductos;
    private javax.swing.JMenu JSalir;
    private javax.swing.JMenuItem NuevaVenta;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jConsultas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenuCliente;
    private javax.swing.JMenu jmenuDetalles;
    private javax.swing.JMenu jmenuProducto;
    private javax.swing.JMenu jmenuVenta;
    // End of variables declaration//GEN-END:variables

}