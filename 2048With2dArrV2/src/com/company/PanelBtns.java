package com.company;

import javax.swing.*;
import java.awt.*;

// panelBtns class, the panel that contain the buttons in the ui panels.
// @pharm btnUndo -> The undo button, sets the game 1 step back.
// @pharm btnRestart -> The restart btn, create a new board to play on.
public class PanelBtns extends JPanel {

    private final MyJButton btnUndo;
    private final MyJButton btnRestart;

//    The panelBtns constructor.
//    create the buttons, add them to the panel and sets the panel characteristics.
    public PanelBtns(int size){
        btnUndo = new MyJButton("Undo");
        btnRestart = new MyJButton("Restart");
        this.setPreferredSize(new Dimension(size, size));
        this.setBackground(new MyColors().myPalette[0]);
        this.setLayout(new BorderLayout());
        this.add(btnRestart, BorderLayout.NORTH);
        this.add(btnUndo, BorderLayout.SOUTH);
    }


//    @return -> The undo button.
    public MyJButton getBtnUndo() {
        return btnUndo;
    }

//    @return -> the restart button.
    public MyJButton getBtnRestart() {
        return btnRestart;
    }
}
