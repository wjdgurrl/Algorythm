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

    //우선순위따로 지정해서 fish들 리스트에 추가해주기
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int time = 0;
        fillMap(br);
        while(remainFish()){
            visited = new boolean[N][N];
            moveForEat();
            time++;
        }
        System.out.println(time);
    }

    //물고기 잔여 확인
    //20 * 20 400
    public static boolean remainFish(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != 9 && map[i][j] > 0) return true;
            }
        }
        return false;
    }

    //물고기 먹으러 가기(가까운애 탐색하기)
    public static void moveForEat(){
        ArrayDeque<Shark> deque = new ArrayDeque<>();
        deque.offerLast(shark);
        visited[shark.y][shark.x] = true;

        while(!deque.isEmpty()){
            Shark current = deque.pollFirst();

            //고기먹을때
            if(map[current.y][current.x] > 0){
                if(current.size > map[current.y][current.x]){
                    current.eatCount += 1;
                }
                map[current.y][current.x] = 0;
            }

            if(current.size == current.eatCount) current.size += 1;

            for (int i = 0; i < 4; i++) {
                int nextY = current.y + dy[i];
                int nextX = current.x + dx[i];

                if(nextY < 0 || nextY >= N || nextX < 0 || nextX <= N) continue;
                if(visited[nextY][nextX]) continue;

                visited[nextY][nextX] = true;
                deque.offerLast(new Shark(nextY,nextX, current.size, current.eatCount));
            }
        }

    }

    private static void fillMap(BufferedReader br) throws IOException {
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Shark(i,j,2,0);
                }
            }
        }
    }

    private static class Shark{
        int y,x;
        int size;
        int eatCount;

        Shark(int y,int x,int size,int eatCount){
            this.y = y;
            this.x = x;
            this.size = size;
            this.eatCount = eatCount;
        }
    }

    private static class Fish{
        int y,x;
        int distance;

        Fish(int y, int x, int distance){
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

}
