package Backjoon_level;

import java.util.*;
import java.io.*;

public class problem_18808 {

    static int N,M,K;
    static ArrayList<Node> stickers = new ArrayList<>();
    static int[][] board; //노트북 뒷판
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int cnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //노트북 세로
        M = Integer.parseInt(st.nextToken()); //노트북 가로
        K = Integer.parseInt(st.nextToken()); //스티커 개수

        board = new int[N][M]; // 노트북 뒷판

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Node node = new Node(R,C);
            node.setStickerArray(stickerAdd(R,C));
            stickers.add(node);
        }

        dfs(0);

        System.out.println(cnt);

    }
    /*스티커를 회전시키지 않고 모눈종이에서 떼어낸다.

    다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다. 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다.
    가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.

    선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
    위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.*/

    public static void dfs(int depth) {
        if (depth == stickers.size()) {
            cnt = checkStickerCount(board);
            return;
        }

        Node cur = stickers.get(depth);

        for (int rotate = 0; rotate < 4; rotate++) {
            if (attachCheck(cur)) {
                break;
            }
            rotateSticker(cur);
        }
        dfs(depth+1);
    }

    public static int checkStickerCount(int[][] board){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    //붙이는지 확인
    // 스티커를 붙일 수 있는지 확인 후, 붙일 수 있으면 바로 붙인다.
    public static boolean attachCheck(Node sticker) {
        int r = sticker.r;
        int c = sticker.c;

        for (int x = 0; x <= N - r; x++) {  // 노트북 범위를 벗어나지 않게
            for (int y = 0; y <= M - c; y++) {
                if (canAttach(sticker, x, y)) {
                    attachSticker(sticker, x, y);  // 실제로 스티커를 붙임
                    return true;
                }
            }
        }
        return false;  // 붙일 수 있는 위치가 없으면 false 반환
    }

    // 스티커를 붙일 수 있는지 검사하는 함수
    public static boolean canAttach(Node sticker, int startX, int startY) {
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.stickerArray[i][j] == 1 && board[startX + i][startY + j] == 1) {
                    return false;  // 겹치는 부분이 있으면 false
                }
            }
        }
        return true;
    }

    // 스티커를 실제로 붙이는 함수
    public static void attachSticker(Node sticker, int startX, int startY) {
        for (int i = 0; i < sticker.r; i++) {
            for (int j = 0; j < sticker.c; j++) {
                if (sticker.stickerArray[i][j] == 1) {
                    board[startX + i][startY + j] = 1;
                }
            }
        }
    }


    //회전
    public static void rotateSticker(Node sticker){
        int r = sticker.r;
        int c = sticker.c;
        int[][] rotatedSticker = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                rotatedSticker[i][j] = sticker.stickerArray[r-1-j][i];  // 90도 회전
            }
        }
        sticker.stickerArray = rotatedSticker;
        sticker.setR(c);
        sticker.setC(r);
    }

    private static class Node{
        private int r,c;
        private int[][] stickerArray;

        private Node(int r,int c){
            this.r = r;
            this.c = c;
        }

        private void setR(int r){
            this.r = r;
        }
        private void setC(int c){
            this.c = c;
        }
        private void setStickerArray(int[][] stickerArray) {
            this.stickerArray = stickerArray;
        }
    }

    public static int[][] stickerAdd(int R,int C) throws IOException{
        int[][] sticker = new int[R][C];
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                sticker[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return sticker;
    }
}
