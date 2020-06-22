package at.cc.jku.task;

import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private Scanner scanner;
    TaskDAO taskDAO;

    public TaskManager() {

        this.scanner = new Scanner(System.in);
        this.taskDAO = new TaskDAO();

    }

    public void mainTaskProgram() {
        System.out.println("Taskmanager wurde gestartet");

        boolean programIsRunning = true;

        while (programIsRunning) {

            printOptions();

            String input = this.scanner.nextLine();

            switch (input) {
                case "a":
                    addTask();
                    break;
                case "c":
                    changeTaskName();
                    break;
                case "d":
                    deleteTask();
                    break;
                case "e":
                    System.out.println("Das Programm wird beendet.");
                    programIsRunning = false;
                    break;
                case "p":
                    printAllTasks();
                    break;
                case "s":
                    changeStatus();
                    break;
                default:
                    System.out.println("Ihre Eingabe ist ungültig.");
                    break;
            }

        }

    }

    private void deleteTask() {

        printAllTasks();
        System.out.println("Welchen Datensatz möchten Sie löschen? Bitte Id eingeben:");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();

        this.taskDAO.deleteTask(id);

    }

    private void changeTaskName() {
        printAllTasks();
        System.out.println("Welchen Task möchten Sie ändern?");
        System.out.println("Bitte Id eingeben:");

        int id = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("Wie soll der Task heißen? Bitte eingeben;");

        String name = this.scanner.nextLine();

        TaskVO taskVO = new TaskVO(id, name, false);

        this.taskDAO.changeTaskVO(taskVO);

    }

    private void addTask() {

        System.out.println("Bitte einen neuen Task eingeben.");
        Scanner scanner = new Scanner(System.in);
        String taskName = scanner.nextLine();

        TaskVO taskVO = new TaskVO(0, taskName, false);

        this.taskDAO.addTask(taskVO);

    }

    private void printOptions() {

        System.out.println("Was möchten sie machen?");
        System.out.println("a - add Task");
        System.out.println("c - change Task");
        System.out.println("d - delete Task");
        System.out.println("p - print all Task");
        System.out.println("s - change status");
        System.out.println("e - exit");

    }

    private void printAllTasks() {

        List<TaskVO> tasks = this.taskDAO.getAllTasks();

        for (TaskVO task : tasks) {

            System.out.println("id: " + task.getId() + " name: " + task.getName() + " done: " + task.isDone());

        }
    }

    private void changeStatus() {

        printAllTasks();

        System.out.println("Bei welcher ID möchten Sie den Status ändern? Bitte ID eingeben: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("1: Status Done = true, 0: Status Done = false");
        int status = this.scanner.nextInt();
        this.scanner.nextLine();

        if (status == 0) {

            this.taskDAO.changeStatus(id, false);

        } else if (status == 1) {

            this.taskDAO.changeStatus(id, true);

        } else {

            System.out.println("Ihre Eingabe ist falsch");

        }

    }

}
