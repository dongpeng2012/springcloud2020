package com.dp.test;



import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        int[] arr=new int[]{3,2,4};
//
//        int[] ints = twoSum1(arr, 6);
//        System.out.println(Arrays.toStrig(ints));
        System.out.println(reverse(-321));

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <nums.length; i++) {
        for (int j = i+1; j <nums.length ; j++) {
            if (nums[i]+nums[j]==target){
                return new int[]{i,j};
            }
        }
    }
        return null;
}
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;

    }

    public static int reverse(int x) {
//        try {
//            if (x>=0&&x<=Integer.MAX_VALUE){
//                String i=x+"";
//                String[] strings = i.split("");
//                String string = new String();
//                for (int i1 = 0; i1 < strings.length; i1++) {
//                    string=strings[i1]+string;
//                }
//                return Integer.valueOf(string);
//            }
//            if (x<0&&x>=Integer.MIN_VALUE){
//                String i=-x+"";
//                String[] strings = i.split("");
//                String string = new String();
//                for (int i1 = 0; i1 < strings.length; i1++) {
//                    string=strings[i1]+string;
//                }
//                return Integer.valueOf(string);
//            }
//        } catch (NumberFormatException e) {
//            return 0;
//        }
//        return 0;
        int ans=0;
        while(x!=0){
            int pop=x%10;
            if (ans>Integer.MAX_VALUE/10&&(ans==Integer.MAX_VALUE/10)&&pop>7){
                return 0;
            }
            if (ans<Integer.MIN_VALUE/10&&(ans==Integer.MAX_VALUE/10)&&pop<-8){
                return 0;
            }
            ans=ans*10+pop;
            x=x/10;
        }
        return ans;
    }

}
