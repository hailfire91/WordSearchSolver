import java.util.ArrayList;
import java.util.List;

public class WordSearchSolver {
    public static void main(String[] args) {
        String wordsearch = "A T L L F U V D E Y O B Z V D" +
                "W F B N E D X G H E A N P O R" +
                "O T V B Y L A L G T D K E A A" +
                "D O O W D R A H H E L A S P Z" +
                "A P P E A K H R O F X W L X O" +
                "W B R G A S O M M B R O K E R" +
                "M C X G X O U I E O K M Y K W" +
                "A O E F M R S L S N L R S I I" +
                "S N P D B C E Q P R I U K U Q" +
                "T E G R I P E B O Q U I Q S C" +
                "B P A S D Q P E T X J P S E S" +
                "B R K R R E U E T T D Z D K L" +
                "L B J B C B B L E U B I U R F" +
                "L N H S F H T K R K G H Y A M" +
                "O J H D N Q A J S Q P L R M U";
        WordSearchValidator wordSearchValidator = new WordSearchValidator();
        WordsearchConverter wordsearchConverter = new WordsearchConverter();
        WordSearchSearcher wordSearchSearcher = new WordSearchSearcher(wordSearchValidator);
        List<String> wordSearchStrings = wordsearchConverter.processWordSearch(wordsearch);
        List<String> foundWords = new ArrayList<>();
        for (String wordString: wordSearchStrings) {
            StringBuilder stringBuilder = new StringBuilder();
            //check strings for all possible words 4 letters or longer
            foundWords.addAll(wordSearchSearcher.findWordsInString(wordString));

            //then check the reverse string
            stringBuilder.append(wordString);
            String reverseWordString = stringBuilder.reverse().toString();
            foundWords.addAll(wordSearchSearcher.findWordsInString(reverseWordString));

        }
        System.out.println(foundWords);
    }
}