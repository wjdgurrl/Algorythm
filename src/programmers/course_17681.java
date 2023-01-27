package programmers;

public class course_17681 {
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        TreasureMap t = new TreasureMap();
        t.solution(5,arr1,arr2);
    }

}
class TreasureMap{
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] arrr1 = new String[n];
        String[] arrr2 = new String[n];
        for (int i = 0; i < n; i++) {
            arrr1[i] = Integer.toBinaryString(arr1[i]);
            arrr2[i] = Integer.toBinaryString(arr2[i]);
            if (arrr1[i].length() < n) {
                for (int t = 0; t <= n - arrr1[i].length() ; t++) {
                    arrr1[i] = "0" + arrr1[i];
                }
            }
            if (arrr2[i].length() < n) {
                for (int t = 0; t <= n - arrr2[i].length() ; t++) {
                    arrr2[i] = "0" + arrr2[i];
                }
            }
        }
           StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if(arrr1[j].equals("1") || arrr2[j].equals("1")){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
                answer[j] = sb.toString();
            }
        return answer;
    }
}
