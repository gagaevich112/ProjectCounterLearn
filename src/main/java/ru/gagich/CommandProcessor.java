package ru.gagich;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CommandProcessor {
    private final Counter counter;
    private final CounterFileManager fileManager;

    public CommandProcessor(Counter counter, CounterFileManager fileManager) {
        this.counter = counter;
        this.fileManager = fileManager;
    }

    public void start() {
        System.out.println("Счетчик загружен со сначением: " + counter.getCount());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            while (true) {
                System.out.print("Введите команду (inc - увеличить счетчик, reset - сбросить счетчик, stop - завершить программу):");
                input = reader.readLine();
                switch (input) {
                    case "inc":
                        counter.increment();
                        System.out.println("Значение счетчика увеличино. Новое значение: " + counter.getCount());
                        fileManager.writeCounter(counter);
                        break;
                    case "stop":
                        System.out.println("Значение счетчика: " + counter.getCount() + " Завершение программы");
                        return;
                    case "reset":
                        counter.reset();
                        System.out.println("Значение счетчика сброшено. Новое значение равно: " + counter.getCount());
                        fileManager.writeCounter(counter);
                        break;
                    default:
                        System.out.println("Команда не найдена. Попробуйте снова.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}