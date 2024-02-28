package ru.gagich;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        CounterFileManager fileManager = new CounterFileManager("counter.ser");
        Counter counter = fileManager.readCounter();
        CommandProcessor commandProcessor = new CommandProcessor(counter, fileManager);
        commandProcessor.start();
    }
}