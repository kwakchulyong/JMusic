package Jm808;

//==========================================================
//File:                 Jm808_GUI.java
//Function:             Interface for the Jm808 class
//Author:               Andrew Brown
//Environment           JDK1.1.7
//============================================================
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jm.JMC;

public class Jm808_GUI extends Frame implements ActionListener, JMC {
    // Attributes shared within the class
    private TextField loopNumBox, fileNameBox;
    private Jm808 drumMachine;

    ////////////
    // constructor
    ////////////

    public Jm808_GUI(Jm808 drumMachine) {
        //give the window a name
        super("JM 808 by Andrew Brown");
        // make other class reference avilible to all methods in this class
        this.drumMachine = drumMachine;

        //create a panel to put objects on
        Panel p = new Panel();

        //add the text field
        //Lable loopLable = new Lable("Loop #", label.RIGHT);
        //p.add(loopLable);
        loopNumBox = new TextField("7", 5);
        p.add(loopNumBox);
        //Lable fileLable = new Lable("File Name", label.RIGHT);
        //p.add(fileLable);
        fileNameBox = new TextField("jm808.mid", 24);
        p.add(fileNameBox);

        //add the button
        Button composeBtn = new Button("Compose");
        composeBtn.addActionListener(this);
        composeBtn.setActionCommand("Create");
        p.add(composeBtn);

        Button saveBtn = new Button("Save");
        saveBtn.addActionListener(this);
        saveBtn.setActionCommand("Save");
        p.add(saveBtn);

        //put the panel in the frame
        this.add(p);

        //display the window
        this.pack();
        this.show();
    }

    ////////////
    // Deal with the button click
    ////////////

    public void actionPerformed(ActionEvent ae) {

        if(ae.getActionCommand().equals("Create")) {
            int numb = Integer.valueOf(loopNumBox.getText()).intValue();
            if(numb < 1)
                numb = 3;
            drumMachine.createScore(numb);
        }

        if(ae.getActionCommand().equals("Save")) {
            String fileName = fileNameBox.getText();
            if(fileName != null) {
                drumMachine.saveScore(fileName);
            } else
                drumMachine.saveScore("jm8082.mid");

        }
    }
}
