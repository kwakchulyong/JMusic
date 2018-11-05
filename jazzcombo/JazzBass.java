package jazzcombo;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Phrase;

public class JazzBass implements JMC {

    public static Phrase bassLine(int rootPitch) {
        // build the bass line from the rootPitch
        Phrase phr = new Phrase();
        phr.addNote(new Note(rootPitch, C));
        phr.addNote(new Note(rootPitch - 2, C));
        phr.addNote(new Note(rootPitch - 3, C));
        phr.addNote(new Note(rootPitch - 5, C));
        return phr;
    }

    public static Phrase bassLine2(int rootPitch) {
        // build the bass line from the rootPitch
        Phrase phr = new Phrase();
        phr.addNote(new Note(rootPitch, C));
        phr.addNote(new Note(rootPitch + 4, C));
        phr.addNote(new Note(rootPitch + 7, C));
        phr.addNote(new Note(rootPitch + 4, C));
        return phr;
    }
}
