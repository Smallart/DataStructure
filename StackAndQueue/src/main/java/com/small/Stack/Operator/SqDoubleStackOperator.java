package com.small.Stack.Operator;

import com.small.Stack.Base.BaseStack;

public interface SqDoubleStackOperator {
    //将栈清空,其中index是指关于对哪个栈进行操作
    boolean clearStack(int index);
    //判断栈是否为空，其中index是指关于对哪个栈进行操作
    boolean stackEmpty(int index);
    //获取栈顶元素,其中index是指关于对哪个栈进行操作
    int getTop(int index);
    //将数据压入栈中,其中index是指关于对哪个栈进行操作
    void push(int data,int index);
    //取出栈顶元素并且将其删除,其中index是指关于对哪个栈进行操作
    int pop(int index);
    //获取栈中元素个数,其中index是指关于对哪个栈进行操作
    int StackLength(int index);
}
