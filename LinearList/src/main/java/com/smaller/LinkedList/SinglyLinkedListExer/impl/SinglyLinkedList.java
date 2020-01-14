package com.smaller.LinkedList.SinglyLinkedListExer.impl;

import com.smaller.LinkedList.SinglyLinkedListExer.base.Node;
import com.smaller.base.LinearList;

public class SinglyLinkedList implements LinearList<Integer> {

    private Node<Integer> headNode;
    //带参的构造函数，如果输入的num为偶数则头插法否则为尾插法
    public SinglyLinkedList(int num){
        //初始化头节点
        this.headNode = new Node<Integer>();
        headNode.data=0;
        headNode.next=null;
        if (num%2==0){
            headInsert(num);
        }else{
            tailInsert(num);
        }
    }
    //头插法
    private void headInsert(int num){
        for (int i = 0; i <num ; i++) {
            Node<Integer> node = new Node<>();
            node.data=i;
            node.next=headNode.next;
            headNode.next=node;
            headNode.data++;
        }
    }
    //尾插法
    private void tailInsert(int num){
        Node<Integer> next = new Node<>();
        next=headNode;
        for (int i = 0; i < num; i++) {
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
        return headNode.data==0?true:false;
    }

    @Override
    public int size() {
        return headNode.data;
    }

    @Override
    public Integer get(int index) {
        if (headNode.data<index) return -1;
        Node<Integer> node = new Node<>();
        node=headNode;
        for (int i = 0; i < index; i++) {
            if (node.next!=null){
                node=node.next;
            }
        }
        return node.data;
    }

    @Override
    public void set(int index, Integer element) {
        if (headNode.data<index|| index<1) return;
        Node<Integer> node = new Node<>();
        node=headNode;
        for (int i = 0; i < index; i++) {
            if (node.next!=null){
                node=node.next;
            }
        }
        node.data=element;
    }

    @Override
    public boolean add(int index, Integer element) {
        Node<Integer> pre = new Node<>();
        pre=headNode;
        for (int i = 0; i < index-1; i++) {
            if (pre.next!=null){
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
        if (index>headNode.data) return false;
        Node<Integer> pre = new Node<>();
        pre=headNode;
        for (int i = 0; i < index-1; i++) {
            if (pre.next!=null){
                pre=pre.next;
            }
        }
        pre.next=pre.next.next;
        headNode.data--;
        return true;
    }

    @Override
    public int locateElem(Integer element) {
        Node<Integer> node = new Node<>();
        node=headNode;
        int i=1;
        while(node.next!=null){
            node=node.next;
            if (node.data==element){
                return i;
            }
            i++;
        }
        return i;
    }

    @Override
    public void printList() {
        Node<Integer> node = new Node<>();
        node=headNode;
        while(node.next!=null){
            node=node.next;
            System.out.print(node.data+" ");
        }
        System.out.println("链表长度："+size());
    }
}
