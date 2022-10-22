package com.lisakzbigniew.quickreader.gui;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import org.springframework.stereotype.Component;

@Component
public class ReadingDisplay extends JLabel{
    
    QuickReaderFrame parentQR;

    public ReadingDisplay(){
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Ariel",Font.PLAIN,24));
    }

    public QuickReaderFrame getparentQR() {
        return parentQR;
    }

    public void setparentQR(QuickReaderFrame parentQR) {
        this.parentQR = parentQR;
    }

}
