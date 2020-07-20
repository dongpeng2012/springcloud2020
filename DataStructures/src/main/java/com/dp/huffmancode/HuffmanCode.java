package com.dp.huffmancode;
import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();

        byte[] bytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(bytes));

//        System.out.println(contentBytes.length); //40
//
//        List<Node> nodes = getNodes(contentBytes);
//
//        Node huffmanTreeRoot = createHuffmanTree(nodes);
//
//        getCodes(huffmanTreeRoot,"",stringBuilder);
//        System.out.println("生成的赫夫曼编码表"+huffmanCodes);
//
//        byte[] zip = zip(contentBytes, huffmanCodes);
//        System.out.println(Arrays.toString(zip));

    }
    //使用一个方法，将前面的方法封装起来，便于我们的调用

    /**
     *
     * @param bytes 原始的字符串对应的字符数组
     * @return 经过赫夫曼编码处理过的字节数组
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //根据赫夫曼树创建对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = getCodes(tree);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;

    }



    //编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]

    /**
     *
     * @param bytes 这是原始的字符串对应的byte[]
     * @param huffmanCodes huffmanCodes 生成赫夫曼编码的map
     * @return 返回赫夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes, Map<Byte,String> huffmanCodes){
        //1.利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        //将字符串转为一个byte数组
        //统计返回的byte[] huffmanCodeBytes长度
        int len;
        if (stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }

        //创建存储压缩后的byte数组

        byte[] huffmanCodeBytes=new byte[len];
        int index=0;//记录第几个bytes
        for (int i = 0; i < stringBuilder.length(); i=i+8) {//因为是每8位对应一个byte，所以步长应该是+8
            String strByte;
            if (i+8>stringBuilder.length()){//不够8位
                strByte=stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte，转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index]= (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;




    }



    //为了调用方便，我们重载getCodes
    private static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        //处理root的左子树
        getCodes(root.left,"0",stringBuilder);
        //处理root的右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;

    }




    //生成赫夫曼树对应的赫夫曼编码
    //思路：
    //1.将赫夫曼编码存放在Map<Byte,String>
    static Map<Byte,String> huffmanCodes = new HashMap<>();

    //2.在生成赫夫曼编码表时，需要取拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static StringBuilder stringBuilder=new StringBuilder();

    /**
     * 功能：将传入的node节点的所有叶子节点的赫夫曼树得到，并放入到huffmanCodes集合
     * @param node 传入节点
     * @param code 路径：左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node!=null){//如果node==null不处理
            //判断当前node是叶子节点还是非叶子节点
            if (node.data==null){//非叶子节点
                //递归处理
                //向左
                getCodes(node.left,"0",stringBuilder2);
                //向右
                getCodes(node.right,"1",stringBuilder2);
            }else {//说明是一个叶子节点
                //表示找到某个叶子结点的最后
                huffmanCodes.put(node.data,stringBuilder2.toString());

            }

        }

    }


    private static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("�շ�����Ϊ��");
        }
    }


    private static List<Node> getNodes(byte[] bytes) {

        ArrayList<Node> nodes = new ArrayList<Node>();

        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;

    }

    private static Node createHuffmanTree(List<Node> nodes) {

        while(nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }
        return nodes.get(0);

    }


}



class Node implements Comparable<Node>  {
    Byte data;
    int weight;
    Node left;
    Node right;
    public Node(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}