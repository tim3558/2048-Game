package com.company;

public class Main {
//    Create a new game frame, with a buttons action listener.
//    @pharm rowSize -> The number of cubes on the board.
//    @pharm frame -> create a new frame to the screen.

    private static final int rowSize = 4;
    private static MyJFrame frame;

    public static void main(String[] args) {
        createNewGame();
    }

//    Create a new game state, create a new MyJFrame, and close the current frame if it open.
//    and call the restart btn listener and undo button methods.
    private static void createNewGame(){
        if(frame != null){
            frame.dispose();
        }
        frame = new MyJFrame(rowSize);
        restartBtnListener();
        undoBtnListener();

    }

//    Get the restart button from the panel buttons, and add action listener for running createNewGame method.
    private static void restartBtnListener(){
        frame.getPanelUI().getPanelBtns().getBtnRestart().addActionListener(e -> createNewGame());
    }

//    Get the undo button from the button panel, and add action listener for running undoLastMove method.
    private static void undoBtnListener(){
        frame.getPanelUI().getPanelBtns().getBtnUndo().addActionListener(e -> frame.undoLastMove());
    }
}
