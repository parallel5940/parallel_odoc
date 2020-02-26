import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    private static int i1;
    private static int i2;
    private static String operator;
    private static int answer;
    private static String[] num = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        while(c-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            i1 = strToInt(st.nextToken());
            operator = st.nextToken();
            i2 = strToInt(st.nextToken());
            st.nextToken();
            answer = strToInt(answerIn(st.nextToken()));
            // System.out.println(i1+ operator + i2 +"="+answer);
            System.out.println(correct());


        }
    }
    // string to int
    public static int strToInt(String s){
        for(int i = 0; i<num.length;i++){
            // System.out.println(s +", " + num[i] + ", " + i);
            if(s.equals(num[i])) return i;

        }return -999999;
    }
    public static String answerIn(String s){
        for( String s1 : num){
            String s2 = s1;
            // System.out.println(s1 + s);
            for(int i = 0; i<s.length();i++){
                for(int j = 0; j<s1.length();j++){
                    if(s.charAt(i)==s1.charAt(j)){
                        s1=s1.replace(String.valueOf(s1.charAt(j)),"");
                        break;
                    }
                }
            }
            if(s1.isEmpty())return s2;
        }
        return "false";
    }

    public static String correct(){
        
        switch(operator){
            case "+" : return (i1+i2==answer?"Yes":"No");
            case "-" : return (i1-i2==answer?"Yes":"No");
            case "*" : return (i1*i2==answer?"Yes":"No");
            case "/" : return (i1/i2==answer?"Yes":"No");
        }

        return "No";
    }
}