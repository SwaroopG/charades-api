package com.poorjar.wordgames.zunused;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.poorjar.wordgames.WordGamesAPIApplication;

/**
 * Created by sgaddameedhi on 8/27/2016.
 */
@Service
public class FileProcessor {
    @Async
    public void processUploadFiles() throws InterruptedException {
        File directory = new File(WordGamesAPIApplication.UPLOAD_DIR);
        String[] directoryContents = directory.list();

        List<String> fileLocations = new ArrayList<>();

        for (String fileName : directoryContents) {
            System.out.println(fileName);
            File temp = new File(String.valueOf(directory), fileName);
            fileLocations.add(String.valueOf(temp));
        }
    }

    private FileQueueFlag queueFileForProcessing() {
        return null;
    }
}
