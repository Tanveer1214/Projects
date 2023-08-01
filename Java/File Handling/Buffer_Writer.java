import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer_Writer {
	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt",true));
		bw.write("From Pakistan");
		bw.close();
		
	}
}
/* this program write the data in a file using Buffer. Buffer is tempory storage first buffer store all
   character in buffer the write in file */