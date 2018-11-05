package tester;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

import jm.util.Write;

/**
 * A short example which generates a random chromatic melody
 * and writes to a MIDI file called stochy.mid
 * @author Andrew Brown
 */
public final class Stochastic implements JMC {

    public static void main(String[] args) {
        Score stochScore = new Score("JMDemo - Stochastic");
        Part inst = new Part("Piano", PIANO, 0);
        Phrase phr = new Phrase(0.0);

        // create a phrase of randomly pitched quavers over the full MIDI range.
        for(int i = 0; i < 24; i++) {
            Note note = new Note((int)(Math.random() * 127), QUAVER);
            phr.addNote(note);
        }

        // add the phrase to an instrument and that to a score
        inst.addPhrase(phr);
        stochScore.addPart(inst);

        // create a MIDI file of the score
        Write.midi(stochScore, "stochy.mid");
    }
}
