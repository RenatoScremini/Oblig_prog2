package Entities;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        CargaDatos todo = new CargaDatos();
        todo.leerCSV("src/beer_dataset_test.csv");


    }
}
