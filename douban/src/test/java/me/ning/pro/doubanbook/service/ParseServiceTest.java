package me.ning.pro.doubanbook.service;

import me.ning.pro.doubanbook.entity.DoulistParseInputDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParseServiceTest {

    @Test
    public void parse() {
        ParseService parseService = new ParseService();
        parseService.parse(new DoulistParseInputDto("id","3371955"));

    }
}