class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> cols = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if ( board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) {
                        return false;
                    }
                    cols.add(board[j][i]);
                    }
                }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                HashSet<Character> square = new HashSet<Character>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[3*i + k][3*j + l] != '.') {
                            if(square.contains(board[3*i + k][3*j + l])) {
                                return false;
                            }
                            square.add(board[3*i + k][3*j + l]);
                        }
                    }
                }

            }
        }
        return true;
    }
}
