package AlgorithmsAndDataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 1/4/19
 */
public class Classwork0 {
    public static void main(String[] args) {
        System.out.println(makeAllWords(2, 3));
    }

    public static List<String> makeAllWords(int k, int maxLetter){
        return makeAllWords(k, maxLetter, "", new ArrayList<>(Math.pow(maxLetter, k)));
    }

    public static List<String> makeAllWords(int k, int maxLetter, String currentString, List<String> combination){
        if(k == 0){
            combination.add(currentString);
        }else{
            for(int i = 0; i < maxLetter; i++){
                makeAllWords(k - 1, maxLetter, currentString + ((char) ('a' + i)), combination);
            }
        }
        return combination;
    }
}
