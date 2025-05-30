package programmers;
import java.util.*;
import java.io.*;

/*주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
        항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
        제한사항
        모든 공항은 알파벳 대문자 3글자로 이루어집니다.
        주어진 공항 수는 3개 이상 10,000개 이하입니다.
        tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
        주어진 항공권은 모두 사용해야 합니다.
        만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
        모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

        [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]] 결과 ["ICN", "JFK", "HND", "IAD"]*/
//https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class course_43164 {
    public static void main(String[] args) {
        course_43164 aa = new course_43164();
        System.out.println(Arrays.toString(aa.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }

    private static boolean[] visited;
    private static boolean isArrived; // 도착 여부 확인(조기 종료용)
    private static String[] answer;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        isArrived = false;


        //티켓 정렬부터
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        ArrayList<String> route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN",route,tickets,0);
        answer= route.toArray(new String[route.size()]);

        return answer;
    }

    public void dfs(String current, ArrayList<String> route, String[][] tickets, int depth) {
        //티켓 끝
        if(depth == tickets.length){
            isArrived = true;
            return;
        }

        for (int i = 0; i  < tickets.length; i++){
            //도착지 가 같는지
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                route.add(tickets[i][1]);
                dfs(tickets[i][1],route,tickets,depth+1);

                if(isArrived){
                    return;
                }
                visited[i] = false;
                route.remove(route.size()-1); // 백트래킹
            }
        }
    }


}

