package com.small.Stack.Base;

import lombok.Data;

/**
 * 两栈共享空间结构
 */
@Data
public class SqDoubleStackNode extends BaseStack{
    private int[] data;
    private int topZero;
    private int topLast;

    public SqDoubleStackNode(int maxCapacity) {
        this.data = new int[maxCapacity];
    }
}
