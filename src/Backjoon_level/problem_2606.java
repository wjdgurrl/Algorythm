package Backjoon_level;
import java.util.*;
import java.io.*;
public class problem_2606 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer_num = Integer.parseInt(br.readLine());
        int pair_num = Integer.parseInt(br.readLine());
        VirusConnection virusConnection = new VirusConnection(computer_num);
        for (int i = 0; i < pair_num; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);  // 1번 노드
            int b = Integer.parseInt(input[1]);  // 2번 노드
            virusConnection.addConnection(a,b);
        }
        int answer = virusConnection.InfectStart(1);
        System.out.println(answer);
        br.close();
        //클래스 노드 하나 생성
        //클래스 노드에 연결된 노드들 dfs로 입력
        // 1번 컴퓨터를 기준으로 연결된 노드 수 구하기

    }

    public static class VirusConnection{
        private HashMap<Integer,ArrayList<Integer>> map; //[1번노드] - [연결노드][연결노드][연결노드]
        private boolean[] visited;

        public VirusConnection(int computer_num){
            map = new HashMap<>();
            visited = new boolean[computer_num+1];

            for (int i = 1; i <= computer_num; i++) {
                map.put(i,new ArrayList<>());
            }
        }
        public void addConnection(int a, int b){
            map.get(a).add(b);
            map.get(b).add(a);
        }
        public void dfs(int start){
            Deque<Integer> deque = new LinkedList<>();
            deque.offerLast(start);

            while(!deque.isEmpty()){
                int node = deque.pollFirst();

                if(!visited[node]){
                    visited[node] = true;
                    for (int neighbor : map.get(node)){
                        deque.offerLast(neighbor);
                    }
                }
            }
        }
        public int InfectStart(int start){
            dfs(start);
            int answer = 0;
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]){
                    answer++;
                }
            }
            return answer-1;
        }
    }

}
