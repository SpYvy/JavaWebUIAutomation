package ru.gb.lesson4;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BoxTest {
    Box box;

    @Nested
    class WhenBoxIsEmpty {
        @BeforeEach
        void createBox() {
            box = new Box(0);
        }

        @Test
        void exceptionWhenTryToRemoveBall(){
            Assertions.assertThrows(BoxIsEmptyException.class, () -> box.removeBall());
            assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.removeBall());
        }
        @Nested
        class WhenOneBall {
            @BeforeEach
            void addBall() { //Создание коробки произойдет в @Nested уровнем выше
                box.addBall();
            }
            @Test
            void removeBallTest() throws BoxIsEmptyException {
                box.removeBall();
                assertThat(box.getBallCount()).isEqualTo(0);
            }

        }
    }
}
