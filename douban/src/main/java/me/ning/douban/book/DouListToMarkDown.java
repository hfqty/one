package me.ning.douban.book;

import me.ning.douban.book.entity.DouList;
import me.ning.douban.book.parser.DouListParser;

public class DouListToMarkDown {

    public static void main(String[] args) {
     /*   DouListToMarkDown douListToMarkDown = new DouListToMarkDown();
        douListToMarkDown
                .setid(1264675)//9分
                .setid(1246984)//入门
                .setid(1757387)//9-9.7
                .setid(723364)//二十世纪
                //.setid(14090587)//开智
               // .setid(43430373)//2500
                //.setid(31441)//编程
        ;*/
        DouList douList = new DouList();
        douList
                .id(1264675)//9分
                .id(1246984)//入门
                .id(1757387)//9-9.7
                .id(723364)//二十世纪
                .id(14090587)//开智
                .id(31441)//编程
                .id(43430373)//2500
                .id(73746)
        .id(444550)
        ;

        DouListParser douListParser = new DouListParser(douList);
        douListParser.parse();
    }


}
