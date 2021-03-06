package com.dp.bst;

/**
 * @author dp
 * @data 2020/7/21 - 23:00
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {

        int[] arr={7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree ();

        //循环的添加节点到二叉排序树
        for (int i : arr) {
            binarySortTree.add (new Node (i));
        }
        binarySortTree.infixOrder ();

    }




}
//二叉排序树
class BinarySortTree{
    private Node root;
    //添加节点的方法
    public void add(Node node){
        if (root==null){
            root=node;//如果root为空则直接让root指向node
        }else{
            root.add (node);
        }
    }

    public void infixOrder(){

        if (root!=null){
            root.infixOrder ();
        }else {
            System.out.println ("二叉排序树为空");
        }

    }



}


//创建node节点
class Node{

    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }

    //添加节点的方法
    //递归的形式添加节点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if (node==null){
            return;
        }
        //判断传入的节点的值，和当前子树的根节点的值的关系
        if (node.value<this.value){
            //如果当前节点的左子结点为空
            if (this.left==null) {
                this.left = node;
            }else {
                //递归的向左子树添加
                this.left.add (node);
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add (node);
            }
        }
    }

    


    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder ();
        }

        System.out.println (this);

        if (this.right!=null){
            this.right.infixOrder ();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}