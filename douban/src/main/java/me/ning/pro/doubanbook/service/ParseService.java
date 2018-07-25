package me.ning.pro.doubanbook.service;

import me.ning.pro.doubanbook.entity.DouList;
import me.ning.pro.doubanbook.entity.DoulistParseInputDto;
import me.ning.pro.doubanbook.parser.DouListParser;
import org.springframework.stereotype.Service;

@Service
public class ParseService {


    public boolean parse(DoulistParseInputDto inputDto){
        DouList douList = new DouList(inputDto.id());
        DouListParser douListParser = new DouListParser(douList);
        douListParser.parse();
        return 1==1;
    }
}
