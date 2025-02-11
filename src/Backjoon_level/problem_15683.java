package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_15683 {

    static int N,M;
    static int[][] office;
    static ArrayList<int[]> cctvs = new ArrayList<>(); //<-cctv 위치와 종류 (x,y,type)
    static int min_num = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0}; //상 우 하 좌
    static int[] dy = {0, 1, 0, -1};

    static int[][][] directions = {
            {}, //구색 맞추기 0
            {{0},{1},{2},{3}},  //1번 카메라
            {{0,2},{1,3}},      //2번 카메라
            {{0,1},{1,2},{2,3},{3,0}}, //3번 카메라
            {{0,1,2,},{1,2,3},{2,3,0},{3,0,1}}, //4번
            {{0,1,2,3}}, //5번
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(line[j]);

                if(1<= office[i][j] && office[i][j] <= 5){ //cctv 위치 기록하기
                    cctvs.add(new int[]{i,j,office[i][j]});
                }
            }
        }

        dfs(0,office);
        System.out.println(min_num);

    }

    public static void dfs(int depth, int[][] map){
        if(depth == cctvs.size()){ //cctv 전부 탐색 완료
            //모든 cctv의 방향 설정 후 사각지대 계산
            int blindSpot = countBlindSpots(map);
            min_num = Math.min(min_num,blindSpot);
            return;
        }
        //cctv 위치와 종류 [depth][(x,y,type)]
        int curX = cctvs.get(depth)[0];
        int curY = cctvs.get(depth)[1];
        int curType = cctvs.get(depth)[2];

        //무빙

        for (int[] dirs : directions[curType]) {
            int[][] copiedMap = copyMap(map); //백트래킹을 위해 복사해서 사용하기.
            for (int dir : dirs){
                cctvCheck(curX,curY,dir,copiedMap);
            }
            dfs(depth+1,copiedMap); // 다음 cctv 관전
        }
    }

    public static int[][] copyMap(int[][] map){
        int[][] copiedMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copiedMap[i] = map[i].clone();
        }
        return copiedMap;
    }

    public static void cctvCheck(int x, int y, int dir, int[][] map){
        int nextX = x + dx[dir];
        int nextY = y + dy[dir];

        while(0 <= nextX && nextX <N && 0 <= nextY && nextY < M && map[nextX][nextY] != 6){
            if(map[nextX][nextY] == 0){
                map[nextX][nextY] = -1; //감시 가능하면 -1로 변환
            }

            nextX += dx[dir];
            nextY += dy[dir]; //계속 진행
        }
    }

    public static int countBlindSpots(int[][] map){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0) count++;
            }
        }
        return count;
    }

}
