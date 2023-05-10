package nl.inholland.movieshopapi.model;

import org.springframework.stereotype.Component;

//@Component
public class Movie {
    private long id;
    private String title;
    private double price;

    public Movie(long id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    public Movie(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.price = price;
    }
}
