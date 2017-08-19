package com.poorjar.charades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;

@SpringBootApplication
@EnableAsync
public class CharadesAPIApplication extends SpringBootServletInitializer {
    public static final String UPLOAD_DIR = System.getProperty("user.dir") + "/temp/";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CharadesAPIApplication.class, TeluguMovieNamesController.class);
    }

    public static void main(String[] args) {
        cleanAndCreateFolder();
        SpringApplication.run(CharadesAPIApplication.class, args);
    }

    private static void cleanAndCreateFolder() {
        File tempDir = new File(UPLOAD_DIR);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
    }
}
