package com.poorjar.wordgames;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.collect.Lists;
import com.poorjar.wordgames.dataaccess.MovieTitle;
import com.poorjar.wordgames.dataaccess.MovieTitlesRepository;
import com.poorjar.wordgames.exception.WordGameException;
import com.poorjar.wordgames.exception.WordGameExceptionResponse;
import com.poorjar.wordgames.importers.TeluguMovieTitlesImporter;
import com.poorjar.wordgames.importers.WikiMovieData;

/**
 * @author Swaroop G
 */
@RestController
@EnableAutoConfiguration
public class MovieTitlesController extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(MovieTitlesController.class);

    @Autowired
    private MovieTitlesRepository movieRepository;

    @RequestMapping(value = "/movietitles/all", produces = "application/json")
    public List<MovieTitle> getAllTitles() {
        LOGGER.debug("Retrieving all movie titles....");
        return this.movieRepository.findAll();
    }

    /**
     * Adds movie titles.
     *
     * @param movieTitles The movie titles to be added.
     * @return Collection of newly created movie titles.
     */
    @RequestMapping(value = "/movietitles/create", method = RequestMethod.POST, produces = "application/json")
    public Collection<MovieTitle> create(@RequestBody Collection<MovieTitle> movieTitles) {
        LOGGER.debug("Adding movie titles... " + movieTitles);
        Collection<MovieTitle> titles = this.movieRepository.save(movieTitles);
        LOGGER.debug(movieTitles.toString());
        return titles;
    }

    @RequestMapping(value = "movietitles/upload", headers = ("content-type=multipart/*"), method = RequestMethod.POST, produces = "application/json")
    public String fileUpload(@RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws IOException {
        LOGGER.debug("Uploading files...");
        for (MultipartFile uploadedFile : uploadFiles) {
            LOGGER.debug("Uploading File: " + uploadedFile.getOriginalFilename());
            File file = new File(WordGamesAPIApplication.UPLOAD_DIR + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "Success";
    }

    @RequestMapping(value = "/movietitles/telugu/import", method = RequestMethod.POST, produces = "application/json")
    public List<MovieTitle> importTeluguMovieTitleFromWiki(@RequestParam("year") int year) throws Exception {
        LOGGER.debug("Importing telugu movie titles from wiki...");
        List<MovieTitle> movieTitlesByYear = Lists.newArrayList(this.movieRepository.findByYear(year));
        if (movieTitlesByYear.isEmpty()) {
            throw new WordGameException("Data already exist for year [" + year + "].");
        }
        return this.movieRepository.save(getMovieDataFromWiki(year));
    }

    private List<MovieTitle> getMovieDataFromWiki(int year) throws Exception {
        LOGGER.debug("Saving the following movie names to DB...");
        List<WikiMovieData> wikiMovieData = TeluguMovieTitlesImporter.getWikiMovieDataForYear(year);
        List<MovieTitle> movieTitles = Lists.newArrayListWithCapacity(wikiMovieData.size());

        int index = 1;
        for (WikiMovieData movie : wikiMovieData) {
            LOGGER.debug("Movie " + index++ + " - " + movie.toString());
            movieTitles.add(new MovieTitle(movie.getTitle(), movie.getDirector(), movie.getCast(), year));
        }
        return movieTitles;
    }

    @RequestMapping(value = "/movietitles/telugu/randomTitle/{year}", method = RequestMethod.GET, produces = "application/json")
    public MovieTitle getRandomTeluguTitleForTheYear(@PathVariable int year) throws Exception {
        LOGGER.debug("Finding a random telugu movie title from db for year[" + year + "]...");
        List<MovieTitle> movieTitlesByYear = Lists.newArrayList(this.movieRepository.findByYear(year));
        if (movieTitlesByYear.isEmpty()) {
            throw new WordGameException("Data not found for year [" + year + "].");
        }
        int randomNumber = new Random().nextInt(movieTitlesByYear.size());
        return movieTitlesByYear.get(randomNumber);
    }

    @RequestMapping(value = "/movietitles/telugu/randomTitle", method = RequestMethod.GET, produces = "application/json")
    public MovieTitle getRandomTeluguTitle() throws Exception {
        LOGGER.debug("Finding a random telugu movie title from db...");
        long totalMovieNameCount = this.movieRepository.count();
        if (totalMovieNameCount <= 0) {
            throw new WordGameException("Data not found in DB.");
        }
        int randomNumber = new Random().nextInt((int) totalMovieNameCount);
        return this.movieRepository.findOne(Long.valueOf(randomNumber));
    }

    @ExceptionHandler(WordGameException.class)
    public ResponseEntity<WordGameExceptionResponse> exceptionHandler(Exception ex) {
        WordGameExceptionResponse error = new WordGameExceptionResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
