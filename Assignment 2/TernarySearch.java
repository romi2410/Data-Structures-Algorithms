/*
Assignment 2
Submitted By - Romi Padam (rkp170230)
Problem Statement -
Given an array of sorted numbers, search an item using ternary search i.e. in each iteration divide
the list into three parts. Use recursion. Run your program for the following four cases -
1. Array has 15 elements and the item is in the array.
2. Array has 15 elements and the item is not in the list.
3. Array has 16 elements and the item is in the list.
4. Array has 16 elements and the item is not in the list.
*/
package TernarySearch;

class TernarySearch {
    
    int ternarySearch (int intArray[], int start, int end, int x) {
            
            int mid1 = start + (end - start) / 3;
            int mid2 = mid1 + (end-start) / 3;
                        
            if (start > end)
                return -1;
            
            if (intArray[mid1]==x) {
                return mid1;
            } else if (intArray[mid2]==x) {
                return mid2;
            } else if (intArray[mid1] > x) {
                return ternarySearch(intArray, start, mid1-1, x);
            } else if (intArray[mid2] < x) {
                return ternarySearch(intArray, mid2+1, end, x);
            } else if ((intArray[mid1] < x) && (intArray[mid2] > x)) {
                return ternarySearch(intArray, mid1+1, mid2-1, x);
            } else {
                return -1;
            }
    }

    public static void main(String[] args) {
       
        TernarySearch obj = new TernarySearch();
        
        int[] intArray = new int[]{ -90, -1, 0, 24, 92, 101, 102, 109, 110, 198, 289, 300, 1000, 1001, 2003 }; 
        int intArrayLength = intArray.length;
        int elementToBeSearched = 101;
        
        int result = obj.ternarySearch(intArray, 0, intArrayLength-1, elementToBeSearched);
        System.out.println("Following "+intArrayLength+" elements are present in the array: \n"+ java.util.Arrays.toString(intArray));
        if (result == -1) 
            System.out.println("\nElement "+elementToBeSearched+" not found.");
        else 
            System.out.println("\nElement "+elementToBeSearched+" found at index: "+ (result+1) +".");
    }
}
