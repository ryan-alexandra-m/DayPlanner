package org.vashonsd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Day {
    LocalDateTime creationDate;
    List<String> tasks;

    public Day() {
        creationDate = LocalDateTime.now();
        tasks = new ArrayList<>();
    }

    public void addTask(String str) {
        tasks.add(str);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, L/D, u");
        String result = creationDate.format(formatter) + "\n";
        for (String t: tasks) {
            result += t + "\n";
        }
        return result;
    }
}
