package me.ning.douban.book.service;

import me.ning.douban.book.entity.DouList;
import me.ning.douban.book.writer.DouListWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WriteService {

    public boolean write(DouList douList){
        try {
            DouListWriter.write(douList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
