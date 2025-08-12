package programmers;

import java.util.*;
import java.io.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/84021?language=java
public class course_84021 {

    private static ArrayList<Poly> polys = new ArrayList<Poly>();
    private static ArrayList<Box> boxes = new ArrayList<Box>();

    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    private static int[][] Board;
    private static int[][] Table;

    public static void main(String[] args) {
        course_84021 aa = new course_84021();
        System.out.println(aa.solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}} ));
        System.out.println(aa.solution(new int[][]{{0,0,0},{1,1,0},{1,1,1}} , new int[][]{{1,1,1},{1,0,0},{0,0,0}}));
    }

    public int solution(int[][] game_board, int[][] table){
        int answer = -1;
        Board = game_board;
        Table = table;

        //도형 찾기
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board[0].length; j++){
                //게임판에서 빈칸 찾기
                if(game_board[i][j] == 0){
                    BFS(new Node(i,j), false);
                }
                //테이블에서 도형 찾기
                if(table[i][j] == 1){
                    BFS(new Node(i,j) , true);
                }
            }
        }

        //System.out.println(polys.toString());
        //System.out.println(boxes.toString());

        /*boolean[] usedPoly = new boolean[polys.size()];
        answer = dfs(0,usedPoly,0);*/
        answer = comparePoly();


        return answer;
    }

    /*public static int dfs(int depth , boolean[] visited, int curCount){
        if(depth >= boxes.size()){
            return curCount;
        }
        int maxCount = 0;
        Box curBox = boxes.get(depth);
        maxCount = Math.max(maxCount,dfs(depth+1,visited,curCount));

        // 도형이랑 매칭 시도
        for(int i = 0; i < polys.size(); i++){
            if(visited[i]) continue;
            Poly poly = polys.get(i);

            if(curBox.box.length != poly.box.length || curBox.box[0].length != poly.box[0].length) continue;
            Poly rotatedPoly = poly;
            for (int j = 0; j < 4; j++) {
                rotatedPoly = rotatedPoly.rotate();
                if(Arrays.deepEquals(rotatedPoly.box,curBox.box)) {
                    visited[i] = true;

                    int count =  dfs(depth + 1, visited, curCount + countPoly(rotatedPoly));
                    maxCount = Math.max(maxCount, count);

                    //백트
                    visited[i] = false;
                }
            }
        }
        return maxCount;
    }*/

    public static int comparePoly(){
        int totalCount = 0;
        boolean[] usedBox =  new boolean[boxes.size()];

        for (Poly poly : polys){
            for (int i = 0; i < boxes.size(); i++){
                if (usedBox[i]) continue;

                Box box = boxes.get(i);
                if(countPoly(poly) != countPoly(box)) continue;

                Poly rotatedPoly = poly;
                boolean isMatched = false;

                for (int j = 0; j < 4; j++) {
                    rotatedPoly = rotatedPoly.rotate();

                    if(rotatedPoly.box.length != box.box.length || rotatedPoly.box[0].length != box.box[0].length) continue;

                    // 배열 내용 비교
                    if( Arrays.deepEquals(rotatedPoly.box, box.box)){
                        totalCount += countPoly(rotatedPoly);
                        usedBox[i] = true;
                        isMatched = true;
                        break;
                    }
                }
                if(isMatched) break;
            }
        }
        return totalCount;
    }

    public static int countPoly(Box poly){
        int count = 0;
        for(int i = 0; i < poly.box.length; i++){
            for(int j = 0; j < poly.box[0].length; j++){
                if(poly.box[i][j] == 1) count++;
            }
        }
        return count;
    }

    public static void BFS(Node start,boolean isPoly){
        ArrayDeque<Node> deque = new ArrayDeque<>();
        //boolean[][] visited = new boolean[target_board.length][target_board[0].length];
        deque.offerLast(start);
        //visited[start.y][start.x] = true;
        if(isPoly){
            Table[start.y][start.x] = -1;
        } else {
            Board[start.y][start.x] = -1;
        }


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

                if(x < 0 || y < 0 || x >= Board[0].length || y >= Board.length) continue;
                //if(visited[y][x]) continue;


                if(!isPoly){
                    //보드 뒤질때
                    if(Board[y][x] == 1 || Board[y][x] == -1) continue;
                    Board[y][x] = -1;
                } else {
                    //테이블 뒤질때
                    if(Table[y][x] == 0 || Table[y][x] == -1) continue;
                    Table[y][x] = -1;
                }

                deque.offerLast(new Node(y,x));
            }
        }

        //int len = Math.max(maxY- minY + 1,maxX - minX + 1);

        int[][] temp_box = new int[maxY- minY + 1][maxX - minX + 1];

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
            int rows = this.box.length;
            int cols = this.box[0].length;
            int[][] rotatedBox = new int[cols][rows];

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    rotatedBox[j][rows - 1 - i] = this.box[i][j];
                }
            }
            return new Poly(rotatedBox);
        }
    }
}
