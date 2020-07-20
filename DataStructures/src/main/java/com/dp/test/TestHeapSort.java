package com.dp.test;

public class TestHeapSort {
    public static void main(String[] args) {

    }

    public static void heapSort(int[] arr) {
        int temp;
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);

        }


    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//取当前值存在临时变量里
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k]>arr[i]){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;


    }


}
