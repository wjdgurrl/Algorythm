package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/16236
public class problem_16236 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static Shark shark;

    private static int[] dx = new int[]{0,-1,1,0};
    private static int[] dy = new int[]{-1,0,0,1};

    private static int answer = 0;

    //우선순위따로 지정해서 fish들 리스트에 추가해주기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        shark = fillMap(br);

        while(bfs());
        System.out.println(answer);

    }

    //물고기 찾아보기
    public static boolean bfs() {
        ArrayDeque<Node> deque = new ArrayDeque<>();
        ArrayList<Node> fishs = new ArrayList<>();
        visited = new boolean[N][N];

        deque.offerLast(new Node(shark.y, shark.x));
        visited[shark.y][shark.x] = true;

        int time = 0;
        boolean found = false;

        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();

            if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < shark.size) {
                fishs.add(cur);
                found = true;
            }

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > shark.size) continue;

                visited[ny][nx] = true;
                deque.offerLast(new Node(ny, nx));
            }


            if (found) break;
            time++;
        }

        if (!fishs.isEmpty()) {
            fishs.sort((a, b) -> {
                if (a.y == b.y) return a.x - b.x;
                return a.y - b.y;
            });

            Node target = fishs.get(0);
            answer += time;

            // 상어 이동
            map[shark.y][shark.x] = 0;
            shark.y = target.y;
            shark.x = target.x;

            shark.addSizeStack();
            if (shark.size == shark.sizeStack) {
                shark.setSize(shark.size + 1);
                shark.sizeStack = 0;
            }

            return true;
        }

        return false;
    }


    //물고기 먹으러 가기(가까운애 탐색하기) xxx
    // 상어위치에서 시작해서 각 물고기들 위치 큐에 담아오기


    private static Shark fillMap(BufferedReader br) throws IOException {
        map = new int[N][N];
        Shark shark = null;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Shark(i,j);
                }
            }
        }
        return shark;
    }


    private static class Node{
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Shark extends Node{
        int size;
        int sizeStack;
        Shark(int y, int x) {
            super(y, x);
            this.size = 2;
            this.sizeStack = 0;
        }

        public void addSizeStack() {
            this.sizeStack++;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }


}
