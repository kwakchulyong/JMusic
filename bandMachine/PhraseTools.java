package bandMachine;

/* --------------------
* A collection of tools used to alter Phrases
* @author Andrew Troedson
* ---------------------
*/

import java.util.Enumeration;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Phrase;

public final class PhraseTools implements JMC {

    /**
     * Don't let anyone instantiate this class.
     */
    private PhraseTools() {
    }

    //--------------
    // Class Methods
    //--------------

    //a method that "swings" a given phrase

    public static Phrase swing(Phrase p) {

        double rhythmValueCounter = 0.0;
        int elementCounter = 0;
        Enumeration enumeration = p.getNoteList().elements();
        while(enumeration.hasMoreElements()) {

            Note note = (Note)enumeration.nextElement();
            rhythmValueCounter += note.getRhythmValue();
            if((rhythmValueCounter * 10) % 10 == 5.0) { //if the rhythmValueCounter ends in 0.5
                note.setRhythmValue(note.getRhythmValue() + SQ); //add a semiquaver to the notes rhythmValue
                rhythmValueCounter += SQ;
                if(elementCounter + 1 < p.getNoteList().size() - 1) {
                    Note nextNote = (Note)p.getNoteList().elementAt(elementCounter + 1);
                    nextNote.setRhythmValue(nextNote.getRhythmValue() - SQ); //subtract a semiquaver from the next notes rhythmValue
                }
            }
            elementCounter++;
        }
        return p;
    }
}
