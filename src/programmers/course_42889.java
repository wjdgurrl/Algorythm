package programmers;

public class course_42889 {
    public static void main(String[] args) {
        // 도달했으나 클리어하지 못한 수 / 도달한 수
        // N = 스테이지 개수
        // stages 길이
        int[] stages = {2,1,2,6,2,4,3,3};
        Failure fal = new Failure();
        System.out.println(fal.solution(5,stages));
    }

}
class Failure{
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int cleared = 0;
        int fail = 0;
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) {
                //통과자 수
                cleared++;
            } else if (stages[i] <= N) {
                fail++;
            }
        }
        int t;
        do {
            t = stages.length;
        }

        while (t == 0); {
            System.out.println();
        }


        return answer;
    }
}
