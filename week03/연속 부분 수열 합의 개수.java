import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sumSet = new HashSet<>();

        int[] extended = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extended[i] = elements[i % n];
        }

        for (int len = 1; len <= n; len++) {
            int sum = 0;

            for (int i = 0; i < len; i++) {
                sum += extended[i];
            }
            sumSet.add(sum);

            for (int start = 1; start < n; start++) {
                sum = sum - extended[start - 1] + extended[start + len - 1];
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
