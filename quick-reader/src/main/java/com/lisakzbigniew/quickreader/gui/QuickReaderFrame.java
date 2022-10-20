package com.lisakzbigniew.quickreader.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.GridBagLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import org.springframework.stereotype.Component;

@Component
public class QuickReaderFrame extends JFrame{

    private final int HEIGHT = 400,WIDTH = 300;

    ReadingInput readingInput;
    ReadingSpeedRegulator speedRegulator;
    StartButton startButton;
    StopButton stopButton;
    ReadingDisplay readingDisplay;

    public QuickReaderFrame(ReadingInput readingInput, ReadingSpeedRegulator speedRegulator, StartButton startButton, StopButton stopButton, ReadingDisplay readingDisplay) {
        this.readingInput = readingInput;
        this.speedRegulator = speedRegulator;
        this.startButton = startButton;
        this.stopButton = stopButton;
        this.readingDisplay = readingDisplay;

        setup();
        setUI();
    }


    private void setup(){
        this.setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void setUI(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Container content = getContentPane();

        //all components with margins and filling the space
        c.insets = new Insets(2,2,2,2);
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        content.add(new JScrollPane(readingInput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),c);

        c.gridx=0;
        c.gridy=1;
        c.gridwidth = 2;
        c.gridheight = 1;

        content.add(speedRegulator,c);

        c.gridx=0;
        c.gridy=2;
        c.gridwidth = 1;
        c.gridheight = 1;

        content.add(startButton, c);

        c.gridx=1;
        c.gridy=2;
        c.gridwidth = 1;
        c.gridheight = 1;

        content.add(stopButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.CENTER;

        content.add(readingDisplay,c);

    }


    public void speedChanged(int speed) {
        //TODO Add change spped of reading
    }
    
}
