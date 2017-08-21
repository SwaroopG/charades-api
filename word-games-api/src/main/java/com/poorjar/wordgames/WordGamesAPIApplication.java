package com.poorjar.wordgames;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WordGamesAPIApplication extends SpringBootServletInitializer {
    public static final String UPLOAD_DIR = System.getProperty("user.dir") + "/temp/";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WordGamesAPIApplication.class, MovieTitlesController.class);
    }

    public static void main(String[] args) {
        cleanAndCreateFolder();
        SpringApplication.run(WordGamesAPIApplication.class, args);
    }

    private static void cleanAndCreateFolder() {
        File tempDir = new File(UPLOAD_DIR);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
    }
}
