
package Vistas;

import AccesoADatos.ProductoData;
import Entidades.Producto;
//
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;


public class FormularioProductos extends javax.swing.JInternalFrame {
//Atributos de la clase --------------------------------------------------------    
    //Declaracion instancia producto.
    private Producto prod;
    //Instanciacion clase de servicio.
    private ProductoData pData;
//------------------------------------------------------------------------------
//Constructor-------------------------------------------------------------------
    public FormularioProductos() {
        
        this.initComponents();
        
        pData = new ProductoData();
        
        this.reestablecerCampos("", 0);
        
        // (inicial,minimo,maximo,paso)
        SpinnerNumberModel modeloStock = new SpinnerNumberModel(0,0,99999999,1);
        jsStock.setModel(modeloStock);
        
        SpinnerNumberModel modeloPrecioEntero = new SpinnerNumberModel(0,0,99999999,1);
        jsPrecioEntero.setModel(modeloPrecioEntero);
        
        SpinnerNumberModel modeloPrecioFraccion;
        modeloPrecioFraccion = new SpinnerNumberModel(10,10,99,1);
        jsPrecioFraccion.setModel(modeloPrecioFraccion);         
    }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbRegistrarProd = new javax.swing.JButton();
        jbModificarProd = new javax.swing.JButton();
        jbDiscontinuar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdProd = new javax.swing.JTextField();
        jtfNombreProd = new javax.swing.JTextField();
        jtfDescripcionProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbBuscarProd = new javax.swing.JButton();
        jbLimpiarCampos = new javax.swing.JButton();
        jsStock = new javax.swing.JSpinner();
        jsPrecioEntero = new javax.swing.JSpinner();
        jsPrecioFraccion = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDisponibilidad = new javax.swing.JLabel();

