import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

class Stock {
    public int[] stock(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> downSeconds = new ArrayList<>();
        int second = 0;
        int index = 0;

        for (int price : prices) {
            q.offer(price);
        }
        while (!q.isEmpty()) {
            index++;
            if (index == prices.length) {
                break;
            }
            for (int i = index; i < prices.length; i++) {
                second++;
                if (q.peek() > prices[i]) {
                    downSeconds.add(second);
                    second = 0;
                    q.poll();
                    break;
                }
                if (i == prices.length - 1) {
                    downSeconds.add(second);
                    second = 0;
                    q.poll();
                }
            }
        }
        downSeconds.add(0);

        return downSeconds.stream().mapToint(i->i)toArray());
    }
}