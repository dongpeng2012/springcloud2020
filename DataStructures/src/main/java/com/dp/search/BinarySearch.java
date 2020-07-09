package com.dp.search;

import java.util.ArrayList;

/**
 * @author dp
 * @data 2020/7/4 - 22:02
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000,1000,1234};

//        int i = binarySearch (arr, 0, arr.length - 1, 1234);
        ArrayList arrayList = binarySearch1 (arr, 0, arr.length - 1, 1000);
//        System.out.println (i);
        System.out.println (arrayList);

    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findVal < midValue) {
            return binarySearch (arr, left, mid - 1, findVal);
        } else if (findVal > midValue) {
            return binarySearch (arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }
    public static ArrayList binarySearch1(int[] arr, int left, int right, int findVal) {
        ArrayList<Integer> arrayList = new ArrayList<Integer> ();
        if (left > right) {
            return new ArrayList ();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];

        if (findVal < midValue) {
            return binarySearch1 (arr, left, mid - 1, findVal);
        } else if (findVal > midValue) {
            return binarySearch1 (arr, mid + 1, right, findVal);
        } else {

            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=midValue){
                    break;
                }
                arrayList.add (temp);
                temp--;

            }
            arrayList.add (mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=midValue){
                    break;
                }
                arrayList.add (temp);
                temp++;
            }
            return arrayList;
        }

    }
}






