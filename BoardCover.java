import java.util.Scanner;

public class BoardCover {
    public static int[][][] cover = { { { 0, 0 }, { 0, 1 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 0, 1 } }, { { 0, 0 }, { 0, 1 }, { -1, 1 } } };

    public static void main(final String[] args) {
        int testCase;
        int board[][];
        int countingCase[];

        final Scanner scn = new Scanner(System.in);

        testCase = scn.nextInt();
        countingCase = new int[testCase];
        scn.nextLine();
        for (int i = 0; i < testCase; i++) {
            final int col = scn.nextInt();
            final int row = scn.nextInt();
            int whiteNum = 0;
            scn.nextLine();
            board = new int[col][row];
            for (int y = 0; y < col; y++) {
                final String temp = scn.nextLine();
                for (int x = 0; x < row; x++) {
                    if (temp.charAt(x) == '#') {
                        board[y][x] = 1;
                    } else if (temp.charAt(x) == '.') {
                        board[y][x] = 0;
                        whiteNum++;
                    }
                }
            }
            if (whiteNum % 3 == 0)
                countingCase[i] = countCase(board, whiteNum / 3, 0, col, row);
            else
                countingCase[i] = 0;
        }
        for (int i = 0; i < testCase; i++) {
            System.out.println(countingCase[i]);
        }
    }

    public static int countCase(final int board[][], final int canCover, final int current, final int col,
            final int row) {
        int count = 0;
        int x = 0;
        int y = 0;
        boolean isWhite = false;
        if (current >= canCover) {
            return 1;
        }
        for (y = 0; y < col; y++) {
            for (x = 0; x < row; x++) {
                if (board[y][x] == 0) {
                    isWhite = true;
                    break;
                }
            }
            if (isWhite) {
                break;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (set(board, y, x, i, col, row)) {
                for (int a = 0; a < 3; a++) {
                    board[y + cover[i][a][1]][x + cover[i][a][0]] = 1;
                }
                count += countCase(board, canCover, current + 1, col, row);
                for (int a = 0; a < 3; a++) {
                    board[y + cover[i][a][1]][x + cover[i][a][0]] = 0;
                }
            }
        }
        return count;
    }

    public static boolean set(final int board[][], final int nY, final int nX, final int type, final int col,
            final int row) {
        for (int i = 0; i < 3; i++) {
            final int y = nY + cover[type][i][1];
            final int x = nX + cover[type][i][0];
            if (y < 0 || x < 0 || y >= col || x >= row || board[y][x] == 1) {
                return false;
            }
        }
        return true;
    }
}