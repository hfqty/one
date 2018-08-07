package me.ning.douban.film.writer;

import me.ning.douban.film.entity.Creater;
import me.ning.douban.film.entity.DoubanFilm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FilmWriter {

    public static void write(Creater creater , List<DoubanFilm> films){
        BufferedWriter writer = CreaterWriter.doWrite(creater,0);
        try {
            writer.newLine();
            writer.write("### 共 "+ films.size());
            write(writer,films);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void write(Creater creater, List<DoubanFilm> doubanFilms, int num, int i) throws IOException {
        List<DoubanFilm> doubanBooks = doubanFilms(doubanFilms, num, i);
        BufferedWriter writer = CreaterWriter.doWrite(creater, i);
        writer.newLine();
        writer.write("## 共" + doubanBooks.size() + "本");
        write(creater,doubanFilms);
    }
    public static List<DoubanFilm> doubanFilms(List<DoubanFilm> items, int num, int i) {
        List<DoubanFilm> doubanFilms = null;
        if ((i + 1) < num) {
            doubanFilms = items.subList(i*500,(1+i)*500);
        } else if((i+1) == num){
            if (num * 500 > items.size()) {
                doubanFilms = items.subList(i * 500, items.size());
            }
        }
        return doubanFilms;
    }

    public static void write(BufferedWriter writer,List<DoubanFilm> doubanFilms) throws IOException {
        int index = 0;
        writer.write("---");
        for(DoubanFilm doubanFilm : doubanFilms){
            index ++;
            writer.newLine();
            writer.write("## No."+(index) +" " +doubanFilm.getTitle());
            writer.newLine();
            write(writer,doubanFilm);
        }

    }

    private static void write(BufferedWriter writer, DoubanFilm doubanFilm) throws IOException {
      writer.write("评分："+doubanFilm.getRateNum());
      writer.newLine();
      writer.write("人数："+doubanFilm.getRatePeople());
      writer.newLine();
      write(writer,doubanFilm.getDoc(),doubanFilm.getMain(),doubanFilm.getType(),doubanFilm.getNation(),doubanFilm.getYears());
    }

    private static void write(BufferedWriter writer, String doc, String main, String type, String nation, String years) throws IOException {
        writer.newLine();
        if(doc != null && doc != ""){
            writer.write(doc);
            writer.newLine();
        }
        if(main != null && main != ""){
            writer.write(main);
            writer.newLine();
        }
        if(type != null&& type !=""){
            writer.write(type);
            writer.newLine();
        }
        if(nation != null && nation != ""){
            writer.write(nation);
            writer.newLine();
        }
        if(years != null && years != ""){
            writer.write(years);
            writer.newLine();
        }
        writer.newLine();

    }


}
