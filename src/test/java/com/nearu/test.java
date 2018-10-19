package com.nearu;

import org.junit.Test;

import java.util.LinkedList;

public class test {
    @Test
    public void t1(){
        LinkedList<Object> linkedList = new LinkedList<Object>();
        linkedList.addFirst("asdf");

        OyeLinkedList oyeLinkedList = new OyeLinkedList();
        oyeLinkedList.add(1);
        oyeLinkedList.add(2);
        oyeLinkedList.add(3);
        oyeLinkedList.add(4);

        showListItems(oyeLinkedList);

        oyeLinkedList.remove(4);

        showListItems(oyeLinkedList);
    }

    private void showListItems(OyeLinkedList oyeLinkedList) {
        for (int i = 0; i < oyeLinkedList.size; i++) {
            int t = oyeLinkedList.get(i);
            System.out.println(t);
        }
        System.out.println("=============================");
    }
}
