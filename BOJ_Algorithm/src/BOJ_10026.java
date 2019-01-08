import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
/**
 * 백준 10026번 적록색약
 */

public class BOJ_10026 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        People people = new People(map, N);
        System.out.println(people.getOriginArea() + " " + people.getBlindArea());
        br.close();
    }
 
    static class People {
        private final int[] Y = {0, 1, 0, -1};
        private final int[] X = {1, 0, -1, 0};
        private final int HEALTHY = 1;
        private final int BROWN_COLOR = 2;
        private char[][] map;
        private int n;
 
        public People(char[][] map, int n) {
            this.map = map;
            this.n = n;
        }
 
        public int getOriginArea() {
            boolean[][] visited = new boolean[n][n];
            int areaNum = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!visited[i][j]) {
                        ++areaNum;
                        bfsArea(i, j, visited, HEALTHY);
                    }
                }
            }
            return areaNum;
        }
 
        public int getBlindArea() {
            boolean[][] visited = new boolean[n][n];
            int areaNum = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!visited[i][j]) {
                        ++areaNum;
                        bfsArea(i, j, visited, BROWN_COLOR);
                    }
                }
            }
            return areaNum;
        }
 
        private void bfsArea(int y, int x, boolean[][] visited, int who) {
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(y, x));
            visited[y][x] = true;
 
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                for (int i=0; i<4; i++) {
                    int adj_y = p.getY() + Y[i];
                    int adj_x = p.getX() + X[i];
                    if (adj_y >= 0 && adj_x >= 0 && adj_y < n && adj_x < n) {
                        if (!visited[adj_y][adj_x]) {
                            if (who == HEALTHY) {
                                if (map[p.getY()][p.getX()] == map[adj_y][adj_x]) {
                                    queue.offer(new Pair(adj_y, adj_x));
                                    visited[adj_y][adj_x] = true;
                                }
                            } else if (who == BROWN_COLOR) {
                                if (map[p.getY()][p.getX()] == map[adj_y][adj_x]
                                        || (map[p.getY()][p.getX()] == 'R' && map[adj_y][adj_x] == 'G')
                                        || (map[p.getY()][p.getX()] == 'G' && map[adj_y][adj_x] == 'R')) {
                                    queue.offer(new Pair(adj_y, adj_x));
                                    visited[adj_y][adj_x] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
 
    static class Pair {
        private int y, x;
 
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
 
        public int getY() {
            return y;
        }
 
        public int getX() {
            return x;
        }
    }
}


//http://virusworld.tistory.com/86