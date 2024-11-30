package programmers;
import java.util. *;
import java.io. *;
public class course_86491 {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }
    public static int solution(int[][] sizes){
        int answer = 0;
        //가로를 무조건 더 길게 설정하기
        List<wallet> arr = new ArrayList<>();
        for (int i = 0; i < sizes.length; i++) {
            wallet wallet = new wallet();
            for (int j = 0; j < sizes[0].length; j++) {
                int len = sizes[i][0];
                int hth = sizes[i][1];
                if (len > hth){
                    wallet.setLength(len);
                    wallet.setHeight(hth);
                }else{
                    wallet.setLength(hth);
                    wallet.setHeight(len);
                }
            }
            arr.add(wallet);
        }
        int longestLength = 0;
        int longestHeight = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getHeight() > longestHeight){
                longestHeight = arr.get(i).getHeight();
            }
            if(arr.get(i).getLength() > longestLength){
                longestLength = arr.get(i).getLength();
            }
        }
        answer = longestHeight * longestLength;
        return answer;
    }
    static class wallet{
        private int length; // 가로
        private int height; // 세로

        public void setHeight(int height) {
            this.height = height;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getHeight() {
            return height;
        }

        public int getLength() {
            return length;
        }
    }
}
