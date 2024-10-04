package programmers_level0;

import java.util.*;

public class note {
    public static void main(String[] args) {
        note aa = new note();
        //System.out.println(Arrays.toString(aa.solution("banana")));
        //System.out.println(Arrays.toString(aa.solution2("Programmers")));
        //System.out.println(aa.solution("apporoograpemmemprs",new int[]{1, 16, 6, 15, 0, 10, 11, 3}));
        //System.out.println(Arrays.toString(aa.solution(new int[]{4,5,4},new int[]{1,0})));
        //System.out.println(Arrays.toString(aa.solution(new String[]{"u", "r", "l","d"})));
        //System.out.println(aa.solution(new int[]{1,2,3,100,99,98}));
        //System.out.println(aa.solution1(new int[]{12,4,15,1,14}));
        //System.out.println(aa.solution1("oxooxoxxox"));
        //System.out.println(aa.solution3("cabab")+""+aa.solution3("abcd")+""+aa.solution3("baconlettucetomato"));
        //System.out.println(Arrays.toString(aa.solution(new String[]{".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."}, 2)));
        System.out.println(aa.solution(5,555));
    }
    public int[] solution(int l, int r) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] answer = {};
        //01 11 100 101 111
        for(int i = l; i <= r ; i++){
            String a = Integer.toString(i);
            if(!a.contains("0") || !a.contains(("5"))){
                continue;
            }
            else{
                arr.add(i);
            }
        }
        System.out.println(arr);
        return answer;
    }
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[0].length();j++){
                String target = picture[i].substring(j,j+1);
                    for (int t = 0; t < k; t++) {
                        if(i ==0) {
                            answer[i] = target;
                            continue;
                        }
                        answer[i] += target;
                    }
            }
        }
        return answer;
    }

    public String[] solution3(String myStr) {
        String[] answer = {};
        ArrayList<String> al = new ArrayList<>();
        myStr = myStr.replaceAll("a"," ").replaceAll("b"," ").replaceAll("c"," ");
        String[] temp = myStr.split(" ");
        for(int i = 0;i<temp.length;i++){
            if(!temp[i].equals("")) al.add(temp[i]);
        }
        if(al.size() > 0){
            answer = new String[al.size()];
            for(int i=0;i<al.size();i++){
                answer[i] = al.get(i);
            }
        }else{
            answer = new String[1];
            answer[0] ="EMPTY";
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public int[] solution1(String myString) {
        int[] answer = {};
        int temp = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<myString.length();i++){
            if(myString.substring(0,1).equals("x") || myString.substring(myString.length()-1,myString.length()).equals("x")){
                al.add(0);
            }
            if(!myString.substring(i,i+1).equals("x")){
                temp++;
                continue;
            }
            else{
                al.add(temp);
                temp = 0;
            }
        }
        System.out.println(al.size());
        answer = new int[al.size()];
        for(int t =0;t<al.size();t++){
            answer[t] = al.get(t);
        }
        return answer;
    }

    public int solution1(int[] num_list) {
        int answer = 0;
        for(int t : num_list){
            while(t!= 1){
                t = aaa(t);
                answer ++;
            }
            System.out.println(answer);
        }
        return answer;
    }
    public int aaa(int a){
        if(a % 2 == 0){
            a /= 2;
        }
        else if(a % 2 != 0){
            a -= 1;
            a /= 2;
        }
        return a;
    }


    public int solution(int[] arr) {
        int answer = 0;
        int[] temp = Arrays.copyOf(arr,arr.length);
        while(true){
            int[] temp2 = aaa(Arrays.copyOf(temp,temp.length));
            if(Arrays.equals(temp,temp2)){
                break;
            }
            temp = temp2;
            answer++;
        }
        return answer;
    }
    public int[] aaa(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] >= 50 && t[i] % 2 == 0) {
                t[i] /= 2;
            } else if (t[i] < 50 && t[i] % 2 != 0) {
                t[i] = (t[i] * 2) + 1;
            }
        }
        return t;
    }

    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        answer = Arrays.copyOf(arr,arr.length);
        return answer;
    }

    public String[] solution(String[] str_list) {
        String[] answer = {};
        int t = 0;
        for(int i=0;i<str_list.length;i++){
            if(str_list[i].equals("l")){
                answer = new String[i];
                while(t < i){
                    answer[t] = str_list[t++];
                    System.out.println(Arrays.deepToString(answer));
                }
                break;
            }
            if(str_list[i].equals("r")){
                answer = new String[str_list.length - (i+1)];
                while(i+t < str_list.length-1){
                    answer[t] = str_list[(i+1) + t++];
                    System.out.println(Arrays.deepToString(answer));
                }
                break;
            }
        }
        return answer;
    }
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for(int i=0;i<my_string.length();i++){
            answer[i] = my_string.substring(i,my_string.length());
        }
        Arrays.sort(answer);
            return answer;
    }
    public int[] solution2(String my_string) {
        int[] answer = new int['z'-'A'-5];
        for(int i = 0; i< my_string.length();i++){
            char t = my_string.charAt(i);
            if('A'<=t && t<='Z'){
                answer[t-'A']++;
            }
            if('a'<=t && t<='z'){
                answer[t-'a'+26]++;
            }
        }
        return answer;
    }
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] strArr = my_string.split("");
        for ( int index : indices ) {
            strArr[ index ] = "";
        }

        return answer = String.join( "", strArr );
    }
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        ArrayList<int[]> al = new ArrayList<>();
        al.add(arr);
        for(int i =0; i<query.length;i++){
            int[] ar = al.get(i);
            if(i%2 == 0){
                if(query[i] == arr.length){
                    al.add(al.get(i));
                    continue;
                }
                int[] temp = new int[query[i]+1];
                for(int t=0;t<=query[i];t++){
                    temp[t] = ar[t];
                }
                al.add(temp);
            }
            else{
                if(query[i] == 0){
                    al.add(al.get(i));
                    continue;
                }
                int[] temp = new int[ar.length - query[i]];
                for(int t = query[i];t<= temp.length;t++){
                    temp[t-query[i]] = ar[t];
                }
                al.add(temp);
            }

        }
        answer = al.get(query.length);
        return answer;
    }
}
