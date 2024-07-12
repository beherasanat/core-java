package io;

import java.io.*;

public class ExternalizationTest {
static Data data;
    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream  = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;

        data = new Data(1, "sanat", 19);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            data.writeExternal(objectOutputStream);
            System.out.println("Data written to ByteArray");
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            data.readExternal(objectInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {byteArrayOutputStream.close();} catch (Exception ex){}
            try {byteArrayInputStream.close();} catch (Exception ex){}
            try {objectInputStream.close();} catch (Exception ex){}
            try {objectOutputStream.close();} catch (Exception ex){}
        }
    }
}
