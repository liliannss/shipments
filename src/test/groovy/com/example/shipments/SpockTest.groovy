package com.example.shipments

import spock.lang.Specification

class SpockTest extends Specification {

    def "Should Identify If The Number Is Odd And Return True Or False With Success"(Integer value) {
        when:
        def result = isOdd(value)

        then:
        result == expected

        where:
        value | expected
        1     | true
        2     | false
        3     | true

    }

    static boolean isOdd(Integer value) {
        return value % 2 != 0
    }

}