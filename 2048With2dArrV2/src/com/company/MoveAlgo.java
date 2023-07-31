package com.company;

// moveAlgo record, control all of the user input and labels movement.
public record MoveAlgo(int rowSize) {

//    For each of the labels on the grid, call moveValues helper (move or unite the values).
//    @pharm keyType -> The input value from the user.
//    @pharm labelCubes -> The 2d array that store the labels.
//    @pharm scoreLabel -> The label in the ui panel that shows the score.
//    @return hasMoved -> true if any of the labels has been moved.
    public boolean moveValues(int keyType, LabelCube[][] labelCubes, ScoreLabel scoreLabel) {
        boolean hasMoved = false;
        switch (keyType) {
            case 37:
                //Left
                for (int row = 0; row < rowSize; row++) {
                    for (int col = 0; col < rowSize; col++) {
                        if (moveValuesHelper(labelCubes, scoreLabel, row, col, 0, -1)) {
                            hasMoved = true;
                        }
                    }
                }
                break;

            case 38:
                //UP
                for (int row = 0; row < rowSize; row++) {
                    for (int col = 0; col < rowSize; col++) {
                        if (moveValuesHelper(labelCubes, scoreLabel, col, row, -1, 0)) {
                            hasMoved = true;
                        }
                    }
                }
                break;

            case 39:
                //Right
                for (int row = 0; row < rowSize; row++) {
                    for (int col = rowSize - 1; col >= 0; col--) {
                        if (moveValuesHelper(labelCubes, scoreLabel, row, col, 0, 1)) {
                            hasMoved = true;
                        }
                    }
                }
                break;

            case 40:
                //Down
                for (int row = 0; row < rowSize; row++) {
                    for (int col = rowSize - 1; col >= 0; col--) {
                        if (moveValuesHelper(labelCubes, scoreLabel, col, row, 1, 0)) {
                            hasMoved = true;
                        }
                    }
                }
                break;

            default:
                break;

        }
        return hasMoved;
    }

//    The helper to the moveValues method, get the current label position and check if in the movement direction there is:
//    1. any label with the same value to unite the current label with it .
//    2. any label with free space to move the current label there.
//    Continue until there is no more space to move the value, or has collide 2 values.
//    @pharm labelCubes -> The 2d array of the labels on the grid.
//    @pharm scoreLabel -> The label in the ui panel that shows the score.
//    @pharm row -> the row number that the current label is.
//    @pharm col -> the column number that the current label is.
//    @pharm nextRow -> The next row that we want to check.
//    @pharm nextCol -> the next column that we want to check.
//    @pharm hasCollide -> check if there is any 2 values that has been collide.
//    @return hasMoved -> true if any of the labels has been moved.
    private boolean moveValuesHelper(LabelCube[][] labelCubes, ScoreLabel scoreLabel, int row, int col, int nextRow, int nextCol) {
        boolean hasMoved = false, hasCollide = false;
        while (!labelCubes[row][col].getText().equals("") && (row + nextRow) >= 0 && (row + nextRow) < rowSize && (col + nextCol) >= 0 && (col + nextCol) < rowSize) {
            if (labelCubes[row + nextRow][col + nextCol].getText().equals("")) {
                labelCubes[row + nextRow][col + nextCol].setText(labelCubes[row][col].getText());
                labelCubes[row][col].setText("");
                hasMoved = true;
            } else if (labelCubes[row + nextRow][col + nextCol].getText().equals(labelCubes[row][col].getText()) && !hasCollide) {
                int temp = Integer.parseInt(labelCubes[row][col].getText());
                labelCubes[row + nextRow][col + nextCol].setText(String.valueOf(temp * 2));
                labelCubes[row][col].setText("");
                scoreLabel.setScore(scoreLabel.getScore() + temp * 2);
                scoreLabel.setHisDinArr();
                hasMoved = true;
                hasCollide = true;
            }
            row += nextRow;
            col += nextCol;

        }
        return hasMoved;
    }
}