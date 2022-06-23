package Entities;

import Tads.Hash.MyClosedHash;
import Tads.Hash.MyHash;

public class Brewery {

    long id;
    String name;

    private MyHash<Long ,Beer> listaCervezas;



    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
        this.listaCervezas = new MyClosedHash<>(10000);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyHash<Long, Beer> getListaCervezas() {
        return listaCervezas;
    }

    public void setListaCervezas(MyHash<Long, Beer> listaCervezas) {
        this.listaCervezas = listaCervezas;
    }
}
