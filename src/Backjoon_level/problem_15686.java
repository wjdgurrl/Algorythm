package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/15686
public class problem_15686 {
    private static int N, M;
    private static int[][] map;
    private static ArrayList<Location> chickenStores;
    private static ArrayList<Location> houses;
    private static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houses = new ArrayList<>();
        chickenStores = new ArrayList<>();

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenStores.add(new Location(i, j));
                } else if (map[i][j] == 1) {
                    houses.add(new Location(i, j));
                }
            }
        }

        // DFS를 이용해 M개의 치킨집 선택
        dfs(0, new ArrayList<>());

        // 최소 치킨 거리 출력
        System.out.println(minDistance);
    }

    public static void dfs(int index, ArrayList<Location> selected) {
        // M개의 치킨집을 선택한 경우 최소 거리 계산
        if (selected.size() == M) {
            minDistance = Math.min(minDistance, calculateCityChickenDistance(selected));
            return;
        }

        // 치킨집 조합 선택 (index부터 탐색)
        for (int i = index; i < chickenStores.size(); i++) {
            selected.add(chickenStores.get(i));  // 치킨집 선택
            dfs(i + 1, selected);  // 다음 치킨집 선택 (i+1부터)
            selected.remove(selected.size() - 1);  // 백트래킹 (선택 취소)
        }
    }

    // 선택된 치킨집들로부터 도시의 치킨 거리 계산
    public static int calculateCityChickenDistance(ArrayList<Location> selected) {
        int totalDistance = 0;

        for (Location house : houses) {
            int minDist = Integer.MAX_VALUE;

            for (Location chicken : selected) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minDist = Math.min(minDist, dist);
            }

            totalDistance += minDist;
        }

        return totalDistance;
    }

    // 위치를 나타내는 클래스
    private static class Location {
        int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
