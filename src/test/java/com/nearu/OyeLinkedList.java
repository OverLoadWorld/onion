package com.nearu;

/**
 * https://algorithm.yuanbin.me/zh-hans/basics_data_structure/linked_list.html
 * Jdk中节点数据类型采用泛型
 */
public class OyeLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size = 0;

    public void linkFirst(Node<T> t){
        if (head != null) {
            Node<T> item = head;
            head = t;
            head.next = item;
        } else {
            head = t;
            tail = t;
        }
        size++;
    }

    public void linkLast(Node<T> t){
        if (head != null) {
            Node<T> item = head;
            head = t;
            head.next = item;
        } else {
            head = t;
        }
        size++;
    }

    public void remove(int i) {
    }

    private class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T val, Node<T> next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }


    Node node(int index){
        if (index < 0 || index >= size ) {
            return null;
        }
        Node e = head;
        for (int i = 0; i < index; i++) {
            e = e.next;
        }
        return e;
    }


    private Node getLastNode() {
        Node index = head;
        while (index != null && index.next != null) {
            index = index.next;
        }
        return index;
    }
}
