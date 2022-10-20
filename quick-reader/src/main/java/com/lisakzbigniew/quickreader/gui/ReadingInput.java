package com.lisakzbigniew.quickreader.gui;

import javax.swing.JTextArea;

import org.springframework.stereotype.Component;

@Component
public class ReadingInput extends JTextArea{
    
    private final int ROW_NUMBER = 10;
    
    QuickReaderFrame parentQR;

    public ReadingInput(){
        setRows(ROW_NUMBER);
        setLineWrap(true);
        
    }

    public QuickReaderFrame getparentQR() {
        return parentQR;
    }

    public void setparentQR(QuickReaderFrame parentQR) {
        this.parentQR = parentQR;
    }

}
