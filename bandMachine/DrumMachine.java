package bandMachine;

/* --------------------
* A DrumMachine that creates DrumKit Phrases
* based on probabilities
* @author Andrew Troedson
* ---------------------
*/

import jm.JMC;

import jm.music.data.*;

import jm.midi.*;

import java.util.*;

/*----------------------------
* DRUM MACHINE
*-----------------------------
*/

public final class DrumMachine implements JMC {

    /**
     * Don't let anyone instantiate this class.
     */
    private DrumMachine() {
    }

    //--------------
    // Class Methods
    //--------------

    public static CPhrase getBar(String style) {

        Vector fullKit = new Vector();
        Phrase phrBD = new Phrase(0.0);
        Phrase phrSD = new Phrase(0.0);
        Phrase phrHH = new Phrase(0.0);

        // make bass drum
        int[] BDchance = { 90, 10, 25, 50, 80, 10, 25, 50 };

        for(short i = 0; i < 8; i++) {
            Note note = new Note(36, Q);
            Note rest = new Note(REST, Q); //rest

            if(chanceTest(BDchance[i])) {
                phrBD.addNote(note);
            } else {
                phrBD.addNote(rest);
            }
        }

        // make snare drum
        int[] SDchance = { 15, 5, 80, 5, 20, 15, 80, 15 };

        for(short i = 0; i < 8; i++) {
            Note rest = new Note(REST, Q); //rest
            Note note = new Note(38, Q);

            if(chanceTest(SDchance[i])) {
                phrSD.addNote(note);
            } else {
                phrSD.addNote(rest);
            }
        }

        // make hats
        for(short i = 0; i < 8; i++) {
            Note note = new Note(42, Q);
            Note openNote = new Note(46, Q); // open hi hat
            if(chanceTest(95)) {
                if(chanceTest(80)) {
                    phrHH.addNote(note);
                } else {
                    phrHH.addNote(openNote);
                }
            }
        }

        if(style == "SWING") { //swing them phrases!!!
            phrBD = PhraseTools.swing(phrBD);
            phrSD = PhraseTools.swing(phrSD);
            phrHH = PhraseTools.swing(phrHH);
        }
        // add phrases to the instrument (part)
        fullKit.addElement(phrBD);
        fullKit.addElement(phrSD);
        fullKit.addElement(phrHH);

        CPhrase cp = new CPhrase(0.0);
        cp.setPhraseList(fullKit);

        return cp;
    }

    //a method to make probability based true/false decisions

    private static boolean chanceTest(int percent) {
        boolean b;
        if(percent > (int)(java.lang.Math.random() * 100) + 1) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }
}
