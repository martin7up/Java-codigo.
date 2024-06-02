
package Vistas;
//Comunicacion con BD
import AccesoADatos.ClienteData;
import AccesoADatos.VentaData;
//Entidades Contenedoras e Interfaz
import Entidades.Cliente;
import Entidades.Entidades;
import Entidades.Venta;
import com.toedter.calendar.JDateChooser;
//
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
//
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
//
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentaFormulario extends javax.swing.JInternalFrame {
//Atributos de la clase VentaFormulario-----------------------------------------
    
    //Modelos de tablas y sus propiedades.
    private final DefaultTableModel modelo; 
    private final DefaultTableModel modelo1;  
    
    //Instancias contenedoras y de servicios.
    private ClienteData clData;
    private VentaData veData; 
    private Cliente cliente;
    private Venta venta;
    
    private final LinkedList<JRadioButton> jrB;
    
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------
    public VentaFormulario() {
        
        this.initComponents();
        
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };
        modelo1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int fila, int columna){
                return ((columna==1||columna==2) && jrSeVaACorregir.isSelected());//Id cliente y fechaVenta solamente son editables.
            }
        };
             
        jrB = new LinkedList<>();//Lista requerida para el metodo ordenamiento()
        jrB.add(jrXdni);jrB.add(jrXFecha);jrB.add(jrXapellido);jrB.add(jrXidCliente);
        jrB.add(jrXidVenta);jrB.add(jrXnombre);
        
        //Cabeceras de tablas y asignacion de modelos
        armarCabeceraTabla(new LinkedList<>(Arrays.asList("ID_Venta","Fecha_Venta")), modelo ,jtVentasDe1Cliente);        
        armarCabeceraTabla(new LinkedList<>(Arrays.asList("Id_Venta","Id_Cliente",
                "Fecha_Venta","Dni_Cliente","Apellido_Cliente","Nombre_Cliente")) ,modelo1, jtTodasLasVentas);
        
        clData = new ClienteData();//Instancias de servicio con BD
        veData = new VentaData();
        
        resetearCamposBotonesTablasYCombo();//Seteo por defecto de componentes de vista
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdcSeleccionFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jrbFechaActual = new javax.swing.JRadioButton();
        jcbClientesRegistrados = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jlFechaActual = new javax.swing.JLabel();
        jbRegistrarVenta = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVentasDe1Cliente = new javax.swing.JTable();
        jbLimpiarYResetear = new javax.swing.JButton();
        jlFormato = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTodasLasVentas = new javax.swing.JTable();
        jrSeVaACorregir = new javax.swing.JRadioButton();
        jrXdni = new javax.swing.JRadioButton();
        jrXidVenta = new javax.swing.JRadioButton();
        jrXidCliente = new javax.swing.JRadioButton();
        jrXFecha = new javax.swing.JRadioButton();
        jrXnombre = new javax.swing.JRadioButton();
        jrXapellido = new javax.swing.JRadioButton();
        jrDescendente = new javax.swing.JRadioButton();

        jdcSeleccionFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jdcSeleccionFechaMouseClicked(evt);
            }
        });

        jLabel1.setText("Fecha del dia de la Venta.");

        jrbFechaActual.setText("Utilizar fecha actual.");
        jrbFechaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrbFechaActualMouseClicked(evt);
            }
        });

        jcbClientesRegistrados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbClientesRegistradosItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario Venta");

        jbRegistrarVenta.setText("Registrar Venta");
        jbRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarVentaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtVentasDe1Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtVentasDe1Cliente);

        jbLimpiarYResetear.setText("Limpiar Datos y Botones");
        jbLimpiarYResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarYResetearActionPerformed(evt);
            }
        });

        jtTodasLasVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtTodasLasVentas);

        jrSeVaACorregir.setText("Corregir en lista.");
        jrSeVaACorregir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrSeVaACorregirMouseClicked(evt);
            }
        });

        jrXdni.setText("por Dni");
        jrXdni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXdniMouseClicked(evt);
            }
        });

        jrXidVenta.setText("por Id Venta");
        jrXidVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXidVentaMouseClicked(evt);
            }
        });

        jrXidCliente.setText("por Id Cliente");
        jrXidCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXidClienteMouseClicked(evt);
            }
        });

        jrXFecha.setText("por Fecha");
        jrXFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXFechaMouseClicked(evt);
            }
        });

        jrXnombre.setText("por Nombre");
        jrXnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXnombreMouseClicked(evt);
            }
        });

        jrXapellido.setText("por Apellido");
        jrXapellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrXapellidoMouseClicked(evt);
            }
        });

        jrDescendente.setText("Mayor a Menor.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jrbFechaActual)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrSeVaACorregir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jrDescendente)
                                                .addGap(19, 19, 19))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jbLimpiarYResetear, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jbRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrXdni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXidVenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXidCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXnombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrXapellido)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jlFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdcSeleccionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(jcbClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jdcSeleccionFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jcbClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlFechaActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jrbFechaActual, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jlFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrXdni)
                            .addComponent(jrXidVenta)
                            .addComponent(jrXidCliente)
                            .addComponent(jrXFecha)
                            .addComponent(jrXnombre)
                            .addComponent(jrXapellido)
                            .addComponent(jrDescendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrSeVaACorregir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbRegistrarVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpiarYResetear))
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------   
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        /*try {
            clData.cerrar();
            veData.cerrar();
            deVtaDta.cerrar();          
        } catch (SQLException ex) {}*/     
        clData = null;
        veData = null;       
        cliente = null;
        venta = null; 
        this.dispose();     
    }//GEN-LAST:event_jbSalirActionPerformed
    //Evento de seleccion de fecha de Venta
    private void jrbFechaActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrbFechaActualMouseClicked
        if(jrbFechaActual.isSelected()){
            //Si se selecciona jrbFechaActual se deshabilita el uso del calendario.   
            jdcSeleccionFecha.setEnabled(false); 
            jlFormato.setText("aaaa-mm-dd");
            jlFechaActual.setText(LocalDate.now(ZoneId.systemDefault())+"");       
        }else{
            //Si se des-selecciona jrbFechaActual se habilita el uso del calendario.   
            jdcSeleccionFecha.setEnabled(true);
            jlFechaActual.setText("");
            jlFormato.setText("");
        }
    }//GEN-LAST:event_jrbFechaActualMouseClicked
    //Evento para registrar nueva venta o modificar una existente
    private void jbRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarVentaActionPerformed
        if (jdcSeleccionFecha.getDate()==null && !jrbFechaActual.isSelected()){ 
            JOptionPane.showMessageDialog(this, "Seleccione una fecha");
            return;
        }     
        if (jtTodasLasVentas.getSelectedRow() != -1 && jrSeVaACorregir.isSelected()) {
            
            //Modificacion de una venta ya existente.
            cliente = new Cliente();
            venta = new Venta();
            //Captura desde tabla del idVenta.
            venta.setIdVenta(Integer.parseInt(jtTodasLasVentas.getValueAt(jtTodasLasVentas.getSelectedRow(), 0) + ""));  
            //Captura desde tabla del idCliente y fecha(modificadas o no).
            venta.setFechaVenta((Date.valueOf(jtTodasLasVentas.getValueAt(jtTodasLasVentas.getSelectedRow(), 2)+"")).toLocalDate());
            cliente.setIdCliente((int) Long.parseLong(jtTodasLasVentas.getValueAt(jtTodasLasVentas.getSelectedRow(), 1)+""));
            venta.setCliente(cliente);    
            veData.modificarVenta(venta);//Envio de solicitud de modificacion hacia BD.
            
            jcbClientesRegistrados.setSelectedIndex(-1);//Se deja el combo box sin seleccion alguna.
            jcbClientesRegistrados.setSelectedItem(null);
            jdcSeleccionFecha.setDate(null);//Se reinicia la seleccion del calendario
  
        }else{
            
            //Registro de Venta nueva.
            venta = new Venta();
            try{
                venta.setCliente(cliente);
                int i = (int) cliente.getIdCliente();
            }catch(NullPointerException npe){
                JOptionPane.showMessageDialog(this, "No se lecciono ningun cliente."
                            + "\nIntente nuevamente. "+npe.getMessage());
                venta = null;
                cliente = null;
                jdcSeleccionFecha.setDate(null);
                jcbClientesRegistrados.setSelectedIndex(-1);
                jcbClientesRegistrados.setSelectedItem(null);
                return;
            }
            if(jrbFechaActual.isSelected()){
                //Se emplea fecha actual segun sistema.
                venta.setFechaVenta(LocalDate.now(ZoneId.systemDefault()));
                
            }else{
                
                try{//Se emplea una fecha seleccionada del calendario.
                    venta.setFechaVenta(dcFecha(jdcSeleccionFecha));
                }catch(NullPointerException npe){
                    JOptionPane.showMessageDialog(this, "No se selecciono ninguna fecha en el calendario."
                            + "\nIntente nuevamente.");
                    venta = null;
                    cliente = null;
                    jdcSeleccionFecha.setDate(null);
                    jcbClientesRegistrados.setSelectedIndex(-1);
                    jcbClientesRegistrados.setSelectedItem(null);
                    return;
                }
                
            }
            veData.registraVenta(venta);//Envio de solicitud de registro hacia BD.
            
            venta = null;
            cliente = null;
            jdcSeleccionFecha.setDate(null);
            jcbClientesRegistrados.setSelectedIndex(-1);
            jcbClientesRegistrados.setSelectedItem(null);          
        }
    }//GEN-LAST:event_jbRegistrarVentaActionPerformed
    //--------------------------------------------------------------------------
    //Este evento brinda informacion sobre como realizar un modificacion
    private void jrSeVaACorregirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrSeVaACorregirMouseClicked
        
        if(jrSeVaACorregir.isSelected()){
            JOptionPane.showMessageDialog(this, "Puede modificar la fecha o el idCliente, o ambos."+
                "\nPrimero presione el boton <Limpiar Datos y Botones>."+
                "\nModifique manualmente los valores en la tabla derecha (fecha/idCliente)"+
                "\nLuego para asentar la modificacion presione el boton <Registrar venta>."+
                "\n(formato fecha aaaa-mm-dd >>> ¡¡¡respete los guiones medios!!!)");
        }
        
    }//GEN-LAST:event_jrSeVaACorregirMouseClicked
    //--------------------------------------------------------------------------
    //Eventos de ordenamiento.
    private void jrXdniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXdniMouseClicked
        ordenamiento(jrB, jtTodasLasVentas, jrXdni, "dni");
    }//GEN-LAST:event_jrXdniMouseClicked
    private void jrXidVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXidVentaMouseClicked
        ordenamiento(jrB, jtTodasLasVentas, jrXidVenta, "idVenta");
    }//GEN-LAST:event_jrXidVentaMouseClicked
    private void jrXidClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXidClienteMouseClicked
        ordenamiento(jrB, jtTodasLasVentas, jrXidCliente, "idCliente");
    }//GEN-LAST:event_jrXidClienteMouseClicked
    //Evento de reseteo de funcionalidades de vista.
    private void jbLimpiarYResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarYResetearActionPerformed
        resetearCamposBotonesTablasYCombo();
    }//GEN-LAST:event_jbLimpiarYResetearActionPerformed
    //Eventos de ordenamiento.
    private void jrXFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXFechaMouseClicked
        ordenamiento(jrB, jtTodasLasVentas, jrXFecha, "fechaVenta");
    }//GEN-LAST:event_jrXFechaMouseClicked
    private void jrXnombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXnombreMouseClicked
        ordenamiento(jrB, jtTodasLasVentas, jrXnombre, "nombre");
    }//GEN-LAST:event_jrXnombreMouseClicked
    private void jrXapellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrXapellidoMouseClicked
        ordenamiento(jrB, jtTodasLasVentas, jrXapellido, "apellido");
    }//GEN-LAST:event_jrXapellidoMouseClicked
    //--------------------------------------------------------------------------
    private void jdcSeleccionFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jdcSeleccionFechaMouseClicked
        jrbFechaActual.setSelected(false);
    }//GEN-LAST:event_jdcSeleccionFechaMouseClicked
    //--------------------------------------------------------------------------
    private void jcbClientesRegistradosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbClientesRegistradosItemStateChanged
        //Obtencion del objeto Cliente desde ComboBox
        if(jcbClientesRegistrados.getSelectedIndex()!= -1){
        cliente = jcbClientesRegistrados.getItemAt(jcbClientesRegistrados.getSelectedIndex());       
        //Busqueda de ventas anteriores del cliente seleccionado en BD, y presentacion en tabla.
        refrescarTabla(jtVentasDe1Cliente);
        Collection<Venta> ventas = veData.listarVentasDeUnCliente(cliente.getIdCliente());
        ventas.forEach((aux) -> {modelo.addRow(new Object[]{aux.getIdVenta(), aux.getFechaVenta()});});
        jbRegistrarVenta.setEnabled(true);
        //El cliente que se instancio en la primer linea se usa al registrar una nueva venta.
        }
    }//GEN-LAST:event_jcbClientesRegistradosItemStateChanged
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbLimpiarYResetear;
    private javax.swing.JButton jbRegistrarVenta;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Cliente> jcbClientesRegistrados;
    private com.toedter.calendar.JDateChooser jdcSeleccionFecha;
    private javax.swing.JLabel jlFechaActual;
    private javax.swing.JLabel jlFormato;
    private javax.swing.JRadioButton jrDescendente;
    private javax.swing.JRadioButton jrSeVaACorregir;
    private javax.swing.JRadioButton jrXFecha;
    private javax.swing.JRadioButton jrXapellido;
    private javax.swing.JRadioButton jrXdni;
    private javax.swing.JRadioButton jrXidCliente;
    private javax.swing.JRadioButton jrXidVenta;
    private javax.swing.JRadioButton jrXnombre;
    private javax.swing.JRadioButton jrbFechaActual;
    private javax.swing.JTable jtTodasLasVentas;
    private javax.swing.JTable jtVentasDe1Cliente;
    // End of variables declaration//GEN-END:variables
