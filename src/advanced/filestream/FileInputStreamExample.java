package advanced.filestream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {

        try {

            FileInputStream in = new FileInputStream("Data\\Input.txt");
            int c;

            while ((c = in.read()) != -1){
                System.out.print((char) c);
            }


        }catch (IOException e){
            System.out.println(e);
        }


    }
}
