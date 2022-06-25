package Entities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class  main {
    public static void main(String[] args) throws IOException {

        boolean encendido = true;
        boolean cargaDatosRealizada = false;
        CargaDatos todo = new CargaDatos();

        while(encendido){
            Scanner escaneado = new Scanner(System.in);


            System.out.println("Seleccione la opción que quiera:");
            System.out.println("1. Carga de datos\n" + "2. Ejecutar consultas\n" + "3. salir");

            try{
                int numEsc = Integer.parseInt(escaneado.nextLine());
                long inicio = System.currentTimeMillis();
                switch (numEsc){
                    case 1:
                        if(!cargaDatosRealizada){
                            cargaDatosRealizada = true;
                            todo.leerCSV("src/beer_dataset_full.csv");
                            //todo.tamañolistas();
                            long fin = System.currentTimeMillis();
                            System.out.println(fin - inicio);

                        }else{
                            System.out.println("Los datos ya fueron cargados");
                        }

                        break;

                    case 2:
                        if(cargaDatosRealizada) {
                            Scanner escanoConsulta = new Scanner(System.in);


                            System.out.println("Seleccione la consulta que quiere;");
                            System.out.println("1. Las 10 Cervezas con más reseñas en un año\n" + "2. Los 15 Catadores con más reseñas \n" + "3. Cantidad de reviews en un periodo de tiempo\n" + "4. Los 7 estilos de cerveza con mejor aroma\n" + "5. Las 5 cervezas con más reviews");
                            try {
                                int numConsulta = Integer.parseInt(escaneado.nextLine());
                                switch (numConsulta) {
                                    case 1:

                                        System.out.println("Entro en consulta 1");

                                        Scanner anio_s = new Scanner(System.in);
                                        System.out.println("Ingrese el año con formato yyyy");
                                        String  anio = anio_s.nextLine();
                                        String fecha11 ="01-01-"+anio;
                                        String fecha21 = "31-12-"+ anio;
                                        SimpleDateFormat formatoFecha1 = new SimpleDateFormat("dd-MM-yyyy");

                                        Date fechaInicio1;
                                        Date fechaFinal1;
                                        try {
                                            long inicio1 = System.currentTimeMillis();
                                            fechaInicio1 = formatoFecha1.parse(fecha11);
                                            fechaFinal1 = formatoFecha1.parse(fecha21);
                                            todo.top10Cervezas(fechaInicio1,fechaFinal1);
                                            long fin1 = System.currentTimeMillis();
                                            System.out.println(fin1-inicio1 + "milisegundos");

                                        }
                                        catch (Exception e){
                                            System.out.println("Año invalido");
                                        }
                                        break;

                                    case 2:
                                        long inicio2 = System.currentTimeMillis();

                                        todo.top15Catadores();

                                        long fin2 = System.currentTimeMillis();
                                        System.out.println(fin2-inicio2 + "milisegundos");
                                        break;

                                        case 3:


                                        Scanner fecha1 = new Scanner(System.in);
                                        System.out.println("Ingrese la fecha de inicio con formato dd-MM-yyyy");
                                        String  escaneoFechaInicio = fecha1.nextLine();

                                        Scanner fecha2 = new Scanner(System.in);
                                        System.out.println("Ingrese la fecha de final con formato dd-MM-yyyy");
                                        String  escaneoFechaFinal = fecha2.nextLine();

                                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

                                        Date fechaInicio=null;
                                        Date fechaFinal=null;

                                        try {
                                            long inicio3 = System.currentTimeMillis();

                                            fechaInicio = formatoFecha.parse(escaneoFechaInicio);
                                            fechaFinal = formatoFecha.parse(escaneoFechaFinal);
                                            todo.cantidadReseñas(fechaInicio, fechaFinal);

                                            long fin3 = System.currentTimeMillis();
                                            System.out.println(fin3-inicio3 + "milisegundos");
                                        }catch (Exception e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 4:
                                        long inicio4 = System.currentTimeMillis();
                                        todo.top7Estilos();

                                        long fin4 = System.currentTimeMillis();
                                        System.out.println(fin4-inicio4 + "milisegundos");

                                        break;
                                    case 5:
                                        long inicio5 = System.currentTimeMillis();
                                        todo.top5Cervezas();

                                        long fin5 = System.currentTimeMillis();
                                        System.out.println(fin5-inicio5 + "milisegundos");

                                        break;

                                    default:
                                        System.out.println("La opción ingresada es incorrecta");
                                        break;
                                }
                            } catch (Exception e){

                            }
                        }else{
                            System.out.println("Los datos no fueron cargados");
                        }
                        break;


                    case 3:
                        System.out.println("El programa a finalizado");
                        encendido = false;
                        break;

                    default:
                        System.out.println("La opción ingresada es incorrecta");
                        break;


                }


            }catch (Exception e){

            }
        }

       /* System.out.println("Seleccione la opción que desee:");
        System.out.println("1. Carga de datos\n" + "2. Ejecutar consultas\n" + "3. salir");*/

    }
}
