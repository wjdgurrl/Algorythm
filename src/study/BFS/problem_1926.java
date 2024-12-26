package study.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*문제
	어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

	입력
	첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

	출력
	첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.*/

public class problem_1926 {
	//동서남북 돌기
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static boolean[][] visited;

	public static int n;
	public static int m;

	public static ArrayDeque<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		int num = 0;
		int maxNum = 0;
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		visited = new boolean[n][m];
		//먼저 좌표를 담을 큐를 생성해주기
		queue = new ArrayDeque<>();

		//첫 스타트 좌표 담기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//색칠이 안되있거나 방문한 경우 넘어감
				if (board[i][j] == 0 || visited[i][j]) {
					continue;
				}
				//탐색 해야 하는 경우
				num ++;//일단 그림은 찾았음

				maxNum = Math.max(maxNum,bfs(board,i,j)); // 최대 크기 찾기
			}
		}
		System.out.println(num);
		System.out.println(maxNum);
	}
	public static int bfs(int[][] board,int x, int y) {
		//먼저 방문처리 하고 큐에 넣음
		visited[x][y] = true;
		queue.offerLast(new int[]{x, y});
		int area = 0; //현재 그림의 크기

		//큐에 들어갔으니 해당 좌표를 기준으로 탐색 시작
		while (!queue.isEmpty()) {
			area++; //큐에서 하나 꺼낼때마다 그림 크기가 늘어나는 것
			int[] current = queue.pollFirst(); //현재 좌표 꺼내기
			int curX = current[0];
			int curY = current[1];

			//동서남북 탐색하기
			for (int i=0; i<4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];

				//범위를 벗어나는 경우
				if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
					continue;
				}
				//이미 방문한 경우 + 보드판에 0이 그려진 경우
				if(visited[nextX][nextY] || board[nextX][nextY] == 0){
					continue;
				}

				//다음에 방문한 예정일 곳 처리
				visited[nextX][nextY] = true;
				queue.offerLast(new int[]{nextX, nextY});
			}
		}
		return area;
	}
}

