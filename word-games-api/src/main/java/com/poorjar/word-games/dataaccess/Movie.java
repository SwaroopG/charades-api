package com.poorjar.charades.dataaccess;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Movie.
 *
 * @author Swaroop
 * @since 1.0
 */
@Document(collection = "movie")
public class Movie implements Serializable {
    @Id
    private String movieId;
    private String title;
    private String description;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public final void setTitle(String title) {
        this.title = title;
    }


    public final String getTitle() {
        return title;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Movie[id=%s, title='%s', description='%s']", movieId, title, description);
    }

}
