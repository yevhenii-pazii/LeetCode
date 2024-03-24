package problem.p0000_0099;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class P36 {

    /*
        Time Complexity O(N)
        Space Complexity O(3N)
        N - all points
     */
    public boolean isValidSudokuHashMap(char[][] board) {
        Map<Integer, Set<Character>> horizontal = new HashMap<>(9);
        Map<Integer, Set<Character>> vertical = new HashMap<>(9);
        Map<Integer, Set<Character>> box = new HashMap<>(9);

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                Character c = board[i][j];
                if (c != '.' && (
                        !horizontal.computeIfAbsent(i, k -> new HashSet<>()).add(c)
                                || !vertical.computeIfAbsent(j, k -> new HashSet<>()).add(c)
                                || !box.computeIfAbsent(i / 3 * 3 + j / 3, k -> new HashSet<>()).add(c))) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(3N)
        N - all points
     */
    public boolean isValidSudokuArray(char[][] board) {
        boolean[][] hor = new boolean[9][10];
        boolean[][] ver = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                Character c = board[i][j];
                if (c != '.') {
                    var num = Integer.parseInt(String.valueOf(c));
                    var boxIndex = i / 3 * 3 + j / 3;
                    if (hor[i][num] || ver[j][num] || box[boxIndex][num]) {
                        return false;
                    }

                    hor[i][num] = true;
                    ver[j][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }

        return true;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
        N - all points
     */
    public boolean isValidSudokuBitManipulation(char[][] board) {
        int[] hor = new int[9];
        int[] ver = new int[9];
        int[] box = new int[9];

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    var bit = 1 << c - '0';
                    var boxIndex = i / 3 * 3 + j / 3;

                    if((hor[i] & bit) != 0 || (ver[j] & bit) != 0 || (box[boxIndex] & bit) != 0) {
                        return false;
                    }

                    hor[i] |= bit;
                    ver[j] |= bit;
                    box[boxIndex] |= bit;
                }
            }
        }

        return true;
    }
}
