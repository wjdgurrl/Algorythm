package study.BFS;
import java.io.*;
import java.util.*;

public class problem_4179 {
	private static int R;
	private static int C;

	private static int[] dx = new int[]{0,0,1,-1};
	private static int[] dy = new int[]{1,-1,0,0};

	private static String[][] map;
	private static int[][] fireDist;
	private static int[][] jihunDist;

	private static ArrayDeque<int[]> fireDeque;
	private static ArrayDeque<int[]> jihunDeque;

	/*#: 벽
	.: 지나갈 수 있는 공간
	J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
	F: 불이 난 공간*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new String[R][C];
		fireDeque = new ArrayDeque<>(); //불에대한 큐
		jihunDeque = new ArrayDeque<>(); // 지훈이 큐
		fireDist = new int[R][C]; //불 거리
		jihunDist = new int[R][C]; // 지훈이 거리

		for (int i = 0; i < R; i++) {
			Arrays.fill(fireDist[i],-1);
			Arrays.fill(jihunDist[i],-1);
		}

		for (int i = 0; i < R; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = line[j];
				if(map[i][j].equals("F")){
					fireDist[i][j] = 0;
					fireDeque.offerLast(new int[]{i,j});
				}
				if(map[i][j].equals("J")){
					jihunDist[i][j] = 0;
					jihunDeque.offerLast(new int[]{i,j});
				}
			}
		}
		/*System.out.println(Arrays.deepToString(map));
		System.out.println(Arrays.deepToString(fireDist));
		System.out.println(Arrays.deepToString(jihunDist));*/
		//먼저 불부터 bfs
		fireBfs();
		/*System.out.println(Arrays.deepToString(map));
		System.out.println(Arrays.deepToString(fireDist));
		System.out.println(Arrays.deepToString(jihunDist));*/
		int time = jihunBfs2();
		if (time == -99){
			System.out.println("IMPOSSIBLE");
		}else{
			System.out.println(time);
		}
		/*System.out.println(Arrays.deepToString(jihunDist));*/

	}
	private static void fireBfs(){
		while(!fireDeque.isEmpty()){
			int[] current = fireDeque.pollFirst();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				//범위체크
				if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C){
					continue;
				}
				//벽 체크
				if(map[nextX][nextY].equals("#") || fireDist[nextX][nextY] > -1){
					continue;
				}
				fireDist[nextX][nextY] = fireDist[curX][curY] + 1;
				fireDeque.offerLast(new int[]{nextX,nextY});
			}
		}
	}
	private static int jihunBfs2(){
		while(!jihunDeque.isEmpty()) {
			int[] current = jihunDeque.pollFirst();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				//범위 체크 벗어나면 탈출임
				if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
					return jihunDist[curX][curY] + 1;
				}
				//벽체크 와 방문 체크
				if (jihunDist[nextX][nextY] >= 0 || map[nextX][nextY].equals("#")) {
					continue;
				}
				//불보다 지훈이가 더 빨리 움직일 수 있어야 함
				if (fireDist[nextX][nextY] != -1 && fireDist[nextX][nextY] <= jihunDist[curX][curY] + 1) {
					continue;
				}
				jihunDist[nextX][nextY] = jihunDist[curX][curY] + 1;
				jihunDeque.offerLast(new int[] {nextX, nextY});

			}
		}
		return -99;
	}
}