        jbRegistrarProd.setText("Registrar");
        jbRegistrarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarProdActionPerformed(evt);
            }
        });

        jbModificarProd.setText("Modificar");
        jbModificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarProdActionPerformed(evt);
            }
        });

        jbDiscontinuar.setText("Discontinuar");
        jbDiscontinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDiscontinuarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario Productos");

        jLabel2.setText("Id Producto");

        jLabel3.setText("Nombre Producto");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Precio desde Prov");

        jLabel6.setText("Stock Ingresado");

        jbBuscarProd.setText("Buscar");
        jbBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarProdActionPerformed(evt);
            }
        });

        jbLimpiarCampos.setText("Limpiar Campos");
        jbLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarCamposActionPerformed(evt);
            }
        });

        jLabel7.setText(",");

        jLabel8.setText("$");

        jLabel9.setText("Disponibilidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jsPrecioEntero, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsPrecioFraccion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jsStock, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfNombreProd)
                                            .addComponent(jtfIdProd)
                                            .addComponent(jtfDescripcionProd)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbRegistrarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbModificarProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbDiscontinuar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbLimpiarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDescripcionProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jsPrecioEntero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsPrecioFraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jsStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jDisponibilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegistrarProd)
                    .addComponent(jbDiscontinuar)
                    .addComponent(jbBuscarProd)
                    .addComponent(jbModificarProd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarCampos)
                    .addComponent(jbSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Eventos-----------------------------------------------------------------------
    private void jbLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarCamposActionPerformed
        reestablecerCampos("",0);     
    }//GEN-LAST:event_jbLimpiarCamposActionPerformed
    //--------------------------------------------------------------------------
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        prod = null;
        //pData.cerrar();
        pData = null;
        this.dispose();     
    }//GEN-LAST:event_jbSalirActionPerformed
    //--------------------------------------------------------------------------
    private void jbRegistrarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarProdActionPerformed
        if(jtfIdProd.getText().isEmpty()){           
            if(errorEnAtributos())//Verificacion de campos.
                return;    
            prod = instanciarDesdeCampos();
            pData.registrarProducto(prod);//Envio de inf hacia BD.   
            //No se emite ningun aviso aqui, clase ProductoData lo hace si resulta exitoso el impacto en BD.             
            reestablecerCampos("",0);
            prod = null;
        }else{    
            JOptionPane.showMessageDialog(this, "Id producto sera asignado por"
                    + " BD;\ndeje el campo(Id) vacio y intente nuevamente.");
        }
        
    }//GEN-LAST:event_jbRegistrarProdActionPerformed
    //--------------------------------------------------------------------------
    //Este metodo no permite dar de baja un producto; para ello esta el boton "Discontinuar".
    private void jbModificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarProdActionPerformed
        if(errorEnAtributos()){//Verificacion de campos.            
            return;
        }else{
            try{
                pData.modificarProducto(instanciarDesdeCampos(prod));
            }catch(NullPointerException npe){
                JOptionPane.showMessageDialog(this, "Debe realizar la busqueda de un"
                    + " producto por su Id primeramente.");
                return;
            }
            jtfIdProd.setEditable(true);//Se habilita el campo ID producto.
            jtfIdProd.setEnabled(true);
            reestablecerCampos("",0);
            prod = null;
        } 
    }//GEN-LAST:event_jbModificarProdActionPerformed
    //--------------------------------------------------------------------------
    private void jbBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarProdActionPerformed
        if(hayLetras(jtfIdProd.getText())||jtfIdProd.getText().isEmpty()){//Verificacion del campo ID.            
            JOptionPane.showMessageDialog(this, "Id productos acepta numeros"
                    + " unicamente\nsin ningun tipo de puntuacion,letra o "
                    + "espacio en blanco.");
            return;          
        }else if(excedeLongitudMax(jtfIdProd.getText(), 11)){ 
            JOptionPane.showMessageDialog(this, "Demasiados digitos!! Verifique"
                    + "que sea correcto el Id introducido.");
            return;
        }       
        //Solicitud de informacion a BD, e instanciacion si fuera posible.
        prod = pData.buscarProductoXId(Integer.parseInt(jtfIdProd.getText()+""));   
        
        //Presentacion de la informacion(del producto encontrado en BD).
        jtfIdProd.setText(prod.getIdProducto()+"");
        jtfDescripcionProd.setText(prod.getDescripcion());
        jtfNombreProd.setText(prod.getNombreProducto());
        
        String precio = prod.getPrecioActual()+"";//Precio en Spinners
        
        jsPrecioEntero.setValue((int)prod.getPrecioActual());
        
        try{
            jsPrecioFraccion.setValue(Integer.parseInt(precio.substring((precio.length()-2), (precio.length()))));
        } catch(StringIndexOutOfBoundsException | NumberFormatException SIOOBNFE){
            jsPrecioFraccion.setValue(0);
        }
        
        jsStock.setValue(prod.getStock());  
        
        if(prod.isEstado()){
            jDisponibilidad.setText("Disponible");
        }else{
            jDisponibilidad.setText("NoDisponible");
        }
        
        jtfIdProd.setEditable(false);//Se bloquea el campo Id para evitar errores al modificar o eliminar.
        jtfIdProd.setEnabled(false);    
        jbRegistrarProd.setEnabled(false);//Evita que se intente registrar lo que se busco.
        jbBuscarProd.setEnabled(false);//Evita que se intente buscar lo que ya se busco.
    }//GEN-LAST:event_jbBuscarProdActionPerformed
    //--------------------------------------------------------------------------
    private void jbDiscontinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDiscontinuarActionPerformed
        try{
            if(!prod.isEstado()){ 
                JOptionPane.showMessageDialog(this, "El probucto ya fue dado de"
                        + " baja con anterioridad.");
                return;
            }else{
                pData.eliminarProducto(prod.getIdProducto());//Envio de solicitud de baja a BD.
            }
        }catch(NullPointerException npe){
            JOptionPane.showMessageDialog(this, "Debe realizar la busqueda de un"
                    + " producto por su Id primeramente.");
        }
        prod = null;
        reestablecerCampos("",0);
    }//GEN-LAST:event_jbDiscontinuarActionPerformed
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jDisponibilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbBuscarProd;
    private javax.swing.JButton jbDiscontinuar;
    private javax.swing.JButton jbLimpiarCampos;
    private javax.swing.JButton jbModificarProd;
    private javax.swing.JButton jbRegistrarProd;
    private javax.swing.JButton jbSalir;
    private javax.swing.JSpinner jsPrecioEntero;
    private javax.swing.JSpinner jsPrecioFraccion;
    private javax.swing.JSpinner jsStock;
    private javax.swing.JTextField jtfDescripcionProd;
    private javax.swing.JTextField jtfIdProd;
    private javax.swing.JTextField jtfNombreProd;
    // End of variables declaration//GEN-END:variables
