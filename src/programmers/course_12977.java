package programmers;

public class course_12977 {
    public static void main(String[] args) {
        course_12977 aa = new course_12977();
        System.out.println(aa.solution(new int[]{1,2,3,4}));
    }
    public int solution(int[] nums){
        int answer = 0;
        int numberSum = 0;
        for(int i = 0; i < nums.length-2; i++){
            int firstNum = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                int secondNum = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int thirdNum = nums[k];
                    numberSum = firstNum + secondNum + thirdNum;
                    if(primeNum(numberSum)) answer++;
                }
            }
        }
        return answer;
        // 1,2,3,5,7,11,13,17
    }
    public boolean primeNum(int sum){
        for (int i = 2; i <= sum/2; i++) {
            if(sum % i ==0) return false;
        }
        return true;
    }
}
