package com.dp.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[]={8,4,5,7,1,3,6,2};
        int temp[]=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));





    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){

        if (left<right){
            int mid=(left+right)/2;//中间的索引
            //向左递归进行分
            mergeSort(arr, left, mid, temp);

            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }

    }


    //合并的方法

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        System.out.println("#####################");
        int i=left;//初始化i，左边有序序列的初始索引
        int j=mid+1;//初始化j，右边有序数列的初始索引
        int t=0;//指向temp数组的当前索引

        //先把左右两边的数据按规则填充到temp数组
        //直到左右两边，有一边的数据处理完毕为止
        while(i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                t++;
                i++;
            } else {
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //把剩余数据的一边数据依次填充到temp
        while (i<=mid){
            //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }
        //将temp数组的元素拷贝到array
        //注意并不是每次拷贝所有
        t=0;
        int tempLeft=left;//

        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }

}
