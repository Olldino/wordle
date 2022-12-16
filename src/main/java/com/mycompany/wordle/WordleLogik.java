package com.mycompany.wordle;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WordleLogik {

    

    public boolean FelderÜberprüfen(JTextField[][] Spielfeld, int row) {

        char[] Buchstaben = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int zähler = 0;

        for (int i = 0; i < Spielfeld.length; i++) {

            for (int k = 0; k < Buchstaben.length; k++) {

                if (Spielfeld[i][row].getText().toUpperCase().equals(Buchstaben[k] + "")) {

                    zähler++;

                    if (zähler == 5) {

                        return true;

                    }

                }

            }

        }

        return false;

    }

    public void WortÜberprüfen(String Wort, JTextField[][] Spielfeld, int row) {
        char[] WortBuchstaben = {Wort.charAt(0), Wort.charAt(1), Wort.charAt(2), Wort.charAt(3), Wort.charAt(4)};

        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < WortBuchstaben.length; j++) {
                if (Spielfeld[i][row].getText().toUpperCase().charAt(0) == WortBuchstaben[i]) {
                    Spielfeld[i][row].setBackground(Color.GREEN);
                    
                } else {
                    Spielfeld[i][row].setBackground(Color.LIGHT_GRAY);
                }
                Spielfeld[i][row].setEnabled(false);
                BuchstabenAnDerFalschenPositionErkennen(Spielfeld, Wort, row);
            }
        }
        Gewonnen(Spielfeld, row);
    }

    public void BuchstabenAnDerFalschenPositionErkennen(JTextField[][] Spielfeld, String Wort, int row) {
        char[] WortBuchstaben = {Wort.charAt(0), Wort.charAt(1), Wort.charAt(2), Wort.charAt(3), Wort.charAt(4)};

        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < WortBuchstaben.length; j++) {
                if (Spielfeld[i][row].getText().toUpperCase().charAt(0) == WortBuchstaben[j] && Spielfeld[i][row].getBackground() != Color.GREEN) {
                    Spielfeld[i][row].setBackground(Color.YELLOW);
                }
            }
        }

    }

    public void Gewonnen(JTextField[][] Spielfeld, int row) {
        int Gewonnen = 0;
       
        for (int i = 0; i < Spielfeld.length; i++) {
            if (Spielfeld[i][row].getBackground() == Color.GREEN) {
                Gewonnen++;
                if (Gewonnen >= 5) {
                    JOptionPane.showMessageDialog(null, "Sie haben Gewonnen");
                    
                    break;
                }
            } else {
                Gewonnen--;
                
            }
           
        }
    }

    public void Verloren(int row) {
        if (row == 6) {

            JOptionPane.showMessageDialog(null, "Sie haben Verlorn" + "Das Lösungswort " + wd.getWörter());
        }
    }
  public boolean WordInDatenbank(JTextField[][] Spielfeld, int row, Wordledatenbank WD) {
        String word = "";
        for (int i = 0; i < Spielfeld.length; i++) {
            word += Spielfeld[i][row].getText() + "";
        }
        if (word.toUpperCase().equals(WD.getAlleWörter(word))) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Bitte geben sie ein richtiges word ein");
            return false;
        }
    }

      
    
}
