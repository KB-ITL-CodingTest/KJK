import java.util.*;

public class Main {
    static int k;
    static int[] s;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) break;

            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }

            dfs(0, 0, new ArrayList<>());
            System.out.println();
        }
    }

    public static void dfs(int start, int depth, List<Integer> combination) {
        if (depth == 6) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            combination.add(s[i]);
            dfs(i + 1, depth + 1, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
