package study.BFS;

import java.io.*;
import java.util.*;

public class problem_7576 {

	private static int M;
	private static int N;

	private static int[] dx = new int[]{0,0,1,-1};
	private static int[] dy = new int[]{1,-1,0,0};

	private static int[][] board;
	private static ArrayDeque<int[]> deque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		board = new int[N][M];
		deque = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(line[j]);
				//시작점 전부 큐에 넣기
				if(board[i][j] == 1){
					deque.offerLast(new int[]{i,j});
				}
			}
		}
		bfs();
		System.out.println(checkState(0));

	}

	private static int checkState(int day){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0){
					return -1;
				}
				day = Math.max(board[i][j] , day);
			}
		}
		return day-1;
	}
	public static void bfs(){
		while(!deque.isEmpty()){
			int[] current = deque.pollFirst();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				//범위 쳌
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M){
					continue;
				}

				//안익은 토마토 체크 벽 체크
				if(board[nextX][nextY] != 0){
					continue;
				}
				//박스에 체크
				board[nextX][nextY] = board[curX][curY] + 1;
				//새로운 좌표 큐에 넣기
				deque.offerLast(new int[]{nextX,nextY});
			}
		}
	}
}
