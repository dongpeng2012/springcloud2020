package com.dp.tree;

/**
 * @author dp
 * @data 2020/7/6 - 21:32
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree ();
        //创建需要的节点
        HeroNode root = new HeroNode (1, "宋江");
        HeroNode node2 = new HeroNode (2, "无用");
        HeroNode node3 = new HeroNode (3, "卢俊义");
        HeroNode node4 = new HeroNode (4, "林冲");
//        HeroNode node5 = new HeroNode (5, "宋江");
        root.setLeft (node2);
        root.setRight(node3);
        node3.setRight (node4);
        binaryTree.setRoot (root);
        binaryTree.infixOrder ();

    }
}
//先创建HeroNode节点
class HeroNode{

    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //编写前序遍历的方法
    public void preOrder(){

        System.out.println (this);

        //递归向左子树前序遍历
        if (this.left!=null){
            this.left.preOrder ();
        }

        if (this.right!=null){
            this.right.preOrder ();
        }

    }
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder ();
        }
        System.out.println (this);
        if (this.right!=null){
            this.right.infixOrder ();
        }
    }
    public void postOrder(){

        if (this.left!=null) {
            this.left.postOrder ();
        }
        if (this.right!=null) {
            this.right.postOrder ();
        }
        System.out.println (this);
    }
    public HeroNode preOrderSearch(int no){
        if (this.no==no){
            return this;
        }
        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.preOrderSearch (no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=this.right.preOrderSearch (no);
        }
        return resNode;
    }
    public HeroNode inFixOrderSearch(int no){

        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.inFixOrderSearch (no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.no==no){
            return this;
        }
        if (this.right!=null){
            resNode=this.right.inFixOrderSearch (no);
        }
        return resNode;

    }
    public HeroNode postOrderSearch(int no){

        HeroNode resNode=null;
        if (this.left!=null){
            resNode=this.left.postOrderSearch (no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.left!=null){
            resNode=this.right.postOrderSearch (no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.no==no){
            return this;
        }
        return null;
    }
    public void delNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode (no);
        }
        if (this.right!=null){
            this.right.delNode (no);
        }
    }


}

class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root!=null) {
            this.root.preOrder ();
        }else {
            System.out.println ("二叉树为空无法遍历");
        }
    }

    public void infixOrder(){
        if (this.root!=null) {
            this.root.infixOrder ();
        }else {
            System.out.println ("二叉树为空无法遍历");
        }

    }

    private void postOrder(){
        if (this.root!=null) {
            this.root.postOrder ();
        }else {
            System.out.println ("二叉树为空无法遍历");
        }
    }


    private HeroNode preOrderSearch(int no){
        if (root!=null){
            return root.preOrderSearch (no);
        }else {
            return null;
        }
    }
    private HeroNode infixOrderSearch(int no){
        if (root!=null){
            return root.inFixOrderSearch (no);
        }else {
            return null;
        }
    }
    private HeroNode postOrderSearch(int no){
        if (root!=null){
            return root.postOrderSearch (no);
        }else {
            return null;
        }
    }



}
