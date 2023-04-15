package org.dmytrenko.lab2;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean flagOfEndProgram = false;
        Matrix matrix = new Matrix();
        Scanner scanner = new Scanner(System.in);
        MenuOfTerminal menu = new MenuOfTerminal(matrix, scanner);

        while (!flagOfEndProgram) {
                menu.inputStartParametersOfMatrix();
                menu.inputDataToMatrix();
                menu.printMatrix();
                menu.printMaxValueOfMatrix();
                menu.printMinValueOfMatrix();
                menu.printArithmeticAverageValueOfMatrix();
                menu.printGeometricAverageValueOfMatrix();

                flagOfEndProgram = menu.doYouWantExit();
        }
    }



}