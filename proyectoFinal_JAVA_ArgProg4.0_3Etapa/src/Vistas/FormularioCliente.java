
package Vistas;

import AccesoADatos.ClienteData;
import Entidades.Cliente;
//
import static Vistas.FormularioProductos.*;
import static Vistas.VentaFormulario.*;
//
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
//
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormularioCliente extends javax.swing.JInternalFrame {
//Atributos de la clase---------------------------------------------------------    
    //Declaracion instancia cliente para almacenamiento de datos de cliente.
    private Cliente cl;
    
    //Declaracion  clase de servicio.
    private ClienteData clData;
    
    //Modelo para tabla de clientes registrados.
    private final DefaultTableModel modelo;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------
    public FormularioCliente() {
        
        initComponents();
        
        clData = new ClienteData();
        
        limpiarCamposYBotones(); 
        
        modelo = new DefaultTableModel(){//Modelo de la tabla de clientes.
            @Override
            public boolean isCellEditable(int fila, int columna){
            return false;
            }
        };
        
        armarCabeceraTabla(new LinkedList<>(Arrays.asList("Id_Cli","DNI","Apellido","Nombre","Domicilio","Telefono","Correo")), modelo, jtClientesRegistrados);
        refrescarTabla(jtClientesRegistrados);
        cargarTabla((LinkedList) clData.listarClientes(), jtClientesRegistrados);
        
        jbEliminarCliente.setEnabled(false);
        jbModificarCliente.setEnabled(false);
        jbEliminarCliente.setVisible(false);
        jbModificarCliente.setVisible(false);
        jtIdCliente.setVisible(false);
        jtIdCliente.setEnabled(false);
        
    }
//------------------------------------------------------------------------------    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalir = new javax.swing.JButton();
        jbGuardarNuevoCliente = new javax.swing.JButton();
        jbEliminarCliente = new javax.swing.JButton();
        jbModificarCliente = new javax.swing.JButton();
        jbLimpiarCampos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbBuscarXDni = new javax.swing.JButton();
        jtfDniCliente = new javax.swing.JTextField();
        jtfApellidoCliente = new javax.swing.JTextField();
        jtfNombreCliente = new javax.swing.JTextField();
        jtfTelefonoCliente = new javax.swing.JTextField();
        jtCorreoCliente = new javax.swing.JTextField();
        jtfDireccionCliente = new javax.swing.JTextField();
        jtIdCliente = new javax.swing.JTextField();
        jchkbOperacionesDelicadas = new javax.swing.JCheckBox();
        jchkbMostrarIDCliente = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientesRegistrados = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jbHaciaCampos = new javax.swing.JButton();

        setIconifiable(true);
        setAutoscrolls(true);
        setFocusCycleRoot(false);
        setPreferredSize(new java.awt.Dimension(0, 0));
        setVisible(true);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbGuardarNuevoCliente.setText("REGISTRAR NUEVO CLIENTE");
        jbGuardarNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarNuevoClienteActionPerformed(evt);
            }
        });

        jbEliminarCliente.setText("ELIMINAR CLIENTE");
        jbEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarClienteActionPerformed(evt);
            }
        });

        jbModificarCliente.setText("MODIFICAR DATOS DE CLIENTE");
        jbModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarClienteActionPerformed(evt);
            }
        });

        jbLimpiarCampos.setText("LIMPIAR");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CLIENTES REGISTRADOS");

        jbBuscarXDni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fravemax/Imagicon/Buscar.png")));
        jbBuscarXDni.setText("BUSCAR CLIENTE");
        jbBuscarXDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarXDniActionPerformed(evt);
            }
        });

        jtfDniCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDniCliente.setText("dni");
        jtfDniCliente.setToolTipText("");
        jtfDniCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfDniClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfDniClienteMouseExited(evt);
            }
        });

        jtfApellidoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfApellidoCliente.setText("apellido");
        jtfApellidoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfApellidoClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfApellidoClienteMouseExited(evt);
            }
        });

        jtfNombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfNombreCliente.setText("nombre");
        jtfNombreCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfNombreClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfNombreClienteMouseExited(evt);
            }
        });

        jtfTelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfTelefonoCliente.setText("telefono");
        jtfTelefonoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfTelefonoClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfTelefonoClienteMouseExited(evt);
            }
        });

        jtCorreoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCorreoCliente.setText("correo@");
        jtCorreoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCorreoClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtCorreoClienteMouseExited(evt);
            }
        });

        jtfDireccionCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfDireccionCliente.setText("direccion");
        jtfDireccionCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfDireccionClienteMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfDireccionClienteMouseExited(evt);
            }
        });

        jtIdCliente.setEditable(false);
        jtIdCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jchkbOperacionesDelicadas.setText("MODIFICACIONES");
        jchkbOperacionesDelicadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkbOperacionesDelicadasActionPerformed(evt);
            }
        });

        jchkbMostrarIDCliente.setText("INNER INF");
        jchkbMostrarIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkbMostrarIDClienteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REGISTRO DE CLIENTES");

        jtClientesRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtClientesRegistrados);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jbHaciaCampos.setText("DE LISTA A CAMPOS");
        jbHaciaCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHaciaCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbGuardarNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbBuscarXDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbHaciaCampos)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jchkbOperacionesDelicadas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jchkbMostrarIDCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbEliminarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbModificarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2)
                        .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardarNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarXDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificarCliente)
                    .addComponent(jbLimpiarCampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminarCliente)
                    .addComponent(jchkbOperacionesDelicadas)
                    .addComponent(jchkbMostrarIDCliente))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbHaciaCampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------  
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       
        //Se deja el objeto en condicion de ser eliminado al fin del prog.        
        cl = null;
        //clData.cerrar(); >>> No vuelve a reabrir la conexion en otro IFrame.
        clData = null;
        this.dispose();
        
    }//GEN-LAST:event_jbSalirActionPerformed
    //--------------------------------------------------------------------------
    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
            limpiarCamposYBotones();        
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed
    //--------------------------------------------------------------------------
    private void jbGuardarNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarNuevoClienteActionPerformed
         
        //Verificacion de campos.  
        if(comprobarCamposAlGuardOModif()){
            //Si la condicion resulta true, es que algo resulto en verdad mal.
            return;
            
        } else {
        
        //Instanciar Cliente Nuevo.
        cl = instanciarDesdeCampos();    
        
        //Envio de datos a BD y se completa el campo ID.
        jtIdCliente.setText(clData.agregarCliente(cl)+"");
        
        //Se refrezca la tabla de Clientes y se marca el agregado.
        refrescarTabla(jtClientesRegistrados);
        cargarTabla((LinkedList)clData.listarClientes(), jtClientesRegistrados);
        marcarEnTabla(jtfDniCliente, jtClientesRegistrados);
        }
        
        //Se libera el objeto Cliente.
        cl = null;
    }//GEN-LAST:event_jbGuardarNuevoClienteActionPerformed
    //--------------------------------------------------------------------------
    private void jbModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarClienteActionPerformed
        
        //Verificacion de campos.
        if(comprobarCamposAlGuardOModif()){
            //Si la condicion resulta true, es que algo resulto en verdad mal.
            return;
            
        } else {
        
        //Instanciar Cliente Modificado.
        cl = instanciarDesdeCampos();
        
        //Envio de modificaciones a BD.
        clData.modificarCliente(cl);
        
        //Se refrezca la tabla de Clientes y se marca el modificado.
        VentaFormulario.refrescarTabla(jtClientesRegistrados);
        cargarTabla((LinkedList)clData.listarClientes(), jtClientesRegistrados);
        marcarEnTabla(jtfDniCliente, jtClientesRegistrados);
        }
        
        //Se inhabilitan otras dos operaciones.
        jbModificarCliente.setEnabled(false);//Solo se permite modificar luego de buscar.
        jbEliminarCliente.setEnabled(false);//Solo se permite eliminar luego de buscar.
        
        //Se libera el objeto Cliente.
        cl = null;
    }//GEN-LAST:event_jbModificarClienteActionPerformed
    //--------------------------------------------------------------------------
    private void jbBuscarXDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarXDniActionPerformed

       //Verificacion de campos.
        
        if(comprobarCamposAlBuscar()){
            //Si la condicion de arriba resulta true, es porque VERDADERAMENTE algo salio mal.
            return;
            
        }else{
        
            //Instanciar Cliente desde BD.
       
                cl = clData.buscarClienteXDni(Long.parseLong(jtfDniCliente.getText()));
          
            //Mostrar Campos.
            
            try{
                
                jtfApellidoCliente.setText(cl.getApellido());
                jtfNombreCliente.setText(cl.getNombre());
                jtfDireccionCliente.setText(cl.getDomicilio());
                jtfTelefonoCliente.setText(cl.getTelefono());
                jtIdCliente.setText(cl.getIdCliente()+"");
                
            }catch(NullPointerException npE){
                
                JOptionPane.showMessageDialog(this, "... para el dni : "+jtfDniCliente.getText()+", no existe cliente registrado.");
                return;
                
            }
            
            //Se habilitan otras dos operaciones.
            
            jbModificarCliente.setEnabled(true);//Solo se permite modificar luego de buscar.
            jbEliminarCliente.setEnabled(true);//Solo se permite eliminar luego de buscar.
            JOptionPane.showMessageDialog(this, "Para modificar datos del cliente, altere los campos necesarios,\n"+
                                            "y por ultimo presione el boton <modificar datos de cliente>.");
            
            //Se refrezca la tabla de Clientes y se marca el buscado.
            refrescarTabla(jtClientesRegistrados);
            cargarTabla((LinkedList)clData.listarClientes(), jtClientesRegistrados);
            marcarEnTabla(jtfDniCliente, jtClientesRegistrados);
        }       
        
    }//GEN-LAST:event_jbBuscarXDniActionPerformed
    //--------------------------------------------------------------------------
    private void jchkbOperacionesDelicadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkbOperacionesDelicadasActionPerformed
        //Este evento deja ver los botones Elim y Modif si el cehckbox esta tiladado.
        if(jchkbOperacionesDelicadas.isSelected()){
            
            jbEliminarCliente.setVisible(true);
            jbModificarCliente.setVisible(true);
        }else{
            
            jbEliminarCliente.setVisible(false);
            jbModificarCliente.setVisible(false);
        }
    }//GEN-LAST:event_jchkbOperacionesDelicadasActionPerformed
    //--------------------------------------------------------------------------
    private void jchkbMostrarIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkbMostrarIDClienteActionPerformed
        //Este evento deja ver el campo ID.
        if(jchkbMostrarIDCliente.isSelected()){
            jtIdCliente.setVisible(true);
        } else {
            jtIdCliente.setVisible(false);
        }
    }//GEN-LAST:event_jchkbMostrarIDClienteActionPerformed
    //--------------------------------------------------------------------------
    //Inicio eventos para funcionalidad visual de campos.
    private void jtfDniClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDniClienteMouseClicked
        if(jtfDniCliente.getText().equals("dni"))
            jtfDniCliente.setText("");
    }//GEN-LAST:event_jtfDniClienteMouseClicked
    private void jtfDniClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDniClienteMouseExited
        if(jtfDniCliente.getText().isEmpty())
            jtfDniCliente.setText("dni");
    }//GEN-LAST:event_jtfDniClienteMouseExited
    private void jtfApellidoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfApellidoClienteMouseClicked
        if(jtfApellidoCliente.getText().equals("apellido"))
            jtfApellidoCliente.setText("");
    }//GEN-LAST:event_jtfApellidoClienteMouseClicked
    private void jtfApellidoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfApellidoClienteMouseExited
        if(jtfApellidoCliente.getText().isEmpty())
            jtfApellidoCliente.setText("apellido");
    }//GEN-LAST:event_jtfApellidoClienteMouseExited
    private void jtfNombreClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNombreClienteMouseClicked
        if(jtfNombreCliente.getText().equals("nombre"))
            jtfNombreCliente.setText("");
    }//GEN-LAST:event_jtfNombreClienteMouseClicked
    private void jtfNombreClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNombreClienteMouseExited
        if(jtfNombreCliente.getText().isEmpty())
            jtfNombreCliente.setText("nombre");
    }//GEN-LAST:event_jtfNombreClienteMouseExited
    private void jtfDireccionClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDireccionClienteMouseClicked
        if(jtfDireccionCliente.getText().equals("direccion"))
            jtfDireccionCliente.setText("");
    }//GEN-LAST:event_jtfDireccionClienteMouseClicked
    private void jtfDireccionClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDireccionClienteMouseExited
        if(jtfDireccionCliente.getText().isEmpty())
            jtfDireccionCliente.setText("direccion");
    }//GEN-LAST:event_jtfDireccionClienteMouseExited
    private void jtfTelefonoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfTelefonoClienteMouseClicked
        if(jtfTelefonoCliente.getText().equals("telefono"))
            jtfTelefonoCliente.setText("");
    }//GEN-LAST:event_jtfTelefonoClienteMouseClicked
    private void jtfTelefonoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfTelefonoClienteMouseExited
        if(jtfTelefonoCliente.getText().isEmpty())
            jtfTelefonoCliente.setText("telefono");
    }//GEN-LAST:event_jtfTelefonoClienteMouseExited
    private void jtCorreoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCorreoClienteMouseClicked
        if(jtCorreoCliente.getText().equals("correo@"))
            jtCorreoCliente.setText("");
    }//GEN-LAST:event_jtCorreoClienteMouseClicked
    private void jtCorreoClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCorreoClienteMouseExited
        if(jtCorreoCliente.getText().isEmpty())
            jtCorreoCliente.setText("correo@");
    }//GEN-LAST:event_jtCorreoClienteMouseExited
    //Fin eventos para funcionalidad visual de campos.
    //--------------------------------------------------------------------------
    private void jbHaciaCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHaciaCamposActionPerformed
        if(jtClientesRegistrados.getSelectedRowCount()!=1){
            JOptionPane.showMessageDialog(this, "...debe seleccionar una, y solo un fila de la tabla.");
            return;
        }
        
        try{
        
            //Se intenta pasar los datos de la fila en tabla a los campos.    
            jtIdCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 0)+"");
            jtfDniCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 1)+"");
            jtfApellidoCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 2)+"");
            jtfNombreCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 3)+"");
            jtfDireccionCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 4)+"");
            jtfTelefonoCliente.setText(jtClientesRegistrados.getValueAt(jtClientesRegistrados.getSelectedRow(), 5)+"");

            JOptionPane.showMessageDialog(this, "Para modificar datos del cliente, altere los campos necesarios,\n"+
                                                "y por ultimo presione el boton <modificar>.");

            //Se habilitan las opciones de modificar y eliminar sobre el cliente.
            jbModificarCliente.setEnabled(true);
            jbEliminarCliente.setEnabled(true);
        
        }catch(NullPointerException npE){
            
            JOptionPane.showMessageDialog(this, "...debe seleccionar una, y solo un fila de la tabla.");
            return;
            
        }
    }//GEN-LAST:event_jbHaciaCamposActionPerformed
    //--------------------------------------------------------------------------
    private void jbEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarClienteActionPerformed
        clData.eliminarClienteXId(Long.parseLong(jtIdCliente.getText()));
    }//GEN-LAST:event_jbEliminarClienteActionPerformed
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbBuscarXDni;
    private javax.swing.JButton jbEliminarCliente;
    private javax.swing.JButton jbGuardarNuevoCliente;
    private javax.swing.JButton jbHaciaCampos;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbModificarCliente;
    private javax.swing.JButton jbSalir;
    private javax.swing.JCheckBox jchkbMostrarIDCliente;
    private javax.swing.JCheckBox jchkbOperacionesDelicadas;
    private javax.swing.JTable jtClientesRegistrados;
    private javax.swing.JTextField jtCorreoCliente;
    private javax.swing.JTextField jtIdCliente;
    private javax.swing.JTextField jtfApellidoCliente;
    private javax.swing.JTextField jtfDireccionCliente;
    private javax.swing.JTextField jtfDniCliente;
    private javax.swing.JTextField jtfNombreCliente;
    private javax.swing.JTextField jtfTelefonoCliente;
    // End of variables declaration//GEN-END:variables
