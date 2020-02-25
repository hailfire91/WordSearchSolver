import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class WordSearchValidator {

    private HashMap<String, WordSearchValidatorState> wordMap;

    public WordSearchValidator() {

        Scanner scanner = null;
        wordMap = new HashMap<String, WordSearchValidatorState>();

        try {
            //TODO initialize the word map so we can validate words against it.
            scanner = new Scanner(new File("resources/words.txt"));

            scanner.useDelimiter("\n");

            while (scanner.hasNext())
            {
                //add each word into the hashmap and add all valid substrings of the word in so we can detect a partial match.
                String wordToAdd = scanner.next();
                wordToAdd = wordToAdd.toUpperCase();
                wordMap.put(wordToAdd, WordSearchValidatorState.CompleteWord);
                for(int i = wordToAdd.length() - 1; i > 0; i--) {
                    String substring = wordToAdd.substring(0, i);
                    wordMap.putIfAbsent(substring, WordSearchValidatorState.PartialWord);

                }

            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("file not found. Please make sure that the words file is in the resources folder.");
            //TODO figure out better exception handling here.
        }

    }

    public WordSearchValidatorState validateWord(String word) {
        if (!wordMap.containsKey(word)) {
            return WordSearchValidatorState.NoWord;
        } else {
            WordSearchValidatorState state = wordMap.get(word);
            return state;
        }
    }
}
