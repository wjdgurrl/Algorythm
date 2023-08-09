package Backjoon_level;
import java.util. *;
import java.io. *;
public class problem_2447 {
    public static String[][] arr;
    public static int k = 3;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        problem_2447 star = new problem_2447();
        star.makeStar(N);
        star.printStar(N);
    }
    void makeStar(int N) throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = "*";
            }
        }
        if(N != k){
            for (int i = 1; i < 4; i++) {
                makeBlock(N);
            }
            N /= 3;
            makeStar(N);
        }
    }
    void makeBlock(int N){
        for (int i = N/3; i < (N/3)*2; i++) {
            for (int j = N/3; j < (N/3)*2; j++) {
                arr[i][j] = " ";
            }
        }
    }
    void printStar(int N) throws IOException {
        for (int i = 0; i < N;i++){
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        bw.flush();
        bw.close();
    }
    //27일 경우엔 9x9 공백이 가운데 있고
    //나머지 변은 n/3 = 9 패턴이 자리잡음
    //9일 경우엔 3x3 공백이 가운데 있고
    //나머지 변은 3 패턴이 자리잡음
    //n이 3이면 공백 1임
}
