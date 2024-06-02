package primerGuia_IntroduccionAJava;

public class Main_ejercicio11 {
    public static void main(String[] args){
        
        Triangulo triangulo = new Triangulo();
        System.out.println(triangulo.toString());
    
        triangulo = new Triangulo(7f,5f,7f);
        System.out.println(triangulo.toString());
    
        triangulo = new Triangulo(9f,9f,9f);
        System.out.println(triangulo.toString());
    
        triangulo = new Triangulo(5f,2.3f,1.01f);
        System.out.println(triangulo.toString());
        
        triangulo = null;
    }
}

class Triangulo{
    private float lado1, lado2, lado3;
    
    public Triangulo(){}
    public Triangulo(float lado1, float lado2, float lado3){
        this.lado1 = (lado1>0)? lado1 : 1f;
        this.lado2 = (lado2>0)? lado2 : 1f;
        this.lado3 = (lado3>0)? lado3 : 1f;
    }

    public float getLado1() {
        return lado1;
    }

    public void setLado1(float lado1) {
        this.lado1 = (lado1>0)? lado1 : this.lado1;
    }

    public float getLado2() {
        return lado2;
    }

    public void setLado2(float lado2) {
        this.lado2 = (lado2>0)? lado2 : this.lado2;
    }

    public float getLado3() {
        return lado3;
    }

    public void setLado3(float lado3) {
        this.lado3 = (lado3>0)? lado3 : this.lado3;
    }
    
    public boolean esUnTriangulo(){
        return ((this.lado1+this.lado2)>lado3)||((this.lado1+this.lado3)>lado2)||
                ((this.lado3+this.lado2)>lado1);
    }
    
    public String tipoTriangulo(){
        if(this.lado1==this.lado2 && this.lado1==lado3 && this.lado2==this.lado3)
            return "Equilatero";
        else if((this.lado1!=this.lado2)&&(this.lado1!=this.lado3)&&(this.lado2!=this.lado3))
            return "Escaleno";
        else
            return "Isoceles";
    }

    @Override
    public String toString() {
        if(this.esUnTriangulo())
            return "Tipo : "+this.tipoTriangulo()+'{'+"lado1="+lado1+", lado2="+lado2+", lado3="+lado3+'}';
        else
            return "No es un triangulo!!!";
    }
    
    
    
}