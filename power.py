/*
Program to compute x ^ n using recursion.

Run time complexity = O(log n)

To run the program: python ./power.py x n
*/

import sys

def power(x, n):
    if (n == 0):
        return 1
    if (n % 2 == 0):
        y = power(x, n/2)
        return y * y
    else:
        y = power(x, (n-1)/2)
        return x * y * y

x = int(sys.argv[1])
n = int(sys.argv[2])
result = pow(x, n)
print(str(x) + " ^ " + str(n) + " = " + str(result))
