import java.util.*;

public class Main {
    static int[] nums = {1, 5, 10, 50};
    static Set<Integer> result = new HashSet<>();
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0, 0);
        System.out.println(result.size());
    }

    static void dfs(int depth, int sum, int idx) {
        if (depth == N) {
            result.add(sum);
            return;
        }

        for (int i = idx; i < 4; i++) {
            dfs(depth + 1, sum + nums[i], i);
        }
    }
}
