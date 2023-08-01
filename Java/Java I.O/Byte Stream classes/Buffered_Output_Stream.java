import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Buffered_Output_Stream {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        String s = "My Name is Tanveer";
        byte[] bytes = s.getBytes();
        bufferedOutputStream.write(bytes);

        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        fileOutputStream.close();

    }
}
/*
Buffer is temporary storage first buffer store all character in buffer then write in the file.
it is quite fast as FileOutputStream class.
 */