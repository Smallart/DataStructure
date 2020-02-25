package com.small.Stack.Base;

import lombok.Data;

@Data
public class ArrayStack extends BaseStack{
    private int[] data;
    private int top;
    public ArrayStack(int maxCapacity) {
        this.data = new int[maxCapacity];
    }
}
