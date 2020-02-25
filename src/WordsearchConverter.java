import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class WordsearchConverter {

    public WordsearchConverter() {
    }

    public List<String> processWordSearch(String wordsearch) {
        List<String> returnList = new ArrayList<String>();
        wordsearch = wordsearch.replaceAll("\\s+","");
        int wordStringLength = wordsearch.length();
        int wordSearchWidth = (int)sqrt((double)wordStringLength);

        //convert the string we took in into a square board
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        int stringPosition = 0;
        for (int rows = 0; rows < wordSearchWidth; rows++) {
            for (int columns = 0; columns < wordSearchWidth; columns++) {
                if (columns == 0) {
                    board.add(new ArrayList<Character>());
                }
//                board.get(rows).get(columns).add(wordsearch.charAt(stringPosition));
                board.get(rows).add(wordsearch.charAt(stringPosition));
                stringPosition++;
            }
        }

        //add all horizontal and vertical strings
        for (int i = 0; i < wordSearchWidth; i ++) {
            String returnStringHorizontal = "";
            String returnStringVertical = "";
            for (int j = 0; j < wordSearchWidth; j++) {
                returnStringHorizontal += board.get(i).get(j);
                returnStringVertical += board.get(j).get(i);
            }
            returnList.add(returnStringHorizontal.toUpperCase());
            returnList.add(returnStringVertical.toUpperCase());
        }

        //I added and tested diagonal search too before realizing it was not part of the spec. You can enable it and test it if you want!

//        //return downwards diagonal strings
//        int row = wordSearchWidth - 1;
//        int column = 0;
//        while (row >= 0) {
//
//            returnList.add(getNegetiveDiagonalRow ( row, column, wordSearchWidth, board));
//
//            row--;
//        }
//        row = 0;
//        while (column < wordSearchWidth) {
//
//            returnList.add(getNegetiveDiagonalRow ( row, column, wordSearchWidth, board));
//
//            column++;
//        }
//
//
//        //return upwards diagonal strings
//        row = 0;
//        column = 0;
//        while (column < wordSearchWidth) {
//
//            returnList.add(getPositiveDiagonalRow ( row, column, wordSearchWidth, board));
//
//            column++;
//        }
//        column = wordSearchWidth - 1;
//        while (row < wordSearchWidth) {
//
//            returnList.add(getPositiveDiagonalRow ( row, column, wordSearchWidth, board));
//
//            row++;
//        }



        return returnList;
    }

    private String getNegetiveDiagonalRow (int row, int column, int wordSearchWidth, ArrayList<ArrayList<Character>> board) {
        int r = row;
        int c = column;
        String returnString = "";
        do {
            returnString = returnString + board.get(r).get(c);
            r++;
            c++;
        } while (r >= 0 && r < wordSearchWidth && c >= 0 && c < wordSearchWidth);

        return returnString.toUpperCase();
    }

    private String getPositiveDiagonalRow (int row, int column, int wordSearchWidth, ArrayList<ArrayList<Character>> board) {
        int r = row;
        int c = column;
        String returnString = "";
        do {
            returnString = returnString + board.get(r).get(c);
            r++;
            c--;
        } while (r >= 0 && r < wordSearchWidth && c >= 0 && c < wordSearchWidth);

        return returnString.toUpperCase();
    }


}
