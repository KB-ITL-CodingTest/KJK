import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        sc.nextLine();
        int total = 0;

        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();
            int length = 0;

            for (int j = 0; j < M; j++) {
                char ch = row.charAt(j);

                if (ch == '0') {
                    length++;
                } else {
                   
                    if (length >= K) {
                        total += (length - K + 1);
                    }
                    length = 0;
                }
            }

        
            if (length >= K) {
                total += (length - K + 1);
            }
        }

        System.out.println(total);
    }
}
