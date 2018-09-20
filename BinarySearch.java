
class BinarySearch {
    
    int binarySearch (int intArray[], int start, int end, int x) {
            
            int mid = start + (end - start) / 2;
            System.out.println(mid +" "+start+" "+end);
            
            if (start > end)
                return -1;
            
            if (intArray[mid]==x) {
                return mid;
            } else if (intArray[mid] > x) {
                return binarySearch(intArray, start, mid-1, x);
            } else if (intArray[mid] < x) {
                return binarySearch(intArray, mid+1, end, x);
            } else {
                return -1;
            }
    }

    public static void main(String[] args) {
       
        BinarySearch obj = new BinarySearch();
        
        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
        int intArrayLength = intArray.length;
        int elementToBeSearched = 10;
        
        int result = obj.binarySearch(intArray, 0, intArrayLength-1, elementToBeSearched);
        if (result == -1) 
            System.out.println("Element not found.");
        else 
            System.out.println("Element found at index: "+ result +".");
    }
    
}
