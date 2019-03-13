"""
Problem Statement - Given rod of length n and table of price, determine the maximum revenue obtainable by cutting up the rod and selling the pieces.
"""

import sys

"""
Recursive Solution Drawback - Solves same subproblems repeatedly.
Running time = 2^n
"""
def recursiveCutRod(price, n):
    if n == 0:
        return 0
    optimalPrice = -sys.maxsize-1
    for i in range(n):
        optimalPrice = max(optimalPrice, price[i] + recursiveCutRod(price, n-i-1))
    return optimalPrice

def topDownCutRod(price, n):
    r = []
    for i in range(n+1):
        r.append(-sys.maxsize-1)
    return topDownCutRodAux(price, n, r)

def topDownCutRodAux(price, n, r): # helper routine
    if r[n] >= 0:
        return r[n]
    if n == 0:
        optimalPrice = 0
    else:
        optimalPrice = -sys.maxsize-1
        for i in range(n):
            optimalPrice = max(optimalPrice, price[i] + topDownCutRodAux(price, n-i-1, r))
    r[n] = optimalPrice
    return optimalPrice

def bottomUpCutRod(price, n):
    r = []
    s = [] #list of piece sizes
    for i in range(n+1):
        r.append(0)
        s.append(0)
    for i in range(1, n+1):
        optimalPrice = -sys.maxsize-1
        for j in range(i):
            #optimalPrice = max(optimalPrice, price[j] + r[i-j-1])
            #print(str(i) + "--->" + str(j) + " " + str(i-j) + " " + str(optimalPrice))
            if optimalPrice < price[j] + r[i-j-1]:
                optimalPrice = price[j] + r[i-j-1]
                s[i] = j+1
        r[i] = optimalPrice
    return r[n], s

if __name__ == "__main__":
    #price in dollars for a rod of length 0, 1,..,10 inches
    price = [1, 5, 8, 9, 10, 17, 17, 20, 24, 30]

    #find optimal solution to cut rod of length n inches
    n = 7

    # Recursive Solution -
    optimalPrice = recursiveCutRod(price, n)
    print("Recursive solution-\nOptimal price of rod of length " + str(n) + " is " + str(optimalPrice))

    #Dynamic Programming (both have running time of theta(n^2))-
    optimalPrice = topDownCutRod(price, n)
    print("\nDP Top-down solution-\nOptimal price of rod of length " + str(n) + " is " + str(optimalPrice))

    optimalPrice, optimalDecomposition = bottomUpCutRod(price, n)
    print("\nDP Bottom-up solution-\nOptimal price of rod of length " + str(n) + " is " + str(optimalPrice))
    print("\nOptimal Decomposition-")
    while n > 0:
        print(optimalDecomposition[n])
        n = n - optimalDecomposition[n]
