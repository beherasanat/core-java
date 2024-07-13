package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import commons.Employee;

public class SerializationToMemoryByteArray {
    public static void main(String[] args) {

        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);

            Employee emp = new Employee("sanat kumar behera", 50000, 1 );
            System.out.println(emp);

            oos.writeObject(emp);
            oos.flush();

            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            Employee emp2 = (Employee) ois.readObject();
            System.out.println(emp2);

            if(emp == emp2)
                System.out.println("Same objects");
            else
                System.out.println("Different objects");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try { bais.close();} catch (Exception ex){}
            try { oos.close();} catch (Exception ex){}
            try { baos.close();} catch (Exception ex){}
            try { ois.close();} catch (Exception ex){}
        }
    }
}


