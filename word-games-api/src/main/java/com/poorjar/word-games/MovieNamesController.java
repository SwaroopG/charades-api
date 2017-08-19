package com.poorjar.charades;

import com.poorjar.charades.dataaccess.Movie;
import com.poorjar.charades.dataaccess.MovieRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by sgaddameedhi on 8/23/2016.
 */
@RestController
@EnableAutoConfiguration
public class TeluguMovieNamesController {
    private static final Logger LOGGER = Logger.getLogger(TeluguMovieNamesController.class);

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/movies/all")
    public List<Movie> getAllTeluguMovies() {
        LOGGER.debug("Retrieving All Movies");
        return this.movieRepository.findAll();
    }

    /**
     * Creates movie documents with the provided info.
     *
     * @param movies The movie documents to be created.
     * @return Collection of newly created movies.
     */
    @RequestMapping(value = "/movie/create", method = RequestMethod.POST)
    public Collection<Movie> create(@RequestBody Collection<Movie> movies) {
        LOGGER.debug("Adding movie documents. " + movies);
        return this.movieRepository.save(movies);
    }

    @RequestMapping(value = "/upload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
    public String fileUpload(@RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws IOException {
        LOGGER.debug("Uploading Files!");
        for(MultipartFile uploadedFile : uploadFiles) {
            LOGGER.debug("Uploading File: " + uploadedFile.getOriginalFilename());
            File file = new File(CharadesAPIApplication.UPLOAD_DIR + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "Success";
    }
}
