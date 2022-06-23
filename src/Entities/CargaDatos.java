package Entities;

import Exceptions.YaExiste;
import Tads.MyClosedHash;
import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class CargaDatos {


    private MyClosedHash<Long, Beer> listaCervezas = new MyClosedHash<>(50000);
    private MyClosedHash<Long, Brewery> listaCervecerias = new MyClosedHash(50000);
    private MyClosedHash<Long, Review> listaReviews = new MyClosedHash(50000);
    private MyClosedHash<Long, Style> listaEstilos = new MyClosedHash(50000);
    private MyClosedHash<Long, User> listaUser = new MyClosedHash(50000);
    public void leerCSV(String path) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        int x = 0;
        while((line=csvReader.readNext()) != null){
            agregar(line);
            //System.out.println(x);
        }

    }
    //public int agregar(String[] linea,int x){
    public void agregar(String[] linea){
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
            //x++;
            //return x;

            if( listaCervezas == null || noExisteCerveza(beer_id) == false ) { // porque la priemra vez que lo leo no da qeu lsite cerveza = null?
                Beer cerveza = new Beer(beer_id, beer_name, beer_abv);
                listaCervezas.put(beer_id, cerveza);
            } else{
                throw new YaExiste();
            }
            Brewery cerveceria = new Brewery(brewery_id, brewery_name);
            if(listaCervecerias == null || noExisteCerveceria(brewery_id) ){
                listaCervecerias.put(brewery_id, cerveceria);
                // FIXME  Tengo que tambien a esto agregarle una lista con todas las cervezas qeu tenga la cervezeria
            } else{
                throw new YaExiste();
            }
            // Que tengo qeu verifacr en estilos, que existe o que onda
             Style estilo = new Style(beer_style);

            //listaEstilos.put()

            User usuario = new User(review_profilename);
            //listaUser.put();
            if(listaReviews == null || noExisteReview(review_id)){
                Review review = new Review(review_id, review_time, review_overall, review_aroma, review_taste, usuario, cerveceria,review_palate);
                listaReviews.put(review_id, review);
            }else{
                throw new YaExiste();
            }

            //FIXME me falta agregar todo a las hash que no se como hacerlo y agregar las cosas a las tablas, por ejemplo las cervezas a la lista de cervezas de las brewey


        } catch(Exception e){
           // return x;
        }

    }
    public boolean noExisteCerveza (long beer_id){ // Verificar si esta bien el lsitaCervezas.get o tengo que poner algo más
        boolean aparece = false;
        for(int i = 0; i < listaCervezas.getTableSize(); i++ ){
            if(listaCervezas.get(beer_id) == null){
                aparece = true;
            }
        }
        return aparece;
    }

    public boolean noExisteCerveceria (long brewery_id){
        boolean aparece = false;
        for(int i = 0; i < listaCervecerias.getTableSize(); i++ ){
            if(listaCervecerias.get(brewery_id) == null){
                aparece = true;
            }
        }
        return aparece;
    }
    public boolean noExisteReview (long review_id){
        boolean aparece = false;
        for(int i = 0; i < listaReviews.getTableSize(); i++ ){
            if(listaReviews.get(review_id) == null){
                aparece = true;
            }
        }
        return aparece;
    }
    /* FIXME public boolean noExisteEstilo (String estilo){
        boolean aparece = false;
        for(int i = 0; i < listaEstilos.getTableSize(); i++ ){
            if(listaEstilos.get(estilo) == null){
                aparece = true;
            }
        }
        return aparece;
    }*/


        }



