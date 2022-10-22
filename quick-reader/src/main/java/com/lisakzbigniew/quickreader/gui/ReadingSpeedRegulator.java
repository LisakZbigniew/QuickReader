package com.lisakzbigniew.quickreader.gui;

import javax.swing.JSlider;

import org.springframework.stereotype.Component;

@Component
public class ReadingSpeedRegulator extends JSlider{
    
    QuickReaderFrame parentQR;
    
    public ReadingSpeedRegulator(){
        super(60,300,180);
        
        setPaintLabels(true);
        setPaintTicks(true);

        setMajorTickSpacing(60);
        setMinorTickSpacing(6);

        addChangeListener((e) -> {
            if(parentQR != null){
                parentQR.speedChanged(getIntervalBetweenWords());
            }
        });

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

}
