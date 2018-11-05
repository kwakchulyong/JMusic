package jazzcombo;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Phrase;

public class JazzDrums implements JMC {

    public static Phrase swingTime() {
        // build the bass line from the rootPitch
        Phrase phr = new Phrase();
        int ride = 51;
        phr.addNote(new Note(ride, C));
        phr.addNote(new Note(ride, 0.67));
        phr.addNote(new Note(ride, 0.33));
        phr.addNote(new Note(ride, C));
        phr.addNote(new Note(ride, C));
        return phr;
    }

    public static Phrase swingAccents() {
        // build the bass line from the rootPitch
        Phrase phr = new Phrase();
        int snare = 38;
        for(int i = 0; i < 4; i++) {
            phr.addNote(new Note(REST, 0.67));
            phr.addNote(new Note(snare, 0.33, (int)(Math.random() * 60)));
        }
        return phr;
    }
}
