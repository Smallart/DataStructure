package com.smaller;

import com.smaller.LinkedList.CicylarLinkedListExer.CicylarLinkedList;
import com.smaller.LinkedList.DoubleLinkedListExer.impl.DoubleLinkedList;
import com.smaller.LinkedList.SinglyLinkedListExer.impl.SinglyLinkedList;
import com.smaller.SequenatialListExer.SequenatialList;
import org.junit.Test;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 顺序表测试
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SequenatialList sequenatialList = new SequenatialList(10);
        //初始化表
        for (int i=0;i<7;i++){
            sequenatialList.add(i+1,i);
        }
        sequenatialList.printList();
        int ops=0;
        int index=0;
        int element=0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要操作的数值：添加（1）；删除（2）；获取（3）；修改（4）；查找（5）；判空（6）");
            ops = scanner.nextInt();
            switch (ops){
                case 1:
                    System.out.println("现在进行添加操作");
                    System.out.print("请输入下标index：");
                    index=scanner.nextInt();
                    System.out.print("请输入内容elem：");
                    element=scanner.nextInt();
                    System.out.println("添加"+(sequenatialList.add(index,element)?"成功":"失败"));break;
                case 2:
                    System.out.println("现在进行删除操作");
                    System.out.print("请输入下标index：");
                    index=scanner.nextInt();
                    System.out.println("删除"+(sequenatialList.delete(index)?"成功":"失败"));break;
                case 3:
                    System.out.println("获取元素");
                    System.out.print("请输入下标index：");
                    index=scanner.nextInt();
                    System.out.println(sequenatialList.get(index));break;
                case 4:
                    System.out.println("修改元素");
                    System.out.print("请输入下标index：");
                    index=scanner.nextInt();
                    System.out.print("请输入内容elem：");
                    element=scanner.nextInt();
                    sequenatialList.set(index,element);break;
                case 5:
                    System.out.print("请输入内容elem,查找其下标");
                    element=scanner.nextInt();
                    System.out.println(sequenatialList.locateElem(element));break;
                case 6:
                    System.out.println("该表"+(sequenatialList.isEmpty()?"为空":"非空"));break;
                default:
                    return;
            }
            sequenatialList.printList();
        }while (ops!=0);
    }

    //单链表测试
    @Test
    public void SinglyLinkedListTest(){
        SinglyLinkedList headInsert = new SinglyLinkedList(10);
        headInsert.printList();
        SinglyLinkedList tailInsert = new SinglyLinkedList(9);
        tailInsert.printList();
        headInsert.add(14,14);
        headInsert.printList();
        headInsert.add(2,24);
        headInsert.printList();
    }

    //循环链表测试
    @Test
    public void CicylarLinkedList(){
        CicylarLinkedList headInsert = new CicylarLinkedList(10);
        headInsert.printList();
        CicylarLinkedList tailInsert = new CicylarLinkedList(9);
        tailInsert.printList();
        headInsert.add(5,23);
        headInsert.printList();
        headInsert.delete(1);
        headInsert.delete(11);
        headInsert.printList();
    }

    @Test
    public void DoubleLinkedList(){
        DoubleLinkedList headList = new DoubleLinkedList(10);
        headList.printList();
        DoubleLinkedList tailList = new DoubleLinkedList(9);
        tailList.printList();
    }
}
