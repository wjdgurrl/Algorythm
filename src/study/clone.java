package study;

import java.util.Arrays;

public class clone {
    public static void main(String[] args) {
        clone aa = new clone();
        System.out.println(aa.solution(new int[]{0,1,2,3,4},new int[][]{{0,3},{1,2},{1,4}}));
    }
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int t = queries[0][0];
        int idx1 = Arrays.asList(arr).indexOf(t);
        for(int i=0;i<queries.length;i++){
            idx1 = Arrays.asList(arr).indexOf(queries[i][0]);
            int idx2 = Arrays.asList(arr).indexOf(queries[i][1]);
            int temp = 0;
            temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        answer = arr.clone();
        return answer;
    }
}
