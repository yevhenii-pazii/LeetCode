package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P36Test {

    private final P36 p36 = new P36();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}, true),
                arguments(new char[][]{
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isValidSudokuHashMap(char[][] board, boolean expected) {
        assertThat(p36.isValidSudokuHashMap(board)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isValidSudokuArray(char[][] board, boolean expected) {
        assertThat(p36.isValidSudokuArray(board)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isValidSudokuBitManipulation(char[][] board, boolean expected) {
        assertThat(p36.isValidSudokuBitManipulation(board)).isEqualTo(expected);
    }
}
