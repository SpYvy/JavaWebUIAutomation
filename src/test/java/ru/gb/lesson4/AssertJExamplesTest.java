package ru.gb.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void assertJTest(){
        //Assumptions.assumeTrue(1 == 2); Если данное предположение true, то проверка пройдет дальше

        List<String> stringsList = Arrays.asList("test1", "test2");
        Assertions.assertAll( //Если один из проверок упадет, проверка остальных тестов продолжится в любом случае.
                () -> assertThat(new Functions().isPalindrome("123")).isFalse(),
                () -> assertThat(5).isGreaterThan(4).isLessThan(6),
                () -> assertThat(stringsList).containsAnyOf("test2", "test3")
        );
    }
}
