package me.ning.douban.film.util;

public class STR {

    public static String nospace(String str){
        String newstr = "";
        for(char c : str.toCharArray()){
            if(c != 32){
                newstr += c;
            }
        }
        return newstr;
    }
}
