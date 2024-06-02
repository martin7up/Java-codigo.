
package Vistas;

import AccesoADatos.VentaData;
//
import static Vistas.VentaFormulario.dcFecha;
import static Vistas.VentaFormulario.refrescarTabla;
//
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaVtaXFecha extends javax.swing.JInternalFrame {
//Atributos de la clase---------------------------------------------------------
    private final DefaultTableModel modelo;
    private final VentaData VtaDta;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------
    public ConsultaVtaXFecha() {
        
        initComponents();
        
        modelo=new DefaultTableModel(){
    
            @Override
            public boolean isCellEditable(int f,int c){
                return false;
            }
        };
        modelo.setColumnIdentifiers(new Object[]{"Codigo","DNI","Apellido","Nombre"});
        jtVentas.setModel(modelo);
        
        VtaDta = new VentaData();
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(550, 450));

        jdFecha.setDateFormatString("yyyy/MM/dd");
        jdFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdFechaPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel1.setText("Seleccionar Fecha");

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtVentas);

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("CONSULTA DE VENTAS POR FECHA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(72, 72, 72)
                        .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------
    private void jdFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdFechaPropertyChange
        if(jdFecha.getDate()!=null){
            try{
                if(jtVentas.getRowCount()!=-1){refrescarTabla(jtVentas);}           
                (VtaDta.listarVentasXFecha(dcFecha(jdFecha))).forEach((Vta) -> 
                    {modelo.addRow(new Object[]{ Vta.getIdVenta(),Vta.getCliente().getDni(), 
                        Vta.getCliente().getApellido(), Vta.getCliente().getNombre()});});                 
            }catch(NullPointerException npe){
                JOptionPane.showMessageDialog(this, "Algo no resulto bien =| ");
                jdFecha.setDate(null);
            }
        }    
    }//GEN-LAST:event_jdFechaPropertyChange
//------------------------------------------------------------------------------    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JTable jtVentas;
    // End of variables declaration//GEN-END:variables
//------------------------------------------------------------------------------   
}