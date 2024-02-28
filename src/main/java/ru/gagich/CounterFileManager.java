package ru.gagich;

import java.io.*;

public class CounterFileManager {
    private final String fileName;

    public CounterFileManager(String fileName) {
        this.fileName = fileName;
    }

    public Counter readCounter() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Counter) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Не удалось прочитать файл счетчика. Создаем новый.");
            return new Counter(0);
        }
    }

    public void writeCounter(Counter counter) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(counter);
        } catch (IOException e) {
            System.err.println("Не удалось прочитать файл счетчика.");
        }
    }
}