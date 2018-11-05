package ExtendedKit;

import jm.JMC;

import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;

import jm.util.Write;

/**
 * An example which generates a drum kit pattern
 * and writes to a MIDI file called kit.mid
 * This version uses static methods in the one class.
 * @author Andrew Brown
 */
public final class StaticKit implements JMC {

    public static void main(String[] args) {
        Score pattern1 = new Score("Static class example", 120);
        Part drums = new Part("Drums", 0, 9); // 9 = MIDI channel 10
        Phrase phrBD = new Phrase();
        Phrase phrSD = new Phrase();
        Phrase phrHH = new Phrase();
        CPhrase phrEnd = new CPhrase();

        //calling static methods below
        phrBD = KickPattern();

        phrSD = SnarePattern();

        phrHH = HatsPattern();

        phrEnd = EndPattern();

        // loop the drum pattern
        int loopNum = 7;
        Mod.repeat(phrBD, loopNum);
        Mod.repeat(phrSD, loopNum);
        Mod.repeat(phrHH, loopNum);

        // add phrases to the instrument (part)
        drums.addPhrase(phrBD);
        drums.addPhrase(phrSD);
        drums.addPhrase(phrHH);
        drums.addCPhrase(phrEnd);

        // add the drum part to a score.
        pattern1.addPart(drums);

        // write the score to a MIDIfile
        Write.midi(pattern1, "StaticKit.mid");
    }

    private static Phrase KickPattern() {
        // make bass drum
        Phrase phrase = new Phrase(0.0);
        for(int i = 0; i < 4; i++) {
            Note note = new Note(36, C);
            phrase.addNote(note);
            Note rest = new Note(REST, C);
            phrase.addNote(rest);
        }
        return phrase;
    }

    private static Phrase SnarePattern() {
        // make snare drum
        Phrase phrase = new Phrase(0.0);
        for(int i = 0; i < 4; i++) {
            Note note = new Note(REST, C);
            phrase.addNote(note);
            Note rest = new Note(38, C);
            phrase.addNote(rest);
        }
        return phrase;
    }

    private static Phrase HatsPattern() {
        Phrase phrase = new Phrase(0.0);
        // make hats
        for(int i = 0; i < 15; i++) {
            Note note = new Note(42, Q);
            phrase.addNote(note);
        }
        Note note = new Note(46, Q); // open hi hat
        phrase.addNote(note);

        return phrase;
    }

    private static CPhrase EndPattern() {
        // make crash ending
        CPhrase cphrase = new CPhrase();
        int[] pitchArray1a = { 36, 49 }; // kick and crash cymbal
        cphrase.addChord(pitchArray1a, SB);

        return cphrase;
    }

}
