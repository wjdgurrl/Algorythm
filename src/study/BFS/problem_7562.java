package study.BFS;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/7562
public class problem_7562 {
    private static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    private static int[] dx = {-2,-1,1,2,-2,-1,1,2};
    //[y][x]
    // 1234
    // 5678
    public static void main(String[] args) throws IOException {
        int[][] cases = input();
        for (int i = 0; i< cases.length;i++){
            System.out.println(BFS(cases[i]));
        }
    }

    //Case[0] - > l
    //Case[1],[2] -> 나이트 위치 y,x
    //Case[3],[4] -> 목적지 위치 y,x

    private static int BFS(int[] Case){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[Case[0]][Case[0]];
        deque.offerLast(new Node(Case[1],Case[2],0)); //나이트 위치 넣기
        visited[Case[1]][Case[2]] = true;

        while(!deque.isEmpty()){

            Node current = deque.pollFirst();
            int currentX = current.getX();
            int currentY = current.getY();

            if(currentY == Case[4] && currentX == Case[3]){
                return current.getCount();
            }

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= Case[0] || nextY >= Case[0]) continue;
                if(visited[nextY][nextX]) continue;

                visited[nextY][nextX] = true;
                deque.offerLast(new Node(nextY,nextX,current.getCount() + 1));
            }
        }
        return -1;
    }

    private static class Node{
        int x;
        int y;
        int count;
        Node(int y, int x,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }
        public int getY(){
            return y;
        }

        public int getCount() {
            return count;
        }
    }

    private static int[][] input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[][] cases = new int[testCase][5];
        for (int i = 0; i < testCase; i++) {
            int l = Integer.parseInt(br.readLine()); // 체스판 한 변 길이
            String[] line = br.readLine().split(" ");

            int[] knight = new int[2];//나이트 위치
            knight[1] = Integer.parseInt(line[0]); // x좌표
            knight[0] = Integer.parseInt(line[1]); //y좌표

            line = br.readLine().split(" ");

            int[] destination = new int[2]; // 목적지
            destination[0] = Integer.parseInt(line[0]);
            destination[1] = Integer.parseInt(line[1]);

            cases[i][0] = l;
            cases[i][1] = knight[0];
            cases[i][2] = knight[1];
            cases[i][3] = destination[0];
            cases[i][4] = destination[1];
        }
        return cases;
    }
}
