/*
Assignment 3
Submitted By - Romi Padam (rkp170230)
Problem Statement -
Convert an array (of atleast 10 numbers) into heap using Floyd's method.
1. Print array before it is converted into a heap.
2. Print array after it is converted to a heap .
3. Insert a given element into a heap.
4. Delete a given element from a heap.
*/

package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    
    void arrayToMinHeap(ArrayList<Integer> arr) {
        int start = (arr.size() - 1) / 2;
        while(start >= 0)
        {
            heapify(arr, start);
            start--;
        }
    }
    
    void heapify(ArrayList<Integer> arr, int start) {
        int end = arr.size() - 1;
        
        int parentPos = start;
        int leftChildPos = 2 * parentPos + 1;
        int rightChildPos = leftChildPos + 1;
        int swapPos = 0;
        
        while (leftChildPos <= end) {

            //Check which one is smaller between left child and right child
            if (rightChildPos <= end)
                swapPos = (arr.get(leftChildPos) < arr.get(rightChildPos))?leftChildPos:rightChildPos;
            else
                swapPos = leftChildPos;
            
            //swap if the selected child is smaller than the parent
            if (arr.get(swapPos) < arr.get(parentPos)) {  
                Collections.swap(arr, parentPos, swapPos);
            } else
                return;
            
            parentPos = swapPos;
            leftChildPos = 2 * parentPos + 1;
            rightChildPos = leftChildPos + 1;
        }
    }
    
    public static void main(String[] args) {
        Heap heap = new Heap();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(16);
        arr.add(4);
        arr.add(10);
        arr.add(0);
        arr.add(7);
        arr.add(-9);
        arr.add(3);
        arr.add(2);
        arr.add(8);
        arr.add(89);
        
        System.out.println("Original array before it is converted into a heap:");
        for (int i=0; i<arr.size(); i++) 
            System.out.print(arr.get(i)+" ");
        
        heap.arrayToMinHeap(arr);
        System.out.println("\n\nMin Heap generated from the given array:");
        for (int i=0; i<arr.size(); i++) 
            System.out.print(arr.get(i)+" ");
        
        //Inserting an element into a heap - 
        //1. Add the new element to the end of the array. 
        //2. Check the heap property.
        int insertItem = 1;
        arr.add(insertItem);
        heap.arrayToMinHeap(arr);
        System.out.println("\n\nInserting element " + insertItem + " into the Min Heap:");
        for (int i=0; i<arr.size(); i++) 
            System.out.print(arr.get(i)+" ");
        
        //Deleteing an element from a heap - 
        //1. Replace the element to be deleted with the last element in the heap. 
        //2. Check the heap property.
        int deleteItem = 0;
        Collections.swap(arr, arr.indexOf(deleteItem), (arr.size() - 1));
        arr.remove(arr.size() - 1);
        heap.arrayToMinHeap(arr);
        System.out.println("\n\nDeleting element " + deleteItem + " from the Min Heap:");
        for (int i=0; i<arr.size(); i++) 
            System.out.print(arr.get(i)+" ");
    }
}