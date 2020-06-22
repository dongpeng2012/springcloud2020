package com.dp.stack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author dp
 * @data 2020/6/20 - 23:56
 */
public class PolandNotation {
    public static void main(String[] args) {

        //完成一个中缀表达式，转后缀表达式的功能
        //说明
        //1.1+((2+3)*4)-5  转成1 2 3 + 4 * + 5 -
        //2.因为直接对str进行操作，不方便，因此 先将"1+((2+3)*4)-5"=>中缀表达式对应的List
        String expression="1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList (expression);
        System.out.println (infixExpressionList);
        //把中缀表达式的list转为后缀表达式的list
        List<String> list = parseSuffixExpressionList (infixExpressionList);
        System.out.println (list);
        System.out.println ("结果是："+calculate (list));


//        //先定义给逆波兰表达式
//        //（3+4）* 5 - 6=  3 4 + 5 * 6 -
//        String suffixExpression="4 5 * 8 - 60 + 8 2 / +";
//        //思路
//        //1先把表达式放入一个arrayList中
//        //2将arrayList传递给一个方法，配合栈，遍历arrayList完成计算
//        List<String> rpnList = getListString (suffixExpression);
//        System.out.println ("rpnList="+rpnList);
//        System.out.println ("计算的结果是="+calculate (rpnList));
    }
    //将中缀表达式对应的list转换为后缀表达式的list
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 = new Stack<> ();//符号栈
        //整个转换过程中没pop，不用Stack直接使用ArrayList
//        Stack<String> s2 = new Stack<> ();//存储中间结果
        List<String> s2 = new ArrayList<> ();
        //遍历ls
        for (String item : ls) {
            //如果是一个数就入栈s2
            if (item.matches ("\\d+")){
                s2.add (item);
            }else if(item.equals ("(")){
                s1.push (item);
            }else if (item.equals (")")){
                while (!s1.peek ().equals ("(")){
                    s2.add (s1.pop ());
                }
                s1.pop ();//将这个（弹出s1栈，消除小括号
            }else{

//                if (s1.size()!=0&&s1.peek ().equals ("(")){
//                    s1.push (item);
//                }
                //当item的优先级小于等于栈顶运算符，并压入s2
                while (s1.size()!=0&&Operation.getValue (s1.peek ())>=Operation.getValue (item)){
                    s2.add (s1.pop ());
                }
                //还需要将item压入栈中
                s1.push (item);
            }
        }
        //将剩余的s1运算符一次压入s2
        while(s1.size ()!=0){
            s2.add (s1.pop ());
        }
        return s2;//因为存放的是List所有直接存放的就是逆波兰表达式

    }


    //将中缀表达式转换成对应的list
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放中缀表达式对应的内容
        List<String> list = new ArrayList<> ();
        int i=0;//相当于一个指针用于遍历s字符串
        String str;//对多位数的拼接
        char c;//每遍历一个字符就放入到c;
        do {
            if ((c=s.charAt(i)) < 48||(c=s.charAt(i))>57){
                list.add(c+"");
                i++;
            }else{
                //如果是一个数需要考虑多位数的问题
                str="";//先将str 变为空
                while (i<s.length ()&&(c=s.charAt (i))>=48&&(c=s.charAt (i))>=4){
                    str+=c;//拼接
                    i++;
                }
                list.add (str);
            }
        }while (i<s.length ());

        return list;
    }



    //讲一个逆波兰表达式，一次将数据和运算符，放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split (" ");
        List<String> list = Arrays.stream (split).collect (Collectors.toList ());
        return list;
    }
    public static int calculate(List<String> ls){
        //创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<> ();
        //遍历ls
        for (String item : ls) {
            //使用正则表达式取出数
            if(item.matches ("\\d+")){//匹配的多位数
                stack.push (item);
            }else {
                int num2=Integer.parseInt(stack.pop ());
                int num1=Integer.parseInt (stack.pop ());
                int res=0;
                if (item.equals ("+")){
                    res=num1+num2;
                }else if (item.equals ("-")){
                    res=num1-num2;
                }
                else if (item.equals ("*")){
                    res=num1*num2;
                }
                else if (item.equals ("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException ("运算符有误");
                }
                //res入栈
                stack.push (res+"");
            }
            //最后留在stack的数据就是运算结果了
        }
        return Integer.parseInt (stack.pop ());
    }
}
//编写一个类operation 可以返回一个运算符优先级
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    //写一个方法返回对应的优先级数字
    public static int getValue(String opration){
        int result = 0;
        switch (opration){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
//                System.out.println ("不存在该运算符");
                break;

        }

    return result;

    }




}
