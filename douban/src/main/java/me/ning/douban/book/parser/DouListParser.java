package me.ning.douban.book.parser;

import me.ning.douban.book.entity.Creater;
import me.ning.douban.book.entity.DouList;
import me.ning.douban.book.entity.DoubanBook;
import me.ning.douban.book.util.URLUtil;

import java.util.List;

public class DouListParser<T> {

    private int id;

    public DouListParser(int id){
        this.id = id;
    }
    public DouListParser(DouList<T> douList) {
        this.id = douList.getId();
    }

    public  DouList parse()  {
        String url = URLUtil.url(id);
        Creater creater = CreaterParser.creater(url);
        List<DoubanBook> items = BookParser.items(url);
        return new DouList<DoubanBook>(creater,items);

    }


}
