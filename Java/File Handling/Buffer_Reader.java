import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class Buffer_Reader {
	
    public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt"));
        System.out.println("File length is "+new File("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt").length());
        char[] s = new char[39];
        br.read(s);
        System.out.print(s);
        br.close();

        // other ways to read data from file
        /**String s;
	   FileReader fr=new FileReader("E:/My Lectures/MyFile.txt");
	   BufferedReader br=new BufferedReader(fr);
	   while((s=br.readLine())!=null)
	   {
		   System.out.print(s);
	   }
	   br.close();*/

	   /**int ch;
		FileReader fr=new FileReader("E:/My Lectures/MyFile.txt");
		BufferedReader br=new BufferedReader(fr);
		while((ch=br.read())!=-1)
		{
			System.out.print((char)ch);
		}
		br.close();*/
		
    }
}