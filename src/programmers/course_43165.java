package programmers;

import java.util. *;
import java.io. *;

public class course_43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));

    }
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return answer;
    }
    public static void dfs(int depth,int sum, int[] numbers, int target){
        if(depth == numbers.length){
            if(target == sum){
                answer ++;
            }
            return;
        }
        dfs(depth+1,sum + numbers[depth],numbers,target);
        dfs(depth+1, sum - numbers[depth], numbers, target);
    }
}
//target에서 number 배열 순회하면서 1개씩 빼보기 그럼 맨 앞에서 완성되면 제외하는식?
//순서대로 찾으니까 dfs
//총합에서 배열을 돌면서 빼기?