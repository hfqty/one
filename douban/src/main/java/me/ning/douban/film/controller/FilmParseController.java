package me.ning.douban.film.controller;

import me.ning.douban.film.dto.DouListParseInputDTO;
import me.ning.douban.film.dto.OperationResult;
import me.ning.douban.film.entity.DouList;
import me.ning.douban.film.parser.DouListParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/douban/film/doulist")
public class FilmParseController {

    @GetMapping("/parse")
    public OperationResult parse(DouListParseInputDTO inputDTO){
        OperationResult<DouList> result = new OperationResult<>();
        DouListParser douListParser = new DouListParser(inputDTO.id());
        DouList douList = douListParser.parse();
        result.setData(douList);
        return result;
    }
}
