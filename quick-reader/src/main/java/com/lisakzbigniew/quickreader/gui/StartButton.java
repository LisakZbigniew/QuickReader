package com.lisakzbigniew.quickreader.gui;

import javax.swing.JButton;

import org.springframework.stereotype.Component;

@Component
public class StartButton extends JButton{
    
    QuickReaderFrame parentQR;

    public StartButton(){
        super("Start");
    }

    public QuickReaderFrame getparentQR() {
        return parentQR;
    }

    public void setparentQR(QuickReaderFrame parentQR) {
        this.parentQR = parentQR;
    }

}
