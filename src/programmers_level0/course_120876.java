package programmers_level0;

public class course_120876 {
    public static void main(String[] args) {
        aa a = new aa();
        System.out.println(a.solution(new int[][]{{0,1},{2,5},{3,9}}));
        System.out.println(a.solution(new int[][]{{-3,0},{-3,2},{-4,-1}}));
       System.out.println(a.solution(new int[][]{{0,5},{3,9},{1,10}}));
    }
}
class aa{
    public int solution(int[][] lines){
        int answer = 0;
        for (int i = -100; i < 100; i++) {
            int line = 0;
            if (lines[0][0]<=i && lines[0][1]>=i) line++;
            if (lines[1][0]<=i && lines[1][1]>=i) line++;
            if (lines[2][0]<=i && lines[2][1]>=i) line++;

            if(line > 1) answer++;
        }

        return answer;
    }
}
