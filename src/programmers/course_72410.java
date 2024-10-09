package programmers;

public class course_72410 {
    public static void main(String[] args) {
        course_72410 aa = new course_72410();
        System.out.println(aa.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(aa.solution("z-+.^."));
        System.out.println(aa.solution("=.="));
        System.out.println(aa.solution("123_.def"));
        System.out.println(aa.solution("abcdefghijklmn.p"));
        System.out.println(aa.solution(".ab......cd"));
    }
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); // 문자열 소문자로 치환
        new_id = new_id.replaceAll("[^a-z0-9._-]+", "");
        new_id = new_id.replaceAll("\\.{2,}",".");
        //if(new_id.charAt(0) == '.') new_id = new_id.replaceFirst(".",""); // replaceFirst 맨처음 문자열만 치환\
        //if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0,new_id.length()-1);
        new_id = new_id.replaceAll("^\\.|\\.$","");
        if(new_id.isEmpty()) new_id="a";
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.$","");
        }
        //if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0,new_id.length()-1);
        if(new_id.length() < 3){
            while(new_id.length() != 3){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        return answer = new_id;
    }

}
