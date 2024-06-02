
package Vistas;

import AccesoADatos.DetalleVentaData;
import AccesoADatos.ProductoData;
//
import static Vistas.VentaFormulario.refrescarTabla;
//
import javax.swing.table.DefaultTableModel;

public class ConsultaClienteXProd extends javax.swing.JInternalFrame {
//Atributos de la clase---------------------------------------------------------    
    private final DefaultTableModel modelo1; 
    private final DefaultTableModel modelo2;
    
    private final ProductoData prodData;
    private final DetalleVentaData deVtaData;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------    
    public ConsultaClienteXProd() {
        
        this.initComponents();
        
        modelo1=new DefaultTableModel(){

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
        modelo1.setColumnIdentifiers(new Object[]{"Nombre","Apellido","DNI"});
        modelo2.setColumnIdentifiers(new Object[]{"Codigo","Producto","Detalle","Stock"});
        jtCliente.setModel(modelo1);
        jtProdSelec.setModel(modelo2);
        
        prodData= new ProductoData();
        deVtaData = new DetalleVentaData ();
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdSelec = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("CONSULTA DE CLIENTES POR PRODUCTO");

        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Producto");

        jtProdSelec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jtProdSelec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdSelecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProdSelec);

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
        jLabel3.setText("Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(228, 228, 228))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtBuscarProducto)
                            .addGap(67, 67, 67))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2))
                            .addGap(32, 32, 32)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(170, 170, 170)
                .addComponent(jLabel3)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(63, 63, 63)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(58, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------
    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        if(jtProdSelec.getRowCount()!=-1){refrescarTabla(jtProdSelec);}//Se limpia la tabla si existen filas
        if(!txtBuscarProducto.getText().isEmpty()){
            prodData.buscarProductoXNombre(txtBuscarProducto.getText()).forEach((producto) -> 
                {modelo2.addRow(new Object[]{producto.getIdProducto(), 
                    producto.getNombreProducto(), producto.getDescripcion(), producto.getStock()});});
        }      
    }//GEN-LAST:event_txtBuscarProductoKeyReleased
    //--------------------------------------------------------------------------
    private void jtProdSelecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdSelecMouseClicked
        if(jtCliente.getRowCount()!=-1){refrescarTabla(jtCliente);}//Se limpia la tabla si existen filas
        if(jtProdSelec.getSelectedRow()!=-1){
            deVtaData.listarClientesXProducto((int) modelo2.getValueAt(jtProdSelec.getSelectedRow(), 0)).forEach((cliente) ->
            {modelo1.addRow(new Object[]{cliente.getApellido(), cliente.getNombre(),cliente.getDni(),});});
        }
    }//GEN-LAST:event_jtProdSelecMouseClicked
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtProdSelec;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
//------------------------------------------------------------------------------
}
