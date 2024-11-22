package programmers;

import java.util. *;
import java.io. *;

public class course_42586 {
    public static void main(String[] args) {
        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};
        featureCalculate(progresses,speeds);
    }
    public static int[] featureCalculate(int[] prograsses, int[] speeds){
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        Deque<Integer> progress = setQueue(prograsses);
        ArrayList<Integer> sp = new ArrayList<>();

        for(int speed : speeds) sp.add(speed);

        int feature = 0;
        while(!progress.isEmpty()){
            if(progress.peekFirst() >= 100){
                progress.pollFirst();
                sp.remove(0);
                feature++;
                if(progress.isEmpty()) arr.add(feature);
                continue;
            }
            //task++
            if(feature > 0) {
                arr.add(feature);
                feature = 0;
            }
            else{
                progress = dayPlus(progress,sp);
            }
        }
        System.out.println(arr);
        return answer;
    }

    public static Deque<Integer> setQueue(int[] p){
        Deque<Integer> progress = new ArrayDeque<>();
        for (int i = 0; i < p.length; i++) {
            progress.offerLast(p[i]);
        }
        return progress;
    }
    public static Deque<Integer> dayPlus(Deque<Integer> progresses,ArrayList<Integer> speeds){
        Deque<Integer> afterProgresses = new ArrayDeque<>();
        while(!progresses.isEmpty()){
            for (int s : speeds)
                afterProgresses.offerLast(progresses.pollFirst()+ s);
        }
        return afterProgresses;
    }
}
