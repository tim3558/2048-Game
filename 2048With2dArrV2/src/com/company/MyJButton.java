package com.company;

import javax.swing.*;
import java.awt.*;

// MyJButton class, this is the basic custom JButton.
public class MyJButton extends JButton {

//    @pharm str -> The string that will be the text of the button.
    public MyJButton(String str){
        this.setText(str);
        this.setPreferredSize(new Dimension(100, 35));
        this.setFocusable(false);
    }
}
