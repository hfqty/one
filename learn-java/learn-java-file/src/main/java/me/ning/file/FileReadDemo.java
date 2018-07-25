package me.ning.file;


import java.io.*;

public class FileReadDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("filedemo.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] buf = new byte[1024];
        int read;
        while ((read = bufferedInputStream.read(buf)) != -1) {

            System.out.print(buf + ": ");
            System.out.print(new String(buf) + " ");

        }

        System.out.println(buf.length);

        for (int i = 0; i < buf.length; i++) {
            System.out.print(i + " :　");
            if (buf[i] == 0) {
                continue;
            } else if (buf[i] > 0) {
                byte[] bytes = {buf[i]};
                System.out.print(buf[i] + " : ");
                System.out.print(new String(bytes) + " ");
                System.out.println();
            } else {
                byte[] bytes = {buf[i], buf[++i], buf[++i]};

                System.out.println(new String(bytes));
                System.out.println();


            }
        }

        String str = "这是一个中文句子";
        byte[] bytes = str.getBytes();
        System.out.println(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }
}
