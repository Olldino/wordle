/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordle;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Roman Perkmann
 */
public class timer {
    
    Helper h = new Helper();
        
    public timer() {
         
        
        Timer timer = new Timer();
        TimerTask task = new Helper();
         
        timer.schedule(task, 2000, 1000);
    }
    
    public void ResetTimer() {
        h.setI(0);
    }
}

class Helper extends TimerTask {
    
    public static int i = 0;
    public void run()
    {
        System.out.println(++i + "sec");
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Helper.i = i;
    }
    
    
}
