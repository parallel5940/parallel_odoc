import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class URIDecode{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(bf.readLine());
        while(c-->0){

            String inputData = bf.readLine();
            System.out.println(decoding(inputData));       
        }
    }
    public static String decoding(String data){
        if(data.contains("%20")) data = data.replace("%20", " ");
        if(data.contains("%21")) data = data.replace("%21", "!");
        if(data.contains("%24")) data = data.replace("%24", "$");
        if(data.contains("%28")) data = data.replace("%28", "(");
        if(data.contains("%29")) data = data.replace("%29", ")");
        if(data.contains("%2a")) data = data.replace("%2a", "*");
        if(data.contains("%2d")) data = data.replace("%2d", "-");
        if(data.contains("%25")) data = data.replace("%25", "%");
        return data;
    }
}