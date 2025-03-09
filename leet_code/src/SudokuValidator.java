import java.util.HashSet;

public class SudokuValidator {

    // Method to validate the Sudoku board
    public static boolean isValidSudoku(char[][] board) {
        // Create a HashSet to track the numbers in rows, columns, and subgrids
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> subgridSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Check row for duplicates
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }

                // Check column for duplicates
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }

                // Check 3x3 subgrid for duplicates
                int subgridRow = 3 * (i / 3) + j / 3;
                int subgridCol = 3 * (i % 3) + j % 3;
                if (board[subgridRow][subgridCol] != '.' && !subgridSet.add(board[subgridRow][subgridCol])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Sample Sudoku board (this one is valid)
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '8', '3', '1', '2', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '3', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean isValid = isValidSudoku(board);

        if (isValid) {
            System.out.println("The Sudoku board is valid.");
        } else {
            System.out.println("The Sudoku board is invalid.");
        }
    }
}
