bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    int row[9][10] = {0};
    int col[9][10] = {0};
    int box[9][10] = {0};
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.')
                continue;
            int num = board[i][j] - '0';
            int boxIndex = (i / 3) * 3 + (j / 3);
            if (row[i][num])
                return false;
            if (col[j][num])
                return false;
            if (box[boxIndex][num])
                return false;
            row[i][num] = 1;
            col[j][num] = 1;
            box[boxIndex][num] = 1;
        }
    }
    return true;
}
