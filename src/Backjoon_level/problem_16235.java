package Backjoon_level;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/problem/16235
public class problem_16235 {

    private static int N;
    private static int M; //초기 정보
    private static int K; //시간

    private static int[][] map;
    private static int[][] A;
    private static ArrayList<Tree> trees;

    private static int dr[] = new int[]{-1,-1,-1,0,0,1,1,1};
    private static int dc[] = new int[]{-1,0,1,-1,1,-1,0,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line =  br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);
        setMap(br);
        setStart(br);

        for(int i = 0; i < K; i++){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());

    }

    public static void setMap(BufferedReader br) throws IOException {
        map = new int[N][N];
        A = new int[N][N]; //애가 입력받을거

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = 5;
                A[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    //나무가 나이만큼 양분을 흡수하고, 나이가 1 증가, 나이가 어린 애부터 먹음
    //나이만큼 못먹으면 주긍ㅁ
    public static void spring(){
        trees.sort((o1, o2) -> o1.age - o2.age);
        for(int i = 0; i < trees.size(); i++){
            Tree currentTree = trees.get(i);
            if(map[currentTree.r][currentTree.c]  < currentTree.age){
                currentTree.isAlive = false;
            } else {
                map[currentTree.r][currentTree.c] -= currentTree.age;
                currentTree.age += 1;
            }
        }
    }

    //죽은거 양분으로 지워짐
    //죽은 나무마다  age/2를 map칸에 더하기
    public static void summer(){
        ArrayList<Tree> newTrees = new ArrayList<>();

        for (Tree tree : trees) {
            if (!tree.isAlive) {
                map[tree.r][tree.c] += tree.age / 2;
            } else {
                newTrees.add(tree);
            }
        }

        trees = newTrees;
    }

    //나무 번식
    //인접 8칸에 나이 1 나무 생성
    public static void fall(){
        for(int i = 0; i < trees.size(); i++){
            Tree currentTree = trees.get(i);

            //5배수일때
            if(currentTree.age % 5 == 0){
                for (int j = 0; j < 8; j++) {
                    int nextR =  currentTree.r + dr[j];
                    int nextC =  currentTree.c + dc[j];

                    if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;

                    trees.add(new Tree(nextR,nextC,1,true));

                }
            }
        }

    }


    //땅에 양분 추가
    public static void winter(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    public static void setStart(BufferedReader br) throws IOException {
        trees = new ArrayList<Tree>();
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            //나무 위치
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            //나이
            int z = Integer.parseInt(line[2]);

            trees.add(new Tree(x,y,z,true));
        }
    }

    public static class Tree{
        int r;
        int c;
        int age;
        boolean isAlive;

        Tree(int r, int c, int age, boolean isAlive) {
            this.r = r;
            this.c = c;
            this.age = age;
            this.isAlive = isAlive;
        }
    }
}
