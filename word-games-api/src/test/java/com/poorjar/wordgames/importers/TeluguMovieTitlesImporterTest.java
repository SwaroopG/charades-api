package com.poorjar.wordgames.importers;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by swaroop on 8/20/17.
 */
public class TeluguMovieTitlesImporterTest {
    private static final Logger LOGGER = Logger.getLogger(TeluguMovieTitlesImporterTest.class);

    @Test
    public void testMovieNameImport() throws Exception {
        for(WikiMovieData movie : TeluguMovieTitlesImporter.getWikiMovieDataForYear(2014)) {
            LOGGER.debug(movie.toString());
        }
    }
}
