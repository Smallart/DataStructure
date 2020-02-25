package com.small.Stack.Operator.Impl;

import com.small.Stack.Base.BaseStack;
import com.small.Stack.Base.SqDoubleStackNode;
import com.small.Stack.Operator.SqDoubleStackOperator;
import com.small.Stack.Operator.StackOperator;

public class SqDoubleStackOperatorImpl implements SqDoubleStackOperator {
    private SqDoubleStackNode node;

    public SqDoubleStackOperatorImpl(int maxCapacity) {
        this.node = new SqDoubleStackNode(maxCapacity);
        node.setTopZero(-1);
        node.setTopLast(maxCapacity);
    }

    @Override
    public boolean clearStack(int index) {
        boolean flag=false;
        switch (index){
            case 1:
                node.setTopZero(-1);
                flag=true;
                break;
            case 2:
                node.setTopLast(node.getData().length);
                flag=true;
                break;
            default:
                throw new RuntimeException("共享栈中没有该类型");
        }
        return flag;
    }

    @Override
    public boolean stackEmpty(int index) {
        boolean flag=false;
        switch(index){
            case 1:
                System.out.println("零栈"+(node.getTopZero()==-1?"为空":"不为空"));
                flag=true;
                break;
            case 2:
                System.out.println("容栈"+(node.getTopLast()==node.getData().length?"为空":"不为空"));
                flag=true;
                break;
            default:
                throw new RuntimeException("共享栈中没有该类型");
        }
        return flag;
    }

    @Override
    public int getTop(int index) {
        switch(index){
            case 1:
                if (node.getTopZero()==-1){
                    throw new RuntimeException("零栈为空");
                }
                int data=node.getData()[node.getTopZero()];
                System.out.println("共享栈零栈栈顶元素："+data);
                return data;
            case 2:
                if (node.getTopZero()==node.getData().length){
                    throw new RuntimeException("容栈为空");
                }
                int lastData=node.getData()[node.getTopLast()];
                System.out.println("共享栈零栈栈顶元素："+lastData);
                return lastData;
            default:
                throw new RuntimeException("共享栈中没有该类型");
        }
    }

    @Override
    public void push(int data, int index) {
        if (node.getTopZero()+1==node.getTopLast()) return;
        switch(index){
            case 1:
                node.setTopZero(node.getTopZero()+1);
                node.getData()[node.getTopZero()]=data;
                break;
            case 2:
                node.setTopLast(node.getTopLast()-1);
                node.getData()[node.getTopLast()]=data;
                break;
            default:
                throw new RuntimeException("共享栈中没有该类型");
        }
    }

    @Override
    public int pop(int index) {
        switch(index){
            case 1:
                int data=getTop(index);
                node.setTopZero(node.getTopZero()-1);
                return data;
            case 2:
                int lastData=getTop(index);
                node.setTopLast(node.getTopLast()+1);
                return lastData;
            default:
                throw new RuntimeException("共享栈中没有该类型");
        }
    }

    @Override
    public int StackLength(int index) {
        switch (index){
            case 1:
                int zeroNum=node.getTopZero()+1;
                System.out.println("零栈的长度为："+zeroNum);
                return zeroNum;
            case 2:
                int lastNum=node.getData().length-node.getTopLast();
                System.out.println("容栈的长度为："+lastNum);
                return lastNum;
            default:
                throw new RuntimeException("共享栈中没有该类型");
        }
    }
}
