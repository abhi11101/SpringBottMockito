package org.abhi.springbottmockito.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode")
    private int episode;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private double rating;
    @Column(name = "season")
    private int season;

    public Office() {
    }

    public Office(int episode, String name, String description, double rating, int season) {
        this.episode = episode;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Office{" +
                "episode=" + episode +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", season=" + season +
                '}';
    }
}
