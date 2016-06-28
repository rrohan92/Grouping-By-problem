# Grouping-By-problem

Group-Pays Evaluation: 


Write a method to determine the groupings of integers in a two-dimensional matrix. 

Two or more of the same integers are considered “grouped” if they are directly above, below or to the side of each other.
	
	
	•	Parameters: int[][] matrix
    •	Output: int[][] groupSizes
      •	groupSizes[i][0] should be the integer in this grouping
      •	groupSizes[i][1] should be the number of those integers in the group

Example:

[ 0                   1                    1                  3 

 1                   0                    1                   2 

 1              0              0              2 

 1              1              1             1 ]


Should return (order of rows does not matter):

0              1

1              3

3              1

1              6

0              3

2              2

