package me.ning.douban.film.entity;

import java.util.Arrays;

public class DoubanFilm {

    private String href;
    private String title;
    private String rate;
    private String rateNum;
    private String ratePeople;
    private String ratePeopleNum;
    private String image;
    private String comment;
    private String[] abstracts;
    private String doc;
    private String main;
    private String type;
    private String nation;
    private String years;

    public DoubanFilm(String url, String title, String rating, String rating_nums, String rating_people, String post, String[] abstracts) {
        this.href = url;
        this.title = title;
        this.rate = rating;
        this.rateNum = rating_nums;
        this.ratePeople = rating_people;
        this.image = post;
        this.abstracts = abstracts;
        setRatePeopleNum(rating_people);
        Abstracts();
    }

    public DoubanFilm(String href, String title, String rate, String rateNum, String ratePeople, String image, String comment, String[] abstracts) {
        this.href = href;
        this.title = title;
        this.rate = rate;
        this.rateNum = rateNum;
        this.ratePeople = ratePeople;
        this.image = image;
        this.comment = comment;
        this.abstracts = abstracts;
        Abstracts();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateNum() {
        return rateNum;
    }

    public void setRateNum(String rateNum) {
        this.rateNum = rateNum;
    }

    public String getRatePeople() {
        return ratePeople;
    }

    public void setRatePeople(String ratePeople) {
        this.ratePeople = ratePeople;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getAbstracts() {
        return abstracts;
    }

    public String absToStr(){
        StringBuffer buffer = new StringBuffer();
        for(String a :abstracts){
            buffer.append(a);
        }
        return buffer.toString();
    }

    public void setAbstracts(String[] abstracts) {
        this.abstracts = abstracts;
    }

    public String getRatePeopleNum() {
        return ratePeopleNum;
    }

    public void setRatePeopleNum(String ratePeople) {
//        this.ratePeopleNum = ratePeople.substring(1,ratePeople.indexOf("人"));
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    private void Abstracts(){
        String abstractss = absToStr();
        System.out.println(abstractss);
        if(abstractss.contains("纪录片")){
            this.doc = abstractss.substring(abstractss.indexOf("导演:"),abstractss.indexOf("类型"));
            this.type=abstractss.substring(abstractss.indexOf("类型"),abstractss.indexOf("制片"));
            this.nation = abstractss.substring(abstractss.indexOf("制片"),abstractss.indexOf("年份"));
            this.years = abstractss.substring(abstractss.indexOf("年份"));
        }else {
            if(abstractss.contains("导演")) {
                if(abstractss.contains("类型")) {
                    this.doc = abstractss.substring(abstractss.indexOf("导演:"), abstractss.indexOf("主演"));
                    this.main = abstractss.substring(abstractss.indexOf("主演:"), abstractss.indexOf("类型"));
                    this.nation = abstractss.substring(abstractss.indexOf("制片国家"), abstractss.indexOf("年份"));
                    this.type = abstractss.substring(abstractss.indexOf("类型"), abstractss.indexOf("制片"));
                    this.years = abstractss.substring(abstractss.indexOf("年份:"));
                }else{
                    this.doc = abstractss.substring(abstractss.indexOf("导演"),abstractss.indexOf("主演"));
                    this.main = abstractss.substring(abstractss.indexOf("主演"),abstractss.indexOf("制片"));
                    this.nation = abstractss.substring(abstractss.indexOf("制片"),abstractss.indexOf("年份"));
                    this.years = abstractss.substring(abstractss.indexOf("年份"));
                }
            }else{
                this.main = abstractss.substring(abstractss.indexOf("主演"),abstractss.indexOf("类型"));
                this.type = abstractss.substring(abstractss.indexOf("类型"),abstractss.indexOf("制片"));
                this.nation = abstractss.substring(abstractss.indexOf("制片"),abstractss.indexOf("年份"));
                this.years = abstractss.substring(abstractss.indexOf("年份"));
            }
        }
    }

    @Override
    public String toString() {
        return "DoubanFilm{" +
                "href='" + href + '\'' +
                ", title='" + title + '\'' +
                ", rate='" + rate + '\'' +
                ", rateNum='" + rateNum + '\'' +
                ", ratePeople='" + ratePeople + '\'' +
                ", ratePeopleNum='" + ratePeopleNum + '\'' +
                ", image='" + image + '\'' +
                ", comment='" + comment + '\'' +
                ", abstracts=" + Arrays.toString(abstracts) +
                ", doc='" + doc + '\'' +
                ", main='" + main + '\'' +
                ", nation='" + nation + '\'' +
                ", years='" + years + '\'' +
                '}';
    }
}
