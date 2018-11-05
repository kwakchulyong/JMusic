package libraryofMethods;

import jm.JMC;

import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;

import jm.util.Write;

public final class UseMyLibrary implements JMC {

    private static int[] chordProgression = { 60, 60, 65, 60, 67, 65, 60, 60 };

    public static void main(String[] args) {
        Score s = new Score("Score", 130);

        //drums
        Part p = new Part("Drums", 0, 9);
        Phrase phr = new Phrase();
        phr = MyLibrary.basicDrums();
        Mod.repeat(phr, 7);
        p.addPhrase(phr);
        s.addPart(p);

        //chords
        Part p2 = new Part("Chords", PIANO, 1);
        for(int c = 0; c < chordProgression.length; c++) {
            p2.addCPhrase(MyLibrary.majorChord(chordProgression[c]));
        }

        s.addPart(p2);

        //bass
        Part p3 = new Part("Bass", BASS, 2);

        Phrase Bphr = new Phrase();
        for(int c = 0; c < chordProgression.length; c++) {
            Bphr = MyLibrary.bassPhrase(chordProgression[c] - 24);
            p3.addPhrase(Bphr);
        }

        s.addPart(p3);

        //write the score as a MIDI file to disk
        Write.midi(s, "UseMyLibraryTest2.mid");
    }
}
