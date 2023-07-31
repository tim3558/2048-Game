package com.company;

import javax.swing.*;
import java.awt.*;


// LabelCube class, represent each label that is in the grid.
// @pharm hisDynArr -> Dynamic array that contain the values history of the label.

public class LabelCube extends JLabel {
    private final HisDynArr hisDynArr;

//    The LabelCube Constructor.
//    Create a new dynamic array, and set the label characteristics.
    public LabelCube(){
        hisDynArr = new HisDynArr();
        this.setBackground(Color.white);
        this.setOpaque(true);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setFont(new Font("MV Boli", Font.BOLD, 25));
    }

//    @return -> The dynamic array of the values history.
    public HisDynArr getHisDynArr(){
        return hisDynArr;
    }

//    Set the current label value in the dynamic array.
    public void setHisDinArr(){
        hisDynArr.addCurrentValue(getCurrentValue());
    }

//    Set the color of the label.
//    @pharm place -> the index of the color from myPalate
    public void colorLabel(int place){
        this.setBackground(new MyColors().myPalette[place]);
    }

//    @return -> the current value of the label, if no value return null.
    public int getCurrentValue(){
        int tempValue;
        try{
            tempValue = Integer.parseInt(this.getText());
        }catch (NumberFormatException nfe){
            return 0;
        }
        return tempValue;
    }
}
