package com.company;

import javax.swing.*;
import java.awt.*;

// ScoreLabel class, the label that show the score in the ui panels.
// @pharm scoreStr -> The start of the string that shows the score.
// @pharm scoreInt -> The current score value.
// @pharm -> Dynamic array of all score history.

public class ScoreLabel extends JLabel {
    private final String scoreStr = "Score: ";
    private int scoreInt;
    private final HisDynArr hisDynArr;

//    The ScoreLabel constructor.
//    create a new history dynamic array, sets teh score to 0 and adds it to the history array, and and sets the label characteristics.
    public ScoreLabel(int size){
        hisDynArr = new HisDynArr();
        scoreInt = 0;
        hisDynArr.addCurrentValue(scoreInt);
        this.setText(scoreStr + scoreInt);
        this.setFont(new Font("Neue Haas Grotesk Text Pro", Font.BOLD, 12));
        this.setBackground(new MyColors().myPalette[0]);
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(size, size));
    }

//    Set the text of the label with the current score.
    public void setText(int value){
        this.setText(scoreStr + value);
    }

//    Set the current score to be the value.
//    @pharm value -> the updated score.
    public void setScore(int value){
        scoreInt = value;
        this.setText(scoreStr + scoreInt);
    }

//    @return -> The current score value.
    public int getScore(){
        return scoreInt;
    }

//    @return -> The history dynamic array of the values.
    public HisDynArr getHisDynArr(){
        return hisDynArr;
    }

//    Add the current value o the history array.
    public void setHisDinArr(){
        hisDynArr.addCurrentValue(scoreInt);
    }
}
