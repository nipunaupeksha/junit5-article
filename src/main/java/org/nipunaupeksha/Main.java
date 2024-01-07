package org.nipunaupeksha;

public class Main {
    public static void main(String[] args) {

        SimpleCalculator simpleCalculator = new SimpleCalculator();

        double resAdd = simpleCalculator.add(5, 10);
        double resSubtract = simpleCalculator.subtract(15, 10);
        double resDivide = simpleCalculator.divide(10, 3);
        double resMultiply = simpleCalculator.multiply(5, 2);

        System.out.println("Addition result: " + resAdd);
        System.out.println("Subtraction result: " + resSubtract);
        System.out.println("Division result: " + resDivide);
        System.out.println("Multiplication result: " + resMultiply);
    }
}