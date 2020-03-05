import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Picnic{
    static boolean[][] pair;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pairN = Integer.parseInt(st.nextToken());
            boolean[] students = new boolean[n];
            pair = new boolean[10][10];
            st = new StringTokenizer(bf.readLine());
            for(int i = 0; i<pairN; i++){
                pair[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }
            System.out.println(countPairings(students));
        }
    }
    static int countPairings(boolean[] students){
        int firstFree = -1;
        for(int i = 0; i<students.length; i++){
            if(!students[i]){
                firstFree=i;
                break;
            }
        }
        if(firstFree==-1) return 1;

        int ret = 0;
        for(int i=firstFree+1; i<students.length; ++i){
            if(!students[i] && pair[firstFree][i]){
                students[firstFree]=students[i]=true;
                ret+=countPairings(students);
                students[firstFree]=students[i]=false;
            }
        }
        return ret;
    }
}