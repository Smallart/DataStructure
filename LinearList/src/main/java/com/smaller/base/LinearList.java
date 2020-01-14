package com.smaller.base;

public interface LinearList<T> {
    //判断线性表是否为空
    boolean isEmpty();
    //返回先行表的容量大小
    int size();
    //根据索引来获取线性表中的值
    T get(int index);
    //设置索引为指为i上的元素
    void set(int index,T element);
    //向线性表的index位置添加元素
    boolean add(int index,T element);
    //删除线性表中位置为i的元素
    boolean delete(int index);
    //在线性表中查找与参数相同的元素并且返回其下标
    int locateElem(T element);
    //展示表中数据
    void printList();
}
