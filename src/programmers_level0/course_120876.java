package programmers_level0;

public class course_120876 {
    public static void main(String[] args) {
        aa a = new aa();
        //System.out.println(a.solution(new int[][]{{0,1},{2,5},{3,9}}));
        //System.out.println(a.solution(new int[][]{{-3,0},{-3,2},{-4,-1}}));
        System.out.println(a.solution(new int[][]{{0,5},{3,9},{1,10}}));
    }
}
class aa{
    public int solution(int[][] lines){
        int answer = 0;
        for (int i = 0; i < lines.length-1; i++) {
            for (int j = i+1; j < lines.length; j++) {
                answer += checkLine(lines[i][1],lines[j][0],lines[j][1]);
            }

        }
        return answer;
    }
    public int checkLine(int num, int ls ,int le){
        int ans= 0;
        if(num>=ls && num<=le){
            ans = num - ls;
            if(ans>0) ans  = ans;
            else ans = -ans;
        }
        return ans;
    }
}
