package Entities;

import Tads.Hash.MyClosedHash;
import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class CargaDatos {


    private MyClosedHash<Long, Beer> listaCervezas = new MyClosedHash<>(50000);
    private MyClosedHash<Long, Brewery> listaCervecerias = new MyClosedHash(50000);
    private MyClosedHash<Long, Review> listaReviews = new MyClosedHash(50000);
    private MyClosedHash<String, Style> listaEstilos = new MyClosedHash(50000);
    private MyClosedHash<String, User> listaUser = new MyClosedHash(50000);

    public void leerCSV(String path) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        int x = 0;
        while ((line = csvReader.readNext()) != null) {
            x = agregar(line, x);
            System.out.println(x);
        }

    }

    public int agregar(String[] linea, int x) {
        //public void agregar(String[] linea){
        try {
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


            if(!existeUsuario(review_profilename)){
                User usuario = new User(review_profilename);
                listaUser.put(review_profilename, usuario);
            }

            if(!existeEstilo(beer_style)){
                Style estilo = new Style(beer_style);
                listaEstilos.put(beer_style, estilo);
            }

            if(!existeCerveceria(brewery_id)){
                Brewery cerveceria = new Brewery(brewery_id, brewery_name);
                listaCervecerias.put(brewery_id, cerveceria);
            }

            if(!existeCerveza(beer_id)){
                Style estilo1 = buscarEstilo(beer_name);
                Beer cerveza = new Beer(beer_id, beer_name, beer_abv, estilo1);
                listaCervezas.put(beer_id, cerveza);
            }

            if(!existeReview(review_id)){
                User usuario1 = buscarUsuario(review_profilename);
                Brewery cerveceria1 = buscarCerveceria(brewery_id);
                Review review = new Review(review_id, review_time, review_overall, review_aroma, review_taste, usuario1, cerveceria1, review_palate);
                listaReviews.put(review_id, review);

            }


            x++;
            return x;


        } catch (Exception e) {
            return x;
        }

    }

    public boolean existeUsuario(String username){
        return listaUser.get(username)!=null;
    }
    public User buscarUsuario(String userName){
        return listaUser.get(userName);
    }

    public boolean existeCerveza(long cerveza_id){
        return listaCervezas.get(cerveza_id)!=null;
    }
    public Beer buscarCerveza(long cerveza_id){
        return listaCervezas.get(cerveza_id);
    }

    public boolean existeCerveceria(long cerverceria_id){
        return listaCervecerias.get(cerverceria_id)!=null;
    }
    public Brewery buscarCerveceria(long cerverceria_id){
        return listaCervecerias.get(cerverceria_id);
    }

    public boolean existeEstilo(String nombre_estilo){
        return listaEstilos.get(nombre_estilo)!=null;
    }
    public Style buscarEstilo(String nombre_estilo){
        return listaEstilos.get(nombre_estilo);
    }

    public boolean existeReview(long review_id){
        return listaReviews.get(review_id)!=null;
    }
    public Review buscarReview(long review_id){
        return listaReviews.get(review_id);
    }



}



