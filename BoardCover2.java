import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BoardCover2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            char[][] table = new char[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for (int i = 0; i < table.length; i++) {
                st = new StringTokenizer(bf.readLine());
                char[] temp = st.nextToken().toCharArray();
                for (int j = 0; j < table[i].length; j++) {
                    table[i][j] = temp[j];
                }
            }
        }
    }

    public static void charArrayPrinter(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }
}

class BlockModel {
    char[][] block;
    int type;

}