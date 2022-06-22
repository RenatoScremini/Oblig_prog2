package Entities;

public class Beer {
    private long id;

    private String name;

    private double abv;

    private Style estilo;


    public Beer(long id, String name, double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
        this.estilo = estilo;
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

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public Style getEstilo() {
        return estilo;
    }

    public void setEstilo(Style estilo) {
        this.estilo = estilo;
    }







}
