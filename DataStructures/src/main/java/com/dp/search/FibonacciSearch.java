package com.dp.search;

import java.util.Arrays;

/**
 * @author dp
 * @data 2020/7/5 - 13:24
 */
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println (fibSearch (arr,89));
    }

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值下标
        int mid = 0;//存放mid值
        int f[] = fib ();//获取到斐波那契数列
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]的值可能大于a数组的长度，因此我们需要使用Arrays，因此需要一个新的数组并指向a
        int[] temp = Arrays.copyOf (arr, f[k]);
        //实际上需要用数组的最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid < high) {
                    return mid;
                }else {
                    return high;
                }
            }

        }
        return -1;

    }


}
