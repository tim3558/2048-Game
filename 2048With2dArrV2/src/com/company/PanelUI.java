package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

// PanelUI class, the panel for the user interface.
// @pharm panelBtns -> The panel of the buttons that is on the ui panel.
// @pharm labelScore -> The label that show the score on the ui panel.
// @pharm massageLabel -> The label that show game over on the ui panel.

public class PanelUI extends JPanel {
    private final PanelBtns panelBtns;
    private final ScoreLabel labelScore;
    private final JLabel massageLabel;

//    The panelUI constructor.
//    Create new and add to the ui panel : labelScore, panelBtns, and massageLabel.
//    sets the ui panel characteristics.
//    @pharm size -> The size of the frame.
    public PanelUI(int size){
        labelScore = new ScoreLabel(size/5);
        panelBtns = new PanelBtns(size/5);
        massageLabel = new JLabel("Game Over");
        massageLabel.setFont(new Font("Rockwell Nova Extra Bold", Font.BOLD,25));
        massageLabel.setForeground(new Color(190,30,30));
        massageLabel.setHorizontalAlignment(JLabel.CENTER);
        massageLabel.setVisible(false);

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(size, size/5));
        this.setBackground(new MyColors().myPalette[0]);
        this.add(panelBtns, BorderLayout.EAST);
        this.add(labelScore, BorderLayout.WEST);
        this.add(massageLabel, BorderLayout.CENTER);
        this.setBorder(new LineBorder(Color.BLACK));
    }

//    @return -> The panel of the buttons.
    public PanelBtns getPanelBtns() {
        return panelBtns;
    }

//    @return -> the label of the score.
    public ScoreLabel getLabelScore() {
        return labelScore;
    }

//    Show the game over massage.
    public void showGameOverMsg(){
        massageLabel.setVisible(true);
    }

//    @return -> the previous value of the score.
    public int undoLastMove(){
        massageLabel.setVisible(false);
        return labelScore.getHisDynArr().getLastValue();
    }

}
