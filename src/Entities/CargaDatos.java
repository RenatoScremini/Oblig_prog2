package Entities;

import Tads.MyClosedHash;
import Tads.MyHash;
import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.ObjectUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class CargaDatos {
    private MyClosedHash<Long, Beer> listaCervezas = new MyClosedHash();
    private MyClosedHash<Long, Brewery> listaCervecerias = new MyClosedHash();
    private MyClosedHash<Long, Review> listaReviews = new MyClosedHash();
    private MyClosedHash<Long, Style> listaEstilos = new MyClosedHash();
    private MyClosedHash<Long, User> listaUser = new MyClosedHash();

    public void leerCSV(String path) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        int x = 0;
        while((line=csvReader.readNext()) != null){
            x = agregar(line,x);
            System.out.println(x);
        }

    }

    public int agregar(String[] linea,int x){
        try{
            long review_id = Long.parseLong(linea[0]);
            long brewery_id = Long.parseLong(linea[1]);
            String brewery_name = linea[2];
            Date review_time = new Date(Long.parseLong(linea[3]) * 1000);
            double review_overall = Double.parseDouble(linea[4]);
            double review_aroma = Double.parseDouble(linea[5]);
            double review_appearance = Double.parseDouble(linea[6]);
            String review_profilename = linea[7];
            String beer_style = linea[8];
            double review_palate = Double.parseDouble(linea[9]);
            double review_taste = Double.parseDouble(linea[10]);
            String beer_name = linea[11];
            double beer_abv = Double.parseDouble(linea[12]);
            long beer_id = Long.parseLong(linea[13]);
            x++;
            return x;

            //lleno todas la beer, breweries
            // agegar todo al hash

        } catch(Exception e){
            return x;
        }

    }
    /*
    public void CargaDatos() throws IOException { // PREGUNTAR QUE ES ESTO DE IOExcepton
        BufferedReader br = new BufferedReader(new FileReader("src/beer_dataset_test.csv"));
        int contador = 0;
        String currentLine;

        br.readLine();

        MyClosedHash<Long, Beer> listaCervezas = new MyClosedHash();
        MyClosedHash<Long, Brewery> listaCervecerias = new MyClosedHash();
        MyClosedHash<Long, Review> listaReviews = new MyClosedHash();
        MyClosedHash<Long, Style> listaEstilos = new MyClosedHash();
        MyClosedHash<Long, User> listaUser = new MyClosedHash();
        int var;

        while ((currentLine = br.readLine()) != null) {
            System.out.println(contador);
            String[] linea = currentLine.split(",");
            if (!"\"Pyramid Breweries".equals(linea[2])) {  var =0;}
            else {var = 1;}// pierdo esta cerveza
            System.out.println(linea[0]);

            if (linea[12]!= null){

                //try {
                long review_id = Long.parseLong(linea[0]);
                long brewery_id = Long.parseLong(linea[1]);//FIXME que onda este error
                String brewery_name = linea[2].substring(0, linea[2].length());
                Date review_time = new Date(Long.parseLong(linea[3 + var]) * 1000);
                double review_overall = Double.parseDouble(linea[4 + var]);
                double review_aroma = Double.parseDouble(linea[5 + var]);
                double review_appearance = Double.parseDouble(linea[6 + var]);
                String review_profilename = linea[7 + var].substring(0, linea[7 + var].length());
                String beer_style = linea[8 + var].substring(0, linea[8 + var].length());
                double review_palate = Double.parseDouble(linea[9 + var]);
                double review_taste = Double.parseDouble(linea[10 + var]);
                String beer_name = linea[11 + var].substring(0, linea[11 + var].length());
                double beer_abv = Double.parseDouble(linea[12 + var]);
                long beer_id = Long.parseLong(linea[13 + var]);
                contador++;
                //Tengo que hacer todas las cosas en orden


               /*} catch (Exception e){

            }
            }
        }*/


        }



