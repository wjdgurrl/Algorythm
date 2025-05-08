package study.GREEDY;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/11399
public class problem_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int Arr[] = new int[N];
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arr[0] = arr[0];
        answer += Arr[0];
        for (int i = 1; i < N; i++) {
            Arr[i] = Arr[i-1] + arr[i];
            answer += Arr[i];
        }

        System.out.println(answer);


    }
}
