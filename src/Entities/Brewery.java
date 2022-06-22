package Entities;

import Tads.MyLinkedList;

public class Brewery {

    long id;
    String name;

    private MyLinkedList<Beer> cervezas;



    public Brewery(long id, String name) {
        this.id = id;
        this.name = name;
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


}
