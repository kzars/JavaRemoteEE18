package advanced.filestream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) throws IOException {


        String test = "Output test";

        FileOutputStream out = new FileOutputStream("Data\\Output.txt");

        for(char ch: test.toCharArray()){
            out.write(ch);
        }

    }
}
