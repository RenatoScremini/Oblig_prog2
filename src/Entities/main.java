package Entities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {
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

                switch (numEsc){
                    case 1:
                        if(!cargaDatosRealizada){
                            cargaDatosRealizada = true;
                            todo.leerCSV("src/beer_dataset_test.csv");
                            todo.tamañolistas();

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
                                        Consultas consulta1 = new Consultas();
                                        consulta1.Consulta1();
                                        break;
                                    case 2:
                                        Consultas consulta2 = new Consultas();
                                        consulta2.Consulta2();
                                        break;
                                    case 3:
                                        //Consultas consulta3 = new Consultas();
                                        //consulta3.Consulta3();

                                        System.out.println("Entro en consulta 3");

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
                                            fechaInicio = formatoFecha.parse(escaneoFechaInicio);
                                            fechaFinal = formatoFecha.parse(escaneoFechaFinal);
                                            //long cantidadR;
                                            //cantidadR = todo.cantidadReseñas(fechaInicio, fechaFinal);
                                            todo.cantidadReseñas(fechaInicio, fechaFinal);

                                            //System.out.println("La cantidad de reviews entre la fecha " + fechaInicio + " y " + fechaFinal + " es de " + cantidadR);

                                        }catch (Exception e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 4:
                                        Consultas consulta4 = new Consultas();
                                        consulta4.Consulta4();
                                        break;
                                    case 5:
                                        Consultas consulta5 = new Consultas();
                                        consulta5.Consulta5();
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
