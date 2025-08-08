package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/31246
public class problem_31246 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> costs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(B > A){
                costs.add(B-A);
            }
        }
        int index = K - (N - costs.size()) - 1;
        Collections.sort(costs);

        System.out.println(index >= 0 ? costs.get(index) : 0);

    }

}
