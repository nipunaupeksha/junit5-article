package org.nipunaupeksha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("SimpleCalculator")
public class SimpleCalculatorNestedTest implements ISimpleCalculator{
    private SimpleCalculator simpleCalculator;

    @BeforeEach
    void setUp(){
        simpleCalculator = new SimpleCalculator();
    }

    @DisplayName("Addition")
    @Nested
    class NestedAddition{

        @DisplayName("Check adding two numbers is correct.")
        @Test
        void testAddTwoNumbers(){
            assertEquals(10, simpleCalculator.add(8,2));
        }
    }

    @DisplayName("Division")
    @Nested
    class NestedDivision{

        @DisplayName("Check dividing two numbers is correct.")
        @Test
        void testAddTwoNumbers(){
            assertEquals(4, simpleCalculator.divide(8,2));
        }
    }
}
