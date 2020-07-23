package com.dp.hashtable;

/**
 * @author dp
 * @data 2020/7/5 - 18:22
 */
public class HashTableDemo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable (7);


    }




}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//创建EmpLinkedList,表示链表
class EmpLinkedList{
    //头指针指向第一个雇员
    private Emp head;


    //添加雇员到链表
    public void add(Emp emp){
        //如果是添加第一个雇员
        if (head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，则使用一个指针，则使用一个指针帮定位到最后
        Emp curEmp=head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp=curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next=emp;
    }
    public void list(int no){
        if (head==null){
            System.out.println ("当前"+no+"链表为空");
            return;
        }
        System.out.print ("当前链表的信息为");
        Emp curEmp=head;//辅助指针
        while (true){
            System.out.println (curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
    }

    public Emp findEmpById(int id){
        if (head==null){
            System.out.println ("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp=head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            if (curEmp.next==null){//说明遍历了链表没有找到
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;



    }




}
//创建hashTable管理多条链表
class HashTable{
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示共有多少条链表

    //构造求
    public HashTable(int size){
        //初始化
        empLinkedListArray = new EmpLinkedList[size];
        this.size=size;
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList ();
        }
    }

    public void add(Emp emp){
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNO=hashFun (emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add (emp);
    }
    //遍历所有的链表
    public void list(){
        for (int i = 0; i <size ; i++) {
            empLinkedListArray[i].list (hashFun (i));
        }
    }

    //编写散列函数，使用一个取模法
    public int hashFun(int id){
        return id%size;
    }
    public void findEmpById(int id){

        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun (id);
        Emp emp= empLinkedListArray[empLinkedListNO].findEmpById (id);
        if (emp!=null){

        }else {
            System.out.println ("在hash表中没有找到该雇员");
        }



    }



}