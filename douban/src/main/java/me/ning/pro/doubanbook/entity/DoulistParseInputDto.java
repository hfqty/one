package me.ning.pro.doubanbook.entity;

import org.apache.ibatis.jdbc.Null;

public class DoulistParseInputDto {

    private String type;
    private String url;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public DoulistParseInputDto(){

    }

    public DoulistParseInputDto(String type,String url){
        this.type = type;
        this.url = url;
    }

    public int id(){
        if("id".equals(this.type))
        return Integer.parseInt(this.url);
        if("url".equals(this.type)) {
            String id = this.url.substring(this.url.lastIndexOf("/")+1);
            return Integer.parseInt(id);
        }
       return 0;
    }

    public boolean cannotParse(){
        return this.type.isEmpty()
                ||this.type==null
                ||this.url.isEmpty()
                ||this.url == null
                ||id()==0;
    }
}
