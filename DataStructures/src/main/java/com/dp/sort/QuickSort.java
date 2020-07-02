package com.dp.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 3, 4, 2, 7, 1, 9,55,66,77,22,11,34342};
        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;

        int l=startIndex;
        int r=endIndex;

        int temp = arr[midIndex];
        int flag = 0;
        while (l<r) {
            while (arr[l] < temp) {
                l++;
            }
            while (arr[r] > temp) {
                r--;
            }
            if (l>=r){
                break;
            }
            flag = arr[l];
            arr[l] = arr[r];
            arr[r] = flag;
            if (arr[l] == temp) {
                r--;
            }
            if (arr[r] == temp) {
                l++;
            }
        }
        if (l==r){
            l+=1;
            r-=1;
//            System.out.println(Arrays.toString(arr));
            System.out.println("左"+l);
            System.out.println("右"+r);
        }
        if (startIndex<r) {
            quickSort(arr, startIndex, r);
        }
        if (l<endIndex){
            quickSort(arr,l, endIndex);
        }
    }

}
