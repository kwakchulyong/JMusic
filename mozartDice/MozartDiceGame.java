package mozartDice;

import jm.JMC;

import jm.music.data.CPhrase;
import jm.music.data.Part;
import jm.music.data.Score;
import jm.music.tools.Mod;

import jm.util.Write;

public final class MozartDiceGame implements JMC {

    public static void main(String[] args) {

        MozartPhraseList MPL = new MozartPhraseList(); //the class in which all the phrases are stored

        //Create the data objects we want to use
        Score score = new Score("MozartDiceGame");
        score.setTempo(120.0);
        //Parts can have a name, channel, and instrument.
        Part piano = new Part("Piano", PIANO);

        for(int j = 0; j < 4; j++) { //repeates the full waltz twice (ie form ABAB)

            for(int i = 0; i < 8; i++) { //create the first part of the waltz
                int randNum = (int)rollDice(2); //roll the dice
                System.out.println("roll " + (i + 1) + ": " + randNum);
                CPhrase nextBar = new CPhrase(0.0);
                nextBar = MPL.barArray[i][randNum - 2].copy(); //get the appropriate phrase
                nextBar.setStartTime((float)((i * 3) + (j * 24))); //set the phrases start time
                piano.addCPhrase(nextBar); //add it to the main part
            }
            j++; //required to set the correct start times in the second section of the waltz

            for(int i = 0; i < 8; i++) { //create the second part of the waltz
                int randNum = (int)rollDice(2);
                System.out.println("roll " + (i + 9) + ": " + randNum);
                CPhrase nextBar = new CPhrase(0.0);
                nextBar = MPL.barArray2[i][randNum - 2].copy(); //get the phrase from the second phrase table
                nextBar.setStartTime((float)((i * 3) + (j * 24)));
                piano.addCPhrase(nextBar);
            }
        }

        //add the main piano part (instrument) to the score
        score.addPart(piano);
        Mod.transpose(score, 12);

        // create a MIDI file of the score
        Write.midi(score, "mozart10.mid");
    }

    //method which automates the rolling of a specified number of die

    static int rollDice(int dieNum) {
        int roll = 0;
        for(int i = 0; i < dieNum; i++) {
            roll += ((int)(java.lang.Math.random() * 6)) + 1;
        }
        return roll;
    }
}
