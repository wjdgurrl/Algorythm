package study.BFS;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/2468
public class problem_2468 {
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayDeque<Node> deque;

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static int N;

    private static HashSet<Integer> waters;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        waters = new HashSet<>(); //침수량 저장
        TreeMap<Integer, Integer> results = new TreeMap<>();
        //해쉬 셋으로 값 구해야 하나?
        drawMap(br,N);

        Iterator<Integer> iterator = waters.iterator();
        while(iterator.hasNext()){
            int water = iterator.next(); //현재 침수량
            int area = 0;
            visited = new boolean[N][N];
            deque = new ArrayDeque<>();

            area = searchBFS(water); //시작 지점 큐에 넣기 + 방문 처리
            //BFS(water)
            //트리맵에 넣기
            results.putIfAbsent(water, area);
        }
        System.out.println(Collections.max(results.values()));
    }


    //기존 큐에서 활용
    private static void BFS(int x, int y, int water){
        visited[y][x] = true;
        deque.offerLast(new Node(x,y));

        while(!deque.isEmpty()){
            Node current = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if(visited[nextY][nextX]) continue;
                if(map[nextY][nextX] <= water) continue;

                visited[nextY][nextX] = true;
                deque.offerLast(new Node(nextX,nextY));
            }

        }
    }

    //시작 지점 전부 넣기
    private static int searchBFS(int water){
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                if(map[i][j] > water){
                    BFS(j,i,water);
                    area++;
                }
            }
        }
        return area;
    }


    private static record Node(int x, int y){};


    private static void drawMap(BufferedReader br, int N) throws IOException{
        //맵 그리기 + 요쇼 값 집합에 넣기
        waters.add(0); //모두 안잠길때

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(inputs[j]);
                map[i][j] = height;
                waters.add(height);
            }
        }
    }



}
