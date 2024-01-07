package org.nipunaupeksha;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.nipunaupeksha.junitextensions.TimingExtension;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(TimingExtension.class)
public class SimpleCalculatorTest implements ISimpleCalculator{

    private SimpleCalculator simpleCalculator;

    @BeforeEach
    void setUp() {
        simpleCalculator = new SimpleCalculator();
    }

    @Tag("Addition")
    @DisplayName("Testing the add() method in SimpleCalculator")
    @Test
    void testAdd() {
//        assertEquals(5, simpleCalculator.add(2, 4), "Wrong result returned.");
        assertEquals(5, simpleCalculator.add(2, 3), () -> "Wrong result returned.");
    }

    @Tag("Addition")
    @DisplayName("Testing the add() method in SimpleCalculator as an assumption ")
    @Test
    void testAddAssumption(){
        assumeTrue(simpleCalculator.add(2,4) == 5);
    }

    @Tag("Addition")
    @DisplayName("Testing the add() method in MacOs")
    @EnabledOnOs(OS.MAC)
    @Test
    void testAddOnMacOs(){
        assertEquals(5, simpleCalculator.add(2, 3), () -> "Wrong result returned.");
    }

    @Tag("Addition")
    @DisplayName("Testing the add() method in Windows")
    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testAddOnWindows(){
        assertEquals(5, simpleCalculator.add(2, 3), () -> "Wrong result returned.");
    }

    @Tag("Addition")
    @DisplayName("Testing the add() method in Java 8")
    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testAddOnJava8(){
        assertEquals(5, simpleCalculator.add(2, 3), () -> "Wrong result returned.");
    }

    @Tag("Addition")
    @DisplayName("Testing the add() method in Java 17")
    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void testAddOnJava17(){
        assertEquals(5, simpleCalculator.add(2, 3), () -> "Wrong result returned.");
    }

    @Tag("Addition")
    @DisplayName("Repeated Test")
    @RepeatedTest(value= 10, name= "{displayName}: {currentRepetition} of {totalRepetitions}")
    void testAddRepeat(){
        assertEquals(5, simpleCalculator.add(2,3), ()-> "Wrong result returned,");
    }

//    @DisplayName("Testing the subtract() method in SimpleCalculator using AssertJ")
//    @Test
//    void testSubtract(){
//        assertThat(simpleCalculator.subtract(10, 5)).isEqualTo(5);
//    }

    @Tag("Division")
    @DisplayName("Testing the ArithmeticException when you divide any number by zero")
    @Test
    void testDivideException() {
        assertThrows(ArithmeticException.class, () -> simpleCalculator.divide(10, 0));
    }

    @Tag("Multiplication")
    @DisplayName("Testing the multiply() method in SimpleCalculator using Hamcrest")
    @Test
    void testMultiply() {
        assertThat(simpleCalculator.multiply(2,5), is(10.0));
    }

    @DisplayName("Value source multiplication test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ValueSource(doubles={5, 10})
    void testMultiplyWithValueSource(double val){
        assertEquals(val, simpleCalculator.multiply(val, 1));
    }

    @Tag("All")
    @Disabled
    @DisplayName("Testing all the arithmetic operations in SimpleCalculator")
    @Test
    void testCalculations() {
        assertAll("Calculations Test",
                () -> assertEquals(5, simpleCalculator.add(2, 3), "Addition failed."),
                () -> assertEquals(1, simpleCalculator.subtract(2, 1), "Subtraction failed."),
                () -> assertEquals(4, simpleCalculator.divide(8, 2), "Division failed."),
                () -> assertEquals(10, simpleCalculator.multiply(2, 5), "Multiplication failed."));
    }
}