//Metodos propios de la clase---------------------------------------------------    
    private void cargarTabla(Collection<Cliente> coleccion, JTable jt){      
        try{        
            for(Cliente cliente : coleccion){
                ((DefaultTableModel) jt.getModel()).addRow(new Object[]{
                    cliente.getIdCliente(),cliente.getDni(),cliente.getApellido(),
                    cliente.getNombre(),cliente.getDomicilio(),cliente.getTelefono()
                });
            }           
        }catch(NullPointerException npE){
            JOptionPane.showMessageDialog(null, "...parece que no tienes clientes registrados!");
            npE.printStackTrace();
        }
        return;
    }
    //--------------------------------------------------------------------------
    public static void marcarEnTabla(JTextField jtf, JTable jt){
        if(jtf.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "...no se pudo marcar en tabla al cliente.");
            return;
        }
            for(int i = 0; i<jt.getRowCount(); i++){
                long j = (long) jt.getValueAt(i, 1);
                if( j == (Long.parseLong(jtf.getText()))){
                    jt.getSelectionModel().setSelectionInterval(i, i);
                    break;
                }
            }            
    }
    //--------------------------------------------------------------------------
    private void limpiarCamposYBotones(){
        
        //Limpieza de botones.
        jbBuscarXDni.setEnabled(true);
        jbEliminarCliente.setEnabled(false);
        jbGuardarNuevoCliente.setEnabled(true);
        jbModificarCliente.setEnabled(false);
        
        //Limpieza de campos.
        jtfApellidoCliente.setText("apellido");
        jtIdCliente.setText("");
        jtfNombreCliente.setText("nombre");
        jtfDireccionCliente.setText("direccion");
        jtfDniCliente.setText("dni");
        jtfTelefonoCliente.setText("telefono");
        jtCorreoCliente.setText("correo");
        
    }
    //--------------------------------------------------------------------------
    private boolean verificarCamposVacios(){
        return (jtfApellidoCliente.getText().isEmpty() || jtfNombreCliente.getText().equals("") ||
                    jtfDniCliente.getText().equals("") || jtfDireccionCliente.getText().equals("") ||
                        jtfTelefonoCliente.getText().equals(""));  
        
    }
    //--------------------------------------------------------------------------
    public static boolean hayNumeros(String cadena){
        for(char aux : cadena.toCharArray()){
            if(Character.isDigit(cadena.charAt(aux)))
                return true;
        }
        return false;
    }
    //--------------------------------------------------------------------------
    private boolean comprobarCamposAlGuardOModif(){
        
        if(excedeLongitudMax((jtfDniCliente.getText()+""), 11) || excedeLongitudMax(jtfApellidoCliente.getText(), 60) ||
                excedeLongitudMax(jtfNombreCliente.getText(), 60) || excedeLongitudMax(jtfDireccionCliente.getText(), 100) ||
                    excedeLongitudMax(jtfTelefonoCliente.getText(), 20)){
            JOptionPane.showMessageDialog(this, "...mmm, alguno de los campos excede la longitud permitida.");
            return true;
        }           
       
        if(verificarCamposVacios()){
            JOptionPane.showMessageDialog(this, "...mmm, ha dejado uno o mas campos vacios.");
            return true;
        }
        
        if(hayNumeros(jtfApellidoCliente.getText()) || hayNumeros(jtfNombreCliente.getText())){
            JOptionPane.showMessageDialog(this, "...mmm, parece que hay numeros, en los campos Nombre y/o Apellido.");
            return true;
        }
        
        if(hayLetras(jtfDniCliente.getText()) || hayLetras(jtfTelefonoCliente.getText())){
            JOptionPane.showMessageDialog(this, "...mmm, parece que hay letras o simbolos, en los campos DNI y/o Telefono.");
            return true;
        }
        
        return false;
        
    }
    //--------------------------------------------------------------------------
    private boolean comprobarCamposAlBuscar(){
        
        if(!jtfApellidoCliente.getText().isEmpty() || !jtfNombreCliente.getText().isEmpty() ||
                !jtfDireccionCliente.getText().isEmpty() || !jtfTelefonoCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "...recuerde que la busqueda de clientes es solo por dni.");
            //Este bloque solamente recuerda al usuario como hacer una busqueda de Cliente.
        }
            
        if(excedeLongitudMax((jtfDniCliente.getText()+""), 11)){
            JOptionPane.showMessageDialog(this, "...mmm, dni excede la longitud permitida.");
            return true;
        }
        
        if(jtfDniCliente.getText().equals("")){
            JOptionPane.showMessageDialog(this, "...mmm, ha dejado el campo dni vacio.");
            return true;
        }
        
        if(hayLetras(jtfDniCliente.getText())){
           JOptionPane.showMessageDialog(this, "...mmm, el campo dni no lleva letras ni puntos y tampoco espacios, solo numeros.");
            return true; 
        }
        
        return false;
        
    }
    //--------------------------------------------------------------------------
    private Cliente instanciarDesdeCampos(){
        
        Cliente cli = new Cliente();
        
        try{
            cli.setIdCliente(cl.getIdCliente());
        }catch(NullPointerException npE){
            cli.setIdCliente(Long.parseLong(jtIdCliente.getText()+""));
        }
        
        cli.setDni(Long.parseLong(jtfDniCliente.getText()));
        cli.setApellido(jtfApellidoCliente.getText().toLowerCase());
        cli.setNombre(jtfNombreCliente.getText().toLowerCase());
        cli.setDomicilio(jtfDireccionCliente.getText().toLowerCase());
        cli.setTelefono(jtfTelefonoCliente.getText().toLowerCase());
        
        return cli;
        
    }
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------ 
}