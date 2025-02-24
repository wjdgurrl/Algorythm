package study.Sort;

import java.io.*;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2751
public class problem_2751 {
    static int[] arr;
    static int[] temp; //merge 에서 쓰일 임시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0,N);

        for (int i = 0; i < N-1; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.write(arr[N-1]);

        bw.flush();
        br.close();
        bw.close();


    }
    public static void mergeSort(int start, int end){
        if(end - start == 1) return; //길이가 1이면 종료
        int mid = (start + end) / 2;

        mergeSort(start, mid); //좌측 정렬
        mergeSort(mid, end); // 우측 정렬
        merge(start, end);


    }

    public static void merge(int start, int end){
        int mid = (start + end) / 2;
        int lidx = start; //왼
        int ridx = mid; // 오

        //합치기
        for (int i = start; i < end; i++) {
            if(lidx == mid){ // 왼쪽 완료
                temp[i] = arr[ridx++];
            }else if(ridx == end){ //오른쪽 완료
                temp[i] = arr[lidx++];
            }else if(arr[lidx] <= arr[ridx]){
                temp[i] = arr[lidx++]; //왼쪽이 이하일때
            }else{
                temp[i] = arr[ridx++]; //오른쪽이 미만
            }
        }

        //합치고 배열에 복사
        for(int i = start; i < end; i++) arr[i] = temp[i];
    }
}
