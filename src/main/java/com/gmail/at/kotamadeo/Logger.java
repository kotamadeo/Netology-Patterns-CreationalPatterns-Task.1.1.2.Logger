package com.gmail.at.kotamadeo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private int num = 1;
    private static Logger instance = null;
    private static List<String> logData = new ArrayList<>();

    public void log(String message) {
      String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        logData.add("[" + timeStamp + " " + num++ + "] " + message);
    }

    public static Logger getInstance() {
        if (instance == null) {
            return new Logger();
        }
        return instance;
    }

    public void printLog() {
        logData.forEach(System.out::println);
    }
}
