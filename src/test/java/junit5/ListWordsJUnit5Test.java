package junit5;

import file.processing.ListWords;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ListWordsJUnit5Test {

    static ListWords listWords = new ListWords();

    @BeforeAll
    static public void beforeAll(){
        listWords.addWord("usa");
    }

    @BeforeEach
    public void beforeEach(){
        listWords.addWord("aid");
    }

    @AfterEach
    public void afterEach(){
        listWords.remove("aid");
    }

    @ParameterizedTest
    @ValueSource(strings = {"success", "aorta", "air"})
    public void addWord(String word){

        listWords.addWord(word);

        int worlLen = word.length();

        int wordCountConsonant = word.replaceAll("[aeyuoi]", "").length();
        int wordCountVowel = worlLen - wordCountConsonant;
        //add new word to list
        if(wordCountVowel > wordCountConsonant) {
            assertThat(listWords.contains(word), equalTo(true));
        } else {
            assertFalse(listWords.contains(word));
        }
    }

    @Test
    public void remove_basic(){
        listWords.remove("aid");
        assertEquals(false, listWords.contains("aid"));
    }

    @Test
    public void remove_word(){
        assertThat(listWords.remove("success"), is(""));
    }

    @Test
    public void contains(){
        ListWords listWordDemo = new ListWords();
        listWordDemo.addWord("ear");
        assertThat(listWordDemo.contains("ear"), is(true));
    }

    @Test
    public void hasToString(){
        assertThat(listWords.toString(), equalTo("[usa, aorta, air, aid]"));
    }
}