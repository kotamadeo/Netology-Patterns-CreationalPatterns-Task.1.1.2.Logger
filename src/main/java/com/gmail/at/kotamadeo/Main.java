package com.gmail.at.kotamadeo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("\nВведите размер списка N : ");
        int size = scanner.nextInt();
        logger.log("Введите размер списка N : " + size);
        System.out.print("\nВведите верхнюю границу значений элементов в списке M : ");
        int highBorderSize = scanner.nextInt();
        logger.log("Введите верхнюю границу значений элементов в списке M : " + highBorderSize);

        List<Integer> allValues = Arrays.asList(new Integer[size]);
        logger.log("Создаём и наполняем список");
        StringBuilder listAllValuesForLog = new StringBuilder();
        for (int i = 0; i < allValues.size(); i++) {
            int randomInt = random.nextInt(highBorderSize);
            allValues.set(i, randomInt);
            listAllValuesForLog.append(randomInt).append(" ");
        }
        logger.log("Вот случайный список: " + listAllValuesForLog);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("\nВведите число f для фильтрации списка : ");
        int filterNum = scanner.nextInt();
        logger.log("Введено следующее число для фильтрации списка : " + filterNum);
        logger.log("Запускаем фильтрацию");
        List<Integer> result = new Filter(filterNum).filterOut(allValues);
        logger.log("Выводим результат на экран");
        StringBuilder listResultForLog = new StringBuilder();
        for (Integer res : result) {
            listResultForLog.append(res).append(" ");
        }
        logger.log("Отфильтрованный список: " + listResultForLog);
        System.out.print("\nОтфильтрованный список: ");
        result.forEach(x -> System.out.print(x + " "));
        logger.log("Завершаем программу");
        System.out.println(System.lineSeparator());
        logger.printLog();
    }
}