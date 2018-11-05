package bandMachine;

/* --------------------
* A PianoMachine that returns Piano CPhrases
* @author Andrew Troedson
* ---------------------
*/

import jm.JMC;

import jm.music.data.*;

/* --------------
 * PIANO MACHINE
 * --------------
 */
public final class PianoMachine implements JMC {

    /**
     * Don't let anyone instantiate this class.
     */
    private PianoMachine() {
    }

    //--------------
    // Class Methods
    //--------------

    public static CPhrase getBar(String tonality, String style) {

        //The Phrase arrays which store all the phrases
        CPhrase[][] pianoPhrases = new CPhrase[3][2];

        //PIANO PHRASES
        //MAJOR
        //Phrase 1
        int[] pitchArray1a = { C2, G2, C3, E3 };
        CPhrase pbar1 = new CPhrase(0.0);
        pbar1.addChord(pitchArray1a, Q);

        int[] pitchArray1b = { C2, G2, C3, E3 };
        pbar1.addChord(pitchArray1b, C);
        int[] pitchArray1c = { C2, C3, E3, G3 };
        pbar1.addChord(pitchArray1c, C);

        int[] pitchArray1d = { C2, G2, C3, E3 };
        pbar1.addChord(pitchArray1d, CD);

        //Phrase 2
        int[] pitchArray2a = { G2, C3, E3 };
        CPhrase pbar2 = new CPhrase(0.0);
        pbar2.addChord(pitchArray2a, C);

        int[] pitchArray2b = { C2, G2, C3, E3 };
        pbar2.addChord(pitchArray2b, C);

        int[] pitchArray2c = { C2, C3, E3, G3 };
        pbar2.addChord(pitchArray2c, C);

        int[] pitchArray2d = { C2, G2, C3, E3 };
        pbar2.addChord(pitchArray2d, C);

        //Phrase 3
        int[] pitchArray3a = { C2, C3, E3 };
        CPhrase pbar3 = new CPhrase(0.0);
        pbar3.addChord(pitchArray3a, C);

        int[] pitchArray3b = { C2, G2, C3, E3 };
        pbar3.addChord(pitchArray3b, Q);

        int[] pitchArray3c = { C2, C3, E3, G3 };
        pbar3.addChord(pitchArray3c, Q);

        int[] pitchArray3d = { C2, G2, C3, E3 };
        pbar3.addChord(pitchArray3d, Q);

        int[] pitchArray3e = { C2, C3, E3, G3 };
        pbar3.addChord(pitchArray3e, Q);

        int[] pitchArray3f = { C2, G2, C3, E3 };
        pbar3.addChord(pitchArray3f, C);

        //MINOR
        //Phrase 1
        int[] minPitchArray1a = { C2, G2, C3, EF3 };
        CPhrase pbar1min = new CPhrase(0.0);
        pbar1min.addChord(minPitchArray1a, Q);

        int[] minPitchArray1b = { C2, G2, C3, EF3 };
        pbar1min.addChord(minPitchArray1b, C);

        int[] minPitchArray1c = { C2, C3, EF3, G3 };
        pbar1min.addChord(minPitchArray1c, C);

        int[] minPitchArray1d = { C2, G2, C3, EF3 };
        pbar1min.addChord(minPitchArray1d, CD);

        //Phrase 2
        int[] minPitchArray2a = { G2, C3, EF3 };
        CPhrase pbar2min = new CPhrase(0.0);
        pbar2min.addChord(minPitchArray2a, C);

        int[] minPitchArray2b = { C2, G2, C3, EF3 };
        pbar2min.addChord(minPitchArray2b, C);

        int[] minPitchArray2c = { C2, C3, EF3, G3 };
        pbar2min.addChord(minPitchArray2c, C);

        int[] minPitchArray2d = { C2, G2, C3, EF3 };
        pbar2min.addChord(minPitchArray2d, C);

        //Phrase 3
        int[] minPitchArray3a = { C2, C3, EF3 };
        CPhrase pbar3min = new CPhrase(0.0);
        pbar3min.addChord(minPitchArray3a, C);

        int[] minPitchArray3b = { C2, G2, C3, EF3 };
        pbar3min.addChord(minPitchArray3b, Q);

        int[] minPitchArray3c = { C2, C3, EF3, G3 };
        pbar3min.addChord(minPitchArray3c, Q);

        int[] minPitchArray3d = { C2, G2, C3, EF3 };
        pbar3min.addChord(minPitchArray3d, Q);

        int[] minPitchArray3e = { C2, C3, EF3, G3 };
        pbar3min.addChord(minPitchArray3e, Q);

        int[] minPitchArray3f = { C2, G2, C3, EF3 };
        pbar3min.addChord(minPitchArray3f, C);

        //And add 'em in...
        pianoPhrases[0][0] = pbar1;
        pianoPhrases[1][0] = pbar2;
        pianoPhrases[2][0] = pbar3;

        pianoPhrases[0][1] = pbar1min;
        pianoPhrases[1][1] = pbar2min;
        pianoPhrases[2][1] = pbar3min;

        CPhrase p;
        int phraseNum = (int)(java.lang.Math.random() * pianoPhrases.length);

        if(tonality == "MAJ") {
            p = pianoPhrases[phraseNum][0].copy();
        } else if(tonality == "MIN") {
            p = pianoPhrases[phraseNum][1].copy();
        } else {
            p = new CPhrase(0.0); //if type isn't correct, defaults to an empty phrase
        }
        //swing that Phrase (or CPhrase in this case!)
        if(style == "SWING") {
            p = CPhraseTools.swing(p);
        }
        return p;
    }
}
