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
        while(time <= 100){
            //1. 등장 회수가 커지는 순
            //2. 수가 커지는 순
            //배열 정렬하고 리스트<노드>에 담아서 등장회수 대로 정렬
            if (r - 1 < A.length && c - 1 < A[0].length && A[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }
            if(time == 100){
                System.out.println(-1);
                return;
            }

            if (A.length >= A[0].length) {
                A = excuteR(A);
            } else {
                A = excuteC(A);
            }
            time++;
        }
    }

    /*public static int[][] excuteR(int[][] A){
        ArrayList<Node> arr;
        ArrayList<ArrayList<Node>> newArr = new ArrayList<>();
        int size = 0;

        for (int i = 0; i < A.length; i++) {
            arr = new ArrayList<>();
            int[] a = A[i].clone();
            int beforeNum = 0; //다음숫자랑 같은지 비교용

            Arrays.sort(a);

            int idx = 0;
            for (int j = 0; j < a.length; j++) {
                if(beforeNum == a[j] && j != 0){
                    arr.get(idx-1).plusCount();
                } else {
                    arr.add(new Node(a[j],1));
                    idx++;
                }
                beforeNum = a[j];
            }


            size = Math.max(arr.size() * 2, size);
            newArr.add(arr);
        }

        size = Math.min(100,size);

        int[][] newA = new int[A.length][size];
        for(int i = 0; i < A.length; i++){
            ArrayList<Node> row =  newArr.get(i);
            int index = 0;
            for(int j = 0; j < row.size() * 2 && j < 100; j++,index++){
                newA[i][j] = row.get(index).num;
                j++;
                newA[i][j] = row.get(index).count;
            }
        }

        return newA;
    }*/

    public static int[][] excuteR(int[][] A) {
        int rowLen = A.length;
        int maxColLen = 0; // 이 값은 실제 배열의 최대 열 길이 (100까지 제한되지 않은)

        List<List<Integer>> newRows = new ArrayList<>(); // List<List<Integer>>로 변경

        for (int[] ints : A) {
            int[] count = new int[101]; // 숫자 1부터 100까지의 개수를 저장
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 0) continue; // 0은 개수에 포함되지 않음
                count[ints[j]]++;
            }

            List<Node> nodeList = new ArrayList<>();
            for (int num = 1; num <= 100; num++) { // 숫자는 1부터 100까지
                if (count[num] > 0) {
                    nodeList.add(new Node(num, count[num]));
                }
            }
            nodeList.sort((a, b) -> {
                if (a.count == b.count) return a.num - b.num;
                return a.count - b.count;
            });

            List<Integer> currentRowList = new ArrayList<>();
            for (Node node : nodeList) {
                currentRowList.add(node.num);
                currentRowList.add(node.count);
            }


            if (currentRowList.size() > 100) {
                currentRowList = currentRowList.subList(0, 100);
            }

            maxColLen = Math.max(maxColLen, currentRowList.size());
            newRows.add(currentRowList);
        }

        int finalColLen = Math.min(100, maxColLen);
        int[][] result = new int[rowLen][finalColLen];

        for (int i = 0; i < rowLen; i++) {
            List<Integer> row = newRows.get(i);
            for (int j = 0; j < row.size(); j++) {
                result[i][j] = row.get(j);
            }
        }
        return result;
    }

    public static int[][] excuteC(int[][] A){
        A = transe(A);
        A = excuteR(A);
        A = transe(A);
        return A;
    }

    public static int[][] transe(int[][] A){
        int row = A.length;
        int col = A[0].length;
        int[][] transedA = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transedA[j][i] = A[i][j];
            }
        }
        return transedA;
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
