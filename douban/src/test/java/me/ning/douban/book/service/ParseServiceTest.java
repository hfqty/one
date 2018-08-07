package me.ning.douban.book.service;

import me.ning.douban.book.entity.DoulistParseInputDto;
import org.junit.Test;

public class ParseServiceTest {

    @Test
    public void parse() {
        ParseService parseService = new ParseService();
        parseService.parse(new DoulistParseInputDto("id","3371955"));

    }
}