package tester;

import jm.music.data.Note;
import jm.music.data.Phrase;

/**
 * This class creates a one bar disco beat
 * @author Andrew Brown
 */
public class ShuffleBeat extends BasicBeat {

    protected String getName() {
        return "Shuffle drum beat";
    }

    protected void composeHats(final Phrase hats) {
        for(int i = 0; i < 4; i++) {
            hats.addNote(new Note(CLOSED_HI_HAT, DOTTED_QUAVER));
            hats.addNote(new Note(CLOSED_HI_HAT, SEMI_QUAVER));
        }
    }
}
