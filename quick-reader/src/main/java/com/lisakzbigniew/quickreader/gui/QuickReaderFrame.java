package com.lisakzbigniew.quickreader.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.springframework.stereotype.Component;

@Component
public class QuickReaderFrame extends JFrame{

    private String message;

    public QuickReaderFrame(){
        this("Hello Swing integration");
    } 

    public QuickReaderFrame(String message){
        this.message = message;
        this.setSize(200, 200);
        this.getContentPane().add(new JLabel(this.message));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }
    
}
