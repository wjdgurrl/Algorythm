package programmers;
import java.util. *;
import java.io. *;

/*1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
  2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,  2, 1, 2, 3, 2, 4, 2, 5, ...
  3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...*/

public class course_42840 {
    public static void main(String[] args) {
        System.out.println(new int[]{1,2,3,4,5});
        //1번은 그냥 12345 반복 하면 됌
        //2번은 2, 1, 2, 3, 2, 4, 2, 5 반복?
        //3번은 33 11 22 44 55 반복
    }
    public static int[] solution(int[] answers) {
        int[] answer = {};
        List<student> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            student student = new student();
            switch (i + 1) {
                /*case 1 -> student.setAns(Arrays.asList(1, 2, 3, 4, 5));
                case 2 -> student.setAns(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
                case 3 -> student.setAns(Arrays.asList(33, 11, 22, 44, 55));*/
            }
            arr.add(student);
        }
        return answer;
    }
    static class student{
        private List<Integer> ans;
        private int score;

        public void setScore(int score) {
            this.score = score;
        }

        public void setAns(List<Integer> ans) {
            this.ans = ans;
        }
        public void addAns(int a){
            this.ans.add(a);
        }
    }
}
