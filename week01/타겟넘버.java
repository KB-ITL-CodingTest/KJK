import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int n = numbers.length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0}); // {index, sum}

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int index = current[0];
            int sum = current[1];

            if (index == n) {
                if (sum == target) answer++;
                continue;
            }

            stack.push(new int[]{index + 1, sum + numbers[index]});
            stack.push(new int[]{index + 1, sum - numbers[index]});
        }

        return answer;
    }
}
