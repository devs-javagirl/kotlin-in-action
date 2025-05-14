package org.javagirls.chapter_5.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Button {

    public static void main(String[] args) {
        JButton button = new JButton("Click Me");

        // antes do Java 8 - instanciando classe anônima
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.printf("Cliquei no botão");
            }
        });

        // após Java 8 - utilizando lambda
        button.addActionListener(actionEvent -> {
            System.out.println("Cliquei no botão");
        });

    }
}
