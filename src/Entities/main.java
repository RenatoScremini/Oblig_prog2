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

            System.out.println("Seleccione la opción que desee:");
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


                }


            }catch (Exception e){
                System.out.println("Ingrese una opcion correcta");
            }
        }

       /* System.out.println("Seleccione la opción que desee:");
        System.out.println("1. Carga de datos\n" + "2. Ejecutar consultas\n" + "3. salir");*/

    }
}
