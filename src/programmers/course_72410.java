package programmers;

public class course_72410 {
    public static void main(String[] args) {
        course_72410 aa = new course_72410();
        System.out.println(aa.solution("...!@BaT#*..y.abcdefghijklm"));
    }
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); // 문자열 소문자로 치환
        new_id = new_id.replaceAll("[-_.~!@#$%^&*()=+[{]}:?,<>/]","");
        new_id = new_id.replaceAll("..",".");
        if(new_id.charAt(0) == '.') new_id = new_id.replaceFirst(".",""); // replaceFirst 맨처음 문자열만 치환\
        if(new_id.charAt(new_id.length()) == '.') new_id = new_id.substring(0,new_id.length());
        if(new_id.equals("")) new_id+="a";
        if(new_id.length() > 15) new_id = new_id.substring(0,16);
        if(new_id.charAt(new_id.length()) == '.') new_id = new_id.substring(0,new_id.length());
        if(new_id.length() < 3){
            while(new_id.length() != 3){
                new_id += new_id.charAt(new_id.length());
            }
        }
        return answer;
    }

}
