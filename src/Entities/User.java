package Entities;

import Tads.MyLinkedList;

public class User {
    private String username;

    private MyLinkedList<Review> review;


    private MyLinkedList<Review> reviews; // Verificar que es lo más practico una list


    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }





}
