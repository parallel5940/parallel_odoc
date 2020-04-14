import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1261 {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String t = sc.next();
            for (int j = 0; j < n; j++)
                arr[i][j] = t.charAt(j) - '0';
        }
        visited = new boolean[m][n];
        System.out.println(solve(arr));
    }

    static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static boolean[][] visited;

    private static int solve(int[][] arr) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0, 0));
        visited[0][0] = true;
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair t = queue.poll();

            if (t.x == m - 1 && t.y == n - 1) {
                min = Math.min(min, t.cnt);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tx = t.x + dir[i][0];
                int ty = t.y + dir[i][1];
                if (tx < 0 || ty < 0 || ty >= n || tx >= m)
                    continue;
                if (visited[tx][ty])
                    continue;
                visited[tx][ty] = true;
                if (arr[tx][ty] == 1)
                    queue.add(new Pair(tx, ty, t.cnt + 1));
                else
                    queue.add(new Pair(tx, ty, t.cnt));
            }
        }
        return min;
    }

    static class Pair implements Comparable<Pair> {
        private int x;
        private int y;
        private int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            return cnt > o.cnt ? 1 : cnt == o.cnt ? 0 : -1;
        }
    }
}