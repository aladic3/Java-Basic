package org.dmytrenko.lab2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class Matrix {


    public final int MAX_COUNT_OF_COLUMNS = 20;
    public final int MAX_COUNT_OF_ROWS = 20;
    public final int MIN_COUNT_OF_COLUMNS = 1;
    public final int MIN_COUNT_OF_ROWS = 1;
    public final boolean RANDOM_ON = true;
    public final boolean RANDOM_OFF = false;
    private int countOfColumns, countOfRows;

    private boolean randomMode;


    private final List<List<Integer>> matrix = new ArrayList<>();

    public void addValueToMatrix(int data, int currentRow, int currentColumn){
        if (matrix.size() < (currentRow + 1)) {
            matrix.add(new ArrayList<>(countOfColumns));
        }

        matrix.get(currentRow).add(currentColumn, data);
    }

    public double getArithmeticAverage(){
        return matrix.stream()
                .flatMap(List::stream)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }
    public double getGeometricAverage(){
        double resultOfMultiplicationAllElements = matrix.stream()
                .flatMap(Collection::stream)
                .mapToDouble(Integer::doubleValue)
                .reduce(1, (a, b) -> a * b);
        return Math.pow( resultOfMultiplicationAllElements,
                1.0 / (countOfColumns * countOfRows) );
    }

    // Getters and setters
    public int getCountOfColumns() {
        return countOfColumns;
    }

    public void setCountOfColumns(int countOfColumns)  {
        this.countOfColumns = countOfColumns;
    }

    public int getCountOfRows() {
        return countOfRows;
    }

    public void setCountOfRows(int countOfRows) {
        this.countOfRows = countOfRows;
    }

    public boolean isRandomMode() {
        return randomMode;
    }

    public void setRandomMode(boolean randomMode) {
        this.randomMode = randomMode;
    }

    public int getMinValueOfMatrix() {
        return matrix.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::valueOf)
                .min()
                .orElse(0);
    }

    public int getMaxValueOfMatrix() {
        return matrix.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::valueOf)
                .max()
                .orElse(0);
    }
    public void clearMatrix(){
        matrix.clear();
        countOfColumns = 0;
        countOfRows = 0;
        randomMode = RANDOM_OFF;
    }

    public List<List<Integer>> getMatrix() {
        return matrix;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix matrix1)) return false;
        return countOfColumns == matrix1.countOfColumns && countOfRows == matrix1.countOfRows
                && randomMode == matrix1.randomMode && matrix.equals(matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfColumns, countOfRows, randomMode, matrix);
    }
}
