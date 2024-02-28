package ru.gagich;

import java.util.Scanner;

public class CommandProcessor {
    private Counter counter;

    public CommandProcessor(Counter counter) {
        this.counter = counter;
    }

    public void processCommands() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("Текущее значение счетчика: " + counter.getCount());
            System.out.println("Введите команду (/inc - увеличить счетчик, /reset - сбросить счетчик, /stop - завершить программу):");
            command = scanner.nextLine();

            switch (command) {
                case "/inc":
                    counter.increment();
                    System.out.println("Счетчик увеличен. Новое значение: " + counter.getCount());
                    break;
                case "/reset":
                    counter.reset();
                    System.out.println("Счетчик сброшен. Новое значение: " + counter.getCount());
                    break;
                case "/stop":
                    System.out.println("Завершение программы.");
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        } while (!command.equals("/stop"));

        scanner.close();
    }
}