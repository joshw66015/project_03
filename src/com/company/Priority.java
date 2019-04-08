package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Created by 017075 on 2/14/2019.
 */
public class Priority implements Iterable<Task>{
    private Scanner scan = new Scanner(System.in);
    public ArrayList<Task> taskList = new ArrayList<>();
    public void addTask(){
        int taskPriority = 0;
        System.out.println("What is the task title?");
        String taskTitle = scan.nextLine();
        System.out.println("What is the task description?");
        String taskDesc = scan.nextLine();
        boolean validInput;
        do {
            try {
                System.out.println("What is the task priority(0-5)?");
                taskPriority = scan.nextInt();
                scan.nextLine();
                if (-1<taskPriority && taskPriority<6) {
                    validInput = true;
                }else{
                    validInput = false;
                    System.out.println("Invalid input.");
                }
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
        Task task = new Task(taskTitle,taskDesc,taskPriority);
        taskList.add(task);
    }
    public void remTask(){
        int taskID = 0;
        boolean validInput = false;
        do {
            try {
                listTasks();
                System.out.println("What is the task you would like to remove?");
                taskID = Integer.parseInt(scan.nextLine());
                for (Task task : taskList){
                    if (task.getTaskNum() == taskID){
                        taskList.remove(task);
                        validInput = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
    }
    public void editTask(){
        int taskID = 0;
        boolean validInput = false;
        do {
            try {
                listTasks();
                System.out.println("What is the task you would like to edit?");
                taskID = Integer.parseInt(scan.nextLine());
                for (Task task : taskList){
                    if (task.getTaskNum() == taskID){
                        int taskPriority = 0;
                        System.out.println("What would you like to change the title to?");
                        String taskTitle = scan.nextLine();
                        System.out.println("What would you like to change the description to?");
                        String taskDesc = scan.nextLine();
                        boolean validInput2;
                        do {
                            try {
                                System.out.println("What would you like to change the priority to?(0-5)");
                                taskPriority = scan.nextInt();
                                scan.nextLine();
                                if (-1<taskPriority && taskPriority<6) {
                                    validInput2 = true;
                                }else{
                                    validInput2 = false;
                                    System.out.println("Invalid input.");
                                }
                            } catch (Exception e) {
                                scan.nextLine();
                                System.out.println("Invalid input.");
                                validInput2 = false;
                            }
                        }while(!validInput2);
                        task.setTitle(taskTitle);
                        task.setDescription(taskDesc);
                        task.setPriority(taskPriority);
                        validInput = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
    }
    public void listTasks(){
        int ID = 1;
        for (int i=5;i>=0;i--){
            for (Task task : taskList){
                if(task.getPriority()==i){
                    task.setTaskNum(ID);
                    System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
                    ID++;
                }
            }
        }
    }
    public void listTasksPriority(){
        int taskPriority = 0;
        boolean validInput;
        do {
            try {
                System.out.println("What priority tasks would you like to see?(0-5)");
                taskPriority = scan.nextInt();
                scan.nextLine();
                if (-1<taskPriority && taskPriority<6) {
                    validInput = true;
                }else{
                    validInput = false;
                    System.out.println("Invalid input.");
                }
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Invalid input.");
                validInput = false;
            }
        }while(!validInput);
        for (Task task : taskList){
            if(task.getPriority()==taskPriority){
                task.setTaskNum(taskPriority);
                System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
            }
        }
    }
    @Override
    public Iterator<Task> iterator() {
        return taskList.iterator();
    }
}

