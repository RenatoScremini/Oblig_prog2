package Entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class CargaDatos {

    public void CargaDatos() throws IOException { // PREGUNTAR QUE ES ESTO DE IOExcepton
        BufferedReader br = new BufferedReader(new FileReader("src/beer_dataset_test.csv"));

        String currentLine;

        br.readLine();
        while ((currentLine = br.readLine()) != null){

            String [] columna = currentLine.split(",");

            long review_id = Long.parseLong(columna[0]);
            System.out.println(review_id);
            long brewery_id = Long.parseLong(columna[1]);//FIXME que onda este error
            String brewery_name = columna[2].substring(0, columna[2].length()) ;
            Date review_time = new Date(Long.parseLong(columna[3])*1000);
            double review_overall = Double.parseDouble(columna[4]);
            double review_aroma = Double.parseDouble(columna[5]);
            double review_appearance = Double.parseDouble(columna[6]);
            double review_profilename = Double.parseDouble(columna[7]);
            String beer_style = columna[8].substring(0, columna[8].length()) ;
            double review_palate = Double.parseDouble(columna[9]);
            double review_taste = Double.parseDouble(columna[10]);
            String beer_name = columna[11].substring(0, columna[11].length()) ;
            double beer_abv = Double.parseDouble(columna[12]);
            long beer_beerid = Long.parseLong(columna[13]);
            }


        }

    public static void main(String[] args) throws IOException {
        CargaDatos carga = new CargaDatos();
        carga.CargaDatos();


    }
    }

