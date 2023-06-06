package programmers;

public class course_42860 {
    public static void main(String[] args) {
        System.out.println(solution("BBB"));
    }
    static public int solution(String name){
        int answer = 0;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            int a = (ch - 'A');
            if(a <= 13) answer += a;
            else answer += (a-24);

        }
        return answer;
    }
}
class Stack<T>{
   class Node<T>{
       private T data;
       private Node<T> next;

       public Node(T data){
           this.data = data;
       }
   }
}
