package jazzcombo;

import jm.JMC;

import jm.music.data.CPhrase;

public class JazzGuitar implements JMC {

    public static CPhrase triad(int rootPitch) {
        // build the chord from the rootPitch
        int[] pitchArray = new int[3];
        pitchArray[0] = rootPitch;
        pitchArray[1] = rootPitch + 4;
        pitchArray[2] = rootPitch + 7;
        //add chord to the part
        CPhrase chord = new CPhrase();
        chord.addChord(pitchArray, C, 50);
        return chord;
    }

    public static CPhrase domSeventh(int rootPitch) {
        // build the chord from the rootPitch
        int[] pitchArray = new int[4];
        pitchArray[0] = rootPitch;
        pitchArray[1] = rootPitch + 4;
        pitchArray[2] = rootPitch - 2;
        pitchArray[3] = rootPitch - 5;
        //add chord to the part
        CPhrase chord = new CPhrase();
        chord.addChord(pitchArray, C, 50);
        return chord;
    }
}
