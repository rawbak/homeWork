package ru.gb.family_tree.file_work;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writable {

    @Override
    public boolean write(Serializable serializable, String fileName) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Object read(String fileName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}


