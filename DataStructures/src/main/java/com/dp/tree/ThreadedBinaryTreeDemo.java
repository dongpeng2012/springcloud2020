package com.dp.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        //二叉树，后面要递归创建，现在简单处理手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        //测试：以10号节点
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("前驱节点是：");
        System.out.println(leftNode);
        System.out.println("后继节点是：");
        System.out.println(rightNode);

        //当线索化二叉树后，不能在使用原来的遍历方法

        threadedBinaryTree.threadedList();


    }

}
//实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建给指向当前节点的前驱节点的指针
    //在递归线索化时，pre总保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载一把threadNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树方法
    public void threadedList() {
        //定义一个变量存储当前遍历的节点
        HeroNode node = root;
        while(node != null) {
            //循环找到leftType == 1的节点，第一个找到的就是8节点
            //后面随着遍历而变化,因为当leftType==1时，说明该节点时按照线索化
            //处理的有效节点
            while(node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点就一直输出
            while(node.getRightType() == 1) {
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRight();

        }
    }

    //��д�Զ��������������������ķ���
    /**
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node) {

        //如果node==null，不能线索化
        if(node == null) {
            return;
        }

        //(一)先线索化左子树
        threadedNodes(node.getLeft());
        //(二)线索化当前节点[有难度]

        //处理当前节点的前驱节点
        //��8��������
        //8����.left = null , 8����.leftType = 1
        if(node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //
            pre.setRight(node);
            //
            pre.setRightType(1);
        }
        //!!! 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //（三）在线索化右子树
        threadedNodes(node.getRight());


    }

    //ɾ�����
    public void delNode(int no) {
        if(root != null) {
            //���ֻ��һ��root���, ���������ж�root�ǲ��Ǿ���Ҫɾ�����
            if(root.getNo() == no) {
                root = null;
            } else {
                //�ݹ�ɾ��
                root.delNode(no);
            }
        }else{
            System.out.println("����������ɾ��~");
        }
    }
    //ǰ�����
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void infixOrder() {
        if(this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }
    //�������
    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //ǰ�����
    public HeroNode preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //�������
    public HeroNode infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //�������
    public HeroNode postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //???null
    private HeroNode right; //???null
    //说明
    //1. 如果leftType == 0 表示指向的是左子树 若果是1 则指向的是前驱节点
    //2. 如果rightType == 0 表示指向的是右子树, 如果是1 表示指向后继节点
    private int leftType;
    private int rightType;



    public int getLeftType() {
        return leftType;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public int getRightType() {
        return rightType;
    }
    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    //?????????
    //1.??????????????????????????
    //2.?????????????????????????????
    public void delNode(int no) {

        //?·
		/*
		 * 	1. ???????????????????????????????ж???????????????????????????????ж???????????????????????.
			2. ?????????????????????????????? ??????????????this.left = null; ????????(??????????)
			3. ?????????????????????????????? ??????????????this.right= null ;????????(??????????)
			4. ?????2???3?????????????????????????????????е?????
			5.  ?????4????????????????????????????е?????.

		 */
        //2. ?????????????????????????????? ??????????????this.left = null; ????????(??????????)
        if(this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3.?????????????????????????????? ??????????????this.right= null ;????????(??????????)
        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //4.???????????????????е?????
        if(this.left != null) {
            this.left.delNode(no);
        }
        //5.????????????????е?????
        if(this.right != null) {
            this.right.delNode(no);
        }
    }

    //??д???????????
    public void preOrder() {
        System.out.println(this); //??????????
        //?????????????????
        if(this.left != null) {
            this.left.preOrder();
        }
        //?????????????????
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    //???????
    public void infixOrder() {

        //??????????????????
        if(this.left != null) {
            this.left.infixOrder();
        }
        //????????
        System.out.println(this);
        //??????????????????
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
    //???????
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //??????????
    /**
     *
     * @param no ????no
     * @return ????????????Node ,????????????? null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("??????????");
        //?????????????
        if(this.no == no) {
            return this;
        }
        //1.???ж???????????????????????????????????????
        //2.???????????????????????
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null) {//????????????????
            return resNode;
        }
        //1.???????????????????????????ж??
//        2.??????????????????????????????????????????????
        if(this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //???????????
    public HeroNode infixOrderSearch(int no) {
        //?ж????????????????????????????????????????
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("???????????");
        //???????????????????????????????????????????????
        if(this.no == no) {
            return this;
        }
        //???????????????????????
        if(this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    //???????????
    public HeroNode postOrderSearch(int no) {

        //?ж???????????????????????????????????????
        HeroNode resNode = null;
        if(this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null) {//??????????????
            return resNode;
        }

        //????????????????????????????????к??????????
        if(this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null) {
            return resNode;
        }
        System.out.println("??????????");
        //???????????????????????????????????
        if(this.no == no) {
            return this;
        }
        return resNode;
    }

}
