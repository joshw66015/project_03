package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Joshua Woodson 4/8/2019
 */
public class Main {
    private static Priority taskList = new Priority();
    private static boolean running = true;
    private static Scanner scan = new Scanner(System.in);
    private static void displayMenu(){
        System.out.println("--------------\n" +
                "Choose an option: \n" +
                "(1) Add a Task \n" +
                "(2) Remove a Task \n" +
                "(3) Edit a Task \n" +
                "(4) List Tasks \n" +
                "(5) List Tasks according to priority\n" +
                "(0) Exit");
        String input = scan.nextLine();
        switch(input){
            case "1": taskList.addTask();
                break;
            case "2": taskList.remTask();
                break;
            case "3": taskList.editTask();
                break;
            case "4":
                Collections.sort(taskList.taskList);
                for(Task task: taskList) {
                    System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
                }
                break;
            case "5": taskList.listTasksPriority();
                break;
            case "0": running=false;
                break;
            default:
                System.out.println("Input not valid");
        }
    }
    public static void main(String[] args) {
        while(running){
            displayMenu();
        }
    }
}
