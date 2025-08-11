package programmers;

import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/84021?language=java
public class course_84021 {

    private static ArrayList<Poly> polys = new ArrayList<Poly>();
    private static ArrayList<Box> boxes = new ArrayList<Box>();

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public static void main(String[] args) {
        course_84021 aa = new course_84021();
        System.out.println(aa.Solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},
                new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}} ));
    }

    public int Solution(int[][] game_board, int[][] table){
        int answer = -1;

        //도형 찾기
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[0].length; j++){
                //게임판에서 빈칸 찾기
                if(game_board[i][j] == 0){
                    BFS(game_board, new Node(i,j), false);
                }
                //테이블에서 도형 찾기
                if(table[i][j] == 1){
                    BFS(table, new Node(i,j) , true);
                }
            }
        }

        System.out.println(polys.toString());
        System.out.println(boxes.toString());




        return answer;
    }

    public static void BFS(int[][] target_board , Node start,boolean isPoly){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[target_board.length][target_board[0].length];
        deque.offerLast(start);
        visited[start.y][start.x] = true;

        //도형 담을 릿흐트
        ArrayList<Node> box = new ArrayList<Node>();

        //담을 박스
        int minX = start.x;
        int minY = start.y;
        int maxX = start.x;
        int maxY = start.y;

        while (!deque.isEmpty()) {
            Node current =  deque.pollFirst();

            minX = Math.min(minX, current.x);
            minY = Math.min(minY, current.y);
            maxX = Math.max(maxX, current.x);
            maxY = Math.max(maxY, current.y);

            box.add(current);

            for(int i = 0; i < 4; i++){
                int y = current.y + dy[i];
                int x = current.x + dx[i];

                if(x < 0 || y < 0 || x >= target_board[0].length || y >= target_board.length) continue;
                if(visited[y][x]) continue;


                if(!isPoly){
                    //보드 뒤질때
                    if(target_board[y][x] == 1) continue;
                } else {
                    //테이블 뒤질때
                    if(target_board[y][x] == 0) continue;
                }

                visited[y][x] = true;
                deque.offerLast(new Node(y,x));
            }
        }

        int len = Math.max(maxY- minY + 1,maxX - minX + 1);

        int[][] temp_box = new int[len][len];

        //그래프에서 도형을 추출해서 박스에 담기
        for (Node node : box) {
            int y = node.y - minY;
            int x = node.x - minX;
            temp_box[y][x] = 1;
        }
        //박스에 담은 도형 넣기
        if(isPoly){
            polys.add(new Poly(temp_box));
        } else {
            boxes.add(new Box(temp_box));
        }


    }

    public static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static class Box{
        int[][] box;
        Box(int[][] box){
            this.box = box;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < box.length; i++){
                for(int j = 0; j < box[0].length; j++){
                    sb.append(box[i][j]).append(" ");
                }
            }
            return sb.toString();
        }
    }

    public static class Poly extends Box{
        Poly(int[][] poly){
            super(poly);
        }

        public Poly rotate(){
            int[][] temp = new int[this.box.length][this.box[0].length];
            for(int i = 0; i < box.length; i++){
                for(int j = 0; j < box[0].length; j++){
                    temp[j][this.box.length - i - 1] = temp[i][j];
                }
            }
            return new Poly(temp);
        }
    }
}
