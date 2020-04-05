# Programming Assignment #3 Sorting algorithms

You are to write static methods that implement insertion sort, various quicksort
algorithms, and heapsort by completing the class and methods shown below.
The faster your sorts, the better. If your program runs too slowly, it probably means there
is something wrong. I will eventually create a test program that will show the speeds of your
sorts but I strongly recommend that you write your own test program so that you can start testing
your sorts immediately.

To be sure the stack does not overflow in your quicksorts write your recursive quicksort
methods with a loop that: (1) selects the pivot, (2) partitions the array by calling a partition
method, (3) makes the recursive call on the smaller partition(s), and (4) sets parameter values so
that the loop simulates the second/third recursive call on the larger/largest partition. Don't forget
that the recursive quicksort’s will look a little different depending on which partition algorithm
you use.

You are to write each of the following quicksort algorithms:
```
QuickSort1: outside-in partition, random pivot
QuickSort2: left-to-right-1-pivot partition, random pivot
QuickSort3: left-to-right-2-pivots, 2 random pivots
QuickSort4: outside-in partition, pivot = a[lf]
QuickSort5: left-to-right-1-pivot partition, pivot = a[lf]
AlmostQS1: Exact same driver as QuickSort1 except the call to InsertionSort is commented out
AlmostQS2: Exact same driver as QuickSort2 except the call to InsertionSort is commented out
AlmostQS3: Exact same driver as QuickSort3 except the call to InsertionSort is commented out
```
