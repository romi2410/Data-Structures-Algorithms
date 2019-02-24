"""
Problem Statement -
Write a function that takes two parameters n and k and returns the value of binomial coefficient C(n, k).

"""

def binomialCoeffRecursive(n, k):# Time Complexity - exponential
    #Base Cases
    if n == k or k == 0:
        return 1
    #Recursion
    return binomialCoeffRecursive(n-1, k-1) + binomialCoeffRecursive(n-1, k)

def binomialCoeffDP(n, k): # Time Complexity - O(n*k)
    result = [[0] * (k+1) for i in range(n+1)]
    for i in range(n+1):
        for j in range(min(i, k)+1):
            if i == j or j == 0:
                result[i][j] = 1
            else:
                result[i][j] = result[i-1][j-1] + result[i-1][j]
    return result[i][j]

if __name__ == "__main__":
    print(binomialCoeffRecursive(4, 2))
    print(binomialCoeffDP(4, 2))