//Metodos propios de la clase---------------------------------------------------
    public static void cargarComboBox(Collection<Entidades> collection, JComboBox jcb){
        collection.forEach((aux) -> {jcb.addItem(aux);});
    }
    //--------------------------------------------------------------------------
    private void cargarTablaTodasLasVentas(String campo, String orden){
        LinkedList<Venta> ventas = (LinkedList) veData.listarTodasLasVentas(campo, orden);
        for (Venta aux : ventas) {
            modelo1.addRow(new Object[]{aux.getIdVenta(),//Intentar hacer esta parte con reflexion.
                aux.getCliente().getIdCliente(), aux.getFechaVenta(),
                aux.getCliente().getDni(), aux.getCliente().getApellido(),
                aux.getCliente().getNombre()});
        }
    }  
    //--------------------------------------------------------------------------
    public static void armarCabeceraTabla(Collection<String> columnas, DefaultTableModel dftm, JTable jt){
        columnas.forEach((aux) -> {dftm.addColumn(aux);});
        jt.setModel(dftm);
    }
    //--------------------------------------------------------------------------
    public static void refrescarTabla(JTable jt){
        DefaultTableModel modelo = (DefaultTableModel) jt.getModel();
        for (int f = jt.getRowCount()-1; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }
    //--------------------------------------------------------------------------
    private void ordenamiento(Collection<JRadioButton> coll, JTable jt, JRadioButton jrbInstance,String campo){
        refrescarTabla(jt);
        for(JRadioButton aux : coll){
            if(aux.hashCode()==jrbInstance.hashCode()){
                if(aux.isSelected()){
                    coll.forEach((xua) -> {xua.setSelected(false);});
                    aux.setSelected(true);
                    if(jrDescendente.isSelected()){
                        this.cargarTablaTodasLasVentas(campo, "DESC");
                    }else{
                        this.cargarTablaTodasLasVentas(campo, "ASC");
                    }
                    return;
                } 
            }
        }      
    }
    //--------------------------------------------------------------------------
    private void resetearCamposBotonesTablasYCombo(){
        cliente = null;
        venta = null;
        cargarComboBox((LinkedList)clData.listarClientes(), jcbClientesRegistrados);
        refrescarTabla(jtTodasLasVentas);
        refrescarTabla(jtVentasDe1Cliente);
        jrXidCliente.setSelected(true);
        jrDescendente.setSelected(true);
        jrXFecha.setSelected(false);
        jrXapellido.setSelected(false);
        jrXdni.setSelected(false);
        jrXnombre.setSelected(false);
        jrXidVenta.setSelected(false);
        cargarTablaTodasLasVentas("idCliente", "DESC");
        jdcSeleccionFecha.setEnabled(true);
        jlFechaActual.setText("");
        jlFormato.setText("");
        jrbFechaActual.setSelected(false);
        jdcSeleccionFecha.setDate(null);
        jcbClientesRegistrados.setSelectedIndex(-1);
        jcbClientesRegistrados.setSelectedItem(null);
    }
    //--------------------------------------------------------------------------
    public static LocalDate dcFecha(JDateChooser jdc){//Choclo de linea para obtener una fecha en el calendario.
        return jdc.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------
}