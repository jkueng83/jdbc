package at.cc.jku.countervalues;

import java.util.Scanner;

public class CounterTask {

    private Scanner scanner;

    public CounterTask() {
        this.scanner = new Scanner(System.in);
    }

    public void counterTaskProgram(){

        boolean endProgram = false;

        while (!endProgram){
            printProgramOptions();
            String selection = getStringValue();

            switch (selection){
                case "e":
                case "E":
                    endProgram = true;
                    System.out.println("Exit Program!");
                    break;
                case "a":
                case "A":
                    addCounterValues();
                    break;
                default:
                    System.out.println("Your selection is wrong - make a new selection");
                    break;
            }

        }

    }

    private void printMakeASelection(){
        System.out.println("Make a selection");

    }
    private void printProgramOptions(){
        printMakeASelection();
        System.out.println("e - Exit");
        System.out.println("a - Add new counter values");
    }

    private String getStringValue(){
        return this.scanner.nextLine();
    }

    private void addCounterValues(){
        printMakeASelection();
        System.out.println("e - add energy counter values");
        System.out.println("s - select a counter");

        switch (getStringValue()){
            case "e":
            case "E":
                addEnergyCounterValues();
                break;
            case "s":
            case "S":
                addValueToSelectedCounter();

                break;
            default:
                System.out.println("Your selection was wrong!");
                break;
        }
    }

    private void addEnergyCounterValues(){
        System.out.println("add program for energy counters");

    }

    private void addValueToSelectedCounter(){
        System.out.println(" add program select counter and add value");
    }
}
