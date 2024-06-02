
package tercerGuia_RelacionesEntreClases;

public class Main_ejercicio03 {
    public static void main(String[] args){
        Hombre hombre = new Hombre();
        Robot robot = new Robot();
        
        hombre.jugarConRobot(robot);
        
        while(!robot.bateriaVacia()){
            robot.Despertar();
            hombre.jugarConRobot(robot);
        }
        
        robot.Recargar();
        robot.Despertar();
        hombre.jugarConRobot(robot);
    }
}

class Hombre{
    
    public void jugarConRobot(Robot robot){
        robot.Avanzar(500);
        robot.Retroceder(20);
        System.out.println("Quedan "+robot.energiaActual()+" unidades de energia, en el robot.");
        robot.Dormir();
    }
}

class Robot{
    private Bateria bateria;
    private boolean estaDormido;
    
    public Robot(){
        bateria = new Bateria();
        estaDormido = true;
    }
    
    public void Avanzar(int pasos){
        
        if(this.estaDormido) return;
        
        if(this.bateria.getCarga()>= Math.abs(pasos)*0.1){
            this.bateria.setCarga((short) (this.bateria.getCarga()-Math.abs(pasos)*0.1));
            System.out.println("El robot avanza : "+Math.abs(pasos)+" pasos.");
        }else{
            System.out.println("No hay suficiente energia para avanzar "+Math.abs(pasos)+" pasos.");
        }
    }
    
    public void Retroceder(int pasos){
        
        if(this.estaDormido) return;       
        
        if(this.bateria.getCarga()>= Math.abs(pasos)*0.1){
            this.bateria.setCarga((short) (this.bateria.getCarga()-Math.abs(pasos)*0.1));
            System.out.println("El robot retrocede : "+Math.abs(pasos)+" pasos.");
        }else{
            System.out.println("No hay suficiente energia para retroceder "+Math.abs(pasos)+" pasos.");
        }
    }
    
    public void Dormir(){
        this.estaDormido= true;
    }
    
    public void Despertar(){
        this.estaDormido= !(this.bateria.getCarga()> 0);
    }
    
    public void Recargar(){
        this.bateria.setCarga((short) 1000);
    }
    
    public boolean bateriaLlena(){
        return this.bateria.getCarga()== 1000;
    }
    
    public boolean bateriaVacia(){
        return this.bateria.getCarga()== 0;
    }
    
    public short energiaActual(){
        return this.bateria.getCarga();
    }
}

class Bateria{
    
    private short carga;
    
    public Bateria(){
        carga= 1000;
    }

    public short getCarga() {
        return carga;
    }

    public void setCarga(short carga) {
        this.carga = (short) ((Math.abs(carga)<= 1000)? Math.abs(carga) : this.carga);
    }
    
    
}