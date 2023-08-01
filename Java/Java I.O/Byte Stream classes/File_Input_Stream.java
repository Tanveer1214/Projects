import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_Input_Stream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Tanveer Hussain\\Documents\\test.txt");
        int i = fileInputStream.read(); // reading a single character from the file.
        System.out.println((char) i);

        while(i != -1) { // reading all the data from the file.
            System.out.print((char) i);
            i = fileInputStream.read();
        }

        fileInputStream.close();
    }
}

/*
  A FileInputStream obtains input bytes
  from a file in a file system. What files
  are  available depends on the host environment.

  FileInputStream is meant for reading streams of raw bytes
  such as image data. For reading streams of characters, consider using
  code FileReader.

  FileInputStream is a subclass of InputStream.

 */