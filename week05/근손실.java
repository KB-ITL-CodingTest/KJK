import java.util.*;

public class Main {
    static int N, K, result = 0;
    static int[] kits;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        K = sc.nextInt(); 
        kits = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            kits[i] = sc.nextInt();
        }

        dfs(0, 500); 
        System.out.println(result);
    }

    static void dfs(int day, int weight) {
        if (day == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int nextWeight = weight + kits[i] - K;
                if (nextWeight < 500) continue;

                visited[i] = true;
                dfs(day + 1, nextWeight);
                visited[i] = false;
            }
        }
    }
}
