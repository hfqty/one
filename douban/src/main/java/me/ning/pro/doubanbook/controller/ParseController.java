package me.ning.pro.doubanbook.controller;

import me.ning.pro.doubanbook.entity.DoulistParseInputDto;
import me.ning.pro.doubanbook.entity.MsgResult;
import me.ning.pro.doubanbook.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParseController  {

    @Autowired
    private ParseService parseService;


    @PostMapping("parsedoulist")
    public MsgResult parse(DoulistParseInputDto inputDto){
        if(inputDto.cannotParse())
        return new MsgResult("数据缺失","-1");
        if(parseService.parse(inputDto)){
            return new MsgResult();
        }else{
            return new MsgResult("解析失败","-1");
        }
    }
}
