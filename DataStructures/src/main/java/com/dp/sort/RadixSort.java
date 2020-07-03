package com.dp.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    //基数排序算法
    public static void radixSort(int arr[]) {

        //1.得到数组中的最大位数
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //第一轮(针对每个元素进行排序处理)

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1.二维数组包含10个一维数组
        //2.为了防止在被放入数的时候，数据溢出，每个桶大小只能定为arr.length()
        //3.基数排序是空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶一次存放了多少数据，我们定义一个一个一维数组，来记录各个桶每次放入的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位值
                int dightOfElement = arr[j]/ n% 10;
                //放入到对应的桶中
                bucket[dightOfElement][bucketElementCounts[dightOfElement]] = arr[j];
                bucketElementCounts[dightOfElement]++;
            }
            int index = 0;
            //遍历每一个桶，并将桶中数据，放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环第k个桶，放入数据即可
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }
                //每一轮处理后需要把
                bucketElementCounts[k]=0;
            }
        }
    }
}
