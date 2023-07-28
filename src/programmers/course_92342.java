package programmers;

import java.util.*;
import java.io.*;
public class course_92342 {
    public static void main(String[] args) {
        //int a = 0;//어피치가 맞춘 횟수
        //int b = 0; // 라이언이 맞춘 횟수
        //k(1~10)는 더 많이 맞출 경우 제공되는 점수
        //동점일 경우 라이언이 불리, 최종 시에도 어피치 우승
        int n = 5; //화살의 개수
        int[] info = new int[11]; //어피치가 맞힌 과녁점수
        // {2,1,1,1,0,0,0,0,0,0,0};


        /*for (int i = 0; i < 10; i++) {
            info[i] = 10-i;
        }*/
        course_92342 aa = new course_92342();
        aa.solution(n,info);
    }
    int[] lion = new int[11];
    int[] peach = new int[11];
    int depth;
    int[] answer = {};
    public int[] solution(int n, int[] info){
        depth = n;
        if (n==0) answer[0] = -1;
        peach = info;
        //Queue<Node> lionScore = new LinkedList<>();
        //ArrayList<int[]> lionScore = new ArrayList<>();
        dfs(n);
        return answer;
    }
    static int bestScore = 0;
    public void dfs(int n){
         // 라이온 스코어
        int peachScore = 0;
        int lionScore = 0;
        if(n == depth){
            for (int i = 0; i < 11; i++) {
                if(lion[i] == 0 && peach[i]==0){
                    continue;
                }
                if(lion[i] > peach[i]) lionScore += (10-i);
                if(lion[i] <= peach[i]) peachScore += (10-i);
            }
            int diff = lionScore - peachScore;
            if (diff < 0) answer = lion;
            // 10점 2개 3개  2  0
            // 9점  1개 2개  1  2
            // ~~           1  2
            //              1  0
        }
    }

}
class Node{
    int N;
    int Score;
    public Node(int n, int sc){
        this.N = n;
        Score = sc;
    }
}
