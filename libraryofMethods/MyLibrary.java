package libraryofMethods;

import jm.JMC;

import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Phrase;

/**
 * A skeleton for your own class of library routines to reuse
 * @author Andrew Brown
 */

public final class MyLibrary implements JMC {

    //This method produces one bar of alternating kick and snare

    public static Phrase basicDrums() {
        Phrase drumPhrase = new Phrase();
        for(int i = 0; i < 2; i++) {
            Note n = new Note(36, QUAVER);
            drumPhrase.addNote(n);
            n = new Note(42, QUAVER);
            drumPhrase.addNote(n);
            n = new Note(38, QUAVER);
            drumPhrase.addNote(n);
            n = new Note(42, QUAVER);
            drumPhrase.addNote(n);
        }
        return drumPhrase;
    }

    // This method returns a major triad crotchet

    public static CPhrase majorChord(int root) {
        CPhrase chordPhrase = new CPhrase();
        int[] chordPitches = new int[3];
        chordPitches[0] = root;
        chordPitches[1] = root + 4;
        chordPitches[2] = root + 7;

        chordPhrase.addChord(chordPitches, QUAVER);
        chordPhrase.addChord(chordPitches, CROTCHET);
        chordPhrase.addChord(chordPitches, CROTCHET);
        chordPhrase.addChord(chordPitches, QUAVER);
        chordPhrase.addChord(chordPitches, CROTCHET);
        return chordPhrase;
    }

    // This method returns a one bar bass walk

    public static Phrase bassPhrase(int root) {
        Phrase bassPhrase = new Phrase();
        Note n = new Note(root, C);
        bassPhrase.addNote(n);
        n = new Note(root + 4, C);
        bassPhrase.addNote(n);
        n = new Note(root + 7, C);
        bassPhrase.addNote(n);
        n = new Note(root + 9, C);
        bassPhrase.addNote(n);

        return bassPhrase;
    }
}
