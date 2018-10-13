package file.processing;

import java.util.ArrayList;
import java.util.List;

public class ListWords {
    List<String> listWords;
    private static int maxLetterCount = 30;

    public ListWords() {
        this.listWords = new ArrayList<String>();
    }

    public boolean addWord(String word) {
        int worlLen = word.length();

        if (worlLen > 0 && worlLen < maxLetterCount){
            //calculate count of consonant in the word
            int wordCountConsonant = word.replaceAll("[aeyuoi]", "").length();
            int wordCountVowel = worlLen - wordCountConsonant;
            //add new word to list
            if(wordCountVowel > wordCountConsonant) {
                this.listWords.add(word.toLowerCase());
            }
            return true;
        }
        return false;
    }

    public boolean contains(String word){
        return listWords.contains(word);
    }

    public String remove(String word){
        if(listWords.indexOf(word) != -1) {
            return listWords.remove(listWords.indexOf(word));
        } else {
            return "";
        }
    }

    public String toString(){
        return listWords.toString();
    }

}
