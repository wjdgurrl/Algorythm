package programmers;
import java.util. *;
import java.io. *;

public class course_68936 {
    public static void main(String[] args) {
        course_68936 aa = new course_68936();
        System.out.println(aa.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}}));
    }

    //당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
    //만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
    //그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
    //arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
    public int[] solution(int[][] arr){
        int[] answer = {};
        int row,col;
        row = arr[0].length;
        col = arr.length;
        for (int m = 0; m < col/2; m++) {
            for (int n = 0; n < row/2; n++) {

            }
        }

        return answer;
    }
}
