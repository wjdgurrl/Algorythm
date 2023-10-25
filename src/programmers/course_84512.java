package programmers;

public class course_84512 {

    public static void main(String[] args) {
        course_84512 aa = new course_84512();
        System.out.println(aa.solution("AAAAE"));
        System.out.println(aa.solution("AAAE"));
        System.out.println(aa.solution("I"));
        System.out.println(aa.solution("EIO"));
        System.out.println(aa.solution("E"));
    }
    int A,E,I,O,U;
    public void setVal(int gap){
        this.A = 1;
        this.E = A+gap;
        this.I = E+gap;
        this.O = I+gap;
        this.U = O+gap;
    }
    public int solution(String word){
        int answer = 0;
        String[] arr= word.split("");;
        setVal(781);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("A")) answer+=A;
            if(arr[i].equals("E")) answer+=E;
            if(arr[i].equals("I")) answer+=I;
            if(arr[i].equals("O")) answer+=O;
            if(arr[i].equals("U")) answer+=U;
            if(i+1 == 1) setVal(156); //156
            if(i+1 == 2) setVal(31);
            if(i+1 == 3) setVal(6);
            if(i+1 == 4) setVal(1);
        }
        return answer;
    }
}
