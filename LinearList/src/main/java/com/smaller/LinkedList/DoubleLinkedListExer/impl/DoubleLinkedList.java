package com.smaller.LinkedList.DoubleLinkedListExer.impl;

import com.smaller.LinkedList.DoubleLinkedListExer.base.Node;
import com.smaller.base.LinearList;

public class DoubleLinkedList implements LinearList<Integer> {
    private Node<Integer> head;
    public DoubleLinkedList(int num){
        head=new Node<>();
        head.data=0;
        head.next=head;
        head.pre=head;
        if (num%2==0){
            headInsert(num);
        }else{
            tailInsert(num);
        }
    }

    private void headInsert(int num){
        for (int i = 1; i <=num; i++) {
            Node<Integer> node = new Node<>();
            node.data=i;
            node.next=head.next;
            head.next.pre=node;
            node.pre=head;
            head.next=node;
            head.data++;
        }
    }
    
    private void tailInsert(int num){
        Node<Integer> p=head;
        for (int i = 1; i <=num; i++) {
            Node<Integer> node = new Node<>();
            node.data=i;
            node.next=p.next;
            p.next.pre=node;
            node.pre=p;
            p.next=node;
            p=node;
            head.data++;
        }
    }
    @Override
    public boolean isEmpty() {
        return head.data==0?true:false;
    }

    @Override
    public int size() {
        return head.data;
    }

    @Override
    public Integer get(int index) {
        if (index<1||index>head.data) return -1;
        Node<Integer> next=head.next;
        for (int i=0;i<index;i++){
            if (next.next!=head){
                next=next.next;
            }
        }
        return next.data;
    }

    @Override
    public void set(int index, Integer element) {
        if (index<1||index>head.data) return;
        Node<Integer> next=head.next;
        for (int i=0;i<index;i++){
            if (next.next!=head){
                next=next.next;
            }
        }
        next.data=element;
    }

    @Override
    public boolean add(int index, Integer element) {
        if (index<1||index>head.data+1) return false;
        Node<Integer> pre=head.next;
        for (int i=1;i<index;i++){
            if (pre.next!=head){
                pre=pre.next;
            }
        }
        Node<Integer> node = new Node<>();
        node.data=element;
        node.next=pre.next;
        pre.next.pre=node;
        node.pre=pre;
        pre.next=node;
        head.data++;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index<1||index>head.data) return false;
        Node<Integer> pre=head.next;
        for (int i=1;i<index;i++){
            if (pre.next!=head){
                pre=pre.next;
            }
        }
        pre.next.next.pre=pre;
        pre.next=pre.next.next;
        head.data--;
        return true;
    }

    @Override
    public int locateElem(Integer element) {
        Node<Integer> node=head;
        for (int i=1;i<=head.data;i++){
            if (node.next!=head){
                node=node.next;
                if (node.data==element){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void printList() {
        Node<Integer> node=head;
        for (int i = 0; i < head.data; i++) {
            if (node.next!=head){
                node=node.next;
                System.out.print(node.data+" ");
            }
        }
        System.out.println("循环双链表目前节点数："+head.data);
    }
}
