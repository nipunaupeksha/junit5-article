package org.nipunaupeksha;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("SimpleCalculator")
public interface ISimpleCalculator {
    @BeforeAll
    default void beforeAll(){
        System.out.println("SimpleCalculator tests are running");
    }
}
