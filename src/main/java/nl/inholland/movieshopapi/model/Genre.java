package nl.inholland.movieshopapi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {

    }

    public String getName() {
        return name;
    }
}
