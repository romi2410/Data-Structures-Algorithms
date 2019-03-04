'''
Insertion Sort - Take one key at a time form unsorted array and insert it into correct position in sorted array.

Time Complexity - O(n^2)
'''

def insertionSort(A):
    for i in range(1, len(A)):
        key = A[i]
        j = i-1
        while j >= 0 and key < A[j]:
            A[j+1] = A[j]
            j -= 1
        A[j+1] = key
    return A

if __name__ == "__main__":
    A = [5, 2, 4, 6, 1, 3]
    print(insertionSort(A))
