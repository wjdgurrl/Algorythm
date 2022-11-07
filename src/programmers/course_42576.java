package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42576
/*
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
*/

public class course_42576 {
    public static void main(String[] args) {
        //String participant[] = new String[3];
        //String completion[] = new String[2];

        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String temp = "";
        String[] check = new String[participant.length];
        for (int i = 0; i < participant.length; i++) {
            for (int k = 0; k < completion.length; k++) {
                if (participant[i].equals(completion[k])) {
                    check[i] = "1";
                } else {
                    check[i] = "0";
                }
            }
        }
        for (int j = 0; j < participant.length; j++) {
            if (check[j].equals("0")) {
                temp = participant[j];
            }
        }
        String answer = temp;


        return answer;
    }
}
