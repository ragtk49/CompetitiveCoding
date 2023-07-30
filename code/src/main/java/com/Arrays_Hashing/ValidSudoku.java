/*
 * Leetcode: 36. Valid Sudoku (https://leetcode.com/problems/valid-sudoku/)
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * 1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 2. Only the filled cells need to be validated according to the mentioned rules.
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * ...
 * ["8",".",".",".","6",".",".",".","3"]]
 * Output: true
 */
package com.Arrays_Hashing;
/*
 * Approach: We can use three 2D boolean arrays rows, cols, and boxes of size 9 x 9 to keep track of the digits already
 * present in the corresponding row, column, and sub-box. We can traverse the Sudoku board and check if the current cell
 * is not empty. If yes, then we check if the digit is already present in the corresponding row, column, or sub-box. If
 * yes, then we return false. Otherwise, we mark the digit as present in the corresponding row, column, and sub-box. If
 * the entire board is valid, then we return true.
 */
public class ValidSudoku {
    /*
     * Algorithm:
     * 1. Create three 2D boolean arrays rows, cols, and boxes of size 9 x 9.
     * 2. Traverse the Sudoku board.
     * 3. Check if the current cell is not empty.
     * 4. If yes, then check if the digit is already present in the corresponding row, column, or sub-box.
     * 5. If yes, then return false.
     * 6. Otherwise, mark the digit as present in the corresponding row, column, and sub-box.
     * 7. Return true.
     * Time Complexity: O(1), since the board size is fixed.
     * Space Complexity: O(1), since the board size is fixed.
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        // Traverse the Sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int digit = ch - '1'; // Convert the character to a digit (0 to 8)
                    /*
                     * Note: The sub-boxes are numbered from 0 to 8. The boxIndex is calculated as follows:
                     * boxIndex = (row / 3) * 3 + col / 3
                     * For example, if the current cell is at row = 4 and col = 5, then the boxIndex = (4 / 3) * 3 + 5 / 3 = 1 * 3 + 1 = 4.
                     * Similarly, if the current cell is at row = 7 and col = 8, then the boxIndex = (7 / 3) * 3 + 8 / 3 = 2 * 3 + 2 = 8.
                     * The boxIndex is calculated as follows:
                     * 0 1 2
                     * 3 4 5
                     * 6 7 8
                     * The boxIndex is calculated as follows:
                    * 0 0 0 1 1 1 2 2 2
                    * 0 0 0 1 1 1 2 2 2
                    * 0 0 0 1 1 1 2 2 2
                    * 3 3 3 4 4 4 5 5 5
                    * 3 3 3 4 4 4 5 5 5
                    * 3 3 3 4 4 4 5 5 5
                    * 6 6 6 7 7 7 8 8 8
                    * 6 6 6 7 7 7 8 8 8
                    * 6 6 6 7 7 7 8 8 8
                     */
                    int boxIndex = (i / 3) * 3 + j / 3; // Calculate the 3 x 3 sub-box index
                    System.out.println("digit: " + digit);
                    // Check if the digit is already present in the corresponding row, column, or sub-box
                    if (rows[i][digit] || cols[j][digit] || boxes[boxIndex][digit]) {
                        return false; // Violates Sudoku rules
                    }
                    System.out.println("boxIndex: "+ boxIndex);
                    // Mark the digit as present in the corresponding row, column, and sub-box
                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[boxIndex][digit] = true;
                }
            }
        }
        return true; // If the entire board is valid
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
