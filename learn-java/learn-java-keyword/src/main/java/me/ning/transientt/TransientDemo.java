package me.ning.transientt;

import me.ning.bean.User;

import java.io.*;

public class TransientDemo {

    public static void main(String[]args){
        User user = new User();
        user.setPassword("123123");
        user.setUsername("Zhangning");

        System.out.println("read before serializable");
        System.out.println("username : " + user.getUsername());
        System.err.println("password : " + user.getPassword());

        try{
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("files/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            File file = new File("user.txt");
            System.out.println(file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(fis);
            user= (User) is.readObject();
            is.close();
            System.out.println("\n read after serializable");
            System.out.println("username ="+user.getUsername());
            System.out.println("passwrod = " + user.getPassword());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
