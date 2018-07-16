package chapter02.section02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class Lambdas {

    public static void main(String[]args){
        Runnable noArguments = () -> System.out.println("Hello world");
        JButton jButton = new JButton();
        ActionEvent button = new ActionEvent(jButton,1,"what is command");
        ActionListener actionListener = event -> System.out.println("十多个世纪的法国");
        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };
        BinaryOperator<Long> add = (x,y) -> x+y;
        BinaryOperator<Long> addExplicit = (Long x,Long y) -> x+y;


    }
}
