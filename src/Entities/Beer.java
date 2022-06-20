package Entities;

public class Beer {

    private Long id;

    private String name;

    private Double abv;

    public Beer(Long id, String name, Double abv) {
        this.id = id;
        this.name = name;
        this.abv = abv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAbv() {
        return abv;
    }

    public void setAbv(Double abv) {
        this.abv = abv;
    }
}
