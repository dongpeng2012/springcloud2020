package com.dp.sort;

import java.util.Arrays;
//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[]={3,9,-1,10,-2};
        int arr[]=new int[80000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        bubbleSort(arr);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//        System.out.println(Arrays.toString(arr));


    }
    public static void bubbleSort(int[] arr){
        int temp=0;
        boolean flag=false;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
//            System.out.println(Arrays.toString(arr));
            if (flag=false){
                break;
            }else {
                flag=false;
            }
        }
    }
}
