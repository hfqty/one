package chapter02.section02;

import chapter02.section01.SwingButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.util.Arrays.asList;

public class VarValue {

    public static void main(String[]args){
        SwingButton button  = new SwingButton();
        button.start();
        button.add(withLambda());
        button.add(noLambda());
    }

    public static JButton withLambda(){
        final String name = getUserName(0);
        JButton button = new JButton("with lambda ");
        button.setBounds(10,10,200,50);
        button.addActionListener(e -> System.out.println("hi " + name));
        return button;
    }
    public static JButton  noLambda(){
        final String name =getUserName(1);
        JButton button = new JButton("no lambda");
        button.setBounds(70,10,200,50);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi "+ name);
            }
        });
        return button;
    }

    public static String getUserName(int i){
        return asList("yes","no").get(i);
    }
}
