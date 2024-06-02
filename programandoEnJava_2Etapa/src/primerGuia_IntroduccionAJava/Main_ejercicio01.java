
package primerGuia_IntroduccionAJava;

public class Main_ejercicio01 {

    public static void main(String[] args) {
        Producto cafeteria;
        
        cafeteria = new Producto(3381562165l, "Cafe molido", 995.23D, 7820);
        System.out.println(cafeteria.toString());
        
        cafeteria = new Producto(3998562165l, "Cafe Instantaneo", 2499.99D, 1550);
        System.out.println(cafeteria.toString());
        
        cafeteria = new Producto(1180362165l, "Cafe en saquitos x 20", 850.00D, 12000);
        System.out.println(cafeteria.toString());
        
        cafeteria = null;
        
        Producto cerveza;
        
        cerveza = new Producto();
        System.out.println(cerveza.toString());
        try {
            cerveza.setCodigo(5595136216l);
            cerveza.setDescripcion("Cerveza tipo Pilsen");
            cerveza.setPrecio(998.89);
            cerveza.setStock(99);
            System.out.println(cerveza.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+" >>> en primer prueba");
        }
        
        try {
            cerveza.setCodigo(5595106216l);
            cerveza.setDescripcion("cerveza Tipo Pilsen");
            cerveza.setPrecio(1098.89);
            cerveza.setStock(29);
            System.out.println(cerveza.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+" >>> en segunda prueba");
            System.out.println(cerveza.toString());
        }
        
    }
    
}
//Definicion de clase
class Producto{
    //Atributos
    private long codigo;
    private String descripcion;
    private double precio;
    private int stock;
    //Constructores
    public Producto(){
        this.codigo = 0;
        this.descripcion = "";
        this.precio = 0.0;
        this.stock = 0;
    }
    public Producto(long codigo, String descripcion, double precio, int stock){
        this.codigo = (codigo>0)? codigo : 0;
        this.descripcion = (descripcion.equals(""))? "Descripcion no disponible" : descripcion.toUpperCase();
        this.precio = (precio>0)? precio : 0.0;
        this.stock = (stock>0)? stock : 0;
    }
    //Metodos
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) throws Exception {
        if(this.codigo == codigo) 
            throw new Exception("El codigo asignado es identico al anterior");
        else
            this.codigo = (codigo>0)? codigo : this.codigo;
    }       

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) throws Exception {
        if(this.descripcion.equalsIgnoreCase(descripcion)) 
            throw new Exception("La descripcion asignada es identica a la anterior");
        else
            this.descripcion = (descripcion.equals(""))? "Descripcion no disponible" : descripcion.toUpperCase();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws Exception {
        if(this.precio == precio){ 
            throw new Exception("El precio asignado es identico al anterior.");
        }else{
            this.precio = (precio>0)? precio : this.precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws Exception {
        if(this.stock == stock) 
            throw new Exception("El stock asignado es identico al anterior.");
        else
            this.stock = (stock>0)? stock : this.stock;
    }

    @Override
    public String toString() {
        return "Producto : "+descripcion+" </> Codigo : "+codigo+" </> Stock Disponible : "+stock+" </> Precio unitario : $"+precio;
    }  
}
