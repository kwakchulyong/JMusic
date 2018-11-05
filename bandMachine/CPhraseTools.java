package bandMachine;

/* --------------------
* A collection of tools used to alter CPhrases
* @author Andrew Troedson
* ---------------------
*/

import java.util.Enumeration;

import jm.JMC;

import jm.music.data.CPhrase;
import jm.music.data.Phrase;

public final class CPhraseTools implements JMC {

    /**
     * Don't let anyone instantiate this class.
     */
    private CPhraseTools() {
    }

    //--------------
    // Class Methods
    //--------------

    //a method that "swings" a given phrase

    public static CPhrase swing(CPhrase cp) {

        Enumeration enumeration = cp.getPhraseList().elements();
        while(enumeration.hasMoreElements()) {
            Phrase nextPhrase = (Phrase)enumeration.nextElement();
            nextPhrase = PhraseTools.swing(nextPhrase);
        }
        return cp;
    }
}
