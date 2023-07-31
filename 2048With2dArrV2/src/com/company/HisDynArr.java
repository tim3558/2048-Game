package com.company;

// HisDynArr class, this is the dynamic array to contain all of the history values of each label.
// @pharm cubeHistoryValues -> The array that will contain the values.
// @pharm count -> The amount of values that current in the array.
// @pharm -> The size of the array in every given time.
public class HisDynArr {

    private int[] cubeHistoryValues;
    private int count;
    private int arrSize;

//    The HisDynArr constructor.
//    create a new empty array with the size of 1 .
    public HisDynArr(){
        arrSize = 1;
        count = 0;
        cubeHistoryValues = new int[arrSize];
    }

//    @return -> the last value in the array, also decrees count to "delete" the value.
    public int getLastValue(){
        if(count > 1){
            count--;
        }
        return cubeHistoryValues[count-1];
    }

//    Add a new value to the array by this order:
//    1. Check if the array if full, if true call growSize to increase the size of the array.
//    2. Add the current value to the end of the array.
//    3. Increase count.
//    @pharm value -> The value of the label that we want to add to the array.
    public void addCurrentValue(int value){
        if(count == arrSize){
            this.growSize();
        }
        cubeHistoryValues[count] = value;
        count++;
    }

//    Grow the size of the array in case of full by this order:
//    1. create a new temp array point to nothing.
//    2. Check again if the array if full, if true create a new array double the size, and sets temp to point on it.
//    3. Copy the previous array to temp array.
//    3. sets the previous array to point temp array.
//    3. double arrSize.
    private void growSize(){
        int[] temp = null;
        if(count == arrSize){
            temp = new int[arrSize*2];
        }
        if (arrSize >= 0) System.arraycopy(cubeHistoryValues, 0, temp, 0, arrSize);
        cubeHistoryValues = temp;
        arrSize = arrSize*2;
    }
}
