
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] users) {
        int[] answer = new int[n];
        Stage[] stages = new Stage[n];

        for (int i = 0; i < n; i++) {
            stages[i] = new Stage(i + 1);
        }

        for (int userStage : users) {
            if (userStage <= n) {
                stages[userStage - 1].count++;
            }
        }

        int userCount = users.length;
        for (Stage stage : stages) {
            if (stage.count == 0 || userCount == 0) {
                stage.failureRate = 0.0;
            } else {
                stage.failureRate = (double) stage.count / userCount;
                userCount -= stage.count;
            }
        }

        Arrays.sort(stages);

        for (int i = 0; i < n; i++) {
            answer[i] = stages[i].stageNumber;
        }

        return answer;
    }

    class Stage implements Comparable {
        int stageNumber;
        int count;
        double failureRate;

        public Stage(int stage) {
            this.stageNumber = stage;
        }

        @Override
        public int compareTo(Object o) {
            Stage otherStage = (Stage) o;
            if (this.failureRate == otherStage.failureRate) {
                return Integer.compare(this.stageNumber, otherStage.stageNumber);
            }
            return -Double.compare(this.failureRate, otherStage.failureRate);
        }
        s
    }
}