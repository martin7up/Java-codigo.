package primerGuia_IntroduccionAJava;

public class Main_ejercicio08 {
    public static void main(String[] args){
        Circulo circ = new Circulo(5.75f);
        System.out.println(circ.toString());
    }
}

class Circulo{
    private static final float PI = 3.14f;
    private float radio;

    public Circulo(){
        this.radio = 1;
    }
    public Circulo(float radio){
        this.radio = (radio>0)? radio : 1;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    
    public float calcularArea(){
        return this.radio*PI;
    }
    
    public float calcularPerimetro(){
        return this.radio*2*PI;
    }

    @Override
    public String toString() {
        return " Circulo{" + "radio = " + radio +
                ", Perimetro = " + calcularPerimetro()+
                ", Area = "+calcularArea()+'}';
    }
}
