package me.ning.douban.film.parser;

import me.ning.douban.film.entity.Creater;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

public class CreaterParser {

    private final static Logger LOGGER = LoggerFactory.getLogger(CreaterParser.class);

    private String title ;
    private String image;
    private String nickName;
    private String url;
    private String time;
    private String introduction;


    public Creater parse(String url){
        long startt = System.currentTimeMillis();
        LOGGER.info("开始解析创建数据");
        Connection connection = Jsoup.connect(url).timeout(30000);
        Document douList = null;
        try{
            douList = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element body = douList.body();
        Element content = body.getElementById("content");
        Element peopleInfoDiv = peopleInfoDiv(content);
        Element avatar = getAvatar(peopleInfoDiv);
        Element meta = getMeta(peopleInfoDiv);
        Element doulist_about = getDouListAbout(content);

        title(content);
        url(avatar);
        image(peopleInfoDiv);
        nickName(meta);
         time(meta);
         introduction(doulist_about);
         Creater creater =  new Creater(this.title,this.nickName,time,this.url,this.image,this.introduction);
        System.out.println(creater);
        long end = System.currentTimeMillis();
        LOGGER.info("创建者结束："+new Date());
        LOGGER.info("耗时："+(end-startt));
        return creater;
    }


    private Element peopleInfoDiv(Element content){
        Element doulist_info = content.getElementById("doulist-info");
        Elements divs = doulist_info.getElementsByTag("div");
        Element peopleInfoDiv = divs.first();
         return peopleInfoDiv;
    }

    private Element getAvatar(Element peopleInfoDiv){
        Element avatar = peopleInfoDiv.getElementsByTag("a").first();
         return avatar;

    }

    private Element getMeta(Element peopleInfoDiv){
     Element meta = peopleInfoDiv.getElementsByClass("meta").first();
         return meta;
    }

    private Element getDouListAbout(Element content){
        return content.getElementsByClass("doulist-about").first();
    }

    private  void title(Element content) {
        Elements h1s = content.getElementsByTag("h1");
        Element h1 = h1s.first();
        String h1str= h1.text();
        this.title = h1str;
    }

    private void image(Element avatar) {
        Element image = avatar.getElementsByTag("img").first();
        String image_src = image.attr("src");
        this.image =  image_src;
    }

    private void nickName(Element meta) {
        Element a_name = meta.getElementsByTag("a").first();
         this.nickName = a_name.text()  ;
    }

    private void url(Element avatar) {
         this.url =  avatar.attr("href") ;
    }

    private void time(Element meta) {
        Element time_span = meta.getElementsByTag("span").first();
         this.time =  time_span.text();
    }

    private void introduction(Element doulist_about) {
        if(doulist_about != null)
        if(doulist_about.text()!=null)
         this.introduction = doulist_about.text();
    }
}
