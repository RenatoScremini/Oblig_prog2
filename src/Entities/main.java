package Entities;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        boolean encendido = true;
        boolean cargaDatosRealizada = false;

        while(encendido){
            Scanner escaneado = new Scanner(System.in);
            int numEsc = Integer.parseInt(escaneado.nextLine());

            System.out.println("Seleccione la opción que quiera:");
            System.out.println("1. Carga de datos\n" + "2. Ejecutar consultas\n" + "3. salir");

            try{
                switch (numEsc){
                    case 1:
                        if(!cargaDatosRealizada){
                            cargaDatosRealizada = true;
                            CargaDatos todo = new CargaDatos();
                            todo.leerCSV("src/beer_dataset_test.csv");

                        }else{
                            System.out.println("Los datos ya fueron cargados");
                        }

                    case 2:
                        if(cargaDatosRealizada) {
                            Scanner escanoConsulta = new Scanner(System.in);
                            int numConsulta = Integer.parseInt(escaneado.nextLine());

                            System.out.println("Seleccione la consulta que quiere;");
                            System.out.println("1. Las 10 Cervezas con más reseñas en un año\n" + "2. Los 15 Catadores con más reseñas \n" + "3. Cantidad de reviews en un periodo de tiempo\n" + "4. Los 7 estilos de cerveza con mejor aroma\n" + "5. Las 5 cervezas con más reviews");
                            try {
                                switch (numConsulta) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:

                                    default:
                                        System.out.println("La opción ingresada es incorrecta");
                                        break;
                                }
                            } catch (Exception e){

                            }
                        }else{
                            System.out.println("Los datos no fueron cargados");
                        }


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
