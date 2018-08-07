package me.ning.douban.film.util;

import org.junit.Test;

public class STRTest {

    @Test
    public void nospace() {
        STR str = new STR();
        String s = str.nospace("sadfa sdfasdf asdf asdf");
        System.out.println(s);
    }
}