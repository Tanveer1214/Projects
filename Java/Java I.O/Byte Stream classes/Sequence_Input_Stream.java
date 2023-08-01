import java.io.*;

public class Sequence_Input_Stream {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream1 = new FileInputStream("C:\\Users\\Tanveer Hussain\\Documents\\test.txt");
        FileInputStream fileInputStream2 = new FileInputStream("C:\\Users\\Tanveer Hussain\\Documents\\example.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Tanveer Hussain\\Documents\\single.txt");
        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1,fileInputStream2);


        int i = 0;
        while((i = sequenceInputStream.read()) != -1) {
            System.out.print((char) i);
            fileOutputStream.write(i);
        }

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
        sequenceInputStream.close();

    }
}

/*
we can read multiple files data from multiple stream using SequenceInputStream class.
 */