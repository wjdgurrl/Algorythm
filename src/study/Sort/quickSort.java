package study.Sort;

import java.util.*;
import java.io.*;

public class quickSort {
    static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
    static int n = arr.length;

    public static void main(String[] args) {
        quickSort(0, n);
        System.out.println(Arrays.toString(arr)); // 정렬된 배열 출력
    }

    public static void quickSort(int start, int end) { // arr[start to end-1]을 정렬
        if (end <= start + 1) return; // 수열 길이가 1 이하이면 종료 (base condition)

        int pivot = arr[start]; // 첫 번째 원소를 피벗으로 설정
        int left = start + 1;
        int right = end - 1;

        while (true) {
            while (left <= right && arr[left] <= pivot) left++;  // 왼쪽 포인터 이동
            while (left <= right && arr[right] >= pivot) right--; // 오른쪽 포인터 이동
            if (left > right) break; // 포인터가 엇갈리면 탈출

            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        // Swap pivot (arr[start]) with arr[right]
        int temp = arr[start];
        arr[start] = arr[right];
        arr[right] = temp;

        quickSort(start, right);
        quickSort(right + 1, end);
    }
}
