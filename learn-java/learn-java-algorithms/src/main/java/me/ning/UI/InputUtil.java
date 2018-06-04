package me.ning.UI;

import me.ning.Sort.SortUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    private static final Scanner input = new Scanner(System.in);

    public static  List<Integer> integerList(int num){
        List<Integer> integers = new ArrayList<>(num);
        for(int i = 0;i<num;i++){
            integers.add(integer("输入第"+(i+1)+"个数字"));
        }
        return integers;
    }


    public static Integer integer(String msg){
        System.out.println(msg);
        if(input.hasNextInt()){
            return input.nextInt();
        }else{
           return integer("重试："+msg);
        }
    }


    public static String string(String msg){
        System.out.println(msg);
        if(input.hasNext()){
            return input.next();
        }
        return string("重试"+msg);
    }

    public static List<String> stringList(int num){
        if(num == 0) return null;
        List<String> strings = new ArrayList<>(num);
        for(int i = 0;i<num;i++){
            strings.add(string("输入第："+(i+1)+"个字符串"));
        }
        return strings;
    }

}
