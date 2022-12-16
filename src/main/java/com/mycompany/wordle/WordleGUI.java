package com.mycompany.wordle;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Roman Perkmann
 */
public class WordleGUI extends JPanel implements KeyListener {

    JTextField[][] Spielfeld = new JTextField[5][6];

    JLabel[] BuchstabenFeld = new JLabel[26];
    WordleLogik WL = new WordleLogik();
    Wordledatenbank WD = new Wordledatenbank();
    int count = 0;
    timer timer = new timer();

    public WordleGUI() {
        setLayout(null);
        System.out.println(WD.getWörter());

        SetTextFields();

        Entsperren();
        //Titel Wordle
        JLabel jl = new JLabel();
        jl.setBounds(63, 10, 1000, 50);
        jl.setText("WORDLE");
        jl.setFont(new Font("HALLO", 1, 50));
        this.add(jl);

        //Button für Reset
        JButton JB = new JButton();
        JB.setBounds(40, 445, 150, 30);
        JB.setFocusable(false);
        JB.setText("NEW GAME!");
        
        Font font = new Font("HALLO", Font.BOLD, 10);
        JB.setBackground(Color.white);
        JB.setFont(font);

        this.setLayout(null);
        this.setVisible(true);
        JB.setFocusPainted(false);
        JB.addActionListener(e -> addRestartButton());
        this.add(JB);

        //Button für Timer
        JButton JB2 = new JButton();
        JB2.setBounds(180, 445, 150, 30);
        JB2.setFocusable(false);
        JB2.setText("timer");

        Font font2 = new Font("HALLO", Font.BOLD, 10);
        JB2.setBackground(Color.white);
        JB2.setFont(font2);
        this.add(JB2);

    }

    public void SetTextFields() {
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld[0].length; j++) {
                JTextField Buchstabe = new JTextField("", 100);

                Buchstabe.setBounds(i * 60 + 40, j * 60 + 80, 50, 50);
                Buchstabe.setBackground(Color.white);
                Buchstabe.setFont(new Font("Hallo", 1, 50));
                Buchstabe.addKeyListener(this);
                Buchstabe.setDocument(new LengthRestrictedDocument(1));
                Spielfeld[i][j] = Buchstabe;
                Spielfeld[i][j].setEnabled(false);
                this.add(Buchstabe);
            }
        }
    }

    public void Entsperren() {
        if (count >= 6) {
        } else {
            for (int i = 0; i < 5; i++) {

                Spielfeld[i][count].setEnabled(true);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

//Überprüfen ob Benutzer enter gedrückt hatt.
        if (e.getKeyCode() == KeyEvent.VK_ENTER && WL.WordInDatenbank(Spielfeld, count, WD)) {

//Überprüfung ob Felder ausgefühllt.
            if (WL.FelderÜberprüfen(Spielfeld, count)) {
                WL.WortÜberprüfen(WD.getWörter(), Spielfeld, count);

//Wenn alles ausgefüllt sind dann wird die Reihe Gespert.
                count++;
                WL.Verloren(count);
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < count; y++) {

                        Spielfeld[x][y].setEnabled(false);

                    }

                }
//letzte Reihe count ändern
                Entsperren();
            } else {
                JOptionPane.showMessageDialog(null, "Bitte fülle alle Felder aus ");
            }

            ((Component) e.getSource()).transferFocus();
        } else {
            if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_SHIFT && e.getKeyCode() != KeyEvent.VK_CAPS_LOCK && e.getKeyCode() != KeyEvent.VK_CONTROL && e.getKeyCode() != KeyEvent.VK_ALT && e.getKeyCode() != KeyEvent.VK_ALT_GRAPH && e.getKeyCode() != KeyEvent.VK_ESCAPE) {

                ((Component) e.getSource()).transferFocus();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

                if (((JTextField) e.getSource()).getText().length() == 0) {
                    ((Component) e.getSource()).transferFocusBackward();
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                ((Component) e.getSource()).transferFocusBackward();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addRestartButton() {
        timer.ResetTimer();
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                count = 0;
                Spielfeld[i][j].setText(null);
                Spielfeld[i][j].setBackground(null);
                Entsperren();
                Spielfeld[i][j].setEnabled(false);

            }
        }
        WD.statementword();
        count = 0;
        BuchstabenFeld = null;

    }

}
