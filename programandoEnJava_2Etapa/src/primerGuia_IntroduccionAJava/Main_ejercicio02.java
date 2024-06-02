
package primerGuia_IntroduccionAJava;

public class Main_ejercicio02 {
    public static void main(String[] args) {
        Computadora pc1 = new Computadora(true, 17.8f, 512, "Linux-Ubuntu", "Tailandia");
        System.out.println(pc1.toString());
        
        try {
            pc1.setMemoriaRamActual(2048.00f);
            //pc1.setTamanioMonitor(22f);
            pc1.setSistOperativo("Doors");
            System.out.println(pc1.toString());
        } catch (Exception ex) {System.out.println(ex.getMessage());}
    }
}
//Definicion de clase
class Computadora{
    //Atributos
    private final boolean esPortatil;
    private float tamanioMonitor;
    private float memoriaRamActual;
    private String sistOperativo;
    private String paisDeOrigen;
    //Constructores
    public Computadora(){
        this.esPortatil = false;
        this.tamanioMonitor = 17f;
        this.memoriaRamActual = 0.00f;
        this.sistOperativo = "Linux";
        this.paisDeOrigen = "No asignado";
    }
    
    public Computadora(boolean esPortatil, float tamanioMonitor, float memoriaRamActual, String sistOperativo, String paisDeOrigen){
        this.esPortatil = esPortatil;
        this.tamanioMonitor = (tamanioMonitor<=0)? 17f : tamanioMonitor;
        this.memoriaRamActual = (memoriaRamActual<=0)? 4.0f : memoriaRamActual;
        this.sistOperativo = (sistOperativo.equals(""))? "Linux" : sistOperativo;
        this.paisDeOrigen = (paisDeOrigen.equals(""))? "No asignado" : paisDeOrigen;
    }
    //Metodos > No se permite modificar, una vez instanciado, si es portatil u origen
    public float getTamanioMonitor() {
        return tamanioMonitor;
    }

    public void setTamanioMonitor(float tamanioMonitor) throws Exception{
        if(this.isEsPortatil() || tamanioMonitor<=0) throw new Exception("ERROR : Valor no admisible para el tamanio de pantalla.");
        this.tamanioMonitor = (this.esPortatil)? this.tamanioMonitor : tamanioMonitor;
    }

    public float getMemoriaRamActual() {
        return memoriaRamActual;
    }

    public void setMemoriaRamActual(float memoriaRamActual) throws Exception {
        if(tamanioMonitor<=0) throw new Exception("ERROR : Valor no admisible para el tamanio de memoria.");
        this.memoriaRamActual = memoriaRamActual;
    }

    public String getSistOperativo() {
        return sistOperativo;
    }

    public void setSistOperativo(String sistOperativo) throws Exception {
        if(sistOperativo.equals("")) throw new Exception("ERROR : Especifique al menos un S.O.");
        this.sistOperativo = sistOperativo;
    }

    public boolean isEsPortatil() {
        return esPortatil;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    @Override
    public String toString() {
        return "Modelo portatil : "+esPortatil+" </> Pantalla : "+tamanioMonitor+" </> RAM : "+
                memoriaRamActual+" </> S.O. : "+sistOperativo+" </> Origen : "+paisDeOrigen;
    }  
    
}