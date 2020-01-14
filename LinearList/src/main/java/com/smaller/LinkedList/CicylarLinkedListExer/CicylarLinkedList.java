package com.smaller.LinkedList.CicylarLinkedListExer;

import com.smaller.LinkedList.SinglyLinkedListExer.base.Node;
import com.smaller.base.LinearList;
//循环单链表
public class CicylarLinkedList implements LinearList<Integer> {
    private Node<Integer> headNode;
    public CicylarLinkedList(int num){
        headNode=new Node<>();
        headNode.data=0;
        headNode.next=headNode;
        //偶数头插，基数尾插
        if (num%2==0){
            headInsert(num);
        }else {
            tailInsert(num);
        }
    }
    //头插
    private void headInsert(int num){
        for (int i = 1; i <= num; i++) {
            Node<Integer> node = new Node<>();
            node.data=i;
            node.next=headNode.next;
            headNode.next=node;
            headNode.data++;
        }
    }
    //尾插
    private void tailInsert(int num){
        Node<Integer> next = headNode;
        for (int i = 1; i <= num; i++) {
            Node<Integer> node = new Node<>();
            node.data=i;
            node.next=next.next;
            next.next=node;
            next=node;
            headNode.data++;
        }
    }

    @Override
    public boolean isEmpty() {
        return headNode.data>0?false:true;
    }

    @Override
    public int size() {
        return headNode.data;
    }

    @Override
    public Integer get(int index) {
        if (index<1||index>headNode.data) return -1;
        Node<Integer> node=headNode;
        for (int i = 0; i < index; i++) {
            if (node.next!=headNode){
                node=node.next;
            }
        }
        return node.data;
    }

    @Override
    public void set(int index, Integer element) {
        if (index<1||index>headNode.data) return;
        Node<Integer> node=headNode;
        for (int i = 0; i < index; i++) {
            if (node.next!=headNode){
                node=node.next;
            }
        }
        node.data=element;
    }

    @Override
    public boolean add(int index, Integer element) {
        if (index<1||index>headNode.data+1) return false;
        Node<Integer> pre=headNode;
        for (int i = 1; i < index; i++) {
            if (pre.next!=headNode){
                pre=pre.next;
            }
        }
        Node<Integer> node = new Node<>();
        node.data=element;
        node.next=pre.next;
        pre.next=node;
        headNode.data++;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index<1||index>headNode.data+1) return false;
        Node<Integer> pre=headNode;
        for (int i = 1; i < index; i++) {
            if (pre.next!=headNode){
                pre=pre.next;
            }
        }
        pre.next=pre.next.next;
        headNode.data--;
        return true;
    }

    @Override
    public int locateElem(Integer element) {
        Node<Integer> node=headNode;
        for (int i = 1; i <=headNode.data; i++) {
            if (node.next!=headNode){
                node=node.next;
                if (node.data==element) return i;
            }
        }
        return -1;
    }

    @Override
    public void printList() {
        Node<Integer> node=headNode;
        for (Integer i = 0; i < headNode.data; i++) {
            if (node.next!=headNode){
                node=node.next;
                System.out.print(node.data+" ");
            }
        }
        System.out.println("循环链表的大小："+size());
    }
}
