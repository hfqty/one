package me.ning.douban.book.controller;

import me.ning.douban.book.entity.MsgResult;
import me.ning.douban.book.entity.DoulistParseInputDto;
import me.ning.douban.book.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/douban/book/doulist")
public class ParseController  {

    @Autowired
    private ParseService parseService;


    @PostMapping("/parse")
    public MsgResult parse(DoulistParseInputDto inputDto){
        if(inputDto.cannotParse())
        return new MsgResult("数据缺失","-1");
        if(parseService.parse(inputDto)!=null){
            return new MsgResult();
        }else{
            return new MsgResult("解析失败","-1");
        }
    }
}
