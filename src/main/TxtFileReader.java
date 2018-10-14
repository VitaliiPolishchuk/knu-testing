import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtFileReader implements iFileReader {

    public TxtFileReader() {
    }

    public String  readFile(String file) {
        String contents = new String();
        try{
            contents = new String(Files.readAllBytes(Paths.get(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

}
