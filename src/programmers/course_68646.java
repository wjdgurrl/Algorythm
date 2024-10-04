package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/68646

public class course_68646 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,-1,5}));
    }
    static public int solution(int[] a){
        int answer = 0;
        for (int i = 0; i < a.length-1; i++) {
            boolean smallCount = false;
            balloon(i,a,smallCount); // i = 살릴거
        }

        return answer;
    }


    static public int balloon(int index, int[] a, boolean smallCount){
        for (int i = 0; i < a.length; i++) { //비교할거
            if(i == index){ // i = 살릴거
                continue;
            }
            //if(i < index)
        }
        return index;
    }

    //9.-1,-5,5,9,10
    // -5 -> 최소는 무조건 생존
    //임의의 인접한 두 풍선을 고른 뒤, 두 풍선 중 하나를 터트립니다. i의 양옆
    //터진 풍선으로 인해 풍선들 사이에 빈 공간이 생겼다면, 빈 공간이 없도록 풍선들을 중앙으로 밀착시킵니다
    static public int solution2(int[] a){
        int answer = 0;
        int min = 0;
        for (int i = 1; i < a.length; i++) {
            if(a[i] < a[min]) min = i;
        }
        return answer;
    }

}

/*
단 1개만 남을때까지 터트린다
임의의 인접한 2개 풍선 고르기 i,i+1
터트리고 배열 중앙으로
1번을 제외하곤 큰 번호의 풍선만 터트림
answer = 최후까지 남기는 것이 가능한 풍선들의 개수

 */

