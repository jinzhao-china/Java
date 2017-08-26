package com.company.Generics;

/**
 * Created by zhaojin on 8/26/17.
 */
public class LinkedStack<T> {
    private class Node<T>{
        T item;
        Node<T> next;

        Node(){
            this.item = null;
            this.next = null;
        }

        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return this.item == null && this.next == null;
        }
    }

    Node<T> top = new Node<T>();

    public void push(T item){
        top = new Node<T>(item, top);
    }

    public T pop(){
        T result = this.top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args){
        LinkedStack<String> lst = new LinkedStack<>();
        for (String item :
                ("Hello world thanks your help").split(" ")) {
            lst.push(item);
        }

        String val ;
        while((val = lst.pop()) != null){
            System.out.println(val);
        }
    }
}
