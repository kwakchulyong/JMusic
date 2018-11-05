package tester;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

import jm.util.Write;

public class test implements JMC {

    public static void main(String[] args) {
        System.out.println("Java works");
        Score s = new Score(new Part(new Phrase(new Note(C4, MINIM))));
        Write.midi(s, "Test.mid");
    }
}
