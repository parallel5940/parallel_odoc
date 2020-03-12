class CoinChange{
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(bf.readLine);
        while(c-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int coin[] new int[m];
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(bf.readLine());
                coint[i] = Integer.parseInt(st.nextToken());
            }
            int d[] = new int[c+1];
            for(int i = 1; i<=c ; i++){
                d[i] = -1;
                for(int j = 0; j < m ; j++){
                    if(coint[j] <= i){
                        if(d[i-coint[j]]<0) continue;
                        if(d[i] <0) d[i] = d[i- coin[j]]+1;
                        else if(d[i- coin[j]] +1<d[i]) d[i] = d[i-coin[j]]+1;
                    }
                }
            }
        }

        System.out.println(d[k]);
    }
}