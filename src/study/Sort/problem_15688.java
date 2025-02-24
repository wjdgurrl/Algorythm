package study.Sort;

import java.io.*;

public class problem_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int OFFSET = 1000000;  // 음수를 처리하기 위한 오프셋
        int SIZE = 2000001;    // 총 크기 (-1,000,000 ~ 1,000,000)
        int[] freq = new int[SIZE]; // 카운팅 정렬용 배열

        int N = Integer.parseInt(br.readLine());

        // 입력받아서 카운팅
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            freq[num + OFFSET]++; // 음수를 인덱스로 변환
        }

        // 정렬된 결과 출력
        for (int i = 0; i < SIZE; i++) {
            while (freq[i]-- > 0) {
                bw.write((i - OFFSET) + "\n"); // 원래 값으로 변환하여 출력
            }
        }

        bw.flush(); // 출력 버퍼 비우기
        br.close();
        bw.close();
    }
}

