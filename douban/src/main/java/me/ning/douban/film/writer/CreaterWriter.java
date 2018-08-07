package me.ning.douban.film.writer;

import me.ning.douban.film.entity.Creater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreaterWriter {

    private static final String basepath = "D:\\Personal\\文档\\电影\\豆列\\";

    public static BufferedWriter doWrite(Creater creater,int i){
      BufferedWriter wrtr = createBufferWriter(creater,i);
      write(wrtr,creater);
        return wrtr;
    }

    private static void write(BufferedWriter writer,Creater creater){
        try {
            write(writer,creater.getTitle());
            write(writer,creater.getCreatePeople(),creater.getUrl());
            write(writer,creater.getCreate_time(),creater.getUpdate_time(),creater.getIntroduction());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(BufferedWriter writer,String title) throws IOException {
        writer.write("# "+title);
        writer.newLine();
    }
    private static void write(BufferedWriter writer,String createPeople,String p_url) throws IOException {
        writer.write("[" + createPeople + "](" + p_url+")" );
        writer.newLine();
    }
    private static void write(BufferedWriter writer,String create_time,String update_time,String introduction) throws IOException {
        writer.write("创建于："+create_time);
        writer.newLine();
        writer.write("更新于:" + update_time);
        writer.newLine();
        writer.write("描述："+introduction);
        writer.newLine();
    }
    private static BufferedWriter createBufferWriter(Creater creater,int i){
      return new BufferedWriter(createFileWriter(creater,i));
    }
    private static FileWriter createFileWriter(Creater creater , int i){
        String filepath = filePath(creater,i);
        try {
            return new FileWriter(createFile(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String filePath(Creater creater,int i){
        if(i == 0){
           return basepath+creater.getTitle() +"　by " + creater.getCreatePeople() + ".md";
        }else{
            return basepath+ creater.getTitle() + " by " + creater.getCreatePeople() + "(" + i + ")"+".md";
        }
    }


    private static File createFile(String filepath){
        File file = new File(filepath);
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
