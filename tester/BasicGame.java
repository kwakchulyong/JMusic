package tester;

import java.awt.Frame;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

public class BasicGame implements JMC {

    public static void main(String[] args) {
        new BasicGame();
    }

    public BasicGame() {
        Phrase phr = new Phrase();
        for(int i = 0; i < 16; i++) {
            Note n = new Note(60 + i, 0.25);
            phr.addNote(n);
        }
        Part p = new Part(phr);
        Score s = new Score(p);

        //QTCycle qtc = new QTCycle(s);

        //qtc.startPlayback();
        //jm.util.Play.midiCycle(s);
        jm.util.Play.midiCycle(s);

        Frame f = new Frame();
        f.setVisible(true);
    }
}
