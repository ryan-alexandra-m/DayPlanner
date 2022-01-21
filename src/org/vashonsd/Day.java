package org.vashonsd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneId;
import java.util.Date;

import java.io.IOException;


public class Day {




    LocalDateTime creationDate;
    LocalDateTime day;
    List<String> tasks;

    LocalDate dateGiven;

    public Day() {
        creationDate = LocalDateTime.now();
        day = creationDate;
        tasks = new ArrayList<>();
    }

    public Day(String dateText) {
        creationDate = LocalDateTime.now();

        String givenDate= dateText;


        int slash= (givenDate.indexOf("/"));
        int dateLength= givenDate.length();
        String givenMonth= givenDate.substring(0, slash);
        String givenDay= givenDate.substring(slash+1, dateLength );
        int day=Integer.parseInt(givenDay);
        int month=Integer.parseInt(givenMonth);
        dateGiven = LocalDate.of(2022, month, day);

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(dateGiven.atStartOfDay(defaultZoneId).toInstant());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String dayWeekText = new SimpleDateFormat("EEEE").format(date);
        System.out.println(dayWeekText);

}

    public void addTask(String str) {
        tasks.add(str);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, L/D, u");
        String result = day.format(formatter) + "\n";
        for (String t: tasks) {
            result += t + "\n";
        }
        return result;
    }



    public void save() {
        try {
            File myObj = new File(dateGiven.toString() + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(dateGiven.toString() + ".txt");
            myWriter.write("task");
            myWriter.close();
            System.out.println("Successfully documented task");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}








