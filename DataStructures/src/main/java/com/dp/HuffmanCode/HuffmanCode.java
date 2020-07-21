package com.dp.HuffmanCode;

import java.util.*;

/**
 * @author dp
 * @data 2020/7/19 - 21:05
 */
public class HuffmanCode {

    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes = content.getBytes ();
        System.out.println (contentBytes.length);
        List<Node> nodes = getNodes (contentBytes);
        System.out.println (nodes);
        //测试一把，创建的二叉树
        System.out.println ("赫夫曼树：");
        Node huffmanTreeRoot = createHuffmanTree (nodes);
//        preOrder (huffmanTreeRoot);
        huffmanTreeRoot.preOrder ();



    }
    //前序遍历的方法
    private static void preOrder(Node node){

        if (node!=null){
            node.preOrder ();
        }else {
            System.out.println ("赫夫曼树为空");
        }


    }

    /**
     * 接收一个字符数组返回一个list
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes){
        //创建一个arrayList
        ArrayList<Node> nodes = new ArrayList<Node> ();
        //存储每个byte出现的次数->map
        HashMap<Byte, Integer> counts = new HashMap<> ();
        for(byte b:bytes){
            Integer count = counts.get (b);//map还没有这个字符数据
            if(count==null){
                counts.put (b,1);
            }else {
                counts.put (b,count+1);
            }
        }
        //把每一个键值转成一个Node对象，并加入到nodes集合
        //遍历node
        for (Map.Entry<Byte, Integer> entry : counts.entrySet ()) {

            nodes.add (new Node (entry.getKey (),entry.getValue ()));

        }
        return nodes;


    }
    //通过一个list创建一颗霍夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size ()>1){
            //排序，从小到大
            Collections.sort (nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get (0);
            //取出第二课最小二叉树
            Node rightNode = nodes.get (1);
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;
            //将已经处理的二叉树从nodes中移除
            nodes.remove (leftNode);
            nodes.remove (rightNode);
            nodes.add (parent);
        }
        //nodes 最后节点，就是霍夫曼树的根节点
        return nodes.get (0);
    }



}
//创建node，待数据和权值
class Node implements Comparable<Node>{

    Byte data;//存放数据本身，比如'a'=>97
    int weight;//
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    public void preOrder(){

        System.out.println (this);

        if (this.left!=null){
            this.left.preOrder ();
        }
        if (this.right!=null){
            this.right.preOrder ();
        }



    }
}
