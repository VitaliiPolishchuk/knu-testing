import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ListWordsMockTest {
    @Test()
    public void testReadFromFile() throws IOException{
        FileReader fileReader = new FileReader();
        iFileReader fileReaderSpy = spy(fileReader);
        ListWords listWords = new ListWords(fileReaderSpy);
        listWords.addWordFromFile("test.txt");
        assertTrue(listWords.contains("revolutionary"));
    }

    @Test
    public void testSize() throws IOException{

        iFileReader fileReader = mock(iFileReader.class);
        when(fileReader.readFile("test.txt")).thenReturn("revolutionary face air sick");
        ListWords listWords = new ListWords(fileReader);
        listWords.addWordFromFile("test.txt");
        assertEquals(2,listWords.size());
        verify(fileReader, atLeastOnce()).readFile(anyString());
    }

    @Test(expected = NullPointerException.class)
    public void testException() {
        iFileReader fileReader = mock(iFileReader.class);
        when(fileReader.readFile("")).thenThrow(new NullPointerException("Error occurred"));
        ListWords listWords = new ListWords(fileReader);
        listWords.addWordFromFile("");
    }

    class FileReader implements iFileReader {
        public String readFile(String file){
            return "Hello I am shy file Air revolutionary";
        }
    }

}