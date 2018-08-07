package me.ning.douban.film.parser;

import me.ning.douban.film.entity.Creater;
import me.ning.douban.film.entity.DouList;
import me.ning.douban.film.entity.DoubanFilm;
import me.ning.douban.film.util.URL;

import java.util.List;

public class DouListParser {

    private int id;
    private String url;

    public DouListParser(int id){
        this.id = id;
    }

    public DouListParser(int id, String url) {
        this.id = id;
        this.url = url;
    }
    public DouListParser(DouList douList){
        this.id = douList.getId();
    }
    public DouListParser(){

    }


    public DouList parse(){
        url = URL.get(id);
        CreaterParser createrParser = new CreaterParser();
        FilmParser filmParser = new FilmParser();
        Creater creater  =  createrParser.parse(url);
        List<DoubanFilm> doubanFilms = filmParser.parse(url);
        DouList douList = new DouList(creater,doubanFilms);
        return douList;
    }
}
