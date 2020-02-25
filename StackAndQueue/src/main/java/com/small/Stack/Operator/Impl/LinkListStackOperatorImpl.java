package com.small.Stack.Operator.Impl;

import com.small.Stack.Base.BaseStack;
import com.small.Stack.Base.LinkListStackNode;
import com.small.Stack.Operator.StackOperator;

/**
 * 使用链表实现栈这个结构，对于链栈来说头节点与头指针起到了一样的作用，故保留一个即可
 */
public class LinkListStackOperatorImpl implements StackOperator {
    //这个是头指针
    private LinkListStackNode head;

    @Override
    public void destroyStack() {

    }

    @Override
    public boolean clearStack() {
        head=null;
        return true;
    }

    @Override
    public boolean stackEmpty() {
        return head==null?true:false;
    }

    @Override
    public int getTop() {
        if (head==null) throw new RuntimeException("链栈为空");
        return head.getData();
    }

    @Override
    public void push(int data) {
        LinkListStackNode node = new LinkListStackNode();
        node.setData(data);
        LinkListStackNode first=head;
        node.setNext(first);
        head=node;
    }

    @Override
    public int pop() {
        int top = getTop();
        head=head.getNext();
        return top;
    }

    @Override
    public int StackLength() {
        int num=0;
        if (head==null)
        return 0;
        LinkListStackNode node=head;
        while(node.getNext()!=null){
            node=node.getNext();
            num++;
        }
        return num;
    }
}
