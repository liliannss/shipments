package com.example.shipments

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class JUnitTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    @DisplayName("Should Identify If The Number Is Odd And Return True Or False With Success")
    void shouldIdentifyOddNumber(Integer value) {

        def result = isOdd(value)

        Assertions.assertTrue(result)
    }

    static boolean isOdd(Integer value) {
        return value % 2 != 0
    }

}