import java.io.FileOutputStream;
import java.io.IOException;

public class File_Output_Stream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("C:\\Users\\Tanveer Hussain\\Documents\\test.txt");

        fout.write(65);

        String s = " Tanveer Hussain";
        byte[] bytes = s.getBytes(); // converting string into byte array
        fout.write(bytes);

        System.out.println(bytes[1]);

        fout.close();
    }
}

/*

OutputStream is an abstract class which super class of all byte orientated OutputStream classes.

Java FileOutputStream is an output stream used for writing data to a file.

If you have to write primitive values into a file, use FileOutputStream class. You can write
byte-oriented as well as character-oriented data through FileOutputStream class. But, for
character-oriented data, it is preferred to use FileWriter than FileOutputStream.
 */