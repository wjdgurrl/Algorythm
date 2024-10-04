package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class course_258712 {
    public static void main(String[] args) {
        course_258712 aa = new course_258712();
        System.out.println(aa.solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
    }
    //두 사람이 선물하기 주고받은 기록이 있으면 더 많이 받은 쪽이 다음달에 선물 받음
    // 기록이 없거나 수가 같으면 선물지수가 더 큰사람이 더 작은 사람에게 하나 받음
    // 선물지수 = 준거 - 받은거
    // 선물지수가 같으면 교환 x
    // answer = 선물을 가장 많이 받을 친구가 받을 선물의 수

    /*
    ↓준 사람 \ 받은 사람→	        muzi	ryan	frodo	neo
                        muzi	-	    0	    2	    0
                        ryan	3	    -	    0	    0
                        frodo	1	    1	    -	    0
                        neo	    1	    0	    0	    -
    */

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String,HashMap<String,Integer>> graph = new HashMap<>(); // 준사람, 받은사람, 개수
        HashMap<String, Integer> giftLevel = new HashMap<>(); // 지수


        for (String name : friends) {
            giftLevel.put(name, 0);
        }
        for (String name : friends){
            for (int j = 0; j < gifts.length; j++) {
                String[] info = gifts[j].split(" ");
                int count = 0;
                if (giftLevel.containsKey(info[0])) {
                    count++;
                }
                if (giftLevel.containsKey(info[1])) {
                    count--;
                }
                giftLevel.put(name,count);
            }
        }
        int maxCount = 0;
        for (int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {

            }
        }


        return answer;
    }
}
