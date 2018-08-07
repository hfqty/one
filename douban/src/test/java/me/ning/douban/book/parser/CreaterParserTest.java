package me.ning.douban.book.parser;

import me.ning.douban.film.parser.CreaterParser;
import org.junit.Test;

public class CreaterParserTest {

    @Test
    public void creater() {
        String url = "https://www.douban.com/doulist/1434921/";
        CreaterParser parser = new CreaterParser();
        parser.parse(url);
    }
}