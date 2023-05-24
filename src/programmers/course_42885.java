package programmers;

import java.util.*;

public class course_42885 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70,50,80,50},100));
    }
    static public int solution(int[] people, int limit){
        int answer = 0;
        int min,max;
        Arrays.sort(people);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i: people) arr.add(i);
        while(arr.size() != 0){
            min = arr.get(0);
            max = arr.get(arr.size()-1);
            if((min + max) <= limit){
                answer ++;
                arr.remove(0);
                arr.remove((arr.size()-1));
            }
            else{
                arr.remove(arr.size()-1);
                answer++;
            }
            if(arr.size() == 1) {
                answer++;
                break;
            }
        }

        return answer;
    }

}
