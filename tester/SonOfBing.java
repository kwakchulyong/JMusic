package tester;

import jm.JMC;

import jm.audio.Instrument;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

import jm.util.Write;

import tester.ins.SawtoothInst;

public final class SonOfBing implements JMC {

    public static void main(String[] args) {
        Score score = new Score(new Part(new Phrase(new Note(C4, MINIM))));
        Write.midi(score);
        Instrument inst = new SawtoothInst(44100);
        Write.au(score, inst);
    }
}
