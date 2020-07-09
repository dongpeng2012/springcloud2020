package com.dp.search;

/**
 * @author dp
 * @data 2020/7/4 - 21:00
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[]={1,9,11,-11,-1,34,89};


    }
    public static int seqSearch(int[] arr,int value){
        //
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
