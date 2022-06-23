package Entities;

import Tads.MyLinkedList;

public class Style {

    private String name;

    private MyLinkedList<Beer> cervezas;

    public Style(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
