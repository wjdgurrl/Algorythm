package study.DFS;

import java.util. *;
import java.io. *;


//dfs로는 최단 거리를 구하지 못했음
//백트래킹으로 구현할 거 같은데 그만..하자
public class problem_7562 {

    private static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    private static int[] dx = {-2,-1,1,2,-2,-1,1,2};

    public static void main(String[] args) throws IOException{
        int[][] cases = input();
        for (int i = 0; i < cases.length; i++) {
            System.out.println(DFS(cases[i]));
        }
    }

    private static int DFS(int[] Case){
        ArrayDeque<Node> stack = new ArrayDeque<>();
        boolean[][] visited = new boolean[Case[0]][Case[0]];

        int startY = Case[1];
        int startX = Case[2];
        int destinationY = Case[3];
        int destinationX = Case[4];

        int minMove = Integer.MAX_VALUE;

        stack.offerLast(new Node(startY,startX,0));

        while(!stack.isEmpty()){
            Node current = stack.pollLast();
            int currentY = current.y;
            int currentX = current.x;
            int count = current.count;

            //arrive
            if(currentY == destinationY && currentX == destinationX){
                minMove = Math.min(minMove,count);
                continue;
            }
            if(visited[currentY][currentX]) continue;

            visited[currentY][currentX] = true;

            for (int i = 0; i < 8; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if(nextX < 0 || nextY < 0 || nextY >= Case[0] || nextX>= Case[0] ) continue;
                if(visited[nextY][nextX]) continue;

                stack.offerLast(new Node(nextY,nextX,count + 1));
            }

        }
        return minMove == Integer.MAX_VALUE ? -1 : minMove;
    }

    private static class Node{
        int y;
        int x;
        int count;
        Node(int y,int x,int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    private static int[][] input() throws IOException {
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
