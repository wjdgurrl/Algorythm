package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15686
public class problem_15686 {
    private static int N;
    private static int M;
    private static int[][] map;

    private static ArrayList<location> chickenStores;
    private static ArrayList<location> houses;
    private static ArrayList<Integer> chickenLoad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houses = new ArrayList<location>();
        chickenStores = new ArrayList<location>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    chickenStore store = new chickenStore(i+1, j+1);
                    chickenStores.add(store);
                }
                else if(map[i][j] == 1){
                    House house = new House(i+1, j+1);
                    houses.add(house);
                }
            }
        }
        chickenLoad = new ArrayList<>(); // 각 치킨로드 점수 넣기
        // Todo
        // 치킨 로드를 2차원 배열로 바꿔서 각 행마다 최소값 구하기[치킨스토어.len][하우스.len]



        // 0 - 빈칸
        // 1 - 집
        // 2 - 치킨집

        //각 치킨집들로부터 집의 거리를 찾기
        fillChickenLoad();
        System.out.println(chickenLoad);
    }

    public static void fillChickenLoad(){
        for (int i = 0; i < chickenStores.size(); i++) {
            for (int j = 0; j < houses.size(); j++) {
                chickenLoad.add(distanceCalculate(chickenStores.get(i), houses.get(j)));
            }
        }
    }

    public static int distanceCalculate(location store, location house){
        int x = Math.abs(store.x - house.x); //절대값 Math.abs
        int y = Math.abs(store.y - house.y);

        return x+y;
    }
    private static class location{
        int x;
        int y;

        location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static class chickenStore extends location{

        chickenStore(int x, int y) {
            super(x, y);
        }
    }
    private static class House extends location{

        House(int x, int y) {
            super(x, y);
        }
    }

}
