import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    private static int[][] map;
    private static int N;
    private static int M;
    private static int row;
    private static int col;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] drow = new int[] { 0, 0, -1, +1 };
        int[] dcol = new int[] { 1, -1, 0, 0 };
        int[] dice = new int[7];

        int nrow, ncol;
        st = new StringTokenizer(br.readLine());
        while (k > 0) {
            int dir = Integer.parseInt(st.nextToken());
            nrow = row + drow[dir - 1];
            ncol = col + dcol[dir - 1];

            if (nrow >= 0 && nrow < N && ncol >= 0 && ncol < M) {
                int top = dice[1];
                if (dir == 1) {
                    dice[1] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[3];
                    dice[3] = top;
                } else if (dir == 2) {
                    dice[1] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = top;
                } else if (dir == 3) {
                    dice[1] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = top;
                } else {
                    dice[1] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = top;
                }
                row = nrow;
                col = nrow;
                if (map[row][col] == 0) {
                    map[row][col] = dice[6];
                } else {
                    dice[6] = map[row][col];
                    map[row][col] = 0;
                }
                System.out.println(dice[1]);
            }
            k--;
        }
    }
}