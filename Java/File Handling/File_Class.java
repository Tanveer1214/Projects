import java.io.File;
import java.io.IOException;

public class File_Class {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Tanveer Hussain\\Documents\\MyFile.txt");
        file.createNewFile();
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.exists());
    }
}