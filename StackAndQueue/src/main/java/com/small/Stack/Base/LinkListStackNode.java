package com.small.Stack.Base;

import lombok.Data;

/**
 * 链栈的实体
 */
@Data
public class LinkListStackNode extends BaseStack{
    private int data;
    private LinkListStackNode next;
}
