package Entities;

import Tads.Hash.MyClosedHash;
import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Timer;

public class CargaDatos {


    private MyClosedHash<Long, Beer> listaCervezas = new MyClosedHash<>(200000);
    private MyClosedHash<Long, Brewery> listaCervecerias = new MyClosedHash(200000);
    private MyClosedHash<Long, Review> listaReviews = new MyClosedHash(200000);
    private MyClosedHash<String, Style> listaEstilos = new MyClosedHash(200000);
    private MyClosedHash<String, User> listaUser = new MyClosedHash(200000);

    public void tamañolistas(){
        System.out.println("lista reviews:");
        System.out.println(listaReviews.getSize());
        System.out.println("lista user:");
        System.out.println(listaUser.getSize());
        System.out.println("lista estilos:");
        System.out.println(listaEstilos.getSize());
        System.out.println("lista cervecerias:");
        System.out.println(listaCervecerias.getSize());
        System.out.println("lista cerveza:");
        System.out.println(listaCervezas.getSize());
    }

    public void leerCSV(String path) throws IOException {

        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        int contador = 0;
        line= csvReader.readNext();
        System.out.println("Procesando datos..." );
        while ((line = csvReader.readNext()) != null) {

            agregar(line);
            contador++;
           // System.out.println(contador);

        }
        LocalDateTime nowFinal = LocalDateTime.now();

        System.out.println(contador);
        System.out.println("Datos Cargados");


    }

    public void agregar(String[] linea) {
        //public void agregar(String[] linea){

        if (!linea[0].equals("") && !linea[1].equals("") && !linea[2].equals("") && !linea[3].equals("") && !linea[4].equals("") && !linea[5].equals("") && !linea[6].equals("") && !linea[7].equals("") && !linea[8].equals("") && !linea[9].equals("") && !linea[9].equals("") && !linea[10].equals("") && !linea[11].equals("") && !linea[12].equals("") && !linea[13].equals("")) {
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


            if (listaUser.get(review_profilename) == null) {
                User usuario = new User(review_profilename);
                listaUser.put(review_profilename, usuario);
            }

            if (listaEstilos.get(beer_style) == null) {
                Style estilo = new Style(beer_style);
                listaEstilos.put(beer_style, estilo);
            }

            if (listaCervezas.get(beer_id) == null) {
                Style estilo1 = listaEstilos.get(beer_style);
                Beer cerveza = new Beer(beer_id, beer_name, beer_abv, estilo1);
                listaCervezas.put(beer_id, cerveza);
            }

            if (listaCervecerias.get(brewery_id) == null) {
                Brewery cerveceria = new Brewery(brewery_id, brewery_name);
                listaCervecerias.put(brewery_id, cerveceria);
            } else {
                listaCervecerias.get(brewery_id).getListaCervezas().put(beer_id, listaCervezas.get(beer_id));
            }

            if (listaReviews.get(review_id) == null) {
                User usuario1 = listaUser.get(review_profilename);
                Brewery cerveceria1 = listaCervecerias.get(brewery_id);
                Review review = new Review(review_id, review_time, review_overall, review_aroma, review_taste, usuario1, cerveceria1, review_palate);
                listaReviews.put(review_id, review);
            }
        }
    }

    public long cantidadReseñas(Date fechaI , Date fechaF){
        int cantidadReseñas = 0;
        for(int i = 0; i<listaReviews.getSize(); i++){
            long keyReseña = listaReviews.buscarKey(i);
            Review reviewBuscada = listaReviews.get(keyReseña);
            Date fechaReseña = reviewBuscada.getDate();
            if(fechaI.before(fechaReseña) && fechaReseña.before(fechaF)){
                cantidadReseñas++;
            }
        }
        return cantidadReseñas;
    }
}



