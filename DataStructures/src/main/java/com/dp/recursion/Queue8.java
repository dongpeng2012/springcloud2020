package com.dp.recursion;

public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max=8;
    int[] array=new int[max];
    public static int count=0;
    public static int judgeCount=0;
    public static void main(String[] args) {
        //测试一把8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有"+count+"种解法");
        System.out.println(judgeCount);

    }
    //编写一个方法，放置第n个皇后
    //特别注意：check是每一次递归时，进入到check都有for (int i = 0; i < max; i++)，因此会有回溯
    private void check(int n){
        if (n==max){
            //n=8,其实8个皇后就既然放好
            print();
            count++;
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把这个皇后n，放到改行的第一列
            array[n]=i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){//不冲突
                //接着放n+1个皇后
                check(n+1);
            }
            //如果冲突，就继续执行array[n]=i;即将第n个皇后，放置 在本行得后移一个位置

        }

    }



    //查看当我们放置第n个皇后，就去检测该皇后是否跟前面已经摆放的皇后冲突
    /**
     *
     * @param n n表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i=0;i<n;i++){
            //1.array[i]==array[n]表示判断 第n个和前面第n-1个皇后在同一列
            //2.Math.abs(n-i)==Math.abs(array[n])-Math.abs(array[i])判断是否在同一斜线
            //3.判断是否在同一行，没有必要，n每次都在递增
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }


    //写一个方法，可以将皇后摆放的位置输出
    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
