import java.util.*;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int rows, cols;

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();
        visited = new boolean[rows][cols];
        List<Integer> result = new ArrayList<>();

        char[][] map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    result.add(bfs(map, i, j));
                }
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int bfs(char[][] map, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = map[x][y] - '0';

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        sum += map[nx][ny] - '0';
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return sum;
    }
}
