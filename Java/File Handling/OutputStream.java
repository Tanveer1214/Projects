import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fo = new FileOutputStream("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt",true);
        String s = " Khaskheli";
        char[] arr = s.toCharArray();
        for(char i : arr) {
            fo.write(i);
        }
        fo.close();
		
	}
}