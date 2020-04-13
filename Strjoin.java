import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Strjoin {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            br.readLine();
            String[] inputs = br.readLine().split(" ");
            System.out.println(strcat(inputs));
        }
    }

    public static int strcat(String[] inputs) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        for (int i = 0; i < inputs.length; i++) {
            pQueue.add(Integer.parseInt(inputs[i]));
        }
        int mergeSum = 0, mergeCount = inputs.length - 1, smallSum = 0;

        for (int i = 0; i < mergeCount; i++) {
            smallSum = pQueue.peek();
            pQueue.remove();
            smallSum += pQueue.peek();
            pQueue.remove();
            pQueue.add(smallSum);
            mergeSum += smallSum;
        }
        return mergeSum;
    }
}