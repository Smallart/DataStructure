package com.smaller.SequenatialListExer;

import com.smaller.base.LinearList;

import java.util.Arrays;

public class SequenatialList implements LinearList<Integer> {
    private Integer[] data;
    private int MAX_SIZE;
    private int length;
    public SequenatialList(int capacity){
        this.data=new Integer[capacity];
        this.MAX_SIZE=capacity;
    }
    @Override
    public boolean isEmpty() {
        if (length==0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Integer get(int index) {
        if (index<1||index>length) return null;
        return data[--index];
    }

    @Override
    public void set(int index, Integer element) {
        if (index<1||index>length) return;
        data[--index]=element;
    }

    @Override
    public boolean add(int index, Integer element) {
        if (index<1||length==MAX_SIZE||index>length+1) return false;
        if (index==length+1){
            data[length]=element;
        }else{
            for (int i = length; i >=index ; i--) {
                data[i]=data[i-1];
            }
            data[index-1]=element;
        }
        length++;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index<1||index>length) return false;
        for (int i = index; i <length; i++) {
            data[i-1]=data[i];
        }
        length--;
        return true;
    }

    @Override
    public int locateElem(Integer element) {
        for (int i = 0; i < length; i++) {
            if (data[i]==element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void printList() {
        System.out.println(Arrays.toString(data)+"长度："+size());
    }
}
