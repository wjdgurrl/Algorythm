package Backjoon_level;
import java.nio.Buffer;
import java.util. *;
import java.io. *;
public class problem_2798 {
    public static void main(String[] args) throws IOException{
        problem_2798 bj = new problem_2798();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String num = (br.readLine());
        st = new StringTokenizer(num);
        int N,M;
        N = Integer.parseInt(st.nextToken()); // 카드 개수
        M = Integer.parseInt(st.nextToken()); // 넘지 말아야 할 수

        ArrayList<Integer> arr = new ArrayList<>();
        num = (br.readLine());
        st = new StringTokenizer(String.valueOf(num));
        while(st.hasMoreTokens()){
            arr.add(Integer.valueOf(st.nextToken()));
        }
        bj.blackJack(arr,M);
    }
    public int blackJack(ArrayList<Integer> arr, int M){
        //3장의 합만 찾기
        int sum = 0;
        int temp = 0;
        while (true){
            Collections.sort(arr);
            for (int i = arr.size(); i >= 0; i++) {
                for (int j = i-1; j >=0; j++) {
                    for (int k = j-2; k >=0; k++) {
                        sum = arr.get(i) + arr.get(j) + arr.get(k);
                    }
                }
            }
            if(sum == M){
                return sum;
            }

        }
    }
}
