import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int m = scanner.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(start, end, 0);
        System.out.println(result);
    }

    static void dfs(int node, int target, int depth) {
        if (node == target) {
            result = depth;
            return;
        }

        visited[node] = true;

        int size = graph[node].size();
        for (int i = 0; i < size; i++) {
            int next = graph[node].get(i);
            if (!visited[next]) dfs(next, target, depth + 1);
        }
    }
}
