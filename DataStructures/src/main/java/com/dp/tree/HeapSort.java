package com.dp.tree;


import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排列
        int[] arr={4,6,8,5,9};
        heapSort(arr);

    }
    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp=0;
        System.out.println("堆排序！！");
//        adjustHeap(arr,1,arr.length);
//        System.out.println(Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i=arr.length/2 -1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));


    }
    //将一个数组（二叉树），调整成一个大顶堆

    /**
     * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
     * @param arr arr待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length在逐渐的减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];//先取出当前变量的值保存在临时变量
        //开始调整
        //说明
        //1.k=i*2+1  k是i节点的左子节点
        for (int k = i*2+1; k <length ; k=k*2+1) {
            if (k + 1 < length && arr[k] < arr[k+1]) {//说明左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k]>temp){//如果子节点大于父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k; //i指向k，继续循环比较
            }else {
                break;
            }

        }
        //当for循环结束后，我们将以i为父节点的树的最大值，放在了最顶（局部）
        arr[i]=temp;//将temp值放在调整后的位置

    }



}
