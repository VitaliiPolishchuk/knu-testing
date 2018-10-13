package testng;

import file.processing.ListWords;
import org.testng.Assert;
import org.testng.annotations.*;

public class ListWordsTestNGTest {
    static ListWords listWords = new ListWords();

    @BeforeClass
    static public void beforeClass(){
        listWords.addWord("usa");
    }

    @BeforeTest
    public void beforeTest(){
        listWords.addWord("aid");
    }

    @AfterTest
    public void afterTest(){
        listWords.remove("aid");
    }

    @DataProvider(name = "test1")
    public static Object[][] addWord() {
        return new Object[][] {{"success", false}, {"aorta", true}, {"air", true}};
    }

    @Test(dataProvider = "test1", groups = { "init"})
    public void addWord(String inputString, Boolean expectedResult){

        listWords.addWord(inputString);

        Assert.assertEquals(listWords.contains(inputString), (boolean)expectedResult);
    }

    @Test(groups = {"remove"})
    public void remove_basic(){
        listWords.remove("aid");
        Assert.assertEquals(false, listWords.contains("aid"));
    }

    @Test(groups = {"remove"})
    public void remove_word(){
        Assert.assertEquals(listWords.remove("success"), "");
    }

    @Test(groups = { "init"})
    public void contains(){
        ListWords listWordDemo = new ListWords();
        listWordDemo.addWord("ear");
        Assert.assertTrue(listWordDemo.contains("ear"));
    }

    @Test(groups = {"independent"})
    public void hasToString(){
        Assert.assertEquals(listWords.toString(), "[usa, aorta, air, aid]");
    }
}