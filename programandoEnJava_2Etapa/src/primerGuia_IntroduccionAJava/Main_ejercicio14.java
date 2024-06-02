package primerGuia_IntroduccionAJava;

public class Main_ejercicio14 {
    public static void main(String[] args){
        Fecha fecha = new Fecha();
        System.out.println(fecha.toString());
        
        fecha = new Fecha((byte)15,(byte)2,(short)1908);
        System.out.println(fecha.toString());
    }
}

class Fecha{
    private byte dia, mes;
    private short anio;
    
    public Fecha(){
        this.dia = 1;
        this.mes = 1;
        this.anio = 1999;
    }
    public Fecha(byte dia, byte mes, short anio){
        this();
        this.setAnio(anio).setMes(mes).setDia(dia);//En este orden para evitar errores con el cnstrctr vacio.       
    }
    
    //Metodos setter retornan el objeto, luego de modificar o no un atributo
    public Fecha setDia(byte dia) {
        if((mes!=4&&mes!=6&&mes!=9&&mes!=11&&mes!=2)&&(dia>=1&&dia<=31)){this.dia = dia; return this;}
        if((mes==2)&&this.esBisiesto()&&(dia>=1&&dia<=29)){this.dia = dia;  return this;}
        if((mes==2)&&!this.esBisiesto()&&(dia>=1&&dia<=28)){this.dia = dia;  return this;}
        if((mes==4||mes==6||mes==9||mes==11)&&(dia>=1&&dia<=30)){this.dia = dia;  return this;}  
        return this;
    }

    public Fecha setMes(byte mes) {
        this.mes = (mes>=1&&mes<=12)? mes : this.mes;
        return this;
    }

    public Fecha setAnio(short anio) {
        this.anio = (anio>0)? anio : this.anio;
        return this;
    }  

    public byte getDia() {
        return dia;
    }

    public byte getMes() {
        return mes;
    }

    public short getAnio() {
        return anio;
    }
        
    public boolean esBisiesto(){
        return (anio%4==0 && (anio%100!=0 || anio%400==0));
        /*Algoritmo segun wikipedia para anio Bisisesto si es true ->>> (aino%4==0 && (!anio%100==0 || anio%400))*/
    }
    
    public short calcularAnios(Fecha fecha){//el anio de la fecha parametro debe ser menor al anio de la instancia que llama al metodo.            
        short anios = (short)(Math.abs(this.anio-fecha.anio));
        //El calculo es aproximado y entero
        if(this.mes > fecha.mes){
            return anios;
        }else if(this.mes < fecha.mes){
            return (short) (anios-1);
        }else{//Teniendo meses identicos
            if(this.dia == fecha.dia || this.dia > fecha.dia){
                return anios;
            }else{
                return (short) (anios-1);
            }
        }
    }
    
    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + " es bisiesto : " + this.esBisiesto() +'}';
    }
    
}
