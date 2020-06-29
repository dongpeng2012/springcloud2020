package com.dp.sort;
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        int arr[]=new int[80000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        selectSort(arr);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
