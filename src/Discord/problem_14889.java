package Discord;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_14889 {
    public void main(String[] args) throws IOException {
        int N;
        String temp;
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));

        temp = String.valueOf(bf);
        N = Integer.parseInt(bff.readLine());

        int arr[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(temp, "");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //입력

                Soccer soc = new Soccer();
            }


        }
    }
    class Soccer {
        void split_team(int N, int arr[][]){
            int team1 = 0;
            int team2 = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = 0; j < N-1; j++) {
                    if(i == j){
                        continue;
                    }
                    team1 += arr[i][j] + arr[j][i];
                }
            }

        }


    }
}