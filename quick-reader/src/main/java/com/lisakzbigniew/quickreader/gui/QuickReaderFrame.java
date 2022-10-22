package com.lisakzbigniew.quickreader.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.GridBagLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class QuickReaderFrame extends JFrame{

    private final int HEIGHT = 400,WIDTH = 300;

    private static final Logger logger = LogManager.getLogger(QuickReaderFrame.class);

    ReadingInput readingInput;
    ReadingSpeedRegulator speedRegulator;
    StartButton startButton;
    StopButton stopButton;
    ReadingDisplay readingDisplay;
    Thread t;
    int waitTime;
    public QuickReaderFrame(ReadingInput readingInput, 
                            ReadingSpeedRegulator speedRegulator,
                            StartButton startButton,
                            StopButton stopButton,
                            ReadingDisplay readingDisplay) {

        this.readingInput = readingInput;
        readingInput.setparentQR(this);
        this.speedRegulator = speedRegulator;
        speedRegulator.setparentQR(this);
        this.startButton = startButton;
        startButton.setparentQR(this);
        this.stopButton = stopButton;
        stopButton.setparentQR(this);
        this.readingDisplay = readingDisplay;
        readingDisplay.setparentQR(this);

        setup();
        setUI();

        waitTime = speedRegulator.getIntervalBetweenWords();
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

        int currentRow = 0; 

        JLabel inputLabel = new JLabel("Enter your text here");
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);

        c.gridx = 0;
        c.gridy = currentRow++;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.CENTER;
        content.add(inputLabel, c);

        c.gridx = 0;
        c.gridy = currentRow++;
        c.gridwidth = 2;
        c.gridheight = 1;
        content.add(new JScrollPane(readingInput,
                                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),c);

        JLabel regulatorLabel = new JLabel("Choose display speed (words per minute)");
        regulatorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        c.gridx = 0;
        c.gridy = currentRow++;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.CENTER;
        content.add(regulatorLabel, c);

        c.gridx=0;
        c.gridy=currentRow++;
        c.gridwidth = 2;
        c.gridheight = 1;

        content.add(speedRegulator,c);

        c.gridx=0;
        c.gridy=currentRow;
        c.gridwidth = 1;
        c.gridheight = 1;

        content.add(startButton, c);

        c.gridx=1;
        c.gridy=currentRow++;
        c.gridwidth = 1;
        c.gridheight = 1;

        content.add(stopButton, c);

        c.gridx = 0;
        c.gridy = currentRow++;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.CENTER;

        content.add(readingDisplay,c);

    }


    public void speedChanged(int speed) {
        waitTime = speed; 
    }

    public void startReading(){
        logger.info("Start reading");
        String[] text = readingInput.getText().split("\\s+");
        t = new Thread(() -> {
            int i=0;
            while(i<text.length){
                readingDisplay.setText(text[i]);
                i++;
                try{
                    Thread.sleep(waitTime);
                }catch(InterruptedException e){
                    logger.info("Thread Interuppted");
                    break;
                }
            }
            logger.info("Reading finished");
        });
        t.start();
    }

    public void stopReading(){

        if(t!=null){
            t.interrupt();
            t=null;
        }

    }
    
}
