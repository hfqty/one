package me.ning.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {


    public static void main(String []args){
        File file   = new File("filedemo.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("file.canExecute()="+file.canExecute());
        System.out.println("file.canRead()="+file.canRead());
        System.out.println("file.canWrite()="+file.canWrite());
        System.out.println("file.getAbsoluteFile()="+file.getAbsoluteFile());
        System.out.println("file.getAbsolutePath()="+file.getAbsolutePath());
        try {
            System.out.println("file.getCanonicalFile()="+file.getCanonicalFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("file.getCanonicalPath()="+file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("file.getFreeSpace()="+file.getFreeSpace());
        System.out.println("file.getName()="+file.getName());
        System.out.println("file.getParent()="+file.getParent());
        System.out.println("file.getParent()="+file.getParentFile());
    }
}
