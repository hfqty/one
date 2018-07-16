package chapter02.section01;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingButton {
    JFrame jFrame;


    public static void main(String[] args) {
        SwingButton swingButton = new SwingButton();

        swingButton.start();
    }

    public void start(){
        createMainPanel();
    }

    public void createMainPanel(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        jFrame = new JFrame("SwingButton");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel("Hello Label");
        jFrame.getContentPane().add(jLabel);

        jFrame.pack();
        jFrame.setVisible(true);

        JButton button = new JButton("Swing Button");
        button.setBounds(130,10,200,50);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand()+" has clicked");
            }
        });

        button.addActionListener(event-> System.out.println(event +  " has clicked2"));

        jFrame.add(button);



    }

    public void add(JComponent component){
        jFrame.add(component);
    }
}
