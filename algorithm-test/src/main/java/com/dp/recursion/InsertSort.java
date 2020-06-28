package com.dp.recursion;

import java.util.Arrays;

/**
 * @author dp
 * @data 2020/6/28 - 23:24
 */
public class InsertSort {

    public static void main(String[] args) {
//        int[] arr={101,34,119,1};

        int[] arr=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i]=(int)(Math.random ()*8000000);
        }
        long l = System.currentTimeMillis ();
        insertSort (arr);
        long l1 = System.currentTimeMillis ();
        System.out.println (l1-l);
//        System.out.println (Arrays.toString (arr));
    }
    //插入排序
    public static void insertSort(int[] arr){
        //使用逐步退到
        for (int i = 1; i <arr.length ; i++) {
            int insertVal=arr[i];
            int insertIndex=i-1;//即arr[1]的前面这个数的下标

            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1!=i){
                arr[insertIndex+1]=insertVal;
            }

        }


    }

}
