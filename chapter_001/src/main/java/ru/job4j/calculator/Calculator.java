package ru.job4j.calculator;


/**
 * Class Calculator для вычисления арифметических операций
 * @author MGurfinkel
 * @since 07.08.2018
 * @version 1
 */
public class Calculator {

    private double result;


    /**
     * Method add.
     * @param first First argument.
     * @param second Second argument.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method substract.
     * @param first First argument.
     * @param second Second argument.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }


    /**
     * Method div.
     * @param first First argument.
     * @param second Second argument.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiply.
     * @param first First argument.
     * @param second Second argument.
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}