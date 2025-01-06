package study.BFS;
import java.util. *;
import java.io. *;

        /*문제
        수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
        만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

        수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

        입력
        첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

        출력
        수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.*/
public class problem_1697 {
    public static ArrayDeque<Integer> deque =new ArrayDeque<>();
    public static int[] visited = new int[100001];
    public static int[] dx = {1,-1};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        System.out.println(bfs(N,K));

    }

    public static int bfs(int n,int k) {
        if(n == k) return 0; // 시작위치와 같을때

        visited[n] = 1;
        deque.offerLast(n);

        while(!deque.isEmpty()){
            int current = deque.pollFirst();
            if(current==k) return visited[current];
            for (int i = 0; i < 3; i++) {
                int next = (i==2) ? current * 2 : current + dx[i];
                if (next < 0 || next > 100000 || visited[next] > 0){
                    continue;
                }
                visited[next] = visited[current] + 1;
                if(next == k) return visited[next] - 1;
                deque.offerLast(next);
            }
        }

        return -1;
    }
}
