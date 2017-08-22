package com.poorjar.wordgames.dataaccess;

import java.io.Serializable;

import javax.persistence.*;

/**
 * MovieTitle Entity.
 *
 * @author Swaroop G
 */
@Entity
@Table(name = "movie_titles")
public class MovieTitle implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String title;
    private String director;
    private String crew;
    private int year;

    @Column(name = "dubtitle")
    private String dubTitle;

    MovieTitle() {
    }

    public MovieTitle(String title, String dubTitle, String director, String crew, int year) {
        this.title = title;
        this.dubTitle = dubTitle;
        this.director = director;
        this.crew = crew;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDubTitle() { return dubTitle; }

    public String getDirector() {
        return director;
    }

    public String getCrew() {
        return crew;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MovieTitle[title=" + title + " dubTitle=" + dubTitle + " director=" + director + " crew=" + crew + " year=" + year + "]";
    }
}
