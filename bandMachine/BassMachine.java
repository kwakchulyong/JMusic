package bandMachine;

/* --------------------
* A BassMachine that returns Bass Phrases
* @author Andrew Troedson
* ---------------------
*/

import jm.music.data.*;

import jm.JMC;

import jm.util.*;
/* -------------
 * BASS MACHINE
 * -------------
 */
public final class BassMachine implements JMC {

    /**
     * Don't let anyone instantiate this class.
     */
    private BassMachine() {
    }

    //--------------
    // Class Methods
    //--------------

    public static Phrase getBar(String tonality, String style) {

        //The Phrase arrays which store all the phrases
        Phrase[][] bassPhrases = new Phrase[3][2];

        //BASS PHRASES
        //MAJOR
        //Phrase 1
        int[] pitchArrayb1 = { C2, C2, G1, G1, C2 };
        double[] rhythmArrayb1 = { M, Q, Q, Q, Q };
        Phrase bbar1 = new Phrase(0.0);
        bbar1.addNoteList(pitchArrayb1, rhythmArrayb1);

        //Phrase 2
        int[] pitchArrayb2 = { C2, G1, C2, E2, AS1, D2 };
        double[] rhythmArrayb2 = { CD, Q, Q, Q, Q, Q };
        Phrase bbar2 = new Phrase(0.0);
        bbar2.addNoteList(pitchArrayb2, rhythmArrayb2);

        //Phrase 3
        int[] pitchArrayb3 = { C2, D2, E2, AS1, E2, G2, E2, C2 };
        double[] rhythmArrayb3 = { Q, Q, Q, Q, Q, Q, Q, Q };
        Phrase bbar3 = new Phrase(0.0);
        bbar3.addNoteList(pitchArrayb3, rhythmArrayb3);

        //MINOR
        //Phrase 1
        int[] minPitchArrayb1 = { C2, C2, G1, G1, C2 };
        double[] minRhythmArrayb1 = { M, Q, Q, Q, Q };
        Phrase bbar1min = new Phrase(0.0);
        bbar1min.addNoteList(minPitchArrayb1, minRhythmArrayb1);

        //Phrase 2
        int[] minPitchArrayb2 = { C2, G1, C2, EF2, C2, G2 };
        double[] minRhythmArrayb2 = { CD, Q, Q, Q, Q, Q };
        Phrase bbar2min = new Phrase(0.0);
        bbar2min.addNoteList(minPitchArrayb2, minRhythmArrayb2);

        //Phrase 3
        int[] minPitchArrayb3 = { EF2, C2, EF2, G1, C2, EF2, C2 };
        double[] minRhythmArrayb3 = { Q, Q, Q, Q, Q, Q, C };
        Phrase bbar3min = new Phrase(0.0);
        bbar3min.addNoteList(minPitchArrayb3, minRhythmArrayb3);

        //And add 'em in...
        bassPhrases[0][0] = bbar1;
        bassPhrases[1][0] = bbar2;
        bassPhrases[2][0] = bbar3;

        bassPhrases[0][1] = bbar1min;
        bassPhrases[1][1] = bbar2min;
        bassPhrases[2][1] = bbar3min;

        Phrase p;
        int phraseNum = (int)(java.lang.Math.random() * bassPhrases.length);

        if(tonality == "MAJ") {
            p = bassPhrases[phraseNum][0].copy();
        } else if(tonality == "MIN") {
            p = bassPhrases[phraseNum][1].copy();
        } else {
            p = new Phrase(0.0); //if type isn't correct, defaults to an empty phrase
        }

        if(style == "SWING") { //swing that bass groove!!!
            p = PhraseTools.swing(p);
        }
        return p;
    }
}
