import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1;
    }

    static void dfs(String str, int depth) {
        if (depth > 5) return;
        if (!str.isEmpty()) list.add(str);

        for (int i = 0; i < vowels.length; i++) {
            dfs(str + vowels[i], depth + 1);
        }
    }
}
