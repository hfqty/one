package me.ning.douban.film.entity;

import java.util.List;

public class DouList {

    private int id;
    private Creater creater;
    private List<DoubanFilm> doubanFilms;

    public DouList(int id) {
        this.id = id;
    }

    public DouList(Creater creater, List<DoubanFilm> doubanFilms) {
        this.creater = creater;
        this.doubanFilms = doubanFilms;
    }

    public DouList(int id, Creater creater, List<DoubanFilm> doubanFilms) {
        this.id = id;
        this.creater = creater;
        this.doubanFilms = doubanFilms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Creater getCreater() {
        return creater;
    }

    public void setCreater(Creater creater) {
        this.creater = creater;
    }

    public List<DoubanFilm> getDoubanFilms() {
        return doubanFilms;
    }

    public void setDoubanFilms(List<DoubanFilm> doubanFilms) {
        this.doubanFilms = doubanFilms;
    }

    @Override
    public String toString() {
        return "DouList{" +
                "id=" + id +
                ", creater=" + creater +
                ", doubanFilms=" + doubanFilms +
                '}';
    }
}
