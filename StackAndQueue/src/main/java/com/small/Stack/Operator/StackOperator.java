package com.small.Stack.Operator;

import com.small.Stack.Base.BaseStack;

public interface StackOperator {
    //若栈存在，则销毁
    void destroyStack();
   //将栈清空
    boolean clearStack();
    //判断栈是否为空
    boolean stackEmpty();
    //获取栈顶元素
    int getTop();
    //将数据压入栈中
    void push(int data);
    //取出栈顶元素并且将其删除
    int pop();
    //获取栈中元素个数
    int StackLength();
}
