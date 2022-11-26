package com.collegemgmt;

import java.io.*;
import java.util.ArrayList;

public class TeacherFileOperation extends FileOperations<Teacher>{

    private final String filePath;

    public TeacherFileOperation(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(ArrayList<Teacher> payload) {
        try {
            FileOutputStream fos = new FileOutputStream(this.filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(payload);

            System.out.println("Teachers written to file");

            oos.close();

        } catch (IOException e) {
            System.out.println("Something went wrong while writing to file...");
            System.exit(0);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Teacher> readFromFile() {
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(this.filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            teachers = (ArrayList<Teacher>) ois.readObject();

        }catch (IOException | ClassNotFoundException e) {
            return teachers;
        }

        return teachers;
    }
}
