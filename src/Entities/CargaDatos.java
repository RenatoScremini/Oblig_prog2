package Entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargaDatos {

    public static void CargaDatosImp() throws IOException { // PREGUNTAR QUE ES ESTO DE IOExcepton
        BufferedReader br = new BufferedReader(new FileReader("beer_dataset_test.txt"));

        String currentLine;
        String [] linea = currentLine.split(","):

        while ((currentLine = br.readLine()) != null){
            if(linea[0] == "\\"){
                continue;

                long.parse

            }

        }
    }
}
