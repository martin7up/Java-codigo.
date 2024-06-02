
package fravemax42;

import AccesoADatos.VentaData;
import Entidades.AnotacionMetodosGet;
import Entidades.Cliente;

import Entidades.Entidades;
import Entidades.Venta;
import Vistas.VentaFormulario;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FRAVEMAX42 {


    public static void main(String[] args) {
        
//        //Una forma de comparar una instancia dada con las presentes en una col_
//        //eccion de instancias.
//        Cliente cliente1 = new Cliente();
//        Cliente cliente2 = new Cliente();
//        Cliente cliente3 = new Cliente();
//        Cliente cliente4 = new Cliente();
//        Cliente cliente5 = new Cliente();
//
//        LinkedList<Cliente> lkst = new LinkedList<>();
//        
//        lkst.add(cliente1);
//        lkst.add(cliente2);
//        lkst.add(cliente3);
//        lkst.add(cliente4);
//        lkst.add(cliente5);
//        
//        for(Entidades aux : lkst){
//            if(aux.hashCode()==cliente4.hashCode()){
//                System.out.println(lkst.indexOf(aux));
//            }
//        }
//        
//        //Se puede hacer algo similar a lo que se puede en python, pero es nece_
//        //_sario declarar la vbl contenedora como una interfaz que implementen
//        //todos los tipos de clases, las cuales vamos a asignar a la vble conte_
//        //nedor.
//        Entidades contenedor = new Cliente();
//        System.out.println(contenedor.toString());
//        
//        Entidades nuevoContenedor = contenedor;
//        contenedor = new Venta();
//        ((Venta) contenedor).setCliente((Cliente) nuevoContenedor);
//       
//        System.out.println(contenedor.toString());

    
    
//    public static Collection<String> generarUnaFilaDeTabla(Entidades entidad) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{  
//        ArrayList<String> arrList = new ArrayList<>();
//        for (Method method : entidad.getClass().getDeclaredMethods()) {
//            if (method.isAnnotationPresent(AnotacionMetodosGet.class)) {
//                AnotacionMetodosGet anotacion = method.getAnnotation(AnotacionMetodosGet.class);
//                if(anotacion.isAnObject()){
//                    arrList.addAll(generarUnaFilaDeTabla((Entidades)method.invoke(entidad)));
//                    continue;
//                }        
//                arrList.add(anotacion.order()-1, String.valueOf(method.invoke(entidad)));
//   
//            }
//        }//Se obtuvieron los retornos de los metodos anotados
//        return arrList;
//    }

//    public static Object[] generarUnaFilaClienteDeTabla(Entidades entidad){
//        Cliente cliente = new Cliente(){
//            @Override
//            public String toString(){
//                return this.getIdCliente()+"-"+this.getDni()+"-"+this.getApellido()+
//                        "-"+this.getNombre()+"-"+this.getDomicilio()+"-"+this.getTelefono();
//            }
//        };
//        cliente = (Cliente)entidad; 
//        return cliente.toString().split("-");
//    }

//    public static Object[] generarUnaFilaDeTabla(Entidades entidad) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{  
//        Object[] object = new Object[entidad.metodosAnotados()];//Se crea el array con las posiciones necesarias     
//        Object[] objeto;
//        int i=-1;
//        boolean bool = false;
//        for (Method method : entidad.getClass().getDeclaredMethods()) {
//            i++; 
//            if (method.isAnnotationPresent(AnotacionMetodosGet.class)) {
//                AnotacionMetodosGet anotacion = method.getAnnotation(AnotacionMetodosGet.class);
//                if(anotacion.isAnObject()){
//                    bool = true;
//                    objeto = generarUnaFilaDeTabla((Entidades)method.invoke(entidad));
//                    i = i + objeto.length;
//                    object = Arrays.copyOf(object, (object.length + objeto.length - 1));
//                    System.arraycopy(objeto, 0, object, i, objeto.length);
//                    continue;
//                }
//                if(bool){
//                    object[(anotacion.order()+i-1)] = String.valueOf(method.invoke(entidad));   
//                }else{
//                    object[anotacion.order()-1] = String.valueOf(method.invoke(entidad));
//                }       
//            }
//        }
//        return object;
//    }
//        Cliente cliente = new Cliente(15, 5494562, "Diaz", "Carlos", "SanLorenzo 1123", "37845632");
//        
//        
//        Venta venta = new Venta(29, cliente, LocalDate.of(2023, 2, 14), false);
//        
//        Object[] object;
//        try {
//            object = VentaFormulario.generarUnaFilaDeTabla(venta);
//            System.out.println(Arrays.toString(object));
//        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
//            System.out.println("//ERROR//");
//        }

//        String[] string1 = new String[]{"dum","byt","krasny"};
//        String[] string2 = new String[]{"ul","hory","obchod"};
//        string1 = Arrays.copyOf(string1, (string1.length + string2.length));
//        System.arraycopy(string2, 0, string1, 3, string2.length);
//        System.out.println(Arrays.toString(string1));
             
    }
}
