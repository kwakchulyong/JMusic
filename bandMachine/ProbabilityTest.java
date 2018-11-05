package bandMachine;

/* --------------------
* A Probability Test that makes and returns a selection
* based on a given list (array) of probabilities
* @author Andrew Troedson
* ---------------------
*/

public final class ProbabilityTest {

    /**
     * Don't let anyone instantiate this class.
     */
    private ProbabilityTest() {
    }

    /**
     * ProbabilityTest's sole method
     * Returns an integer when given an array of probabilities
     */
    public static int MakeChoice(int[] choicesProbabilityList) {

        int choicesNumberOf = choicesProbabilityList.length; //the number of possible choices

        //find the sum of the possible choices
        int choicesTotal = 0;
        for(int i = 0; i < choicesNumberOf; i++) {
            choicesTotal += choicesProbabilityList[i];
        }

        //make the choice
        int randNum = (int)(java.lang.Math.random() * choicesTotal); //choice a random number between 0 and (the sum of the possible choices - 1)
        int probabilityCount = 0;
        int chosen = 0; //the final choice

        for(int i = 0; i < choicesNumberOf; i++) {
            probabilityCount += choicesProbabilityList[i];
            if(randNum < probabilityCount) {
                chosen = i;
                break;
            }
        }
        return chosen;
    }
}
