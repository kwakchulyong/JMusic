package bandMachine;

/* --------------------
* BANDMACHINE - a class that creates a piece of music
* using the DrumMachine, BassMachine and PianoMachine,
* as well as the ChordProgression class
* @author Andrew Troedson
* ---------------------
*/

import jm.music.data.*;

import jm.JMC;

import jm.midi.SMF;

import jm.music.tools.*;

import jm.util.*;

public final class BandMachine implements JMC {

    public static void compose(int pieceLength, double fadeInLength, double fadeOutLength, String progressionStyle, boolean pianoPart,
                               String pianoStyle, boolean bassPart, String bassStyle, boolean drumsPart, String drumsStyle, String[] firstChord,
                               String[] lastChord, String fileName) {
        System.out.println("BAND MACHINE STATS:");
        System.out.println("Piece length: " + pieceLength);
        System.out.println("fade in over " + fadeInLength + " bars");
        System.out.println("fade out over " + fadeOutLength + " bars");
        System.out.println(progressionStyle + " style chord progression");
        if(pianoPart) {
            System.out.println(pianoStyle + " piano part");
        }
        if(bassPart) {
            System.out.println(bassStyle + " bass part");
        }
        if(drumsPart) {
            System.out.println(drumsStyle + " drum part");
        }
        System.out.println("First chord: " + firstChord[0] + " " + firstChord[1]);
        System.out.println("Last chord: " + lastChord[0] + " " + lastChord[1]);
        System.out.println("Output file: " + fileName);
        //Create the data objects we want to use
        Score score = new Score("MainScore", 120);
        //Parts can have a name, channel, and instrument.
        Part piano = new Part("Piano", PIANO, 0);
        Part bass = new Part("Bass", BASS, 1);
        Part drums = new Part("Drums", 0, 9);

        int progressionLength = pieceLength;

        //set the root and tonality of the first bar
        int root = Integer.parseInt(firstChord[0]);
        String tonality = firstChord[1];

        for(int j = 0; j < progressionLength; j++) {

            //don't get a new chord for the first bar
            if(j > 0) {
                String[] nextChord = ChordProgression.nextChord(root, tonality, progressionStyle);
                root = Integer.parseInt(nextChord[0]);
                tonality = nextChord[1];
            }
            //set the last chord
            if(j == progressionLength - 1) {
                root = Integer.parseInt(lastChord[0]);
                tonality = lastChord[1];
            }
            System.out.println(root + " " + tonality);

            if(pianoPart) {
                CPhrase nextBar = PianoMachine.getBar(tonality, pianoStyle);
                nextBar.setStartTime((float)(j * 4));
                Mod.transpose(nextBar, root);
                piano.addCPhrase(nextBar);
            }

            if(bassPart) {
                Phrase nextBassBar = BassMachine.getBar(tonality, bassStyle);
                nextBassBar.setStartTime((float)(j * 4));
                Mod.transpose(nextBassBar, root);
                bass.addPhrase(nextBassBar);
            }

            if(drumsPart) {
                CPhrase nextDrumBar = DrumMachine.getBar(drumsStyle);
                nextDrumBar.setStartTime((float)(j * 4));
                drums.addCPhrase(nextDrumBar);
            }
        }

        //add part (instrument) to the score
        score.addPart(piano);
        score.addPart(bass);
        score.addPart(drums);
        Mod.fadeIn(score, fadeInLength);
        Mod.fadeOut(score, fadeOutLength);

        //OK now we test SMF write and read
        Write.midi(score, fileName);
    }
}
