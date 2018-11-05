package tester;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;

import jm.util.Write;

/**

 * This is the simplest jMusic program of all.

 * The eqivalent to a programming language's 'Hello World'

 */

public final class Bing implements JMC {

    public static void main(String[] args) {

        //create a middle C minim (half note)

        Note n = new Note(C4, MINIM);

        //create a phrase

        Phrase phr = new Phrase();

        //put the note inside the phrase

        phr.addNote(n);

        //pack the phrase into a part

        Part p = new Part();

        p.addPhrase(phr);

        //pack the part into a score titled 'Bing'

        Score s = new Score("Bing");

        s.addPart(p);

        //write the score as a MIDI file to disk

        Write.midi(s, "Bing.mid");

    }

}
