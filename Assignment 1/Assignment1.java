/*
Assignment 1
Submitted By - Romi Padam (rkp170230)
Problem Statement -
1. Create a linked list(at least 15 nodes) of unsorted integers.
2. Traverse the list and print value of each node.
3. Sort the linked list by swapping the nodes instead of just values.
4. Traverse the list again and print value of each node.
*/

import java.io.IOException;

class Node {

    int value;
    Node next;

    Node(int v) {
        value = v;
        next = null;
    }
}

class LinkedList {

    protected Node head;
    protected Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    public void insertNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void traversal() {
        if (head == null){
            System.out.println("Linked List is empty");
        }
        else {
            Node tmp = head;
            while (tmp != null){
                System.out.print(tmp.value+" -> ");
                tmp = tmp.next;
            }
        }
    }
}

public class Assignment1 {

    public static void selectionSort(LinkedList list){
        Node first = list.head;
        Node min;
        Node temp;

        while (first.next != null) {
            min=first;
            temp=first.next;

            while(temp!=null) {
                if (temp.value < min.value)
                    min=temp;
                temp=temp.next;
            }
            //System.out.println("\nSwapping "+min.value+" and "+first.value);
            first=swap(list, min, first);
            //list.traversal();
            first=first.next;
        }
    }

    public static Node swap (LinkedList list, Node min, Node n) {

        Node temp=list.head;

        // If both nodes are same, don't do anything
        if (min == n)
            return min;

        // Search for previous node of Node min
        Node prevMin = null, currMin=min;
        while (temp != null && temp != min)
        {
            prevMin = temp;
            temp = temp.next;
        }

        // Search for previous node of Node n
        Node prevN = null, currN = n;
        temp=list.head;
        while (temp != null && temp != n)
        {
            prevN = temp;
            temp = temp.next;
        }

        // If min is not the head
        if (prevMin != null)
            prevMin.next = currN;
        else //If min is head, make n the new head
            list.head = currN;

        // If n is not the head
        if (prevN != null)
            prevN.next = currMin;
        else // If n is head, make min the new head
            list.head = currMin;

        // Change next of min and n
        Node tmp = currMin.next;
        currMin.next = currN.next;
        currN.next = tmp;

        return min;
    }

    public static void main(String[] args) throws IOException {
        LinkedList unSortedList = new LinkedList();

        //Inserting elements into Linked List
        unSortedList.insertNode(17);
        unSortedList.insertNode(8);
        unSortedList.insertNode(0);
        unSortedList.insertNode(-6);
        unSortedList.insertNode(7);
        unSortedList.insertNode(90);
        unSortedList.insertNode(70);
        unSortedList.insertNode(123);
        unSortedList.insertNode(2);
        unSortedList.insertNode(-89);
        unSortedList.insertNode(199);
        unSortedList.insertNode(1000);
        unSortedList.insertNode(76);
        unSortedList.insertNode(42);
        unSortedList.insertNode(8);

        //Linked list traversal
        System.out.println("Unsorted linked list: ");
        unSortedList.traversal();

        //Linked list sorting
        selectionSort(unSortedList);
        System.out.println("\nSorted linked list: ");
        unSortedList.traversal();
    }
}
