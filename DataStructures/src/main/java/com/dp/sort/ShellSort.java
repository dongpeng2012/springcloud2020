//package com.dp.sort;
//
//import java.util.Arrays;
//
//<<<<<<< Updated upstream
//public class ShellSort {
//    public static void main(String[] args) {
////        int[] arr={3,5,7,8,9,4,2,1,6};
//
//        int arr[]=new int[80000];
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i]=(int)(Math.random()*8000000);
//        }
//        long l = System.currentTimeMillis();
//        shellSort2(arr);
//        long l1 = System.currentTimeMillis();
//        System.out.println(l1-l);
//
////        System.out.println(Arrays.toString(arr));
//
//    }
//
//    public static void shellSort(int[] arr){
//        int temp=0;
//        for (int fag=arr.length/2;fag>0;fag/=2){
//            for (int i = fag; i < arr.length ; i++) {
//                for (int j = i-fag; j >=0 ; j-=fag) {
//                    if (arr[j]>arr[j+fag]){
//                        temp=arr[j+fag];
//                        arr[j+fag]=arr[j];
//                        arr[j]=temp;
//                    }
//                }
//            }
//        }
//    }
//    public static void shellSort2(int[] arr){
//        for (int fag=arr.length/2;fag>0;fag/=2){
//            //从第gap个元素开始
//            for (int i = fag; i < arr.length ; i++) {
//                int j=i;
//                int temp=arr[i];
//                if (arr[j]<arr[j-fag]) {
//                    while (j-fag  >= 0 && arr[j-fag] > temp) {
//                        arr[j] = arr[j-fag];
//                        j -= fag;
//                    }
//                    arr[j] = temp;
//                }
//
//=======
///**
// * @author dp
// * @data 2020/6/30 - 23:16
// */
//public class ShellSort {
//    public static void main(String[] args) {
//
//        int[] arr={8,9,1,7,2,3,5,4,6,0};
//        shellSort (arr);
//        System.out.println (Arrays.toString (arr));
//
//
//    }
//    public static void shellSort(int[] arr){
//        int temp=0;
//        for (int gap=arr.length/2;gap>0;gap/=2){
//
//            for(int i=gap;i<arr.length;i++){
//
//                for (int j = i-gap; j >=0 ; j-=gap) {
//                    if (arr[j]>arr[j+gap]){
//                        temp=arr[j];
//                        arr[j]=arr[j+gap];
//                        arr[j+gap]=temp;
//                    }
//                }
//>>>>>>> Stashed changes
//            }
//        }
//    }
//}
