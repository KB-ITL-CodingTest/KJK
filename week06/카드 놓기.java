import java.util.*;

public class Main {
    static int N, K;
    static String[] cards;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        K = sc.nextInt(); 

        cards = new String[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.next();
        }

        dfs("", 0); 

        System.out.println(set.size()); 
    }

    static void dfs(String current, int count) {
        if (count == K) {
            set.add(current);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + cards[i], count + 1);
                visited[i] = false;
            }
        }
    }
}
