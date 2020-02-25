import java.util.ArrayList;
import java.util.List;

public class WordSearchSearcher {

    WordSearchValidator wordSearchValidator;

    public WordSearchSearcher(WordSearchValidator wordSearchValidator) {
        this.wordSearchValidator = wordSearchValidator;
    }

    public List<String> findWordsInString(String string) {
        List<String> foundWords = new ArrayList<String>();
        int stringLength = string.length();
        boolean lineSearched = false;

        if (stringLength <= 4) {
            return  foundWords;
        }

        int wordStart = 0;
        int wordEnd = 4;
        int completedWordMarker = -1;

        //itterate though the line of letters and use this logic to determine what to do next
        while (!lineSearched) {
            String substring = string.substring(wordStart, wordEnd);
            WordSearchValidatorState validatorState = wordSearchValidator.validateWord(substring);
            //if we don't have a complete word yet , but we reached the end of the line then move the start forward and start over.
            if(validatorState == WordSearchValidatorState.PartialWord && wordEnd >= stringLength && completedWordMarker == -1) {
                wordStart++;
                wordEnd = wordStart + 4;

                //if we have a word mark it!
            } else if ( validatorState == WordSearchValidatorState.CompleteWord) {
                //mark it!
                completedWordMarker = wordEnd;
                //then look at the next one.
                wordEnd++;
                //if we have a partial work keep looking
            } else if (validatorState == WordSearchValidatorState.PartialWord) {
                wordEnd++;
                //if we dont have a word check if we had once once.
            } else if (validatorState == WordSearchValidatorState.NoWord) {
                //check to see if we have a completed work
                //if we had a word return that word and start over after that word
                if (completedWordMarker != -1) {
                    //if so add it then reset everything
                    String wordToAdd = string.substring(wordStart, completedWordMarker);
                    foundWords.add(wordToAdd);

                    wordStart = completedWordMarker;
                    wordEnd = wordStart + 4;
                    completedWordMarker = -1;
                    //otherwise move the start forward
                } else {
                    //otherwise reset everything to the text start spot
                    wordStart += 1;
                    wordEnd = wordStart + 4;
                }
            }

            //if we hit then end move the start forward unless
            if (wordEnd > stringLength) {
                //unless we have a completed word, then add that word and look after it
                if (completedWordMarker != -1) {

                    String wordToAdd = string.substring(wordStart, completedWordMarker);
                    foundWords.add(wordToAdd);

                    wordStart = completedWordMarker;
                    wordEnd = wordStart + 4;
                    completedWordMarker = -1;
                } else {

                    wordStart += 1;
                    wordEnd = wordStart + 4;
                }
            }

            //if the start is too close to the end, then we are done.
            if (wordStart + 4 > stringLength) {
                if (completedWordMarker != -1) {

                    String wordToAdd = string.substring(wordStart, completedWordMarker);
                    foundWords.add(wordToAdd);

                }
                lineSearched = true;
            }

        }

        return foundWords;
    }
}
