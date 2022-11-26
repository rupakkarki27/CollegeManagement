package com.collegemgmt;

import java.util.ArrayList;

public abstract class FileOperations<T> {
    public abstract void writeToFile(ArrayList<T> payload);
    public abstract ArrayList<T> readFromFile();
}
