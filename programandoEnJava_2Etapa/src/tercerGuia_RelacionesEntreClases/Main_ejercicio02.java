
package tercerGuia_RelacionesEntreClases;

import java.util.Arrays;

public class Main_ejercicio02 {
    
    public static void main(String[] args){
        
        Auto auto = new Auto("AA-XC89-3C", Color.VERDE);
        auto.setRuedas(new Rueda[] {new Rueda("Piretti").inflar(), new Rueda("Piretti").inflar(),
                        new Rueda("Mickelin"), new Rueda("BuenAnio").inflar()});
        
        System.out.println(auto.toString());
        
        System.out.println(auto.avanzar(99.3F)+"\n"+auto.avanzar(99.3F)+"\n"+
                            auto.avanzar(592.3F)+"\n"+auto.avanzar(592.3F)+"\n"+
                                auto.avanzar(29.3F)+"\n"+auto.avanzar(199.3F)+"\n"+
                                    auto.avanzar(129.3F));
        
        System.out.println(auto.toString());

    }
}

class Auto{
    private String patente;
    private Color color;
    private Rueda[] ruedas;
    private float combustible;
    
    public Auto() { combustible= 50.0F;}
    public Auto(String patente, Color color) {
        this();
        this.color= color;
        this.patente= patente;
    }
    
    public String getPatente() { return patente;}
    public Color getColor() { return color;}
    public void setColor(Color color) { this.color = color;}
    public void setRuedas(Rueda[] ruedas) { this.ruedas = ruedas;}
    
    
    public String avanzar(float distancia) {
        if(this.combustible>= Math.abs(distancia)*0.1){
            this.combustible-= Math.abs(distancia)*0.1;
            return "*Avanza* : "+Math.abs(distancia);
        }else{
            return "No te da la nafta!";
        }
    }
    
    public String retroceder(float distancia) {
          if(this.combustible>= Math.abs(distancia)*0.1){
            this.combustible-= Math.abs(distancia)*0.1;
            return "*Retrocede* : "+Math.abs(distancia);
        }else{
            return "No te da la nafta!";
        }
    }
    
    public void llenarTanque(){ this.combustible= 50.0F;}

    @Override
    public String toString() {
        return "Auto{" + "patente=" + patente + ", color=" + color + ",\n ruedas=" + Arrays.toString(ruedas) + ",\n combustible=" + combustible + '}';
    }
    
    
}

class Rueda{
    private String marca;
    private float presion;
    
    public Rueda(){ presion= 14.7F;}   
    public Rueda(String marca){
        this();
        this.marca= marca;
    }
    
    public Rueda inflar() { 
        this.presion= 28.0F;
        return this;
    } 
       
    public void desinflar() { this.presion= (this.presion-0.1F< 14.7)? 14.7F : this.presion-0.1F;}
    //desinflar() no reducira la presion por debajo de la presion atmosferica std(14.7)

    public void pinchar() { this.presion= 14.7F;}

    public String getMarca() { return marca;}

    public void setMarca(String marca) { this.marca = marca;}

    @Override
    public String toString() { return "Rueda{" + "marca=" + marca + ", presion=" + presion + '}';}
        
}

enum Color{
    AZUL,
    VERDE,
    ROJO,
    AMARILLO,
    GRIS,
    NEGRO,
    BLANCO,
    TORNASOLADO;
}