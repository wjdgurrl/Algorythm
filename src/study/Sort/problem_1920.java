package study.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1920
public class problem_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 및 배열 초기화
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 공백을 기준으로 숫자 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬 (이분 탐색을 위해)
        Arrays.sort(arr);

        // M 입력 및 배열 초기화
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // StringBuilder를 사용해 출력 성능 최적화
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(arr, target) >= 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        // 한 번에 출력
        System.out.print(sb);
    }
}
