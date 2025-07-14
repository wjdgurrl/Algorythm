package Backjoon_level;

import java.util. *;
import java.io. *;

//https://www.acmicpc.net/problem/17140
public class problem_17140 {

    private static int r,c,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] A = setMap(br,st);
        searchArray(A);

    }

    public static void searchArray(int[][] A){
        int time = 0;
        int[][] temp = A.clone();//깊은 복사
        ArrayList<Node> arr;
        while(temp[r][c] == k || time < 100){
            //1. 등장 회수가 커지는 순
            //2. 수가 커지는 순
            //배열 정렬하고 리스트<노드>에 담아서 등장회수 대로 정렬
            for (int i = 0; i < 3; i++) {
                arr = new ArrayList<>();
                //여기서 인덱스 오류터짐 **
                int[] a = temp[i].clone();
                int beforeNum = 0;
                Arrays.sort(a);

                for (int j = 0; j < a.length; j++) {
                    if(beforeNum == a[j] && j != 0){
                        arr.get(j-1).plusCount();
                    } else {
                        arr.add(new Node(a[j],1));
                    }
                    beforeNum = a[j];
                }

                int[] sortedArray = new int[arr.size() * 2];
                int idx = 0;
                for (int j = 0; j < sortedArray.length; j+=2) {
                    //어레이리스트 접근할때 어레이 리스트껄로 해야함
                    if(arr.get(idx).num != 0){
                        sortedArray[j] = arr.get(idx).num;
                        sortedArray[j+1] = arr.get(idx).count;
                    }
                    idx++;
                }
                System.out.println(Arrays.toString(sortedArray));
            }




            time++;
        }


    }

    public static class Node{
        int num;
        int count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
        public void plusCount(){
            this.count++;
        }
    }


    public static int[][] setMap(BufferedReader br,StringTokenizer st) throws IOException {
        int[][] A = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return A;
    }


}
