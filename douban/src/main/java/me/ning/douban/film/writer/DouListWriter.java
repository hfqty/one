package me.ning.douban.film.writer;

import me.ning.douban.film.entity.DouList;
import me.ning.douban.film.entity.DoubanFilm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class DouListWriter {

    private final static Logger LOGGER = LoggerFactory.getLogger(DouListWriter.class);


    public static void write(DouList douList) throws IOException {
        long startt = System.currentTimeMillis();
        System.out.println("开始写入"+new Date());
        int num = fileNum(douList.getDoubanFilms());
        if (num > 1) {
            for (int i = 0; i < num; i++) {
                FilmWriter.write(douList.getCreater(), douList.getDoubanFilms(), num, i);
            }
        } else {
            FilmWriter.write(douList.getCreater(),douList.getDoubanFilms());
        }
        long end = System.currentTimeMillis() - startt;
        System.out.println("写入结束：" + new Date() + "\n耗时：" + end + "ms");
    }

    private static int fileNum(List<DoubanFilm> items) {
        if (items.size() < 500) {
            return 1;
        }
        if (items.size() % 500 > 1) {
            return items.size() / 500 + 1;
        }
        return items.size() / 500;
    }
}
