package tester;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Phrase;

import jm.util.View;

public class Dot01 implements JMC {

    public static void main(String[] args) {
        Note n;
        n = new Note(C4, QUARTER_NOTE);
        Phrase phr = new Phrase();
        phr.addNote(n);

        View.notate(phr);
    }
}
