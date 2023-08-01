import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TempJava {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Tanveer Hussain\\Documents\\test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int i = bufferedInputStream.read();
        while(i != -1) {
            System.out.print((char) i);
            i = bufferedInputStream.read();
        }

        bufferedInputStream.close();
        fileInputStream.close();

    }
}