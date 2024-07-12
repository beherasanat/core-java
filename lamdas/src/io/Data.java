package io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Data implements Externalizable {

    static final Long serialVersionUID = 1l;
    public transient int id;
    public String name;
    public transient int age;

    public Data() {

    }
    public Data(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.id);
        out.writeUTF(this.name);
        out.writeInt(this.age);
        out.flush();
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = in.readInt();
        this.name = in.readUTF();
        this.age = in.readInt();
        System.out.println(this);
    }
}
