
package primerGuia_IntroduccionAJava;

public class Main_ejercicio12 {
    public static void main(String[] args){
        Rabota tito = new Rabota("Tito");
        while(!tito.bateriaVacia()){
            tito.avanzar(1);
            System.out.println("Carga disponible en bateria de tito : "+tito.getBateria());
        }
            tito.avanzar(1);
            tito = null;
    }
}

class Rabota{
    private float bateria;
    private String nombre;
    
    public Rabota(){
        this.bateria = 500f;
        this.nombre = "NO_ASIGNADO";
    }
    public Rabota(String nombre){
        this.bateria = 500f;
        this.nombre = (nombre==null || nombre.isEmpty())? "NO_ASIGNADO" : nombre;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = (bateria>=0&&bateria<=500)? bateria : this.bateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre==null || nombre.isEmpty())? this.nombre : nombre;
    }
    
    public boolean bateriaVacia(){
        return this.bateria==0;
    }
    
    public void avanzar(int pasos){
        if(this.bateriaVacia()){
            System.out.println("No queda bateria para moverse.");
        }else if(this.getBateria()>=pasos*0.1){
            this.setBateria(this.bateria-((float)pasos)*0.1f);
            System.out.println("Se avanzo : "+pasos+" pasos.");
        }else{
            System.out.println("Se avanzo : "+this.getBateria()*10f);
            this.setBateria(0f);
        }
    }
}