import java.util.*;

public class Main {
    static int MAX = 100000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(bfs(n, k));
    }

    static int bfs(int start, int target) {
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0], time = cur[1];

            if (pos == target) return time;

            int[] nextPos = {pos - 1, pos + 1, pos * 2};
            for (int i = 0; i < 3; i++) { 
                int next = nextPos[i];
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }
        return -1; 
    }
}
