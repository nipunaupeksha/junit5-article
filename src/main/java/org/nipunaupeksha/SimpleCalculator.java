package org.nipunaupeksha;

public class SimpleCalculator {
    public double add(double numberA, double numberB) {
        return numberA + numberB;
    }

    public double subtract(double numberA, double numberB) {
        return numberA - numberB;
    }

    public double divide(double numberA, double numberB) {
        if(numberB == 0) throw new ArithmeticException("numberB cannot be zero");
        return numberA / numberB;
    }

    public double multiply(double numberA, double numberB) {
        return numberA * numberB;
    }

}
