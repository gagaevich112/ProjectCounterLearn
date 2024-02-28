package ru.gagich;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Counter counter = loadCounter();
        CommandProcessor commandProcessor = new CommandProcessor(counter);
        commandProcessor.processCommands();
        saveCounter(counter);
    }

    private static Counter loadCounter() {
        Counter counter = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("counter.ser"))) {
            counter = (Counter) ois.readObject();
            System.out.println("Счетчик загружен, значение: " + counter.getCount());
        } catch (FileNotFoundException e) {
            System.out.println("Файл счетчика не найден, создан новый счетчик.");
            counter = new Counter();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }

    private static void saveCounter(Counter counter) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("counter.ser"))) {
            oos.writeObject(counter);
            System.out.println("Счетчик сохранен в файле counter.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}