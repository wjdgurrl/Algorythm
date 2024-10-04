package programmers;

public class course_250137 {
    public static void main(String[] args) {
        course_250137 aa = new course_250137();
        //System.out.println(aa.solution(new int[]{5,1,5},30,new int[][]{{2,10},{9,15},{10,5},{11,5}}));
        System.out.println(aa.solution(new int[]{10,10,100},10,new int[][]{{1,15},{3,1}}));
    }
    public int solution(int[] bandage, int health, int[][] attacks){
        int answer = 0;
        int time = 0;
        int MaxHealth = health;
        int plus = bandage[1];
        int n=0;
        for(int i=0;i<=attacks[attacks.length-1][0];i++){
            time++;
            if(n<=attacks.length-1 && i == attacks[n][0]){ // 피격시
                health -= attacks[n][1];
                n++;
                time =0;
                continue;
            }
            if(health + plus < MaxHealth && time == bandage[0]){//연속힐 성공
                plus = bandage[1]+bandage[2];
                time = 0;
            }
            else if(health + plus >= MaxHealth){
                health = MaxHealth;
                continue;
            }
            else{
                plus = bandage[1];
            }
            /*if(i == attacks[n][0]){ // 시간 끝
                answer = health;
                break;
            }*/
            health += plus;
        }
        answer = health;
        return answer > 0 ? answer : -1 ;
    }
}
