package com.lisakzbigniew.quickreader.gui;

import javax.swing.JButton;

import org.springframework.stereotype.Component;

@Component
public class StopButton extends JButton{
    
    QuickReaderFrame parentQR;

    public StopButton(){
        super("Stop");
    }

    public QuickReaderFrame getparentQR() {
        return parentQR;
    }

    public void setparentQR(QuickReaderFrame parentQR) {
        this.parentQR = parentQR;
    }

}
