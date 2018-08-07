package me.ning.douban.film.parser;

import me.ning.douban.film.entity.DoubanFilm;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmParser {

    private final  Logger LOGGER = LoggerFactory.getLogger(FilmParser.class);

    private String url;
    private String post;
    private String title;
    private String rating;
    private String []abstracts;
    private String rating_nums;
    private String rating_people;
    private String isPlayed;


    public  List<DoubanFilm>  parse(String url){
        long startt = System.currentTimeMillis();
        LOGGER.info("开始解析电影详情:");
        int start = 0;
        List<DoubanFilm> doubanFilms = new ArrayList<>();
        for(;;){
            List<DoubanFilm> doubanFilms1 = parse(url,start);
            start  = start +25;
            if(doubanFilms1 == null){
                break;
            }else{
                doubanFilms.addAll(doubanFilms1);
            }
            LOGGER.info("休息5秒钟");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        LOGGER.info("电影解析结束："+(end-startt));
        LOGGER.info("共："+doubanFilms.size()+"部");
        return doubanFilms;
    }

    private  List<DoubanFilm> parse(String url,int start){
        url = url + "?start="+start;
        Element body = getBody(url);
        Elements doulist_items = getItems(body);
        List<DoubanFilm> doubanFilms = parse(doulist_items);
        return doubanFilms;
    }
    private  Connection getConn(String url){
        return Jsoup.connect(url).timeout(300000);
    }

    private  Element getBody(String url){
        Document doulist = null;
        try{
            doulist = getConn(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element body  = doulist.body();
        return body;
    }

    private  Elements getItems(Element body){
        return body.getElementsByClass("doulist-item");
    }

    private  List<DoubanFilm> parse(List<Element> elements){
        if(elements == null || elements.isEmpty()){
            return null;
        }
        List<DoubanFilm> doubanFilms = new ArrayList<>();
        int index = 0;
        for(Element element :elements){
            index ++;
            DoubanFilm doubanFilm = parse(element);
            doubanFilms.add(doubanFilm);
            LOGGER.info("No 。"+ index);
        }
        return doubanFilms;
    }
    private  DoubanFilm parse(Element element){
        Element bd  = element.getElementsByClass("bd").first();
        if(bd == null || bd.text() == null){
            return null;
        }
        url(element);
        post(element);
        title(element);
        rating(element);
        abstracts(element);
        DoubanFilm doubanFilm = new DoubanFilm(this.url,this.title,this.rating,this.rating_nums,this.rating_people,this.post,this.abstracts);
        LOGGER.info(doubanFilm.toString());
     return doubanFilm;
    }

    private  Element getPostDiv(Element element){
        Element postDiv =  element.getElementsByClass("post").first() ;
        return postDiv;
    }

    private  Element getTitleDiv(Element element){
        return element.getElementsByClass("title").first();
    }

    private  Element getRatingDiv(Element element){
        return element.getElementsByClass("rating").first();
    }

    private  Element getAbstractDiv(Element element){
        return element.getElementsByClass("abstract").first();
    }

    private  void url(Element element){
        Element post_div = getPostDiv(element);
        if(post_div  == null){
            return ;
        }
        Element a = post_div.getElementsByTag("a").first();
        this.url = a.attr("href");
    }

    private void post(Element element){
        Element post_div = getPostDiv(element);
        if(post_div == null)
            return;
        Element a = post_div.getElementsByTag("a").first();
        Element img = a.getElementsByTag("img").first();
        String post = img.attr("src");
        this.post = post;
    }

    private void title(Element element){
        Element title_div = getTitleDiv(element);
        if(title_div == null){
            return;
        }
        Element a = title_div.getElementsByTag("a").first();
        this.title = a.text();
    }

    private void rating(Element element){
        Element rating_div = getRatingDiv(element);
        if(rating_div == null)
            return;
       Elements spans = rating_div.getElementsByTag("span");
       if(spans.size()<3){
           this.rating = "暂无评分";
           this.rating_nums = "";
           this.rating_people = "0";
       }else{
           Element rating_nums_div = spans.get(1);
           Element rating_peop_div = spans.get(2);
           this.rating_nums= rating_nums_div.text();
           this.rating_people = rating_peop_div.text();
       }
    }

    private void abstracts(Element element){
        Element abstract_div = getAbstractDiv(element);
        if(abstract_div == null)
            return;
        this.abstracts = abstract_div.text().split(" ");
    }
}
