package com.small;

import static org.junit.Assert.assertTrue;

import com.small.Stack.Base.BaseStack;
import com.small.Stack.Base.SqDoubleStackNode;
import com.small.Stack.Operator.Impl.ArrayStackOperatorImpl;
import com.small.Stack.Operator.Impl.LinkListStackOperatorImpl;
import com.small.Stack.Operator.Impl.SqDoubleStackOperatorImpl;
import com.small.Stack.Operator.SqDoubleStackOperator;
import com.small.Stack.Operator.StackOperator;
import org.junit.Test;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 栈顺序结构测试
     */
    @Test
    public void arrayStackTest(){
      StackOperator  stackOperator= new ArrayStackOperatorImpl(10);
      int operatorFlag;
      do{
          System.out.println("请输入数字选择相应的操作：【0】退出，" +
                  "【1】判断栈是否为空，【2】获取栈顶元素，【3】将输入压入栈中，【4】取出栈中元素，并且删除该元素，" +
                  "【5】获取栈中元素个数");
          Scanner scanner = new Scanner(System.in);
          operatorFlag = scanner.nextInt();
          switch(operatorFlag){
              case 1:
                  System.out.println("该栈"+(stackOperator.stackEmpty()?"为空":"不为空"));
                  break;
              case 2:
                  System.out.println("获取栈顶元素："+stackOperator.getTop());
                  break;
              case 3:
                  System.out.println("请输入要压入栈中的元素");
                  stackOperator.push(scanner.nextInt());
                  break;
              case 4:
                  System.out.println("取出栈顶元素，并且删除："+stackOperator.pop());
                  break;
              case 5:
                  System.out.println("该栈中元素个数："+stackOperator.StackLength());
                  break;
          }
      }while (operatorFlag!=0);
    }

    @Test
    public void SqDoubleStackTest(){
        SqDoubleStackOperator stackOperator = new SqDoubleStackOperatorImpl(10);
        int operatorFlag;
        int index=0;
        do{
            System.out.println("请输入数字选择相应的操作：【0】退出，" +
                    "【1】判断栈是否为空，【2】获取栈顶元素，【3】将输入压入栈中，【4】取出栈中元素，并且删除该元素，" +
                    "【5】获取栈中元素个数");
            Scanner scanner = new Scanner(System.in);
            operatorFlag = scanner.nextInt();
            if (operatorFlag!=0){
                System.out.println("请输入共享栈的栈号：【1】零栈，【2】容栈");
                index=scanner.nextInt();
            }
            switch(operatorFlag){
                case 1:
                    stackOperator.stackEmpty(index);
                    break;
                case 2:
                    System.out.println("获取栈顶元素："+stackOperator.getTop(index));
                    break;
                case 3:
                    System.out.println("请输入要压入栈中的元素");
                    stackOperator.push(scanner.nextInt(),index);
                    break;
                case 4:
                    System.out.println("取出栈顶元素，并且删除："+stackOperator.pop(index));
                    break;
                case 5:
                    System.out.println("该栈中元素个数："+stackOperator.StackLength(index));
                    break;
            }
        }while (operatorFlag!=0);
    }

    @Test
    public void linkListStackTest(){
        StackOperator stackOperator = new LinkListStackOperatorImpl();
        int operatorFlag;
        do{
            System.out.println("请输入数字选择相应的操作：【0】退出，" +
                    "【1】判断栈是否为空，【2】获取栈顶元素，【3】将输入压入栈中，【4】取出栈中元素，并且删除该元素，" +
                    "【5】获取栈中元素个数");
            Scanner scanner = new Scanner(System.in);
            operatorFlag = scanner.nextInt();
            switch(operatorFlag){
                case 1:
                    System.out.println("该栈"+(stackOperator.stackEmpty()?"为空":"不为空"));
                    break;
                case 2:
                    System.out.println("获取栈顶元素："+stackOperator.getTop());
                    break;
                case 3:
                    System.out.println("请输入要压入栈中的元素");
                    stackOperator.push(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("取出栈顶元素，并且删除："+stackOperator.pop());
                    break;
                case 5:
                    System.out.println("该栈中元素个数："+stackOperator.StackLength());
                    break;
            }
        }while (operatorFlag!=0);
    }
}
