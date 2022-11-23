package programmers;

public class course_81301 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("2three45sixseven"));
        /*int test = 7;
        String q = String.valueOf(test);
        System.out.println(q);*/
    }
}
class Solution{
    public int solution(String s){
        int answer=0;
        String[] t = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        Integer[] k = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < t.length; i++) {
            s = s.replaceAll(t[i], String.valueOf(k[i]));
        }
        answer = Integer.parseInt(s);
        return answer;
    }

}