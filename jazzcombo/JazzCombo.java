package jazzcombo;

import jm.JMC;

import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

import jm.util.Write;

/**
 * This class uses the jMusic CPhrase (Chord Phrase)
 * The class generates a bass line, chords, melody, and two percussion parts
 * around the cycle of 5ths chord progression
 * It uses several static utility classes supporting one main class.
 * This program is based upon the Chords example in the jMusic tutorial.
 * If this class looks daunting check out the Chords example first.
 * @author Andrew Brown
 */
public class JazzCombo implements JMC {

    public static void main(String[] args) {
        new JazzCombo();
    }

    public JazzCombo() {
        Score s = new Score("CPhrase class example", 100);
        Part guitarPart = new Part("Guitar", CLEAN_GUITAR, 0);
        Part bassPart = new Part("Bass", ELECTRIC_BASS, 1);
        Part ridePart = new Part("Drums", 0, 9);
        Part snarePart = new Part("Drums 2", 0, 10);
        Part saxPart = new Part("Lead", SOPRANO_SAX, 2);
        Phrase bassPhrase = new Phrase();

        //Let us know things have started
        System.out.println("Creating chord progression . . .");

        //choose rootPitch notes around the cycle of fifths
        int rootPitch = d4; //set start pitch to C
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 4; j++) { // 4 chords to a bar
                guitarPart.addCPhrase(JazzGuitar.triad(rootPitch));
            }
            bassPart.addPhrase(JazzBass.bassLine(rootPitch));
            ridePart.addPhrase(JazzDrums.swingTime());
            snarePart.addPhrase(JazzDrums.swingAccents());
            saxPart.addPhrase(JazzSax.melody(rootPitch));
            // choose the next root pitch
            rootPitch -= 7;
            for(int k = 0; k < 4; k++) {
                guitarPart.addCPhrase(JazzGuitar.domSeventh(rootPitch));
            }
            bassPart.addPhrase(JazzBass.bassLine2(rootPitch));
            ridePart.addPhrase(JazzDrums.swingTime());
            snarePart.addPhrase(JazzDrums.swingAccents());
            saxPart.addPhrase(JazzSax.melody(rootPitch));
            rootPitch += 5;
        }

        // transpose parts
        //guitarPart.transpose(12);
        //bassPart.transpose(-12);

        //pack the parts into a score
        s.addPart(guitarPart);
        s.addPart(bassPart);
        s.addPart(ridePart);
        s.addPart(snarePart);
        s.addPart(saxPart);

        //display the music
        //View.show(s);

        // write the score to a MIDIfile
        Write.midi(s, "JazzComboTest6.mid");
    }
}

