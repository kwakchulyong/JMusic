package tester;

import jm.music.data.Note;
import jm.music.data.Phrase;

/**
 * This class creates a one bar disco beat with claps
 * @author Andrew Brown
 */
public class ClapBeat extends DiscoBeat {

    protected String getName() {
        return "Disco drum beat with claps";
    }

    protected void composeClaps(final Phrase claps) {
        claps.addNote(new Note(REST, MINIM));
        claps.addNote(new Note(REST, QUAVER));
        claps.addNote(new Note(HAND_CLAP, QUAVER));
        claps.addNote(new Note(HAND_CLAP, CROTCHET));
    }
}
