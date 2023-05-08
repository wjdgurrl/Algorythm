package programmers;

public class course_13469 {
    public static void main(String[] args) {
        System.out.println(aaa(new int[]{1000, 800, 900},1000000,3));
    }
    public static int aaa(int[] boxes, int m, int k){
        int answer= 0;
        int[] after_box = new int[boxes.length];
        int max_money = 0;
        for (int day = 0; day < k; day++) {
            for(int i=0;i< boxes.length;i++){
                after_box[i] = (m/10000) * boxes[i];
                if(after_box[i] > 100000) after_box[i] = 0;
                if(max_money < after_box[i]) max_money = after_box[i];
            }
            m += max_money;
            max_money = 0;
        }
        answer = m;
        return answer;
    }
}
