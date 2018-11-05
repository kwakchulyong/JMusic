package tester;

import jm.music.data.Note;
import jm.music.data.Phrase;

/**
 * This class creates a one bar disco beat
 * @author Andrew Brown
 */
public class DiscoBeat extends BasicBeat {

    protected String getName() {
        return "Disco drum beat";
    }

    protected void composeHats(final Phrase hats) {
        for(int i = 0; i < 4; i++) {
            hats.addNote(new Note(CLOSED_HI_HAT, QUAVER));
            hats.addNote(new Note(OPEN_HI_HAT, QUAVER));
        }
    }
}
