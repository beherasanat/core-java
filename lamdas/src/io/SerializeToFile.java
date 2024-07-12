package io;

import java.io.*;
import java.util.Date;

public class SerializeToFile {
    public static void main(String[] args) {
        processWithoutSerialVersionUID();
        processWithSerialVersionUID();
    }

    static void processWithSerialVersionUID() {
        WithSerialVersionUID ws1 = new WithSerialVersionUID(1, "sanat", new Date());
        String filePath = "F:\\with.bin";
        //write(filePath, ws1);
        read(filePath);
    }

    static void processWithoutSerialVersionUID() {
        WithoutSerialVersionUID ws1 = new WithoutSerialVersionUID(1, "sanat", new Date());
        String filePath = "F:\\without.bin";
        //write(filePath, ws1);
        read(filePath);
    }

    static void write(String filePath, Object o) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(o);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void read(String filePath) {
        try (FileInputStream fos = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fos);) {
            System.out.println(ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class WithSerialVersionUID implements Serializable {
    public final static long serialVersionUID = 1L;

    int id;
    String name;
    //int age;
    Date dob;

    public WithSerialVersionUID() {
    }

    public WithSerialVersionUID(int id, String name, Date dob) {
        this.id = id;
        this.name = name;
        //this.age = age;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "WithSerialVersionUID{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + dob +
                '}';
    }
}

class WithoutSerialVersionUID implements Serializable {

    int id;
    String name;
    //int age;
    Date dob;

    public WithoutSerialVersionUID() {
    }

    public WithoutSerialVersionUID(int id, String name, Date age) {
        this.id = id;
        this.name = name;
        this.dob = age;
    }

    @Override
    public String toString() {
        return "WithoutSerialVersionUID{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + dob +
                '}';
    }
}
