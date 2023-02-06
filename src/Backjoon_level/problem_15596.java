package Backjoon_level;

public class problem_15596 {
    public static void main(String[] args) {
        problem_15596 sum = new problem_15596();
        System.out.println(sum.sum(new int[]{1, 2, 3, 4, 5}));
    }
    long sum(int[] a){
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans+= a[i];
        }
        return ans;
    }
}
