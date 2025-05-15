import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        int before = -1;
        for (int i = start; i < N; i++) {
            if (arr[i] == before) continue;
            result[depth] = arr[i];
            before = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
