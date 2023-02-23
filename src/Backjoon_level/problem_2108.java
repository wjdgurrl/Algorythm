package Backjoon_level;
import java.util. *;
import java.io. *;
public class problem_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int input = 0;
        double avg = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());
            arr[i] = input;
            map.put(input,0); //중복검사 항목 만들기
        }
        Arrays.sort(arr);
        for (int num : arr) sum += num;
        avg = (double) sum / N;
        bw.write((int) avg);
        bw.write(arr[(int)N/2]);

        bw.write(arr[arr.length -1] - arr[0]);

        bw.close();
    }
}
