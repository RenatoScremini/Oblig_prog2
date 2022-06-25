package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Consultas {

    public void Consulta1(){ //FIXME tengo que hacer que las consutlas devuelvea el tad con la informacion
        System.out.println("Entro en consulta 1");

        Scanner anio_s = new Scanner(System.in);
        System.out.println("Ingrese el año con formato yyyy");
        String  anio = anio_s.nextLine();
        String fecha1 ="01-01-"+anio;
        String fecha2 = "31-12-"+ anio;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        Date fechaInicio;
        Date fechaFinal;
        try {
            fechaInicio = formatoFecha.parse(fecha1);
            fechaFinal = formatoFecha.parse(fecha2);


        }
        catch (Exception e){
            System.out.println("Año invalido");
        }

    }
    public void Consulta2(){
        System.out.println("Entro en consulta 2");
    }
    /*public  void Consulta3(){
        System.out.println("Entro en consulta 3");

        Scanner fecha1 = new Scanner(System.in);
        System.out.println("Ingrese la fecha de inicio con formato dd-MM-yyyy");
        String  escaneoFechaInicio = fecha1.nextLine();

        Scanner fecha2 = new Scanner(System.in);
        System.out.println("Ingrese la fecha de final con formato dd-MM-yyyy");
        String  escaneoFechaFinal = fecha2.nextLine();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        Date fechaInicio;
        Date fechaFinal;

        try {
            fechaInicio = formatoFecha.parse(escaneoFechaInicio);
            fechaFinal = formatoFecha.parse(escaneoFechaFinal);

          long cantidadR = this.cantidadReseñas(fechaInicio, fechaFinal);
            System.out.println("La cantidad de reviews entre la fecha " + fechaInicio + " y " + fechaFinal + " es de " + cantidadR);

            }catch (Exception e){

            }

    }*/
    public static void Consulta4(){
        System.out.println("Entro en consulta 5"   );
    }
    public static void Consulta5(){
        System.out.println("Entro en consulta 5");
    }


}
