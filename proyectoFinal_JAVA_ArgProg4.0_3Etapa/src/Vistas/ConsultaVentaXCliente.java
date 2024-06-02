package Vistas;

import AccesoADatos.ClienteData;
import AccesoADatos.DetalleVentaData;
import Entidades.Cliente;
import Entidades.DetalleVenta;

//
import static Vistas.FormularioProductos.*;
import static Vistas.VentaFormulario.refrescarTabla;
//
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaVentaXCliente extends javax.swing.JInternalFrame {
//Atributos de la clase---------------------------------------------------------    
    private final DefaultTableModel modelo;    
    private final ClienteData clData;
    private final DetalleVentaData deVtaDta;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------           
    public ConsultaVentaXCliente() {
        
        this.initComponents();
         
        modelo=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int f,int c){
                return false;
            }
        };
        modelo.setColumnIdentifiers(new Object[]{"Codigo Venta","Fecha","Producto","Cantidad","Monto"});
        jtCliente.setModel(modelo);
        
        clData = new ClienteData();
        deVtaDta= new DetalleVentaData();       
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        txtNombreCliente = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(550, 450));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("CONSULTA DE VENTAS POR CLIENTE");

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("DNI Cliente");

        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(jtCliente);

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Ventas Realizadas");

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Buscar.png")));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        txtNombreCliente.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        
        if (hayLetras(txtCliente.getText())||excedeLongitudMax((txtCliente.getText()), 11)
                ||txtCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Algo no esta bien con el dni ingresado\n"+
                    "Solo se admiten numeros, sin espacios ni puntos.");
            
        } else {
            Cliente cliente = clData.buscarClienteXDni(Long.parseLong(txtCliente.getText()));            
            txtNombreCliente.setText(cliente.getApellido().toUpperCase()+" "+cliente.getNombre().toUpperCase());
            
            refrescarTabla(jtCliente);
            for (DetalleVenta deVta : deVtaDta.listarVentasDeUnCliente(Long.parseLong(txtCliente.getText()))) {
            modelo.addRow(new Object[]{deVta.getVenta().getIdVenta(), deVta.getVenta().getFechaVenta(),
                deVta.getProducto().getNombreProducto(), deVta.getCantidad(),deVta.getPrecioVenta()});}
        
        }
    }//GEN-LAST:event_jbBuscarActionPerformed
//------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
//------------------------------------------------------------------------------
}
