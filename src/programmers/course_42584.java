package programmers;
import java.util. *;
import java.io. *;
public class course_42584 {
    public static void main(String[] args) {
        course_42584 aa = new course_42584();
        System.out.println(Arrays.toString(aa.solution(new int[]{1, 2, 3, 2, 3})));
    }
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int time = 0;
            for (int j = i + 1; j < n; j++) {
                time++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = time;
        }

        return answer;
    }
    /*public int[] solution(int[] prices){
        int[] answer = {};
        Deque<Prices> deque = new LinkedList<>();

        Prices price;
        //데크에 <시세,변동성> 각 삽입
        for(int a : prices){
            deque.offerLast(new Prices(a,0));
        }
        answer = new int[deque.size()];
        for (int i = 0; i < deque.size(); i++) {
            if (Prices.checkPriceChange(deque.pollFirst()),prices[i]){

            }
        }
        return answer;
    }
    public static class Prices{
        private int price;
        private int priceContinueTime;

        private Prices(int price, int priceContinueTime){
            this.price = price;
            this.priceContinueTime = priceContinueTime;
        }
        public int getPrice(){
            return price;
        }
        public void setPriceContinueTime(){
            priceContinueTime++;
        }
        public int getPriceContinueTime(){
            return priceContinueTime;
        }
        //시세 변동 체크
        public static boolean checkPriceChange(Prices price, int prices){
            int currentPrice = price.getPrice(); // 현재 큐의 시세
            if(currentPrice > prices){
                return true;
            }
            return false;
        }
    }*/
}