//Metodos propios de la clase---------------------------------------------------    
    private void reestablecerCampos(String cad, int entero){
        jtfDescripcionProd.setText(cad);
        jtfNombreProd.setText(cad);
        jtfIdProd.setText(cad);
        jsPrecioEntero.setValue(entero);
        jsPrecioFraccion.setValue(entero);
        jsStock.setValue(entero);
        jtfIdProd.setEditable(true);
        jtfIdProd.setEnabled(true); 
        jDisponibilidad.setText("");
        jbRegistrarProd.setEnabled(true);
        jbBuscarProd.setEnabled(true);
    }
    //--------------------------------------------------------------------------
    public static boolean hayLetras(String cadena){
        for(char car : cadena.toCharArray()){
            if(Character.isLetter(car)) return true;
        }
        return false;
    }
    //--------------------------------------------------------------------------
    public static boolean excedeLongitudMax(String cadena, int dimMax){
        return cadena.length()>dimMax;
    }
    //--------------------------------------------------------------------------
    private boolean hayCamposVacios(){   
        return (jtfNombreProd.getText().isEmpty() || 
                jtfDescripcionProd.getText().isEmpty() ||
                    jsPrecioEntero.getValue().equals(0) || 
                        jsStock.getValue().equals(0));     
    }
    //--------------------------------------------------------------------------
    private boolean errorEnAtributos(){  
        if(hayCamposVacios()){
            JOptionPane.showMessageDialog(this, "Ha dejado uno o mas"
                    + " campos vacios, o con valores no admisibles.");
            return true;
        }
            
        if(excedeLongitudMax(jtfNombreProd.getText(), 60)||
                excedeLongitudMax(jtfDescripcionProd.getText(), 100)){
            JOptionPane.showMessageDialog(this, "Nombre o descripcion o ambos "
                    + "campos excede la longitud permitida.");
            return true;
        }
        
        return false;
    }
    //--------------------------------------------------------------------------
    //Este metodo se emplea al momento de registrar un nuevo producto.
    private Producto instanciarDesdeCampos(){      
        Producto prodx = new Producto();
        prodx.setNombreProducto(jtfNombreProd.getText().toLowerCase());
        prodx.setDescripcion(jtfDescripcionProd.getText().toLowerCase());
        prodx.setPrecioActual(Double.parseDouble(jsPrecioEntero.getValue()+"."+jsPrecioFraccion.getValue()));
        prodx.setStock(Integer.parseInt(jsStock.getValue()+""));
        prodx.setEstado(true);//En este caso no se solicita, pues se supone se va a registrar un producto disponible p/la venta.    
        
        return prodx;
        
    }
    //--------------------------------------------------------------------------
    //Este metodo se emplea al momento de modificar un producto.
    private Producto instanciarDesdeCampos(Producto producto){   
        Producto prodx = new Producto();
        prodx.setIdProducto(producto.getIdProducto());
      
        prodx.setNombreProducto(jtfNombreProd.getText().toLowerCase());
        prodx.setDescripcion(jtfDescripcionProd.getText().toLowerCase());
        prodx.setPrecioActual(Double.parseDouble(jsPrecioEntero.getValue()+"."+jsPrecioFraccion.getValue()));
        prodx.setStock(Integer.parseInt(jsStock.getValue()+""));
        prodx.setEstado(true);//En este caso no se solicita, pues se supone se va a registrar un producto disponible p/la venta.    
        
        return prodx;       
    } 
    //--------------------------------------------------------------------------
//------------------------------------------------------------------------------
}