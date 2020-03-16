import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CoinChange {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int [] coin = new int[m];
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(bf.readLine());
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int d[] = new int[c+1];
            for(int i = 1; i<=c ; i++){
                d[i] = -1;
                for(int j = 0; j < m ; j++){
                    if(coin[j] <= i){
                        if(d[i-coin[j]]<0) continue;
                        if(d[i] <0) d[i] = d[i- coin[j]]+1;
                        else if(d[i- coin[j]] +1<d[i]) d[i] = d[i-coin[j]]+1;
                    }
                }
            }
            System.out.println(d[m]);
        }
    }
}