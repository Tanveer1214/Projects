import java.io.*;

class Student implements Externalizable {
    int id;
    String name; // this field will not convert into byte stream because we not mention in writeExternal method.

    public Student() {
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id); // now only 'id' will be converted into byte stream
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt(); // we can read only 'id' filed when deserialization performed
    }
}



public class TempJava {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student();
        student.setId(35);
        student.setName("Tanveer");

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Java\\Serialization\\sample.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
		objectOutputStream.close();
		fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:\\Java\\Serialization\\sample.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student1 = (Student) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();

        System.out.println(student1.getId());
        System.out.println(student1.getName());

    }
}

/*
Externalization is an interface which use for customize serialization which field convert into
byte stream, we write that field in writeExternal method. there are two methods which is use for
writing and reading object.
 */