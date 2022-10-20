package com.lisakzbigniew.quickreader.gui;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.stereotype.Component;

@Component
public class ReadingSpeedRegulator extends JSlider implements ChangeListener{
    
    QuickReaderFrame parentQR;
    
    public ReadingSpeedRegulator(){
        super(60,180,120);
        
        setPaintLabels(true);
        setPaintTicks(true);

        setMajorTickSpacing(30);
        setMinorTickSpacing(3);

        addChangeListener(this);

    }

    public int getIntervalBetweenWords(){
        return (60*1000)/getValue();
    }
    
    public QuickReaderFrame getparentQR() {
        return parentQR;
    }

    public void setparentQR(QuickReaderFrame parentQR) {
        this.parentQR = parentQR;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
        if(parentQR != null){
            parentQR.speedChanged(getIntervalBetweenWords());
        }
        
    }

}
