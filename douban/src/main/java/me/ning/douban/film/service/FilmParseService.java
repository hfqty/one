package me.ning.douban.film.service;

import me.ning.douban.film.dto.OperationResult;
import me.ning.douban.film.entity.Creater;
import me.ning.douban.film.entity.DouList;
import me.ning.douban.film.entity.DoubanFilm;
import me.ning.douban.film.parser.CreaterParser;
import me.ning.douban.film.parser.FilmParser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmParseService {
    public OperationResult<DouList> parse(String url){
        CreaterParser createrparser = new CreaterParser();
         FilmParser filmParser = new FilmParser();
         Creater creater  = createrparser.parse(url);
         List<DoubanFilm> doubanFilmList  = filmParser.parse(url);
         DouList douList = new DouList(creater,doubanFilmList);
         return new OperationResult(douList);
    }


}
