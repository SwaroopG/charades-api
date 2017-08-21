package com.poorjar.wordgames.importers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;

/**
 * Wikipage Ex: https://en.wikipedia.org/wiki/Special:Export/List_of_Telugu_films_of_2000
 *
 * @author Swaroop G
 */
public class TeluguMovieTitlesImporter {
    private static final Logger LOGGER = Logger.getLogger(TeluguMovieTitlesImporter.class);

    public static List<WikiMovieData> getWikiMovieDataForYear(int year) throws Exception {
        return getWikiMovieDataForYears(year, year);
    }

    public static List<WikiMovieData> getWikiMovieDataForYears(int startYear, int endYear) throws Exception {
        LOGGER.debug("Importing Telugu Movie Names from Wikipedia for years [" + startYear + " - " + endYear + "]");
        List<WikiMovieData> movieNames = Lists.newArrayList();

        for (int year = startYear; year <= endYear; year++) {
            Document wikiPage = Jsoup.connect("http://en.wikipedia.org/wiki/List_of_Telugu_films_of_" + year).get();
            Elements wikiTable = wikiPage.select("table.wikitable");
            LOGGER.debug("Movie name tables found on wiki page [" + wikiTable.size() + "].");

            boolean ignoreFirstTable = wikiTable.size() > 2; // Box Office Collections Table
            boolean firstElementIgnored = false;

            // There can be multiple tables on the page. So going through all tables(elements).
            for (Element element : wikiTable) {
                if (ignoreFirstTable && firstElementIgnored) {
                    traveseElements(element, movieNames, year);
                }
                if (ignoreFirstTable && !firstElementIgnored) {
                    firstElementIgnored = true;
                }
            }

            LOGGER.debug("Total Movie names found [" + movieNames.size() + "].");
        }
        return movieNames;
    }

    private static void traveseElements(Element element, List<WikiMovieData> movieNames, int year) {
        for (Element childElement : element.children()) {
            if (childElement.tagName().equals("tr")) {
                WikiMovieData movieName = new WikiMovieData();

                boolean isMovie = false;
                for (Element td : childElement.children()) {

                    if (!td.getElementsByTag("i").isEmpty()) {
                        movieName.setTitle(td.text());
                        movieName.setYear(year);
                        isMovie = true;

                        Elements childElements = td.siblingElements();
                        if (!childElements.isEmpty()) {
                            int index = 0;
                            List<String> cast = Lists.newArrayList();
                            int size = childElements.size();
                            for (Element celement : childElements) {
                                String elementText = celement.text();
                                if (index == 0 && !isNumber(elementText) && !celement.hasAttr("rowspan") && !celement.hasAttr("style")) {
                                    movieName.setDirector(elementText);
                                } else if (index > 0 && index < size - 1 && !elementIsGenre(elementText)) {
                                    cast.add(elementText);
                                }
                                if (celement.hasAttr("rowspan") || celement.hasAttr("style")) {
                                    index -= 1;
                                }
                                index++;
                            }
                            movieName.setCast(cast.toString());
                        }
                    }
                }
                if (isMovie) {
                    movieNames.add(movieName);
                }
            } else {
                traveseElements(childElement, movieNames, year);
            }
        }
    }

    private static boolean isNumber(String elementText) {
        try {
            Integer.parseInt(elementText);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static boolean elementIsGenre(String elementText) {
        Matcher m1 = Pattern.compile("Romance").matcher("");
        Matcher m2 = Pattern.compile("Action").matcher("");
        Matcher m3 = Pattern.compile("Comedy").matcher("");
        Matcher m4 = Pattern.compile("Fiction").matcher("");
        Matcher m5 = Pattern.compile("Musical").matcher("");

        return m1.reset(elementText).matches() || m2.reset(elementText).matches() || m3.reset(elementText).matches() ||
            m4.reset(elementText).matches() || m5.reset(elementText).matches();
    }
}