package com.collegemgmt;

import java.io.*;
import java.util.ArrayList;

public class StudentFileOperation extends FileOperations<Student>{

    private final String filePath;

    public StudentFileOperation(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(ArrayList<Student> payload) {
        try {
            FileOutputStream fos = new FileOutputStream(this.filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(payload);

            oos.close();

            System.out.println("Successfully saved student to File.");

        }catch(IOException e) {
            System.out.println("Something went wrong while writing to file...");
            System.exit(0);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Student> readFromFile() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(this.filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            students = (ArrayList<Student>) ois.readObject();

        }catch (IOException | ClassNotFoundException e) {
            return students;
        }

        return students;

    }
}
