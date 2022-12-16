package com.mycompany.wordle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
/**
 *
 * @author Olldashi
 */
public class Wordledatenbank {

    public static Statement statement;
    public static String wörter = "";

    public Wordledatenbank() {
        final String jdbcURL = "jdbc:postgresql://localhost:5432/Wordle";
        String username = "postgres";
        String psw = "Admin";

        try {
            Connection conn = DriverManager.getConnection(jdbcURL, username, psw);
            statement = conn.createStatement();
            statementword();

        } catch (SQLException ex) {
            Logger.getLogger(Wordledatenbank.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//1197-1794 wordid Datenbank
    public static String getWörter() {

        return wörter;

    }

    public static String statementword() {
// String wörter = "";

        ResultSet rs;

        try {
            rs = statement.executeQuery("SELECT * FROM allwords ORDER BY RANDOM() LIMIT 1");

            while (rs.next()) {
                wörter = rs.getString("wörter");

                System.out.printf(getWörter() + " ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Wordledatenbank.class.getName()).log(Level.SEVERE, null, ex);
        }

        return wörter;
    }

    
  

   public static String getAlleWörter(String word) {
        ResultSet rs;
        String worte = "";
        try {
            rs = statement.executeQuery("SELECT * FROM allwords where wörter like '" + word.toUpperCase() + "'");
            while (rs.next()) {
                worte = rs.getString("wörter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Wordledatenbank.class.getName()).log(Level.SEVERE, null, ex);
        }
        return worte;
    }

    
    



}
