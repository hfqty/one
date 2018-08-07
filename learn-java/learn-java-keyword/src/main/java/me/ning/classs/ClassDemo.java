package me.ning.classs;

import java.util.function.Function;

public class ClassDemo {


    public static void main(String []args){
        Class clazz = String.class;
        System.out.println(clazz.getFields());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.toString());
        Class clazz2 = Function.class;
        System.out.println(clazz2.toString());
        System.out.println(clazz2.toGenericString());
    }
}
