package jazzcombo;

import jm.JMC;

import jm.music.data.Note;
import jm.music.data.Phrase;

public class JazzSax implements JMC {

    public static Phrase melody(int rootPitch) {
        // build the bass line from the rootPitch
        double[] rhythm1 = { 0.34, 0.66, 0.34, 0.66, 0.34, 0.66, 0.34 };
        double[] rhythm2 = { 0.34, 0.66, 0.34, 0.66, 1.34 };
        double[] rhythm3 = { 1.0, 0.34, 0.66, 0.34, 1.0 };
        double[] rhythm4 = { 0.34, 0.66, 1.0, 1.34 };
        int[] mode = { 0, 2, 4, 7, 9 };
        Phrase phr = new Phrase();
        int pitch = (int)Math.random() * 12 + 65;
        int temp = 0;
        boolean ok = false;
        int rhythmNumb = (int)(Math.random() * 4);
        int rhythmLength = 0;
        //choose a rhythm to use for the phrase
        if(rhythmNumb == 0)
            rhythmLength = rhythm1.length;
        if(rhythmNumb == 1)
            rhythmLength = rhythm2.length;
        if(rhythmNumb == 2)
            rhythmLength = rhythm3.length;
        if(rhythmNumb == 3)
            rhythmLength = rhythm4.length;
        // each phrase starts with a rest
        phr.addNote(new Note(REST, 0.66));
        //loop through the rhythm adding notes in a random walk
        for(int i = 0; i < rhythmLength; i++) {
            while(ok == false) {
                //get new interval
                temp = (int)(Math.random() * 10) - 5;
                //check to see if new note is in the mode
                for(int j = 0; j < mode.length; j++) {
                    if((pitch + temp) % 12 == (mode[j] + rootPitch) % 12) {
                        pitch += temp;
                        ok = true;
                        break;
                    }
                }
            }
            //add the next note to the phrase
            if(rhythmNumb == 0)
                phr.addNote(new Note(pitch, rhythm1[i]));
            if(rhythmNumb == 1)
                phr.addNote(new Note(pitch, rhythm2[i]));
            if(rhythmNumb == 2)
                phr.addNote(new Note(pitch, rhythm3[i]));
            if(rhythmNumb == 3)
                phr.addNote(new Note(pitch, rhythm4[i]));
            ok = false;
        }

        return phr;
    }
}
