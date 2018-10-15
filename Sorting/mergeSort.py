'''
Merge Sort - Divide input array in two halves, calls itself for the two halves and then merges the two sorted halves.
Time Complexity = O(n * log n)
'''

def mergeSort(list, first, last):
    if (first >= last):
        return
    mid = int((first+(last-1))/2)
    mergeSort(list, first, mid)
    mergeSort(list, mid+1, last)
    merge(list, first, mid, last)
    return list

def merge(list, first, mid, last):
    tmp = []
    x = first
    y = mid + 1
    for i in range(last-first+1):
        if x == mid + 1:
            tmp.append(list[y])
            y += 1
        elif y == last + 1:
            tmp.append(list[x])
            x += 1
        elif list[x] < list[y]:
            tmp.append(list[x])
            x += 1
        else:
            tmp.append(list[y])
            y += 1

    y = 0
    for i in range(first, last+1):
        list[i] = tmp[y]
        y += 1

    return list

if __name__ == "__main__":
    list = [90, -9, 2, 4, 10, 25, 1908, 0]
    print(mergeSort(list, 0, len(list)-1))
