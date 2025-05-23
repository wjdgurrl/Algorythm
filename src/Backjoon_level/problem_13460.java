package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/13460
public class problem_13460 {

    private static String[][] map;
    private static int[][] points; // 구슬, 구멍 위치 좌표 ,x,y
    private static boolean[][][][] visited;
    private static int[] dx = {-1,1,0,0};// 왼오위아
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        points = new int[3][2];
        map = new String[N][M];
        visited = new boolean[N][M][N][M];

        fillMap(br);
        System.out.println(BFS());
    }

    private static int BFS(){
        ArrayDeque<Point> deque = new ArrayDeque<Point>();
        deque.offerLast(new Point(points[0][1],points[0][0],points[1][1],points[1][0],0));
        visited[points[0][0]][points[0][1]][points[1][0]][points[1][1]] = true;
        while(!deque.isEmpty()){
            Point cur = deque.pollFirst();

            if(cur.count > 10){
                return -1;
            }

            //기울이기 방향
            for (int i = 0; i < 4; i++) {
                // i = 0,1 -> x좌표 확인
                // 2,3 -> y좌표
                /*int priority = checkPriority(cur,i);*/
                int redNextX = cur.redX;
                int redNextY = cur.redY;
                int blueNextX = cur.blueX;
                int blueNextY = cur.blueY;

                int redMove = 0;
                int blueMove = 0;


                //지나가기전에 판단해야하네
                while(isBound(redNextX + dx[i],redNextY + dy[i]) && !map[redNextY + dy[i]][redNextX + dx[i]].equals("#")){
                    redNextX += dx[i];
                    redNextY += dy[i];
                    redMove ++;
                    if (map[redNextY][redNextX].equals("O")) break;
                }

                while(isBound(blueNextX + dx[i], blueNextY + dy[i]) && !map[blueNextY + dy[i]][blueNextX + dx[i]].equals("#")) {
                    blueNextX += dx[i];
                    blueNextY += dy[i];
                    blueMove++;
                    if (map[blueNextY][blueNextX].equals("O")) break;
                }

                //둘다 들어가면 실패
                if(map[blueNextY][blueNextX].equals("O")){
                    continue;
                }

                if(map[redNextY][redNextX].equals("O")){
                    return cur.count + 1;
                }

                //우선순위 비교해서 한칸 뒤로 가야함
                if(redNextX == blueNextX && redNextY == blueNextY){
                    if(redMove > blueMove){
                        redNextX -= dx[i];
                        redNextY -= dy[i];
                    }else{
                        blueNextX -= dx[i];
                        blueNextY -= dy[i];
                    }

                }



                if(visited[redNextY][redNextX][blueNextY][blueNextX]) continue;

                visited[redNextY][redNextX][blueNextY][blueNextX] = true;
                deque.offerLast(new Point(redNextX, redNextY, blueNextX, blueNextY, cur.count + 1));
            }
        }
        return -1;

    }

    private static boolean isBound(int x, int y){
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length;
    }



    private static void fillMap(BufferedReader br) throws IOException {
        for (int i = 0; i < map.length; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                map[i][j] = line[j]; //y,x
                switch (map[i][j]) {
                    case "R":
                        points[0][0] = i; // y
                        points[0][1] = j; // x
                        break;
                    case "B":
                        points[1][0] = i;
                        points[1][1] = j;
                        break;
                    case "O":
                        points[2][0] = i;
                        points[2][1] = j;
                }
            }
        }
    }
    private static class Point{
        int redX;
        int redY;
        int blueX;
        int blueY;
        int count;

        public Point(int redX, int redY, int blueX, int blueY,int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }
}
