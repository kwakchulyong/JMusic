package bandMachine;

/* --------------------
* A GUI interface for operating BANDMACHINE - a class
* that creates a piece of music
* using the DrumMachine, BassMachine and PianoMachine,
* as well as the ChordProgression class
* @author Andrew Troedson
* ---------------------
*/

import java.awt.*;
import java.awt.event.*;

public class BandMachineGUI extends Frame implements ActionListener, ItemListener, WindowListener {

    TextField pieceLength;
    Choice progressionStyle;
    String progressionStyleChosen = "ROCK";
    Checkbox pianoSwitch;
    Checkbox bassSwitch;
    Checkbox drumsSwitch;
    Choice pianoStyle;
    String pianoStyleChosen = "ROCK";
    Choice bassStyle;
    String bassStyleChosen = "ROCK";
    Choice drumsStyle;
    String drumsStyleChosen = "ROCK";
    TextField fadeInLength;
    TextField fadeOutLength;
    Choice firstChordSelection;
    String firstChordString = "I";
    Choice lastChordSelection;
    String lastChordString = "I";
    TextField fileName;

    public static void main(String args[]) {
        BandMachineGUI BMG = new BandMachineGUI("Band Machine");
    }

    public BandMachineGUI(String title) {
        super(title);

        //register the closebox event
        this.addWindowListener(this);

        //Image i = Toolkit.getDefaultToolkit().getImage("icon.gif");
        //this.setIconImage(i);
        this.setBackground(new Color(240, 240, 240)); //set the Background color to Light Grey

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        Label mainTitle = new Label("BAND MACHINE by Andrew Troedson");
        constraints.weightx = 100;
        constraints.weighty = 100;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(mainTitle, constraints);

        Panel p2 = new Panel();
        pieceLength = new TextField("16", 3);
        p2.add(pieceLength);
        p2.add(new Label("Piece Length (no. of bars)"));
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        add(p2, constraints);

        Panel p3 = new Panel();
        progressionStyle = new Choice();
        progressionStyle.add("ROCK");
        progressionStyle.add("SWING");
        progressionStyle.add("JAZZ");
        progressionStyle.addItemListener(this);
        p3.add(new Label("Chord Progression Style: "));
        p3.add(progressionStyle);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(p3, constraints);

        Panel p4 = new Panel();
        pianoSwitch = new Checkbox("Piano", true);
        pianoStyle = new Choice();
        pianoStyle.add("ROCK");
        pianoStyle.add("SWING");
        pianoStyle.add("JAZZ");
        pianoStyle.addItemListener(this);
        p4.add(pianoSwitch);
        p4.add(pianoStyle);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(p4, constraints);

        Panel p5 = new Panel();
        bassSwitch = new Checkbox("Bass", true);
        bassStyle = new Choice();
        bassStyle.add("ROCK");
        bassStyle.add("SWING");
        bassStyle.add("JAZZ");
        bassStyle.addItemListener(this);
        p5.add(bassSwitch);
        p5.add(bassStyle);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(p5, constraints);

        Panel p6 = new Panel();
        drumsSwitch = new Checkbox("Drums", true);
        drumsStyle = new Choice();
        drumsStyle.add("ROCK");
        drumsStyle.add("SWING");
        drumsStyle.add("JAZZ");
        drumsStyle.addItemListener(this);
        p6.add(drumsSwitch);
        p6.add(drumsStyle);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(p6, constraints);

        Panel p7 = new Panel();
        fadeInLength = new TextField("4", 2);
        fadeOutLength = new TextField("4", 2);
        p7.add(new Label("Fade in (bars):"));
        p7.add(fadeInLength);
        p7.add(new Label("Fade out (bars):"));
        p7.add(fadeOutLength);
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(p7, constraints);

        Panel p8 = new Panel();
        firstChordSelection = new Choice();
        firstChordSelection.add("I");
        firstChordSelection.add("IV");
        firstChordSelection.add("V");
        firstChordSelection.add("i");
        firstChordSelection.addItemListener(this);
        p8.add(new Label("First Chord:"));
        p8.add(firstChordSelection);
        lastChordSelection = new Choice();
        lastChordSelection.add("I");
        lastChordSelection.add("IV");
        lastChordSelection.add("V");
        lastChordSelection.add("i");
        lastChordSelection.addItemListener(this);
        p8.add(new Label("Last Chord:"));
        p8.add(lastChordSelection);
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        add(p8, constraints);

        Panel p10 = new Panel();
        fileName = new TextField("bandmachine.mid", 16);
        Button compose = new Button("Compose");
        compose.addActionListener(this);
        compose.setActionCommand("ActionCompose");
        p10.add(new Label("Output File:"));
        p10.add(fileName);
        p10.add(compose);
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        add(p10, constraints);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);
        pack();
        show();
    }

    // Deal with the window closebox

    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
    // other WindowListener interface methods
    // they do nothing but are required to be present

    public void windowActivated(WindowEvent we) {
    };

    public void windowClosed(WindowEvent we) {
    };

    public void windowDeactivated(WindowEvent we) {
    };

    public void windowIconified(WindowEvent we) {
    };

    public void windowDeiconified(WindowEvent we) {
    };

    public void windowOpened(WindowEvent we) {
    };

    // Deal with item events (generated by the Choiceboxs)

    public void itemStateChanged(ItemEvent ie) {
        if(ie.getStateChange() == ItemEvent.SELECTED) {
            if(ie.getItemSelectable() == progressionStyle) {
                progressionStyleChosen = (String)ie.getItem();
            } else if(ie.getItemSelectable() == pianoStyle) {
                pianoStyleChosen = (String)ie.getItem();
            } else if(ie.getItemSelectable() == bassStyle) {
                bassStyleChosen = (String)ie.getItem();
            } else if(ie.getItemSelectable() == drumsStyle) {
                drumsStyleChosen = (String)ie.getItem();
            } else if(ie.getItemSelectable() == firstChordSelection) {
                firstChordString = (String)ie.getItem();
            } else if(ie.getItemSelectable() == lastChordSelection) {
                lastChordString = (String)ie.getItem();
            }
        }
    }

    // Deal with Action events (button pushes)

    public void actionPerformed(ActionEvent ae) {
        String[] firstChord = chordSelect(firstChordString);
        String[] lastChord = chordSelect(lastChordString);

        if(ae.getActionCommand() == "ActionCompose") {
            BandMachine.compose(Integer.parseInt(pieceLength.getText()), //int pieceLength - the length of the piece (in bars)
                    (double)Integer.parseInt(fadeInLength.getText()), (double)Integer.parseInt(fadeOutLength.getText()), progressionStyleChosen,
                    pianoSwitch.getState(), pianoStyleChosen, bassSwitch.getState(), bassStyleChosen, drumsSwitch.getState(), drumsStyleChosen,
                    firstChord, lastChord, fileName.getText());
        }
    }
    //returns a string[] given a upper or lower case roman numeral
    //this method is used in the selection of a first and last bar

    public String[] chordSelect(String s) {
        String[] chord = new String[2];
        if(s == "I") {
            chord[0] = "0";
            chord[1] = "MAJ";
        } else if(s == "IV") {
            chord[0] = "5";
            chord[1] = "MAJ";
        } else if(s == "V") {
            chord[0] = "7";
            chord[1] = "MAJ";
        } else { //if (fChord = "i")
            chord[0] = "0";
            chord[1] = "MIN";
        }
        return chord;
    }
}
