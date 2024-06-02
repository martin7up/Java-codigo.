//Combo boxes en esta vista trabajaban con Strings y no con Entidades, p/mayor eficiencia talvez.
//... metodos clearSelection(), removeAllItems() para CBox y JTable
package Vistas;

import AccesoADatos.ProductoData;//p.Instancias de conexion
import AccesoADatos.VentaData;
import AccesoADatos.DetalleVentaData;
//
import Entidades.DetalleVenta;//p.Instancias contenedoras de entidades
import Entidades.Producto;
import Entidades.Venta;
//
import static Vistas.VentaFormulario.cargarComboBox;//Metodos estaticos de otra vista
//
import java.util.List;
import java.util.LinkedList;
//
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class DetallesVenta extends javax.swing.JInternalFrame {
//Atributos de la clase---------------------------------------------------------    
    private final VentaData veData;
    private final DetalleVentaData deVeData;
    private final ProductoData prodData;
    
    private final DefaultTableModel modelo1;
    private final DefaultTableModel modelo2;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------
    public DetallesVenta() {//Constructor de vista
        
        this.initComponents();
        
        this.veData = new VentaData();
        this.prodData = new ProductoData();
        this.deVeData = new DetalleVentaData();
        
        modelo1=new DefaultTableModel(){//para ver los metodos disponibles tipear this. .   
            @Override
            public boolean isCellEditable(int f,int c){
                return false;
            }
        };
        modelo2=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int f,int c){
                return false;
            }         
        };    
        modelo1.setColumnIdentifiers(new Object[]{"Id","Producto","Stock","$ Lista","$ Contado"});
        modelo2.setColumnIdentifiers(new Object[]{"Id","Producto","Cantidad","$ Unitario","Subtotal"});
        jtProductos.setModel(modelo1);
        jtCargaProductos.setModel(modelo2);

        cargarComboBox((LinkedList)veData.listarTodasLasVentas("idVenta","ASC"),jcbVentas);
        
        limpiarCamposYBotones();//Seteo por defector de componentes
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jbAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jsCantidad = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNeto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCargaProductos = new javax.swing.JTable();
        txtIva = new javax.swing.JTextField();
        jbConfirmar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jcbVentas = new javax.swing.JComboBox<>()

        ;
        jLabel2 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jrbTarjeta = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jrbContado = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Aceptar.png")));
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductos);

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel6.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Total ");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(240, 230, 202));
        txtTotal.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Eliminar.png"))); // NOI18N
        jbEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEliminarMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel9.setText("Fecha ");

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel10.setText("Cliente");

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 213, 237));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setText("Neto");

        txtCliente.setEditable(false);
        txtCliente.setBackground(new java.awt.Color(255, 213, 237));

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("IVA 21%");

        txtNeto.setEditable(false);
        txtNeto.setBackground(new java.awt.Color(240, 230, 202));
        txtNeto.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N

        jtCargaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCargaProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtCargaProductos.getTableHeader().setReorderingAllowed(false);
        jtCargaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCargaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCargaProductos);

        txtIva.setEditable(false);
        txtIva.setBackground(new java.awt.Color(240, 230, 202));
        txtIva.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtIva.setText("  ");

        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbConfirmar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jbConfirmar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Seleccione Venta");

        jcbVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVentasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Buscar Productos");

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jrbTarjeta.setText("Tarjeta");
        jrbTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTarjetaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel8.setText("Condicion Venta");

        jrbContado.setText("Contado");
        jrbContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbContadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jrbContado)
                        .addGap(18, 18, 18)
                        .addComponent(jrbTarjeta)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(35, 35, 35))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbTarjeta)
                    .addComponent(jrbContado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jcbVentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setText("DETALLE DE VENTA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jsCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------
    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        VentaFormulario.refrescarTabla(jtProductos);
        cargaDatosProductos();
    }//GEN-LAST:event_txtBuscarProductoKeyReleased
    //--------------------------------------------------------------------------
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        cargaDetalleVenta();
        jbAgregar.setEnabled(false);
        jrbContado.setEnabled(false);
        jrbTarjeta.setEnabled(false);
        modificarStockAgregar();
        jtProductos.clearSelection();//Emplear este metodo en las primeras vistas.
        calculoNeto();
    }//GEN-LAST:event_jbAgregarActionPerformed
    //--------------------------------------------------------------------------
    private void jrbTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTarjetaActionPerformed
        jrbContado.setSelected(false);
        txtBuscarProducto.setEnabled(true);
    }//GEN-LAST:event_jrbTarjetaActionPerformed
    //--------------------------------------------------------------------------
    private void jcbVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVentasActionPerformed
        limpiarCamposYBotones();        
        cargarComboBox((LinkedList)veData.listarTodasLasVentas("idVenta","ASC"), jcbVentas);          
        txtFecha.setText(((Venta) jcbVentas.getSelectedItem()).getFechaVenta().toString());
        txtCliente.setText(((Venta) jcbVentas.getSelectedItem()).getCliente().getApellido().toUpperCase()+
                " "+((Venta) jcbVentas.getSelectedItem()).getCliente().getNombre().toUpperCase());
    }//GEN-LAST:event_jcbVentasActionPerformed
    //--------------------------------------------------------------------------
    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        jbAgregar.setEnabled(true);
        jsCantidad.setEnabled(true);
        cargaSpinner();
    }//GEN-LAST:event_jtProductosMouseClicked
    //--------------------------------------------------------------------------
    private void jrbContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbContadoActionPerformed
        jrbTarjeta.setSelected(false);
        txtBuscarProducto.setEnabled(true);
    }//GEN-LAST:event_jrbContadoActionPerformed
    //--------------------------------------------------------------------------
    private void jtCargaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCargaProductosMouseClicked
        jbEliminar.setEnabled(true);
    }//GEN-LAST:event_jtCargaProductosMouseClicked
    //--------------------------------------------------------------------------
    private void jbEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarMouseClicked
        eliminarProdDeTabla();
        calculoNeto();
        jbEliminar.setEnabled(false);
    }//GEN-LAST:event_jbEliminarMouseClicked
    //--------------------------------------------------------------------------
    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        if(jtCargaProductos.getRowCount()>0){
            guardarDetalleVenta();
            try{
                jcbVentas.removeAllItems();
                }catch(NullPointerException npe){}
            VentaFormulario.cargarComboBox((LinkedList)veData.listarTodasLasVentas("idVenta","ASC"), jcbVentas);
        } else {
            JOptionPane.showMessageDialog(this, "Debe cargar algun producto para confirmar");
            return;
        }
        limpiarCamposYBotones();
    }//GEN-LAST:event_jbConfirmarActionPerformed
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JComboBox<Venta> jcbVentas;
    private javax.swing.JRadioButton jrbContado;
    private javax.swing.JRadioButton jrbTarjeta;
    private javax.swing.JSpinner jsCantidad;
    private javax.swing.JTable jtCargaProductos;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNeto;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
