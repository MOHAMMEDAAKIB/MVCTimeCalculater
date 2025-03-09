package com.example.calculaterjavafx.Model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCalculater {

    // Method to calculate the remainder between enterTime and exitTime and return it as LocalTime
    public static String remainder(LocalTime enterTime, LocalTime exitTime) {
        // Calculate the duration between the two LocalTimes
        Duration duration = Duration.between(enterTime, exitTime);

        // Get the hours, minutes, and seconds from the duration
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        // Return the duration as a LocalTime object
        return String.valueOf(LocalTime.of((int) hours, (int) minutes, (int) seconds));
    }

    public static String getCurrentTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }

    public static boolean check(LocalTime enterTime, LocalTime exitTime, LocalTime allocatedTime) {
        LocalTime remain = convertTextToTime(remainder(enterTime, exitTime),"HH:mm:ss");

        // Use isAfter() and isBefore() for LocalTime comparison
        return allocatedTime.isBefore(remain);
    }
    public static LocalTime convertTextToTime(String timeText , String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(timeText, formatter);
    }


}
