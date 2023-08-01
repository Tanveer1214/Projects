import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArray_Output_Stream {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream1 = new FileOutputStream("C:\\Users\\Tanveer Hussain\\Documents\\test.txt");
        FileOutputStream fileOutputStream2 = new FileOutputStream("C:\\Users\\Tanveer Hussain\\Documents\\example.txt");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        String s = "Ali Mola";
        byte[] bytes = s.getBytes();
        byteArrayOutputStream.write(bytes);

        byteArrayOutputStream.writeTo(fileOutputStream1);
        byteArrayOutputStream.writeTo(fileOutputStream2);

        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();

    }
}

/*
Java ByteArrayOutputStream class is used to write common data into multiple files.
 */