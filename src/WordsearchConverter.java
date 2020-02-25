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

        //TODO return all possible horisontal strings
        //TODO retun all vertical strings
        for (int i = 0; i < wordSearchWidth; i ++) {
            String returnStringHorizontal = "";
            String returnStringVertical = "";
            for (int j = 0; j < wordSearchWidth; j++) {
                returnStringHorizontal += board.get(i).get(j);
                returnStringVertical += board.get(j).get(i);
            }
            returnList.add(returnStringHorizontal);
            returnList.add(returnStringVertical);
        }

        //return downwards diagonal strings
        int row = wordSearchWidth - 1;
        int column = 0;
        while (row >= 0) {

            returnList.add(getNegetiveDiagonalRow ( row, column, wordSearchWidth, board));
            System.out.println("row,column: " + row + ", " + column);

            row--;
        }
        row = 0;
        while (column < wordSearchWidth) {

            returnList.add(getNegetiveDiagonalRow ( row, column, wordSearchWidth, board));
            System.out.println("row,column: " + row + ", " + column);

            column++;
        }


        //TODO return upwards diagonal strings
        row = 0;
        column = 0;
        while (column < wordSearchWidth) {

            returnList.add(getPositiveDiagonalRow ( row, column, wordSearchWidth, board));
            System.out.println("row,column: " + row + ", " + column);

            column++;
        }
        column = wordSearchWidth - 1;
        while (row < wordSearchWidth) {

            returnList.add(getPositiveDiagonalRow ( row, column, wordSearchWidth, board));
            System.out.println("row,column: " + row + ", " + column);

            row++;
        }



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

        return returnString;
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

        return returnString;
    }


}
