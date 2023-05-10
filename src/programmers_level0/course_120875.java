package programmers_level0;

public class course_120875 {
    public static void main(String[] args) {
        A aa = new A();
        System.out.println(aa.solution(new int[][]{{1,4},{9,2},{3,8},{11,6}}));
        System.out.println(aa.solution(new int[][]{{3,5},{4,1},{2,4},{5,10}}));
        System.out.println(aa.solution(new int[][]{{1,1},{2,2},{3,3},{4,4}}));
    }
}
class A{
    public int solution(int[][] dots){
        int answer = 0;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        int x3 = 0, y3 = 0, x4 = 0, y4 = 0;
        for (int i = 0; i < dots.length-1; i++) {
            for (int j = i+1; j < dots.length; j++) {
                x1 = dots[i][0];
                y1 = dots[i][1];
                x2 = dots[j][0];
                y2 = dots[j][1];
                double s1 = slope(x1,y1,x2,y2);

                for (int k = 0; k < dots.length; k++) {
                    if(k!=i && k!=j){
                        x3 = dots[k][0];
                        y3 = dots[k][1];
                    }
                    for (int l = k+1; l < dots.length; l++) {
                        if(l != i&& l!= j){
                            x4 = dots[l][0];
                            y4 = dots[l][1];

                            double s2 = slope(x3,y3,x4,y4);

                            if (s1 == s2) answer = 1;
                            else answer = 0;
                        }
                    }
                }
            }

        }
        return answer;
    }
    public double slope(int x1, int y1, int x2, int y2) {
        double slope = 0;
        if (x2 - x1 != 0) {
            slope = (double)(y2 - y1) / (double)(x2 - x1);
        }
        if(slope < 0) slope = -slope;
        return slope;
    }
}
