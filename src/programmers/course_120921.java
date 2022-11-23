package programmers;

public class course_120921 {
    public static void main(String[] args) {
        System.out.println(solution("hello","apple"));
    }
    public static int solution(String A, String B){
        int answer = 0;
        String AA = A;
        for (int i = 0; i <A.length(); i++) {
            if (A.equals(B)){
                return answer;
            }
            else{
                AA  = A.substring(A.length()-1);
                //h e l l o
                //AA = h e l l
                String AAA = AA + A.substring(0,AA.length()-1);
                answer++;
            }

        }

            return -1;
    }
}
