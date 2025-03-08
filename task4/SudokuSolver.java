public class SudokuSolver {
    private static final int SIZE = 9; // Sudoku grid size

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("🧩 Unsolved Sudoku:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\n✅ Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("\n❌ No solution exists.");
        }
    }

    // Sudoku solving using Backtracking
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Empty cell
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValidMove(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true; // Move is valid
                            }
                            board[row][col] = 0; // Backtrack if wrong
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    // Check if placing `num` in `board[row][col]` is valid
    private static boolean isValidMove(int[][] board, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3×3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true; // Valid move
    }

    // Print Sudoku board
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] == 0 ? ". " : board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
