package com.company;

import java.awt.*;

// MyColors class, contain the colors that will be in the game.
public class MyColors{

//    The background color.
    public Color backGround = new Color(60,58,44);

//    Array of colors palette.
    public Color[] myPalette = generateColor(50);

    public Color newLabelColor = new Color(200, 70, 200);

//    @pharm n -> The size of the array, and how much color to generate.
//    @return -> The color palette array.
    private Color[] generateColor(int n){
        Color[] cols = new Color[n];
        for(int i = 0; i<n; i++){
            cols[i] = Color.getHSBColor((float) i / (float) n, 0.5f, 2.0f);
        }
        return cols;
    }


}
