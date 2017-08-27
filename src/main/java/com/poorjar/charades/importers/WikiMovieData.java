package com.poorjar.charades.importers;

/**
 * @author Swaroop G
 */
public class WikiMovieData {
    int year;
    String title;
    String dubTitle;
    String director;
    String cast;
    String genre;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        genre = genre;
    }

    public String getDubTitle() { return dubTitle;}

    public void setDubTitle(String dubTitle) { this.dubTitle = dubTitle; }

    @Override
    public String toString() {
        return "WikiMovieData[title=" + title + " dubTitle=" +dubTitle + " director=" + director + " cast=" + cast + " year=" + year + "]";
    }
}