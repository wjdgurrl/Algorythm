package programmers;
import java.util.*;
import java.io.*;
public class course_154538 {
    public static void main(String[] args) {
        System.out.println(aaa.solution(10,40,30));
        System.out.println(aaa.solution(10,40,5));
        System.out.println(aaa.solution(10,40,30));
        System.out.println(aaa.solution(2,5,4));
        System.out.println(aaa.solution(38,40,2));
        System.out.println(aaa.solution(8,144,32));
        System.out.println(aaa.solution(8,134,32));
    }
    static class aaa{
        public static int solution(int x, int y, int n){
            //1. x에 n을 더하기
            //2. x에 3 곱하기
            //3. x에 2 곱하기
            // x -> y 가 되야 하는 최소 수
            int answer = 0;
            answer = dfs(x,y,n);
            return answer;
        }
        public static int dfs(int x, int y, int n){
            if(x == y) return 0;
            if(x > y) return -1;
            int result = Integer.MAX_VALUE;
            if(x+n <= y){
                int res = dfs(x+n,y,n);
                if(res != -1) result = Math.min(result,res+1);
            }
            if(x*3 <= y){
                int res = dfs(x*3,y,n);
                if(res != -1) result = Math.min(result,res+1);
            }
            if(x*2 <= y){
                int res = dfs(x*2,y,n);
                if(res != -1) result = Math.min(result,res+1);
            }
            return result == Integer.MAX_VALUE ? -1 : result;

        }
    }

    /*static class aaa{
        public static int solution(int x, int y, int n) {
            int[] ar = new int[y+1];
            Arrays.fill(ar,-1);
            int num = 0;
            int answer= 0;
            ar[y] = 0;
            for (int i = y; !(i == x) ;) {
                if (x+n == i) {
                    ar[i - n] = num;
                    i -= n;
                    num++;
                    continue;
                }
                if (i / 3 > 0 && i % 3 == 0) {
                    ar[i / 3] = num;
                    i /= 3;
                    num++;
                    continue;
                }
                if (i / 2 > 0 && i % 2 == 0) {
                    ar[i / 2] = num; //0,1,2
                    i /= 2;
                    num++;
                    continue;
                }
                if (i - n >= x) {
                    ar[i - n] = num;
                    i -= n;
                    num++;
                    continue;
                }
                else {
                    num = -1;
                    break;
                }
            }
            answer = num;
            return answer;
        }
    }*/
            /*Node q = new Node(0,this.);
            class Node {
                int num;
                int count;

                public void Node() {
                    this.num = num;
                    this.count = count;
                }
            }
        }*/
}
