package com.dp.recursion;

/**
 * @author dp
 * @data 2020/6/23 - 22:45
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        //地图
        int[][] map=new int[8][7];
        //使用1表示墙
        //上下全部置唯一
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print (map[i][j]+" ");
            }
            System.out.println ();
        }
        //使用递归回溯给小球找路
        setWay (map,1,1);

        //输出新的地图，小球走过，并标识过的递归

        System.out.println ("结果是：");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <7 ; j++) {
                System.out.print (map[i][j]+" ");
            }
            System.out.println ();
        }






    }
    //1.map表示地图
    //2. ij表示从地图的哪个位置开始出发
    //3. 如果小球能到[6][5]位置，则通路找到
    //4.当map[i][j]=0时这点还没测试过  为1时是墙，如果为2表示通路可以走
    //5.3表示已经探过但是走不通
    //6.在走迷宫时需要一个策略  ↓→↑←，如果改点走不通在回溯
    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到路了就返回true，否则返回false；
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            //通路已经找到ok
            return true;
        }else {
            if (map[i][j]==0){
                //当前点还没有走过
                map[i][j]=2;//假定该点是可以走通的
                if(setWay (map,i+1,j)){
                    return true;
                }else if (setWay (map,i,j+1)){
                    return true;
                }else if (setWay (map,i-1,j)){
                    return true;
                }else if (setWay (map,i,j-1)){
                    return true;
                }else {
                    //说明该点是走不通的，是死路
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }


        }
    }
}
