import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 
 class Brackets2 {
 
    public static char searchBracketPair(char originalBracket){
        char pairBracket;
 
        if(originalBracket == '['){
            pairBracket = ']';
        }
//      else if(originalBracket == ']'){
//          pairBracket = '[';
//      }
        else if(originalBracket == '('){
            pairBracket = ')';
        }
//      else if(originalBracket == ')'){
//          pairBracket = '(';
//      }
        else if(originalBracket == '{'){
            pairBracket = '}';
        }
//      else if(originalBracket == '}'){
//          pairBracket = '{';
//      }
        else{
            pairBracket = '*';
        }
 
        return pairBracket;
    }
 
 
    //먼저 입력값이 짝수인지 확인. 홀수이면 그냥 끝.
    //그리고 입력값 중에 괄호가 아닌애가 있는지 확인. 아니면 끝.
    public static boolean isScannerValid(char[] scanner){
        boolean returnValue = false;
 
        if(scanner.length%2 == 0){
            for(int i=0; i<scanner.length; i++){
                if((scanner[i] == '[') || (scanner[i] == ']')
                        || (scanner[i] == '{') || (scanner[i] == '}')
                        || (scanner[i] == '(') || (scanner[i] == ')')){
                    returnValue = true;
                }
            }
        }
 
        return returnValue;
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //testcase 의 갯수.
        String[] brackets = new String[T];
        char[] elements = new char[10000];//10000 이상인지 확인. 아니면 끝.
 
        String[] printValue = new String[T];
 
        List<Character> eList = new ArrayList<Character>();
        int count = 0;
 
        if((1 <= T) && (T <= 100)){
            for(int i=0; i<T; i++){
                brackets[i] = sc.next();
                elements = brackets[i].toCharArray();
 
                eList.clear();
                count = 0;
 
                if(isScannerValid(elements)){
 
//                  System.out.println("valid" + elements.length);
 
 
                    for(int j=0; j<elements.length; j++){
                        eList.add(elements[j]);
 
//                      System.out.println(eList.get(j));
                    }
 
 
//                  System.out.println("1. "+eList.size());
//                  System.out.println("2. "+count);
 
                    //비교하기위한 로직.
                    while((eList.size() != 0) && (count != eList.size()) ){
                        count = eList.size();
 
                        for(int j=0; j<eList.size()-1; j++){
                            if(eList.get(j+1) == searchBracketPair(eList.get(j))){
                                eList.remove(j);
//                              System.out.println("::: " + j + eList.toString());
 
                                eList.remove(j);
//                              System.out.println("::: "+eList.toString());
                            }else{
//                              System.out.println("??????");
                            }
                        }
//                      System.out.println(eList.size());
 
                        if(eList.size() == 0){
                            printValue[i] = "YES";
                        }else{
                            printValue[i] = "NO";
                        }
                    }
 
                }else{
                    printValue[i] = "NO";
                }
 
            }
 
            for(int i=0; i<T; i++){
                System.out.println(printValue[i]);
            }
        }
    }
}