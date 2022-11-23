package Discord;

//로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
//
//로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며,
//이 방향은 동, 서, 남, 북중 하나이다. 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
//
//로봇 청소기는 다음과 같이 작동한다.
//
//현재 위치를 청소한다.
//현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
//로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class problem_14503 {
    public static void main(String[] args) {
        int r = 0;
        int c = 0;
        int d = 0; // 북쪽
        int N = 0;
        int M = 0;

        Robot R = new Robot(); //현재 자리 청소
        Space S = new Space(); //방 크기
        R.setLocation(r,c); // 청소기 현재 위치 설정
        S.setSpace(N,M);//방 크기 설정

    }
}
class Space{
    void setSpace(int x, int y){
        int[][] space = new int[x][y];
    }
}

class Robot{
    int r;
    int c;
    int forward;

    void setLocation(int x,int y){
        this.r = x;
        this.c = y;
    }

    void setForward(int d){
        int[] wasd = {0,1,2,3}; // 북 동 남 서
        this.forward = d;
        if (forward == 0);
        System.out.println("북");
        if (forward == 1);
        C.turnLeft();
    }

    Clean C = new Clean();
}

class Clean extends Robot{
    void turnLeft(){
        for (int i = 3; i >=0; i--) {
            if (i == 0){
                this.setForward(0);
                i+=3;
                //i=0;
            }
            if(i==3){

                this.setForward(0);
            }
        }
    }
    void Cleaning(){

    }
}



