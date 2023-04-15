package org.dmytrenko.lab2;

import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;


class MenuOfTerminal {
    private final Matrix matrix;
    private final Scanner scanner;
    private final int MAX_RANDOM_VALUE = 1_000;
    private final int MIN_RANDOM_VALUE = -1_000;
    private final boolean INPUT_MODE_HEIGHT_MATRIX = true;
    private final boolean INPUT_MODE_WIDTH_MATRIX = false;

    MenuOfTerminal(Matrix matrix, Scanner scanner) {
        this.matrix = matrix;
        this.scanner = scanner;
    }

    public void inputStartParametersOfMatrix() {
        System.out.print("Enter width of matrix: "); setMatrixWidthOrHeight(INPUT_MODE_WIDTH_MATRIX);
        System.out.print("Enter height of matrix: "); setMatrixWidthOrHeight(INPUT_MODE_HEIGHT_MATRIX);
        System.out.print("Do you want to create matrix randomly? (y/n): "); setRandomModeMatrix();

    }

    public void inputDataToMatrix() {
        System.out.println("Inputting data to matrix...");
        if (matrix.isRandomMode() == matrix.RANDOM_ON) randomInputtingAllDataToMatrix();
        if (matrix.isRandomMode() == matrix.RANDOM_OFF) manualInputtingAllDataToMatrix();

    }

    public void printMatrix() {
        int countOfRows = matrix.getCountOfRows();
        int countOfColumns = matrix.getCountOfColumns();
        int widthOfField = getMaxWidthFieldOfMatrixForFormattingPrint();

        System.out.println("Printing matrix...");
        for (int i = 0; i < countOfRows; i++) {
            for (int j = 0; j < countOfColumns; j++) {
                System.out.printf(String.format("%" + widthOfField + "d ",
                        matrix.getMatrix()
                                .get(i)
                                .get(j)));
            }
            System.out.println();
        }

    }

    public boolean doYouWantExit(){
        System.out.print("Do you want exit? (y/n): ");
        matrix.clearMatrix();
        return isAnswerYes();
    }

    public void printMaxValueOfMatrix() {
        System.out.printf("Max value of matrix = %d%n", matrix.getMaxValueOfMatrix());
    }

    public void printMinValueOfMatrix() {
        System.out.printf("Min value of matrix = %d%n", matrix.getMinValueOfMatrix());
    }

    public void printArithmeticAverageValueOfMatrix(){
        System.out.printf("Arithmetic average of matrix = %f%n", matrix.getArithmeticAverage());
    }

    public void printGeometricAverageValueOfMatrix(){
        System.out.printf("Geometric average of matrix = %f%n", matrix.getGeometricAverage());
    }

    private int getMaxWidthFieldOfMatrixForFormattingPrint() {
        int widthOfMaxValue = String.valueOf(matrix.getMaxValueOfMatrix())
                .length();
        int widthOfMinValue = String.valueOf(matrix.getMinValueOfMatrix())
                .length();

        return Math.max(widthOfMaxValue, widthOfMinValue);
    }

    private void randomInputtingAllDataToMatrix() {
        Random random = new Random();
        int countOfRows = matrix.getCountOfRows();
        int countOfColumns = matrix.getCountOfColumns();

        for (int i = 0; i < countOfRows; i++) {
            for (int j = 0; j < countOfColumns; j++) {
                matrix.addValueToMatrix(random
                        .nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE), i, j);
            }
        }
    }

    private void manualInputtingAllDataToMatrix() {
        int input;

        for (int i = 0; i < matrix.getCountOfRows(); i++) {
            for (int j = 0; j < matrix.getCountOfColumns(); j++) {
                System.out.printf("Input [%d][%d]: ", i, j);
                input = saveInputtingInteger();
                matrix.addValueToMatrix(input, i, j);
            }
        }
    }

    private void setMatrixWidthOrHeight(boolean modeInputParameters) {
        /*False mode is input height matrix
         * True mode is input width matrix*/

        int input;
        int maxCount;
        int minCount;
        Consumer<Integer> inputtingToMatrix;
        String nameChangingParameter;
        Formatter formatter = new Formatter();

        if (modeInputParameters == INPUT_MODE_WIDTH_MATRIX) {
            nameChangingParameter = "column";
            maxCount = matrix.MAX_COUNT_OF_COLUMNS;
            minCount = matrix.MIN_COUNT_OF_COLUMNS;
            inputtingToMatrix = matrix::setCountOfColumns;
        } else {
            nameChangingParameter = "row";
            maxCount = matrix.MAX_COUNT_OF_ROWS;
            minCount = matrix.MIN_COUNT_OF_ROWS;
            inputtingToMatrix = matrix::setCountOfRows;

        }

        try {
            input = saveInputtingInteger();

            if ((input > maxCount) || (input < minCount)) {
                formatter.format("Count of %ss out of range %d..%d!",
                        nameChangingParameter, minCount, maxCount);
                throw new Exception(formatter.toString());
            }

            inputtingToMatrix.accept(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.print("Re-enter: ");

            setMatrixWidthOrHeight(modeInputParameters);
        }
    }

    private void setRandomModeMatrix() {
        matrix.setRandomMode(isAnswerYes());
    }

    private int saveInputtingInteger() {
        try {
            if (scanner.hasNextInt())
                return scanner.nextInt();
            else {
                scanner.next();
                throw new IllegalArgumentException("Input is illegal!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("Re-enter value: ");

            return saveInputtingInteger();
        }
    }

    private boolean isAnswerYes() {
        String answer = scanner.next().toLowerCase();
        String exceptionMessage = "You must enter only 'y' or 'n'!!!";

        try {
            if (answer.length() > 1) throw new IllegalArgumentException(exceptionMessage);
            if (answer.equals("y")) return matrix.RANDOM_ON;
            else if (answer.equals("n")) return matrix.RANDOM_OFF;
            else throw new IllegalArgumentException(exceptionMessage);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("Re-enter answer: ");
            return isAnswerYes();
        }
    }
}
