'''
Bubble Sort - Repeatedly swapping the adjacent elements if they are in wrong order.

Time Complexity - 
  Worst Case O(n^2) - When array is reverse sorted.
  Best Case O(n) - When array is already sorted.
'''

def bubbleSort(list):
    for i in range(len(list)):
        sort = False;
        for j in range(len(list)-1-i):
            if (list[j] > list[j+1]):
                temp = list[j]
                list[j] = list[j+1]
                list[j+1] = temp
                sort = True
        if (sort == False):
            break
    return list

if __name__ == "__main__":
    list = [90, -9, 2, 4, 10, 25, 1908, 0]
    print(bubbleSort(list))
