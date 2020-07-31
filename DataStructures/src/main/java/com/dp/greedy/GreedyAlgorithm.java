package com.dp.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放入到map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        broadcasts.put("k1",set1);
        broadcasts.put("k2",set2);
        broadcasts.put("k3",set3);
        broadcasts.put("k4",set4);
        broadcasts.put("k5",set5);
        //存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建arrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集

        HashSet<String> tempSet = new HashSet<>();


    }


}
