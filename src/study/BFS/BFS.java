package study.BFS;
import java.io.*;
import java.util.*;


public class BFS {

    /* test data
    4 6
    101111
    101010
    101011
    111011
     */
    // 동서남북
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int n;
    private static int m;
    private static int[][] array;
    private static boolean[][] visited;
    private static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        array = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node visitNode = q.poll();

            // 종료 조건 체크
            if (visitNode.x == n - 1 && visitNode.y == m - 1) {
                System.out.println(visitNode.movement);
                return;
            }

            // 방문 체크
            //visited[visitNode.x][visitNode.y] = true;

            // 이동
            for (int i = 0; i < 4; i++) {
                int nextX = visitNode.x + dx[i];
                int nextY = visitNode.y + dy[i];

                // 보내도 되는지 체크
                if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > m - 1) {
                    continue;
                }

                // 이미 방문한 노드는 다시 방문하지 않도록 체크
                if (visited[nextX][nextY]) {
                    continue;
                }

                // 노드 이동
                if (array[nextX][nextY] == 1) {
                    q.offer(new Node(nextX, nextY, visitNode.movement + 1));
                    visited[nextX][nextY] = true;
                }


            }
        }
    }
    static class Node {
        int x;
        int y;
        int movement;

        public Node(int x, int y, int movement) {
            this.x = x;
            this.y = y;
            this.movement = movement;
        }
    }
}
