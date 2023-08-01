import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {
	
	public static void main(String[] args) throws IOException {
        FileInputStream fn = new FileInputStream("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt");
        int i = 0;
        while (i != -1) {
            i = fn.read();
            if(i != -1)
                System.out.print((char) i);
        }
        fn.close();
    }
}