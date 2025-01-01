package programmers;
import java.util. *;
import java.io. *;

/*
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
        1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        2. words에 있는 단어로만 변환할 수 있습니다.
        예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
        두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
*/

public class course_43163 {
    public static void main(String[] args) {
        course_43163 aa = new course_43163();
        System.out.println(aa.solution("hit", "cog",new String[]{"hot","dot","dog","lot","log","cog"}));
    }
    public static ArrayDeque<Word> deque;
    public static boolean[] visited;
    public int solution(String begin, String target, String[] words){
        int answer = Integer.MAX_VALUE;
        boolean check = false;
        visited = new boolean[words.length];
        deque = new ArrayDeque<>();

        //배열에 넣을 단어 선별
        for(int i = 0 ; i < words.length ; i++){
            if(target.equals(words[i])) check = true;
            if(matchWord(begin, words[i])) deque.offerLast(new Word(words[i],i));
        }
        if(check == false){
            answer = 0;
            return answer;
        }
        else answer = Math.min(bfs(words,target),answer);
        return answer;
    }
    public static boolean matchWord(String begin, String match){
        int count = 0; // 문자끼리 비교해서 맞는지 카운트 변수
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == match.charAt(i)) {
                count++;
            }
        }
        return count == begin.length()-1;
    }
    public static int bfs(String[] words,String target){
        while(!deque.isEmpty()){
            Word currentWord = deque.pollFirst();
            visited[currentWord.index] = true;
            if(currentWord.word.equals(target)){
                return ++currentWord.num;
            }

            //새로운 단어의 방문, 알파벳 체크
            for (int i = 0; i < words.length; i++) {
                if(!visited[i] && matchWord(currentWord.word, words[i])){
                    Word nextWord = new Word(words[i],i);
                    nextWord.num = currentWord.num + 1;
                    visited[nextWord.index] = true;
                    deque.offerLast(nextWord);
                }
            }
        }
        return 0;
    }
}

class Word{
    public String word;
    public int index;
    public int num;
    public Word(String word, int idx){
        this.word = word;
        this.index = idx;
    }
}
