package file.processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictWords {
    Map<String, List<String>> dictWords;
    private static int maxLetterCount = 30;

    public DictWords() {
        this.dictWords = new HashMap<String, List<String>>();
        for (int i = 0; i < maxLetterCount; i++){
            dictWords.put(Integer.toString(i), new ArrayList<String>());
        }
    }

    public boolean addWord(String word) {
        int worlLen = word.length();

        if (worlLen > 0 && worlLen < maxLetterCount){
            //calculate count of consonant in the word
            int wordCountConsonant = word.replaceAll("[aeyuoi]", "").length();
            //add new word to dict
            this.dictWords.get(Integer.toString(wordCountConsonant)).add(word.toLowerCase());

            return true;
        }

        return false;
    }

    public void out(){
        for (int i = 0; i < maxLetterCount; i++){
            for (String word : dictWords.get(Integer.toString(i))) {
                System.out.println(word);
            }
        }
    }
}
