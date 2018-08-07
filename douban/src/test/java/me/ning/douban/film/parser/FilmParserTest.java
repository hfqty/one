package me.ning.douban.film.parser;

import me.ning.douban.film.entity.DoubanFilm;
import org.junit.Test;

import java.util.List;

public class FilmParserTest {

    @Test
    public void parse() {
        String url = "https://www.douban.com/doulist/12747/";
        FilmParser filmParser = new FilmParser();
        List<DoubanFilm> doubanFilms = filmParser.parse(url);
        System.out.println(doubanFilms.size());

    }

}