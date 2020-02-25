package com.small.Stack.Operator.Impl;

import com.small.Stack.Base.ArrayStack;
import com.small.Stack.Base.BaseStack;
import com.small.Stack.Operator.StackOperator;

/**
 * 栈的顺序结构
 */
public class ArrayStackOperatorImpl implements StackOperator {
    private ArrayStack arrayStack;

    public ArrayStackOperatorImpl(int maxCapacity) {
        this.arrayStack = new ArrayStack(maxCapacity);
        this.arrayStack.setTop(-1);
    }


    @Override
    public void destroyStack() {
        arrayStack=null;
    }

    @Override
    public boolean clearStack() {
        arrayStack.setTop(-1);
        return true;
    }

    @Override
    public boolean stackEmpty() {
        return arrayStack.getTop()!=-1?false:true;
    }

    @Override
    public int getTop() {
        if (arrayStack.getTop()==-1){
            throw new RuntimeException("栈空");
        }
        int data=arrayStack.getData()[arrayStack.getTop()];
        return data;
    }

    @Override
    public void push(int data) {
        if (arrayStack.getData().length==arrayStack.getTop()+1){
            throw new RuntimeException("栈满");
        }
        int top = arrayStack.getTop();
        arrayStack.getData()[++top]=data;
        arrayStack.setTop(top);
    }

    @Override
    public int pop() {
        int data = getTop();
        arrayStack.setTop(arrayStack.getTop()-1);
        return data;
    }

    @Override
    public int StackLength() {
        return arrayStack.getTop()+1;
    }


}
