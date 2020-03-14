import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame {
    static int n;
    static int board[][] = new int[100][100];
    static int cache[][] = new int[100][100];
    static int ret = 0;

    static int jump(int y, int x) {
        if (y >= n || x >= n) {
            return 0;
        }
        if (y == n - 1 && x == n - 1) {
            return 1;
        }
        if (cache[y][x] != -1) {
            return cache[y][x];
        }
        int jumpSize = board[y][x];
        return cache[y][x] = jump(y + jumpSize, x) | jump(y, x + jumpSize);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(bf.readLine());
        while(c-->0){
            n = Integer.parseInt(bf.readLine());
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j = 0; i < n; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                    cache[i][j] = -1;
                }
            }
        }
        if(jump(0,0)==1){
            System.out.println("YES");
        }
        if(jump(0,0)!=1){
            System.out.println("NO");
        }
    }
}