import java.util.*;

public class Main {
    static int[] check = new int[4]; 
    static int[] current = new int[4]; 
    static int validCount = 0; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); 
        int P = sc.nextInt(); 
        String dna = sc.next(); 

        
        for (int i = 0; i < 4; i++) {
            check[i] = sc.nextInt();
        }

        char[] arr = dna.toCharArray();
        int result = 0;

        
        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }

        if (isValid()) result++;

        
        for (int i = P; i < S; i++) {
            add(arr[i]); 
            remove(arr[i - P]); 
            if (isValid()) result++;
        }

        System.out.println(result);
    }

    
    public static void add(char c) {
        int idx = getIndex(c);
        current[idx]++;
    }

    
    public static void remove(char c) {
        int idx = getIndex(c);
        current[idx]--;
    }

    public static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < check[i]) return false;
        }
        return true;
    }

    
    public static int getIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1;
    }
}
