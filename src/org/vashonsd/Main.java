package org.vashonsd;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Day thisDay = new Day();
        thisDay.addTask("Wax moustache");
        thisDay.addTask("Go home");
        System.out.println(thisDay);

        // Day day= new Day();


        Scanner input= new Scanner(System.in);
        System.out.println("Enter a date (m/d)");
        String givenDate= input.nextLine();
        Day day = new Day(givenDate);

        day.save();

        Schedule s = new Schedule("monday");
        s.addTaskToDay("walk and chew gum", "monday");
        s.addTaskToDay("drink water", "monday");
        s.getTasksFromUser();
        System.out.println(s.getTasksPerDay());
        s.getTasksFromUser();
        System.out.println(s.getTasksPerDay());











    }
}
