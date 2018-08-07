package me.ning.douban.book.writer;

import me.ning.douban.book.entity.DouList;
import me.ning.douban.book.entity.DoubanBook;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class DouListWriter {
    public static void write(DouList<DoubanBook> douList) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println("写入开始：" + new Date());
        int num = fileNum(douList.getItems());
        if (num > 1) {
            for (int i = 0; i < num; i++) {
                BookWriter.write(douList.getCreater(), douList.getItems(), num, i);
            }
        } else {
            BookWriter.write(douList.getCreater(),douList.getItems());
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("写入结束：" + new Date() + "\n耗时：" + end + "ms");
    }



    private static int fileNum(List<DoubanBook> items) {
        if (items.size() < 500) {
            return 1;
        }
        if (items.size() % 500 > 1) {
            return items.size() / 500 + 1;
        }
        return items.size() / 500;
    }


}
