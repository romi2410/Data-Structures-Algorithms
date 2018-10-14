'''
Selection Sort -
-> Sorts an array by repeatedly finding the smallest element (considering ascending order) from the unsorted part and putting it at the beginning.
-> In place sort 
-> Never makes more than O(n) swaps. Useful when memory write is costly operation.
-> Time Complexity - O(n^2)
'''
def selectionSort(list):
    for i in range(len(list)-1):
        for j in range(i+1, len(list)):
            if (list[i] > list[j]):
                temp =  list[i]
                list[i] = list[j]
                list[j] = temp
    return list

if __name__ == "__main__":
    list = [90, -9, 2, 4, 10, 25, 1908, 0]
    print(selectionSort(list))
