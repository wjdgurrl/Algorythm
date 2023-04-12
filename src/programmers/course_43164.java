package programmers;

import java.util.*;

public class course_43164 {
    /*public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(PassPort(tickets));
    }*/
    static String[][] emptyString;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(course_43164.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(course_43164.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }
    public static String[] solution(String[][] tickets) {
        emptyString = new String[tickets.length][];
        for (int i = 0; i < emptyString.length; i++) {
            emptyString[i] = new String[] {""};
        }
        return dfs("ICN", tickets, new String[0]);
    }
    public static String[] dfs(String word, String[][] tickets, String[] path) {
        path = Arrays.copyOf(path, path.length+1);
        path[path.length - 1] = word;
        List<String> nextAvailablePath = new ArrayList<>();
        boolean isAllPathEmpty = true;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(word)) {
                nextAvailablePath.add(tickets[i][1]);
                tickets[i] = new String[] {""};
                isAllPathEmpty = false;
            }
        }
        if (isAllPathEmpty && Arrays.deepEquals(tickets, emptyString)) {
            return path;
        }
        if (nextAvailablePath.isEmpty()) {
            return null;
        }
        nextAvailablePath.sort(String::compareTo);
        for (String s : nextAvailablePath) {
            return dfs(s, tickets, path);
        }
        return null;
    }
}


/*    static class Node{
        int num;
        public Node(int num){
            this.num = num;
        }
        *//*public Node(String next){
            route.add(next);
        }*//*
    }

    public static String PassPort(String[][] tickets){
        boolean visited = false;
        HashMap<String,String> map = new HashMap<>(); //
        *//*route = new String[tickets.length+1]; *//*
        //route.add("ICN");
        for (int i = 0; i < tickets.length; i++) {
           if(!map.containsKey("ICN")){
               map.put(tickets[i][0],""); //[ICN , ""]
           }
           map.put(tickets[i][0],tickets[i][1]);
        }
        ArrayList<String> asc = new ArrayList<>(map.keySet());
        Arrays.sort(new ArrayList[]{asc});


        return dfs(tickets,visited,new Node(0));
    }
    static ArrayList<String> route = new ArrayList<>();

    public static String dfs(String[][] tickets,boolean visited, Node now ){
        Queue<Node> q = new LinkedList<>();
        q.add(now); // 0 1 4 5 2 3
        if (now.num == 0){
            visited.add(route.get(0));
        }
        if ()

    }
}*/
