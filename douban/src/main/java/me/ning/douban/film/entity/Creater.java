package me.ning.douban.film.entity;

import me.ning.douban.film.util.STR;

public class Creater {

    private String title;
    private String createPeople;
    private String createDate;
    private String url;
    private String avatar;
    private String introduction;
    private String create_time;
    private String update_time;


    public Creater() {
    }

    public Creater(String title, String createPeople, String createDate) {
        this.title = title;
        this.createPeople = createPeople;
        this.createDate = createDate;
    }

    public Creater(String title, String createPeople, String createDate, String url, String avatar) {
        this.title = title;
        this.createPeople = createPeople;
        this.createDate = createDate;
        this.url = url;
        this.avatar = avatar;
    }

    public Creater(String title, String createPeople, String createDate, String url, String avatar, String introduction) {
        this.title = title;
        this.createPeople = createPeople;
        this.createDate = createDate;
        this.url = url;
        this.avatar = avatar;
        this.introduction = introduction;
        String create_date = STR.nospace(createDate);
        setCreate_time(create_date);
        setUpdate_time(create_date);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_date) {

        this.create_time = createDate.substring(0,createDate.indexOf("创"));
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String create_date) {
        this.update_time = create_date.substring(create_date.indexOf("建"),create_date.indexOf("更"));
    }

    @Override
    public String toString() {
        return "创建数据{" +
                "title='" + title + '\'' +
                ", createPeople='" + createPeople + '\'' +
                ", createDate='" + createDate + '\'' +
                ", url='" + url + '\'' +
                ", avatar='" + avatar + '\'' +
                ", introduction='" + introduction + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
