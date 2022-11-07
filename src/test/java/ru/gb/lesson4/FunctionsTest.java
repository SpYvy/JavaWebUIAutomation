package ru.gb.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class FunctionsTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("Выполнится один раз перед всеми методами класса");
    }

    @BeforeEach
    void BeforeEach(){
        System.out.println("Выполнится перед запуском каждого теста");
    }

    @Test
    @DisplayName("Проверка метода isPalindrome со словом-палиндромом")
    @Disabled("Есть баг, номер 123")
    void isPalindromeTest() {
        boolean result = new Functions().isPalindrome("123321");
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123321", "1234321"})
    @DisplayName("Проверка метода isPalindrome с нечетным числом символов")
    void isOddPalindromeTest(String testWord) {
        boolean result = new Functions().isPalindrome(testWord);
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @CsvSource({"123, false", "123321, true"})
    void isPalindrome(String testWord, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, new Functions().isPalindrome(testWord));
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catAndAgeTest(Cat cat, int age) {
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static List<Arguments> catAndAgeDataProvider(){
        return Arrays.asList(
                Arguments.of(new Cat("Test1", 10), 10),
                Arguments.of(new Cat("Test2", 11) , 12)
        );
    }
    @AfterEach
    void afterEach(){
        System.out.println("Выполнится после запуска каждого теста");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Выполнится после всех тестов");
    }
}
