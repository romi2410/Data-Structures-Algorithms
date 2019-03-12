"""
Problem statement - Pay amount to customer using fewest coins.
"""

"""
Cashier's algorithm - At each iteration, add coin of the largest value that does not take us past the amount to be paid.

Drawback - Cashier's algorithm is optimal in this case because of special properties of US coin denominations. It is not optimal for other sets of denominations and in some cases, may not even lead to a feasible solution.
"""

def cashiersAlgo():
    coinsSelected = []
    denominations = [0.01, 0.05, 0.10, 0.25, 1.00]
    denominations.sort(reverse=True)
    amount = 2.89
    while amount > 0:
        d = largestCoinDenomination(amount,denominations)
        if d > 0:
            coinsSelected.append(d)
            amount = round(amount-d, 2)
        else:
            print("No solution")
            return
    print("Multiset of coins selected :" + str(coinsSelected))
    return

def largestCoinDenomination(amount, denominations):
    for d in denominations:
        if d <= amount:
            return d
    return 0

if __name__ == "__main__":
    cashiersAlgo()
