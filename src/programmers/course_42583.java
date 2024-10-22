package programmers;

import java.util.*;

public class course_42583 {
    public static void main(String[] args) {
        course_42583 aa = new course_42583();
        System.out.println(aa.solution(2,10,new int[]{7,4,5,6}));
        System.out.println(aa.solution(100,100,new int[]{10}));
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int onbridge_weight = 0;
        Deque<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            while(true){
                //다리가 비었을때
                if(bridge.isEmpty()){
                    bridge.offerLast(truck_weights[i]);
                    onbridge_weight += truck_weights[i];
                    answer++;
                    break;
                }
                //다리에 트럭
                else{
                    //다리에 트럭 대수가 다 참
                    if(bridge.size() == bridge_length) onbridge_weight -= bridge.pollFirst();
                    //추가되는 트럭이 무게 초과 시 0만 넣기
                    else if(onbridge_weight + truck_weights[i] > weight){
                        bridge.offerLast(0);
                        answer++;
                    }
                    // 다음 트럭 추가가능
                    else{
                        bridge.offerLast(truck_weights[i]);
                        onbridge_weight+= truck_weights[i];
                        answer++;
                        break;
                    }
                }
            }

        }
        //마지막
        return answer + bridge_length;

    }
}

