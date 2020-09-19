
import static org.junit.jupiter.api.Assertions.*;

import Exception.InputEmptyException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class UniqueWordCountTest {

    static UniqueWord sut;

    @BeforeAll
    public static void setupTest() {

        // Arrange
        sut = new UniqueWord();
    }


    @Tag(value="important")
    @org.junit.jupiter.api.Test
    public void calculateUniqueWordCount_WhenInputIsEmpty_ShouldThrowInputEmptyException() {

        // Act
        Exception exception = assertThrows(InputEmptyException.class, () -> sut.getUniqueWordCount(""));

        // Assert
        assertEquals("Input can not be empty!", exception.getMessage());
    }

    @DisplayName("When input has one word, it should return one")
    @Test
    void calculateUniqueWordCount_WhenInputHasOneWord_ShouldReturn1() {

        // Act
        int result = sut.getUniqueWordCount("input");

        // Assert
        assertEquals(1, result);
    }
    @Test
    void calculateUniqueWordCount_WhenInputHasCommaAndDot_ShouldReturn2() {

        // Act
        int result = sut.getUniqueWordCount("This,test.");

        // Assert
        assertEquals(2, result);
    }

    @Test
    public void calculateUniqueWordCount_WhenInputHasApostrophes_ShouldReturnCorrectResult(){

        //Arrange
        String str = "This test's result is 5";

        //Act
        Integer result = sut.getUniqueWordCount(str);

        //Assert
        assertEquals(result,5);

    }

    @Test
    void calculateUniqueWordCount_WhenInputHasNotUniqueWords_ShouldReturn3() {

        // Act
        int result = sut.getUniqueWordCount("Test one one test input");

        // Assert
        assertEquals(3, result);
    }

    @Test
    void calculateUniqueWordCount_WhenInputHasCaseInsensitiveWords_ShouldReturn4() {

        // Act
        int result = sut.getUniqueWordCount("TEST exampLE eX iNPUT");

        // Assert
        assertEquals(4, result);
    }

    @Test
    void calculateUniqueWordCount_WhenInputHasOnlyCommaAndDot_ShouldReturn0() {

        // Act
        int result = sut.getUniqueWordCount(", .");

        // Assert
        assertEquals(0, result);
    }

    @Test
    void calculateUniqueWordCount_WhenInputHasSpaceCharacter_ShouldReturnCorrectResult() {

        // Act
        int result = sut.getUniqueWordCount("this is a test and  Good taste..");

        // Assert
        assertEquals(7, result);
    }

    @Test
    void calculateUniqueWordCount_WhenInputHasSameWordWithSpace_ShouldReturn1() {

        // Act
        int result = sut.getUniqueWordCount("Test  test");

        // Assert
        assertEquals(1, result);
    }


    private static Stream<Arguments> provideLegalSameWords() {
        return Stream.of(
                Arguments.of("input İNPUT iNPUT inpUT")
                );
    }

    @ParameterizedTest
    @MethodSource("provideLegalSameWords")
    public void calculateUniqueWordCount_WhenInputHasSameWords_ShouldReturn1(String words) {

        // Act
        int result = sut.getUniqueWordCount(words);

        // Assert
        assertEquals(1, result);
    }



}
