/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordle;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Roman Perkmann
 */
public class Start {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(395, 530);
        frame.setIconImage(new ImageIcon("wordle.png").getImage());

        frame.setTitle("WORDLE");

        frame.setLocationRelativeTo(null);

        WordleGUI gui = new WordleGUI();

        frame.setContentPane(gui);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.white);
    }
}
