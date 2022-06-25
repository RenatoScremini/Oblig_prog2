package Entities;

import java.util.Date;

public class Review {
    private long id;

    private Date date;

    private double overallScore;

    private double aromaScore;

    private double flavourScore;

    private User user;

    private Brewery cerveceria;

    private double review_palate;

    public long beer_id;

    public Review(long id, Date date, double overallScore, double aromaScore, double flavourScore, User user, Brewery cerveceria, double review_palate,long beer_id) {
        this.id = id;
        this.date = date;
        this.overallScore = overallScore;
        this.aromaScore = aromaScore;
        this.flavourScore = flavourScore;
        this.user = user;
        this.cerveceria = cerveceria;
        this.review_palate = review_palate;
        this.beer_id = beer_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public double getAromaScore() {
        return aromaScore;
    }

    public void setAromaScore(double aromaScore) {
        this.aromaScore = aromaScore;
    }

    public double getFlavourScore() {
        return flavourScore;
    }

    public void setFlavourScore(double flavourScore) {
        this.flavourScore = flavourScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Brewery getCerveceria() {
        return cerveceria;
    }

    public void setCerveceria(Brewery cerveceria) {
        this.cerveceria = cerveceria;
    }

    public double getReview_palate() {
        return review_palate;
    }

    public void setReview_palate(double review_palate) {
        this.review_palate = review_palate;
    }
}
