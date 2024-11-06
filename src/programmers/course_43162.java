package programmers;

public class course_43162 {
    public static void main(String[] args) {
        course_43162 aa = new course_43162();
        System.out.println(aa.solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
    public int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfs(i,computers,visited);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int node, int[][] computers, boolean[] visited){
        visited[node] = true; // 방문 했으니까 true 처리

        for (int i = 0; i < computers.length; i++) {
            if(computers[node][i] == 1 && !visited[i]){ // 1로 연결된 노드 방문 후, 방문 처리
                dfs(i,computers,visited);
            }
        }
    }

}
