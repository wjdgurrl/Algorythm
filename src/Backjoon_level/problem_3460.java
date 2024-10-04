package Backjoon_level;

import java.io.*;
import java.util.*;

public class problem_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
        StringBuilder stringBuilder = new StringBuilder(); // 결과를 저장할 StringBuilder

        for (int i = 0; i < t; i++) {
            int bit = 0;
            StringBuilder answer = new StringBuilder();
            int n = Integer.parseInt(br.readLine()); // 각 십진수를 개별적으로 입력받기

            while (n != 0) {
                if (n % 2 == 1) {
                    answer.append(bit).append(" "); // 비트 위치를 공백으로 구분하여 추가
                }
                n /= 2;
                bit++;
            }
            // 마지막 공백 제거
            if (answer.length() > 0) {
                answer.setLength(answer.length() - 1); // 마지막 공백 제거
            }

            stringBuilder.append(answer.toString()).append("\n"); // 결과를 전체 결과에 추가
        }

        System.out.print(stringBuilder.toString()); // 결과를 한 번에 출력
        br.close();
    }
}
