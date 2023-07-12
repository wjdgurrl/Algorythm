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
    }
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
