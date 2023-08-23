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
    /*public enum Values{
        A_first(1),E_first(2),I_first(3),O_first(4),U_first(5),
        A_second(1),E_second(7),I_second(13),O_second(19),U_second(25),
        A_third(1),E_third(32),I_third(63),O_third(94),U_third(125),
        A_fourth(1),E_fourth(156),I_fourth(313),O_fourth(469),U_fourth(625),
        A_fifth(1),E_fifth(782),I_fifth(1563),O_fifth(2344),U_fifth(3125);
        private int value;
        Values(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }*/
    int A,E,I,O,U;
    public void setVal(int A, int E, int I, int O, int U){
        this.A = A;
        this.E = E;
        this.I = I;
        this.O = O;
        this.U = U;
    }

    public int solution(String word){
        int answer = 0;
        String[] arr= word.split("");;
        setVal(1,782,1563,2344,3125);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("A")) answer+=A;
            if(arr[i].equals("E")) answer+=E;
            if(arr[i].equals("I")) answer+=I;
            if(arr[i].equals("O")) answer+=O;
            if(arr[i].equals("U")) answer+=U;

            if(i+1 == 1) setVal(1,157,313,469,625);
            if(i+1 == 2) setVal(1,32,63,94,125);
            if(i+1 == 3) setVal(1,7,13,19,25);
            if(i+1 == 4) setVal(1,2,3,4,5);
        }
        return answer;
    }
}
