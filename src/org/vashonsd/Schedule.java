package org.vashonsd;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Schedule {
        private static Object DayOfWeek;
        java.time.DayOfWeek day;
        LocalDate date;
        String mood;
        String username;
        ArrayList<String> monday = new ArrayList<String>();
        ArrayList<String> tuesday = new ArrayList<String>();
        ArrayList<String> wednesday = new ArrayList<String>();
        static ArrayList<String> thursday = new ArrayList<String>();
        ArrayList<String> friday = new ArrayList<String>();
        ArrayList<String> saturday = new ArrayList<String>();
        ArrayList<String> sunday = new ArrayList<String>();

        Map<String, ArrayList> tasksPerDay = new HashMap<>();


        public ArrayList getTasks(String day) {
            return tasksPerDay.get(day);
        }


        public Schedule(DayOfWeek day, LocalDate date, String mood) {
            this.day = day;
            this.mood = mood;
            this.date = date;

        }

        public Schedule(String tired) {
            String[] days = {"monday","tuesday","wednesday", "thursday","friday","saturday","sunday"};
            for (String d : days) {
                tasksPerDay.put(d, new ArrayList());
            }
            System.out.println(this.tasksPerDay);
        }

        public void addTaskToDay(String task, String day) {
            tasksPerDay.get(day).add(task);
        }

        public Map getTasksPerDay() {
            return this.tasksPerDay;
        }

        public ArrayList getTasksOfDay(String day) {
            return tasksPerDay.get(day);
        }

        public void getTasksFromUser() {
            boolean userIsDone = false;
            while(!userIsDone) {
                Scanner input = new Scanner(System.in);
                System.out.println("What day would you like to add a task to?");
                String inputDay = input.nextLine();
                System.out.println("What task would you like to add?");
                String inputTask = input.nextLine();
                this.addTaskToDay(inputTask, inputDay);
                System.out.println("Would you like to add another task to do today? (yes/no)");
                if(input.nextLine().equals("no")) {
                    userIsDone = true;
                    break;
                }
            }
            System.out.println("Great!");
        }
}
