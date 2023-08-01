import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    transient int age; // this member will not serialize it will return default value when deserialization.
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class Serialization {
    public static void main(String[] args) {

        // Serialization
        try {
            Student student = new Student(10,"Tanveer",35);
            FileOutputStream fout = new FileOutputStream("sample.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(student);
            out.flush();
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        // Deserialization
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sample.ser"));
            Student s = (Student) objectInputStream.readObject();
            System.out.println(s.id+"\n"+s.name+"\n"+s.age);
            objectInputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}


/*
Serialization and Deserialization
Serialization in Java is a mechanism of writing the state of an object into a byte-stream.
It is mainly used in Hibernate, RMI, JPA, EJB and JMS technologies.
The reverse operation of serialization is called deserialization where byte-stream is converted
into an object.

Serializable is a marker interface (has no data member and method).
Serializable interface must be implemented by the class whose object needs to be persisted.
The String class and all the wrapper classes implement the java.io.Serializable interface by default.

If a class implements Serializable interface then all its subclasses will also be serializable.

If a class has a reference to another class, all the references must be Serializable otherwise
serialization process will not be performed. In such case, NotSerializableException is thrown
at runtime.

If there is any static data member in a class, it will not be serialized because static is the
part of class not object.

If you don't want to serialize any data member of a class, you can mark it as transient.

private and final member can be serialized

static members can not serialized


Points to remember 

1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true. 2. Only non-static data members are saved via Serialization process. 
3. Static data members and transient data members are not saved via Serialization process. So, if you don’t want to save value of a non-static data member then make it transient. 
4. Constructor of object is never called when an object is deserialized. 
5. Associated objects must be implementing Serializable interface. 

 */