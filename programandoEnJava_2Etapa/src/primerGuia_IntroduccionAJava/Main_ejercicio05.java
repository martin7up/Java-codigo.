
package primerGuia_IntroduccionAJava;

public class Main_ejercicio05 {
    public static void main(String[] args){
        
        PiezaAjedrez pieza1 = new PiezaAjedrez();
        System.out.println(pieza1.toString());
        
        pieza1 = new PiezaAjedrez(TipoDePieza.TORRE, BandosDisponibles.BADO2, (byte)0, (byte)0);
        System.out.println(pieza1.toString());
    }
}

class PiezaAjedrez{
    
    TipoDePieza pieza;
    BandosDisponibles bandoElegido;
    byte posicionX, posicionY;
    boolean continuaJugando;
    
    public PiezaAjedrez(){
        this.pieza = TipoDePieza.NOSELECCIONADA;
        this.bandoElegido = BandosDisponibles.BANDONOSELECCIONADO;
        this.posicionX = -1;
        this.posicionY = -1;
        this.continuaJugando = true;
    }
    public PiezaAjedrez(TipoDePieza pieza, BandosDisponibles bandoElegido, byte posicionX, byte posicionY){
        this.pieza = pieza;
        this.bandoElegido = bandoElegido;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.continuaJugando = true;
    }

    public void setPieza(TipoDePieza pieza) {
        this.pieza = (pieza == TipoDePieza.NOSELECCIONADA)? this.pieza : pieza;
    }

    public void setBandoElegido(BandosDisponibles bandoElegido) {
        this.bandoElegido = bandoElegido;
    }

    public void setPosicionX(byte posicionX) {
        this.posicionX = (posicionX >= 0 && posicionX <= 7)? posicionX : this.posicionX;
    }

    public void setPosicionY(byte posicionY) {
        this.posicionY = (posicionY >= 0 && posicionY <= 7)? posicionY : this.posicionY;
    }

    public void setContinuaJugando() {
        this.continuaJugando = false;
    }

    @Override
    public String toString() {
        return "PiezaAjedrez{" + "pieza=" + pieza + ", bandoElegido=" + bandoElegido + ", posicionX=" + posicionX + ", posicionY=" + posicionY + ", continuaJugando=" + continuaJugando + '}';
    }
    
}

enum TipoDePieza{
    NOSELECCIONADA,
    PEON,
    TORRE,
    CABALLO,
    ALFIL,
    REINA,
    REY;
    
}

enum BandosDisponibles{
    BANDONOSELECCIONADO,
    BANDO1,
    BADO2;
}