package Backjoon_level;
import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/31247
public class problem_31247 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            long[] evenCount = new long[(int) (N + 1)];
            long[] oddCount = new long[(int) (N + 1)];

            // 약수 개수 O(N log N) 계산
            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) { // 짝수 약수
                    for (int j = i; j <= N; j += i) {
                        evenCount[j]++;
                    }
                } else { // 홀수 약수
                    for (int j = i; j <= N; j += i) {
                        oddCount[j]++;
                    }
                }
            }

            int totalCount = 0;
            for (int i = 1; i <= N; i++) {
                if (evenCount[i] == K * oddCount[i]) {
                    totalCount++;
                }
            }

            System.out.println(totalCount);
        }

    }

}
