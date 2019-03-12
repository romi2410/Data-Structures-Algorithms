- Dynamic Programming uses additional memory to save computation time (time-memory trade-off). Savings may be dramatic - exponential time to polynomial time.

- Two ways to implement DP approach - 
  1. Top-Down - 
  We write the procedure recursively in a natural manner, but modified to save the result of each subproblem (usually in an array or hash table). The procedure now first checks to see whether it has previously solved this subproblem. If so, it returns the saved value, saving further computation at this level; if not, the procedure computes the value in the usual manner. We say that the recursive procedure has been memoized; it “remembers” what results it has computed previously.
  
  2. Bottom-Up -
  
