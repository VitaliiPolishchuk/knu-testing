import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        iFileReader fileReader = new TxtFileReader();

        ListWords listWords = new ListWords(fileReader);

        listWords.addWordFromFile("test.txt");

        System.out.println(listWords.toString());
    }


}