//Metodos propios de la clase---------------------------------------------------
    private void limpiarCamposYBotones(){
        txtBuscarProducto.setText("");
        txtBuscarProducto.setEnabled(false);
        jbAgregar.setEnabled(false);
        jbEliminar.setEnabled(false);
        VentaFormulario.refrescarTabla(jtProductos);
        VentaFormulario.refrescarTabla(jtCargaProductos);
        jrbContado.setSelected(false);
        jrbTarjeta.setSelected(false);
        jrbContado.setEnabled(true);
        jrbTarjeta.setEnabled(true);
        jsCantidad.setEnabled(false);
    }
    //--------------------------------------------------------------------------
    private void cargaDatosProductos() {
        String nombreProd = txtBuscarProducto.getText();
        if (!nombreProd.isEmpty()) {
            List<Producto> productos = prodData.buscarProductoXNombre(nombreProd);
            productos.forEach((producto) -> { modelo1.addRow(new Object[]{producto.getIdProducto(), producto.getNombreProducto(), producto.getStock(), producto.getPrecioActual(), (producto.getPrecioActual() * 0.9)});});
        }//row(IdProducto,NombreProducto,Stock,PrecioLista,PrecioContado)
    }
    //--------------------------------------------------------------------------
    private void cargaDetalleVenta(){
        int prodElegido = jtProductos.getSelectedRow();
        int cantidad = (int) jsCantidad.getValue();
        double precio = (jrbContado.isSelected())? (double) modelo1.getValueAt(prodElegido, 4) : (double) modelo1.getValueAt(prodElegido, 3);
        double precioTotal = precio * cantidad;
        modelo2.addRow(new Object[]{modelo1.getValueAt(prodElegido, 0),modelo1.getValueAt(prodElegido, 1), cantidad,  precio, precioTotal});
        //row(idProducto, nombreProducto,cantidad,precio,precioTotal)
    }
    //--------------------------------------------------------------------------
    private void calculoNeto(){
        double iva = 0;
        double total = 0;
        double neto = 0;
        double aux = 0;
        int filasTotales = jtCargaProductos.getRowCount();
        //Este ciclo recorre todas las filas y presenta los valores acumulados en los campos inferiores
        for (int fila = 0; fila < filasTotales; fila++) {
            neto = aux + (((double) modelo2.getValueAt(fila, 4)) / 1.21);
            iva = neto * 0.21;
            total = (iva + neto);
            aux = neto;        
        }
        //
        DecimalFormat formato = new DecimalFormat("#,###.##"); // Define el formato con dos decimales
        txtNeto.setText(formato.format(neto));
        txtIva.setText(formato.format(iva));
        txtTotal.setText(formato.format(total));
    }
    //--------------------------------------------------------------------------
    public void guardarDetalleVenta() {        
        int filasTabla = jtCargaProductos.getRowCount();
        for (int fila = 0; fila < filasTabla; fila++) {   
            deVeData.cargarDetalleVenta(//.cargarDetalleVenta(DetalleVenta(),cantidadProd,Venta,subtotal/*precio x cantidad*/,Producto(idProd))
                    new DetalleVenta(Integer.parseInt(jtCargaProductos.getValueAt(fila, 2)+""),
                            ((Venta) jcbVentas.getSelectedItem()), 
                    Double.parseDouble(jtCargaProductos.getValueAt(fila, 4)+""),
                    (new Producto(Integer.parseInt(jtCargaProductos.getValueAt(fila, 0)+""),"","",0,0,true)))
            );//Este metodo realiza la modificacion final de stock en BD
        }
    }
    //--------------------------------------------------------------------------
    public void modificarStockAgregar() {//Modificacion inicial de stock en tabla superior   
        modelo1.setValueAt(((int) modelo1.getValueAt(jtProductos.getSelectedRow(), 2) - (int) jsCantidad.getValue()), jtProductos.getSelectedRow(), 2);
        //.setValueAt(nuevoStock/*stockActual-cantidadVendida*/, filaProdAModificarStock, columnaDeStock)
    }
    //--------------------------------------------------------------------------
    public void eliminarProdDeTabla() {
        int filaSeleccionada = jtCargaProductos.getSelectedRow();
        int cantEliminada = (int) modelo2.getValueAt(filaSeleccionada, 2);
        int filasTabla = jtProductos.getRowCount();
        //
        for (int fila = 0; fila < filasTabla; fila++) {
            if (modelo1.getValueAt(fila, 0) == modelo2.getValueAt(filaSeleccionada, 0)) {
                int stockActual = (int) modelo1.getValueAt(fila, 2);
                int nuevoStock = stockActual + cantEliminada;
                modelo1.setValueAt(nuevoStock, fila, 2);
            }
        }
        if (filaSeleccionada != -1) modelo2.removeRow(filaSeleccionada);
    }
    //--------------------------------------------------------------------------
    public void cargaSpinner() {
        int prodElegido = jtProductos.getSelectedRow();
        if ((int) modelo1.getValueAt(prodElegido, 2) < 1) {
            JOptionPane.showMessageDialog(this, "No hay stock del producto seleccionado");
            jbAgregar.setEnabled(false);
        } else {
            int stock = (int) modelo1.getValueAt(prodElegido, 2);
            jsCantidad.setModel(new SpinnerNumberModel(1, 0, stock, 1));
        }
    }
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------
}


