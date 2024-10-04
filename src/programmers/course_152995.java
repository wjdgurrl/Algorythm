package programmers;

public class course_152995 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}}));
        System.out.println(solution(new int[][]{{2, 1}, {2, 2}, {1, 4}, {3, 2}, {3, 2}}));
        System.out.println(solution(new int[][]{{3, 2}, {2, 1}, {2, 1}, {2, 1}, {2, 1}}));
        System.out.println(solution(new int[][]{{1, 4}, {2, 2}, {3, 2}, {3, 2}, {2, 1}}));
        System.out.println(solution(new int[][]{{7, 1}, {4, 5}, {0, 3}, {3, 0}, {7, 10}}));
    }

    /*
    테스트 1 〉	통과 (0.02ms, 77MB)
테스트 2 〉	통과 (0.02ms, 74.1MB)
테스트 3 〉	통과 (0.03ms, 79.3MB)
테스트 4 〉	통과 (0.02ms, 74.8MB)
테스트 5 〉	통과 (0.04ms, 73.3MB)
테스트 6 〉	통과 (0.02ms, 72.9MB)
테스트 7 〉	통과 (0.02ms, 77.3MB)
테스트 8 〉	통과 (0.03ms, 78.5MB)
테스트 9 〉	통과 (0.06ms, 77.8MB)
테스트 10 〉	통과 (0.07ms, 76.7MB)
테스트 11 〉	통과 (0.56ms, 73.9MB)
테스트 12 〉	통과 (0.19ms, 68.3MB)
테스트 13 〉	통과 (0.05ms, 79MB)
테스트 14 〉	통과 (0.38ms, 77.5MB)
테스트 15 〉	통과 (0.38ms, 84MB)
테스트 16 〉	통과 (3.92ms, 81.2MB)
테스트 17 〉	통과 (4.94ms, 83.2MB)
테스트 18 〉	통과 (4.80ms, 92.7MB)
테스트 19 〉	통과 (0.90ms, 111MB)
테스트 20 〉	통과 (1.67ms, 106MB)
테스트 21 〉	실패 (시간 초과)
테스트 22 〉	통과 (24.75ms, 106MB)
테스트 23 〉	통과 (6.41ms, 123MB)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	실패 (시간 초과)
     */
    public static int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoScore = wanho[0] + wanho[1];
        int wanhoRank = 1;

        // 인센티브 못 받는 사람 제외
        boolean[] noBonusCheck = new boolean[scores.length];
        for (int i = 0; i < scores.length; i++) {
            for (int j = i + 1; j < scores.length; j++) {
                // 완호가 인센티브를 못 받는 경우
                if (noBonusCheck[0]) {
                    return -1;
                }
                if (noBonusCheck[i]) {
                    break;
                }
                if (noBonusCheck[j]) {
                    continue;
                }

                int[] employee1 = scores[i];
                int[] employee2 = scores[j];

                if (employee1[0] < employee2[0] && employee1[1] < employee2[1]) {
                    noBonusCheck[i] = true;
                }
                if (employee1[0] > employee2[0] && employee1[1] > employee2[1]) {
                    noBonusCheck[j] = true;
                }
            }
        }

        for (int i = 1; i < scores.length; i++) {
            if (noBonusCheck[i]) {
                continue;
            }

            int[] employee = scores[i];
            int employeeScore = employee[0] + employee[1];
            if (wanhoScore < employeeScore) {
                wanhoRank++;
            }
        }

        return wanhoRank;
    }
}
