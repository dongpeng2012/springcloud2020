package com.dp.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr=new int[8];
        for (int i = 0; i <8 ; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++) {
            int insertValue = arr[i];
            int insertIndex=i-1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertValue;
        }
    }

}
