package programmers;

import java.util.*;
public class course_43164 {
    static class Node{
        int num;
        public Node(int num){
            this.num = num;
        }
    }
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(PassPort(tickets));
    }
    public static String PassPort(String[][] tickets){
        ArrayList<String> route =  new ArrayList<>(tickets.length+1);;
        HashMap<String,String> map = new HashMap<>();
        route.add("ICN");
        boolean[][] visited = new boolean[tickets.length][];
        for (int i = 0; i < tickets.length; i++) {
           if(!map.containsKey("ICN")){
               map.put(tickets[i][0],""); //[ICN , ""]
           }
           map.put(tickets[i][0],tickets[i][1]);
        }
        ArrayList<String> asc = new ArrayList<>(map.keySet());
        Arrays.sort(new ArrayList[]{asc});


        //return dfs(tickets,visited[0][0],new Node(0));
        return "i";
    }


    /*public static String dfs(String[][] tickets, boolean visited, Node now ){
        Queue<Node> q = new LinkedList<>();
        q.add(now); // 0 1 4 5 2 3
        if (now.num == 0){
            visited.add(route.get(0));
        }
        if ()
    }*/
}
