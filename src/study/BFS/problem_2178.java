package study.BFS;

import java.util.*;
import java.io.*;

public class problem_2178 {

	private static int[] dx = new int[]{0,0,1,-1};
	private static int[] dy = new int[]{1,-1,0,0};

	private static int[][] board;
	//private static boolean[][] visited; // 사실 미로판에서 지나온 칸 수를 기록해서 하기에 방문 처리가 필요없음
	private static int N;
	private static int M;

	private static ArrayDeque<int[]> deque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		board = new int[N][M];
		//visited = new boolean[N][M];
		deque = new ArrayDeque<>();

		//미로판 채우기
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}

		int num = bfs(0,0);
		System.out.println(num);
	}
	public static int bfs(int x, int y){
		//시작지점
		//방문 처리
		//visited[x][y] = true;
		//큐에 넣기
		deque.offerLast(new int[]{x,y});

		//큐에서 꺼낼때마다 칸을 지나온 길이므로 미로판 배열에서 칸 수를 갱신
		board[x][y] = 1;

		while(!deque.isEmpty()){
			int[] current = deque.pollFirst();
			int curX = current[0];
			int curY = current[1];

			//종료 조건 체크
			if(curX == N-1 && curY == M-1){
				return board[curX][curY];
			}
			//동서남북 탐색
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
					continue;
				}
				if(board[nextX][nextY] == 0){
					continue;
				}
				//방문처리
				//visited[nextX][nextY] = true;
				//미로판에 해당 칸의 값에 +1을 해서 지나온 칸 수를 기록하기
				board[nextX][nextY] = board[curX][curY] + 1;
				//처리 후 큐에 넣기
				deque.offerLast(new int[]{nextX,nextY});

			}
		}
		return -1;
	}
}
