package programmers;
import java.util. *;
import java.io. *;
public class course_42584 {
    public static void main(String[] args) {

    }
    public int[] solution(int[] prices){
        int[] answer = {};
        Deque<Prices> deque = new LinkedList<>();
        answer = new int[deque.size()];
        Prices price;
        //데크에 <시세,변동성> 각 삽입
        for(int a : prices){
            deque.offerLast(new Prices(a,0));
        }
        while(!deque.isEmpty()){
            answer = price.checkPriceChange(deque.peekFirst(),deque);
        }

        return answer;
    }
    public class Prices{
        private int price;
        private int priceContinueTime;

        private Prices(int price, int priceContinueTime){
            this.price = price;
            this.priceContinueTime = priceContinueTime;
        }
        public int getPrice(){
            return price;
        }
        public int setPriceContinueTime(){
            return priceContinueTime++;
        }
        public int getPriceContinueTime(){
            return priceContinueTime;
        }
        //시세 변동 체크
        public int checkPriceChange(Prices price,Deque<Prices> futurePrice){
            int currentPrice = price.getPrice(); // 현재 큐의 시세
            for (int i = 0; i < futurePrice.size(); i++) {
                if(currentPrice < futurePrice.pollFirst().getPrice()){
                    return price.setPriceContinueTime();
                }
            }
            return -100;
        }
    }
}
