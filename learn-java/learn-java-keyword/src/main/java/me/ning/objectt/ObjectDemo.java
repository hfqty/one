package me.ning.objectt;

import me.ning.bean.User;

public class ObjectDemo {


    public static void main(String []args) throws CloneNotSupportedException {
        User user = new User();
        user.setUsername("yuyu");
        user.setPassword("123123123");
        User user1 = (User) user.clone();
        System.out.println(user1.getPassword());
        System.out.println("user1.getUsername() = " +user1.getUsername());

    }
}
