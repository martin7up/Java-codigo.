
package Vistas;

import AccesoADatos.VentaData;
import AccesoADatos.ProductoData;
import Entidades.Venta;
//
import static Vistas.VentaFormulario.dcFecha;
import static Vistas.VentaFormulario.refrescarTabla;
import static Vistas.VentaFormulario.cargarComboBox;
//
import java.util.LinkedList;
//
import javax.swing.table.DefaultTableModel;

public class ConsultaProdXVta extends javax.swing.JInternalFrame {
//Atributos de la clase---------------------------------------------------------
    private final VentaData veData;
    private final ProductoData prodData;
 
    private final DefaultTableModel modelo;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------
 
    public ConsultaProdXVta() {
        
        this.initComponents();
        
        modelo=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int f,int c){
            return false;
            }
        };
        
        modelo.setColumnIdentifiers(new Object[]{"Producto","Detalle","Cantidad"});
        JTproductos.setModel(modelo);
        
        //JDCfechaVenta.setDateFormatString("dd-MM-yyyy");
        
        veData = new VentaData();
        prodData = new ProductoData();
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDCfechaVenta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTproductos = new javax.swing.JTable();
        JCBventas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);

        JDCfechaVenta.setDateFormatString("dd-MM-yyyy");

        JTproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTproductos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(JTproductos);

        JCBventas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBventasItemStateChanged(evt);
            }
        });
        JCBventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCBventasMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("CONSULTA DE PRODUCTOS POR VENTA");

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JDCfechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCBventas, 0, 304, Short.MAX_VALUE)))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(JDCfechaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(JCBventas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------
    private void JCBventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCBventasMouseClicked
        //busca la fecha asignada en JDC, hace la busqueda y carga el CBox con el resultado de la busqueda
        if(JDCfechaVenta.getDate()!=null){
            JCBventas.removeAllItems();
            cargarComboBox((LinkedList)veData.listarVentasXFecha(dcFecha(JDCfechaVenta)), JCBventas);         
        }
    }//GEN-LAST:event_JCBventasMouseClicked
    //--------------------------------------------------------------------------
    private void JCBventasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBventasItemStateChanged
        //si encuentra que se ha seleccionado un item, pasa sus datos a la tabla
        refrescarTabla(JTproductos);
            if(JCBventas.getSelectedIndex()!=-1){
                prodData.buscarProductoXIdVenta(((Venta)JCBventas.getSelectedItem()).getIdVenta()).forEach((detalleVta) -> {
                    modelo.addRow(new Object[]{ detalleVta.getProducto().getNombreProducto(), 
                        detalleVta.getProducto().getDescripcion(),detalleVta.getCantidad()});});
            }
    }//GEN-LAST:event_JCBventasItemStateChanged
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Venta> JCBventas;
    private com.toedter.calendar.JDateChooser JDCfechaVenta;
    private javax.swing.JTable JTproductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
//------------------------------------------------------------------------------
}