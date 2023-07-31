package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// MyJFrame class, act like a JFrame, and got keyListener to get the input from the user.
// All the panels will be on this frame.
// @pharm panelBoard -> The panel that will be the board game.
// @pharm panelUI -> The panel that will be the user interface panel.
// @pharm moveAlgo -> The class that control the movement of the numbers.
// @pharm SIZE -> The size of the panel on the screen.

public class MyJFrame extends JFrame implements KeyListener {

    private final PanelBoard panelBoard;
    private final PanelUI panelUI;
    private final MoveAlgo moveAlgo;
    private final int SIZE = 400;

//    MyJFrame constructor.
//    Add the panels to the frame, and sets the frame characteristics.
//    @pharm rowSize -> The size of the grid (rowSize * rowSize).
    public MyJFrame(int rowSize){

        panelBoard = new PanelBoard(SIZE, rowSize);
        panelUI = new PanelUI(SIZE);
        moveAlgo = new MoveAlgo(rowSize);

        this.setLayout(new BorderLayout());
        this.add(panelUI, BorderLayout.NORTH);
        this.add(panelBoard, BorderLayout.CENTER);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);

    }

//    @return -> panelUI.
    public PanelUI getPanelUI(){
        return panelUI;
    }

//    Undo the last move, call undoLastMove in the panelBoard class, and set the score in the panelUI to the previous score.
    public void undoLastMove(){
        panelBoard.undoLastMove();
        panelUI.getLabelScore().setScore(panelUI.undoLastMove());
        panelUI.getLabelScore().setText(panelUI.getLabelScore().getScore());

    }

//    The key listener implements.
//    1. Check if the user has clicked the escape button, if true ask if wanna exit the game, if true close the program.
//    2. Check if the game is over, if true call showGameOverMsg. (shows the game over massage)
//    3. If game is not over, call moveAlgo with the user input, and call the setTextInCube. (move the numbers in the grid and sets a new number in a free grid)
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 27){
            int result = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit the game", JOptionPane.YES_NO_OPTION);
            if(result == 0){
                System.exit(0);
            }
        }else{
            if(panelBoard.checkForGameOver()){
                panelUI.showGameOverMsg();
            }else{
                if(moveAlgo.moveValues(e.getKeyCode(), panelBoard.getLabelCubes(), panelUI.getLabelScore())){
                    panelBoard.setTextInCubes();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
