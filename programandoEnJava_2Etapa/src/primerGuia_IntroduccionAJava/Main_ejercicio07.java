
package primerGuia_IntroduccionAJava;

public class Main_ejercicio07 {
    public static void main(String[] args){
        Cuadrilatero cuad = new Cuadrilatero(70f, 50f);
        System.out.println(cuad.toString()+"\nPerimetro : "+cuad.calcularPerimetro()
        +"\nArea : "+cuad.calcularArea()+"\nEs cuadrado ¿? : "+cuad.esUnCuadrado());
    }
}

class Cuadrilatero{
    float largo, alto;
    
    public Cuadrilatero(){
        this.largo = 1.0f;
        this.alto = 1.0f;
    }
    
    public Cuadrilatero(float largo, float alto){
        this.largo = (largo>0)? largo : 1f;
        this.alto = (alto>0)? alto : 1f;       
    }

    public float getLargo() {
        return largo;
    }

    public void setLargo(float largo) {
        this.largo = (largo>0)? largo : this.largo;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = (alto>0)? alto : this.alto;
    }
    
    public float calcularPerimetro(){
        return this.largo+this.alto;
    }
    
    public float calcularArea(){
        return this.alto*this.largo;
    }
    
    public boolean esUnCuadrado(){
        return this.alto == this.largo;
    }

    @Override
    public String toString() {
        return "Cuadrilatero{" + "largo=" + largo + ", alto=" + alto + '}';
    }
    
    
}
