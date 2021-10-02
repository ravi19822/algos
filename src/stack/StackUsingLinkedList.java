package stack;

import java.util.LinkedList;

public class StackUsingLinkedList {

    private LinkedList<Integer> l1=new LinkedList<Integer>();

    public StackUsingLinkedList() {

    }
    public void push(int data)
    {

       l1.push(data);

    }

    public int pop()
    {
      return l1.pop();
    }


    public static void main(String[] args) {
        System.out.println("Stack Implementation using Array");
        StackUsingLinkedList st =new StackUsingLinkedList();
        st.push(10);
        st.push(15);
        st.push(20);
        st.push(25);
        st.push(30);
        st.push(35);
        System.out.println(" Popping "+st.pop());
        st.push(5);




    }
}
