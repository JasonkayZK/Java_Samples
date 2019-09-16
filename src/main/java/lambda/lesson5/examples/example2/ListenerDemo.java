package lambda.lesson5.examples.example2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDemo {

    public static void main(String[] args) {
        JButton button1 = new JButton();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });

        JButton button2 = new JButton();
        button2.addActionListener(e -> System.out.println("Light, Camera, Action !! Lambda expressions Rocks"));

    }
}
