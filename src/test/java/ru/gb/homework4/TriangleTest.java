package ru.gb.homework4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static ru.gb.homework4.TriangleArea.triangleAreaCalculate;

public class TriangleTest {
    @AfterEach
    void message(){
        System.out.println("-----");
    }
    @ParameterizedTest
    @DisplayName("Позитивный тест")
    @CsvSource({"10, 10, 5, 24.21", "15, 15, 3, 22.39", "100, 399, 300, 2439.8", "2, 3, 2, 1.98"})
    void triangleAreaPositive(int a, int b, int c, double expectedResult) throws NotAnPositiveNumberException, ThereIsNoSuchTriangleException {
        assertThat(expectedResult).isEqualTo(triangleAreaCalculate(a ,b ,c));
        System.out.println("Позитивное тестирование");
    }
    @ParameterizedTest
    @DisplayName("Тест исключения NotAnPositiveNumberException")
    @CsvSource({"-1, 10, 5", "0, 15, 3", "100, -399, 300", "2, -3, 2"})
    void triangleSideNotAPositiveNumberException(int a, int b, int c) throws NotAnPositiveNumberException, ThereIsNoSuchTriangleException {
        assertThatExceptionOfType(NotAnPositiveNumberException.class).isThrownBy(() -> triangleAreaCalculate(a, b, c));
    }
    @ParameterizedTest
    @DisplayName("Тест исключения ThereIsNoSuchTriangleException")
    @CsvSource({"1, 10, 100", "5, 15, 3", "100, 400, 300", "2, 3, 1"})
    void thereIsNoSuchTriangleException(int a, int b, int c) throws NotAnPositiveNumberException, ThereIsNoSuchTriangleException {
        assertThatExceptionOfType(ThereIsNoSuchTriangleException.class).isThrownBy(() -> triangleAreaCalculate(a, b, c));
    }
}
