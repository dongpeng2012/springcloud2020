package com.dp.search;

/**
 * @author dp
 * @data 2020/7/4 - 23:24
 */
public class InsertValueSearch {

    public static void main(String[] args) {

        int [] arr= new int[100];
        for (int i = 0; i <100 ; i++) {
            arr[i]=i+1;
        }
        int i = insertValueSearch (arr, 0, 99, 10);
        System.out.println (i);


    }

    public static int insertValueSearch(int[] arr,int left,int right,int findValue){
        System.out.println ("good");
        if (left>right||arr[left]<arr[0] ||arr[right]>arr[arr.length-1]){
            return -1;
        }
        int mid=(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];

        if (findValue>midValue){
            return insertValueSearch (arr,mid+1,right,findValue);
        }else if (findValue<midValue){
            return insertValueSearch (arr,left,mid-1,findValue);
        }else {
            return mid;
        }
    }
}
