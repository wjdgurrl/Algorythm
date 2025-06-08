package Backjoon_level;

import java.util. *;
import java.io. *;


//https://www.acmicpc.net/problem/2146
public class problem_2146 {
    public static int[][] map;
    public static int[][] mapId;
    public static ArrayDeque<Node> deque;
    public static ArrayList<ArrayList<Node>> islandBoundaryList;
    public static boolean[][] visited; // 섬 좌표 탐색용
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        fillMap();
        visited = new boolean[map.length][map.length];
        mapId = new int[map.length][map.length];
        islandBoundaryList = new ArrayList<ArrayList<Node>>();
        //전부 돌아야 되나?
        //외곽 부터 전부 찾아보자
        System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != 1 || visited[i][j]) continue;
                bfs(i,j, islandBoundaryList.size() + 1);
            }
        }

        //구한 좌표를 기준으로 각 섬 외곽 좌표까지 min?
        for (int i = 0 ; i < islandBoundaryList.size(); i++) {
            visited = new boolean[map.length][map.length];
            //mapId = new int[map.length][map.length];
            deque = new ArrayDeque<>();

            for (Node spot : islandBoundaryList.get(i)) {
                deque.offerLast(new Node(spot.y, spot.x, i,0));
                visited[spot.y][spot.x] = true;
            }

            findDist(i);
        }
        //디버깅용
        for (int i = 0; i < islandBoundaryList.size(); i++) {
            System.out.println((i + 1) + "번째 섬");
            ArrayList<Node> test = islandBoundaryList.get(i);
            for (Node t: test) {
                System.out.println(t.y +" "+ t.x + " "+t.id);
            }
            System.out.println("===");
        }

        System.out.println(min);

    }

    public static void findDist(int islandId){
        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if(visited[ny][nx]) continue;

                if(map[ny][nx] == 1 && mapId[ny][nx] != islandId && mapId[ny][nx] != 0){
                    // 다른 섬에 도달
                    min = Math.min(min, cur.dist);
                    return;
                }

                visited[ny][nx] = true;
                deque.offerLast(new Node(ny, nx, islandId, cur.dist + 1));
            }
        }
    }


    public static class Node{
        int y;
        int x;
        int id;
        int dist;

        Node(int y,int x,int id,int dist){
            this.y = y;
            this.x = x;
            this.id = id;
            this.dist = dist;
        }


    }

    // 각 섬마다 외곽을 탐색
    // 각 좌표만 검사하자 -> bfs로 탐색하자
    public static void bfs(int y, int x,int id) {
        ArrayList<Node> island = new ArrayList<>();
        ArrayDeque<Node> deque = new ArrayDeque<>();

        deque.offerLast(new Node(y,x, id,0));
        mapId[y][x] = id;
        visited[y][x] = true;

        while(!deque.isEmpty()){
            Node cur = deque.pollFirst();
            // 외곽인지 체크
            if(map[cur.y][cur.x] == 1 && findBoundary(cur)){
                island.add(cur);
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if(visited[ny][nx] || map[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                mapId[ny][nx] = id;
                deque.offerLast(new Node(ny, nx,id,0));
            }
        }
        islandBoundaryList.add(island);
    }

    public static boolean findBoundary(Node cur){
        for (int i = 0; i < 4; i++) {
            int ny = cur.y + dy[i];
            int nx = cur.x + dx[i];

            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
            if (map[ny][nx] != 0) continue;
            return true;
        }
        return false;
    }

    public static void fillMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
