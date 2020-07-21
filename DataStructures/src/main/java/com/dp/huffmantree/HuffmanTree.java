package com.dp.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dp
 * @data 2020/7/14 - 21:57
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root = createHuffmanTree (arr);

        //测试
        preOrder (root);



    }
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder ();
        }else {
            System.out.println ("是空树不能遍历");
        }
    }

    /**
     *
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好后的赫夫曼树的root节点
     */
    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<Node> ();
        for (int value : arr) {
            nodes.add (new Node (value));
        }
        while (nodes.size ()>1) {
            //排序从小到大
            Collections.sort (nodes);
            //取出根节点最小的两颗二叉树
            Node leftNode = nodes.get (0);
            Node rightNode = nodes.get (1);
            Node parent = new Node (leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //删除处理过的节点
            nodes.remove (leftNode);
            nodes.remove (rightNode);

            //将parent加入到nodes
            nodes.add (parent);
        }
        //返回赫夫曼树的root节点
        return nodes.get (0);
    }


}
class Node implements Comparable<Node>{
    int value;//节点权值
    char c;
    Node left;//指向做自己额点
    Node right;//指向柚子节点


    public void preOrder(){
        System.out.println (this);
        if (this.left!=null){
            this.left.preOrder ();
        }
        if (this.right!=null){
            this.right.preOrder ();
        }

    }

    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排
        return this.value-o.value;
    }
}
