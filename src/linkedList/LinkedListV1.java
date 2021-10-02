package linkedList;

import java.util.Stack;

public class LinkedListV1 {

    class Node{
        private int data;
        private Node next;
        private Node tail;

        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }
    private Node head;
    public static void main(String[] args) {
        System.out.println(" Inside main **********************");
        LinkedListV1 l1=new LinkedListV1();
        LinkedListV1 l3;
        l1.addElementToTailOfLinkedList(70);
        l1.addElementToTailOfLinkedList(60);
        l1.addElementToTailOfLinkedList(50);
        l1.addElementToTailOfLinkedList(40);
        l1.addElementToTailOfLinkedList(30);
        l1.addElementToTailOfLinkedList(20);
        l1.addElementToTailOfLinkedList(10);
        l1.deleteNodeFromLinkedList(40);
        l1.printElementsOfLinkedList();
        l1.printLinkedListInReverse();
        l1.reverseLinkedList();
        l1.printElementsOfLinkedList();
        LinkedListV1 l2=new LinkedListV1();
        l2.addElementToTailOfLinkedList(400);
        l2.addElementToTailOfLinkedList(300);
        l2.addElementToTailOfLinkedList(65);
        l2.addElementToTailOfLinkedList(55);
        l2.reverseLinkedList();
        l3=l1.merge2Lists(l1,l2);
        Node currNovel3=l3.head;
        while(currNovel3!=null)
        {
            System.out.println("Printing Merge List Data"+currNovel3.data);
            currNovel3=currNovel3.next;

        }
    }

    private  LinkedListV1 merge2Lists(LinkedListV1 l1, LinkedListV1 l2) {
        LinkedListV1 l3=new LinkedListV1();
        Node head3=null;
        if(l1.head==null && l2.head==null) return null;
        if(l1.head==null) return l2;
        if(l2.head==null) return l1;
        Node currNodeL1=l1.head;
        Node currNodeL2=l2.head;
        Node currNodeL3=l3.head;

        while(currNodeL1!=null && currNodeL2!=null)
        {
            System.out.println(" Inside Loop"+currNodeL1.data );
            System.out.println(" Inside Loop"+currNodeL2.data );
            if(currNodeL1.data<=currNodeL2.data)
            {
                Node newNode=new Node(currNodeL1.data);
                if(l3.head==null)
                {
                    l3.head=newNode;
                    currNodeL3=newNode;
                }
                else{
                    currNodeL3.next=newNode;
                    currNodeL3=newNode;
                }
                currNodeL1=currNodeL1.next;

            }
            else{
                Node newNode=new Node(currNodeL2.data);
                if(l3.head==null)
                {
                    l3.head=newNode;
                    currNodeL3=newNode;
                }
                else{
                    currNodeL3.next=newNode;
                    currNodeL3=newNode;
                }
                currNodeL2=currNodeL2.next;

            }

        }
        if(currNodeL1!=null) currNodeL3.next=currNodeL1;
        if(currNodeL2!=null) currNodeL3.next=currNodeL2;

        System.out.println(" Came out of loop ");
        return l3;
    }

    private void reverseLinkedList() {
        Node currNode=head;
        Node prevNode=null;
        while(currNode!=null)
        {

            Node temp=currNode.next;
            currNode.next=prevNode;

            prevNode=currNode;
            currNode=temp;
        }
        head=prevNode;
    }

    private void printLinkedListInReverse() {
        Node currNode=head;
        Stack<Integer> st=new Stack<Integer>();
        while(currNode!=null)
        {
            st.push(currNode.data);
            currNode=currNode.next;
        }
        System.out.println("Printing List in Reverse");
        while(!st.empty())
        {
            System.out.println(st.pop());
        }
    }

    private void deleteNodeFromLinkedList(int data) {
        Node currNode=head;
        Node prevNode=head;
        while(currNode!=null)
        {
            if(currNode.data==data)
            {
                if(currNode==head) {head=null; return;}
                prevNode.next=currNode.next;
                currNode.next=null;
                break;
            }
            prevNode=currNode;
            currNode=currNode.next;
        }
    }

    private void addElementToHeadOfLinkedList(int data) {
        Node n1=new Node(data);
        Node currNode=head;
        if(head==null)
        {
            head=n1;
            return;
        }
        n1.next=head;
        head=n1;


    }

    private void printElementsOfLinkedList() {
        System.out.println("START::: Printing Elements of Linked list************");
        Node currNode=head;
        while(currNode!=null)
        {
            System.out.println(currNode.data);
            currNode=currNode.next;
        }
        System.out.println("END:::: Printing Elements of Linked list************");
    }

    private  void addElementToTailOfLinkedList(int data) {
        Node n1=new Node(data);
        if(head==null)
        {
            head=n1;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null)
        {
            currNode=currNode.next;
        }
        currNode.next=n1;
        return;
    }



      public class ListNode {
        int val;
         ListNode next;
        ListNode() {}
     ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        int count=0;
        ListNode currNode=head;
        while(currNode!=null)
        {
            currNode=currNode.next;
            count++;
        }
        k=k>=count?k%count:k;
        if(k==0) return head;

        while(k>0)
        {
            fast=fast.next;
            k--;
        }

        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        ListNode temp=slow.next;
        fast.next=head;
        head=temp;
        slow.next=null;
        return head;
    }
}
