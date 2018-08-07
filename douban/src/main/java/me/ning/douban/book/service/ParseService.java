package me.ning.douban.book.service;

import me.ning.douban.book.entity.DouList;
import me.ning.douban.book.entity.DoulistParseInputDto;
import me.ning.douban.book.parser.DouListParser;
import org.springframework.stereotype.Service;

@Service
public class ParseService {


    public DouList parse(DoulistParseInputDto inputDto){
        DouListParser douListParser = new DouListParser(inputDto.id());
        DouList douList = douListParser.parse();
        return douList;
    }
}
