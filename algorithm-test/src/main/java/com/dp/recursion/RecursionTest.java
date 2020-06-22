package com.dp.recursion;

/**
 * @author dp
 * @data 2020/6/22 - 22:54
 */
public class RecursionTest {
    public static void main(String[] args) {
    test (10);



    }
    //打印问题
    public static void test(int n){
        if (n>2){
            test (n-1);
        }
        System.out.println ("n="+n);
    }

    public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return factorial (n-1)*n;
        }
    }
}
