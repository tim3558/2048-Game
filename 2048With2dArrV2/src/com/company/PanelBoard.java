package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

// panelBoard class, the panel that is the grid of the game, all the numbers will be on this.
// @pharm size -> The size of the frame.
// @pharm rowSize -> the size of the grid.
// @pharm labelCubes -> A 2d array of LabelCube object. (contain all the values on the grid)

public class PanelBoard extends JPanel{
    private final int size;
    private final int rowSize;

    private final LabelCube[][] labelCubes;

//    The panelBoard constructor.
//    Create new LabelCube 2d arr, populate the arr with empty labels and generate 1 value in random place.
//    Sets the board panel characteristics.
//    @pharm size -> The size of the frame.
//    @pharm rowSize -> The size of the grid.
    public PanelBoard(int size, int rowSize){
        labelCubes = new LabelCube[rowSize][rowSize];
        this.size = size;
        this.rowSize = rowSize;
        this.setPreferredSize(new Dimension(size, size-size/5));
        this.setLayout(new GridLayout(rowSize,rowSize,rowSize,rowSize));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setBackground(new MyColors().backGround);
        addLabelsCubes();
        setTextInCubes();


//        int x = 2;
//        for(int i = 0; i<rowSize; i++){
//            for(int j = 0; j<rowSize; j++){
//                labelCubes[i][j].setText(String.valueOf(x));
//                x *= 2;
//            }
//        }
//        saveCurrentState();

    }

//    Pass on every labelCube value on the 2d arr, update it according the previous value, and re-color the label.
    public void undoLastMove(){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < rowSize; col++){
                int temp = labelCubes[row][col].getHisDynArr().getLastValue();
                if( temp == 0){
                    labelCubes[row][col].setText("");
                    labelCubes[row][col].colorLabel(0);
                }else{
                    labelCubes[row][col].setText(String.valueOf(temp));
                    labelCubes[row][col].colorLabel(log2(temp - 1)+1);
                }

            }
        }
    }

//    For each labelCube object in the 2d arr, create a new labelCube object, and add each labelCube to the grid.
    private void addLabelsCubes(){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < rowSize; col++){
                labelCubes[row][col] = new LabelCube();
                this.add(labelCubes[row][col]);
            }
        }
    }

//    Check if there is any more moves to to by:
//    1. Checking if there is any labels with no value.
//    2. Checking if there is any neighbors with the same value.
//    @return -> false if one of the conditions above are true.
    public boolean checkForGameOver(){
        for(int row = 0; row <rowSize ; row++){
            for(int col = 0; col<rowSize; col++){
                if(row>0){
                    if(labelCubes[row-1][col].getText().equals("") || labelCubes[row-1][col].getText().equals(labelCubes[row][col].getText())){
                        return false;
                    }
                }else{
                    if(labelCubes[row][col].getText().equals("")){
                        return false;
                    }
                }
                if(col>0){
                    if(labelCubes[row][col-1].getText().equals("") || labelCubes[row][col-1].getText().equals(labelCubes[row][col].getText())){
                        return false;
                    }
                }else{
                    if(labelCubes[row][col].getText().equals("")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    Generate a point on the grid.
//    Check if the point is free, if not generate a new point on the grid.
//    When finds a free point on the grid, call generateToF to get back value to set in the grid, and call saveCurrentState for Undoing by the user choice.
    public void setTextInCubes(){
        int[] tempPlaces = geneRandPlace();
        if( isNumber(labelCubes[tempPlaces[0]][tempPlaces[1]]) ){
            setTextInCubes();
        }else{
            labelCubes[tempPlaces[0]][tempPlaces[1]].setText(String.valueOf(generateToF()));
            saveCurrentState();
            labelCubes[tempPlaces[0]][tempPlaces[1]].colorLabel(49);
        }
    }

//    Pass on every value on the grid, color the label, and save the current value in the history dynamic array.
    private void saveCurrentState(){
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < rowSize; col++){
                if ((labelCubes[row][col].getCurrentValue() == 0)) {
                    labelCubes[row][col].colorLabel(0);
                } else {
                    labelCubes[row][col].colorLabel(log2(labelCubes[row][col].getCurrentValue() - 1)+1);
                }
                labelCubes[row][col].setHisDinArr();
            }
        }
    }

//    @pharm n -> The number that we want to do log2.
//    @return -> log2 of a number.
    private static int log2(int n){
        return (int) (Math.log(n) / Math.log(2));
    }

//    Check if the label have a value.
//    @pharm label -> The label that we want to check.
    private boolean isNumber(JLabel label){
        if(label == null){
            return false;
        }else{
            try{
                int tempValue = Integer.parseInt(label.getText());
            }catch (NumberFormatException nfe){
                return false;
            }
        }
        return true;
    }

//    @return -> length 2 array, that contain x position and y position.
    private int[] geneRandPlace(){
        int[] tempPlaces = new int[2];
        tempPlaces[0] = genRanNum(rowSize);
        tempPlaces[1] = genRanNum(rowSize);

        return tempPlaces;
    }

//    @return -> 2 by 70% chance, or 4 by 30% chance.
    private int generateToF(){
        if(genRanNum(10)< 7){
            return 2;
        }else{
            return 4;
        }
    }

//    @pharm max -> the max value of the range.
//    @return -> Random number in the range.
    private int genRanNum(int max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

//    @return -> The labels 2d array.
    public LabelCube[][] getLabelCubes(){
        return labelCubes;
    }


}
