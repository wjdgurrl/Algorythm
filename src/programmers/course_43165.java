package programmers;

import java.util. *;
import java.io. *;

public class course_43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int n : numbers){
            deque.offerLast(n);
        }
        answer += dfs(deque,0,target);
        return answer;
    }
    //재귀로 때리자
    public static int dfs(Deque<Integer> deque, int sum, int target){
        if(deque.size() == 0){
            if (sum == target) return 1;
        }
        int num = deque.pollFirst();
        for(int i=0; i < 2; i++){
            if(i == 0){

            }
        }
    }
}
//target에서 number 배열 순회하면서 1개씩 빼보기 그럼 맨 앞에서 완성되면 제외하는식?
//순서대로 찾으니까 dfs
//총합에서 배열을 돌면서 빼기?