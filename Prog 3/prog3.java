/**
 * @author Bishoy A Abdelmalik
 * @class COMP 282 meeting at 2:00 PM
 * @Assigment Program #3
 * @DateTurnedIn Nov 20, 2019
 * @description this file includes ArraySorts which have all the code for
 * the diffrent sorting algorithms in addition
 * it incluedes the Pair class which was ued in some  of the sorts
 */
import java.util.Random;
class ArraySorts {
    /***********QuickSort1**********************/
    public static void QuickSort1(int[] a, int n, int cutoff) {
        Random r = new Random();
        //handle the situation if cutoff of 0 is passed in
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort1(a, 0, n - 1, cutoff, r);
        insertionSort(a, n);
    }
    public static void AlmostQS1(int[] a, int n, int cutoff) {
        Random r = new Random();
        //handle the situation if cutoff of 0 is passed in
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort1(a, 0, n - 1, cutoff, r);
        //insertionSort(a,n);
    }
    private static void QuickSort1(int[] a, int leftPointer, int rightPointer, int cutoff, Random r) {
        while (rightPointer - leftPointer >= (cutoff - 1)) {
            //choose random pivot in range
            int pivot = r.nextInt(rightPointer - leftPointer) + leftPointer;
            //partition
            pair partitionPoints = outsideIn(a, leftPointer, rightPointer, pivot);
            //recursively sort the smaller partition
            //and change the pointer to simulate the other
            if ((partitionPoints.getLeft() - leftPointer) < (rightPointer - partitionPoints.getRight())) {
                QuickSort1(a, leftPointer, partitionPoints.getLeft(), cutoff, r);
                leftPointer = partitionPoints.getRight();
            } else {
                QuickSort1(a, partitionPoints.getRight(), rightPointer, cutoff, r);
                rightPointer = partitionPoints.getLeft();
            }
        }
    }
    /***********End QuickSort1**********************/
    /***********QuickSort2**********************/
    public static void QuickSort2(int[] a, int n, int cutoff) {
        Random r = new Random();
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort2(a, 0, n - 1, cutoff, r);
        insertionSort(a, n);
    }
    public static void AlmostQS2(int[] a, int n, int cutoff) {
        Random r = new Random();
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort2(a, 0, n - 1, cutoff, r);
        //insertionSort(a,n);
    }
    private static void QuickSort2(int[] a, int leftPointer, int rightPointer, int cutoff, Random r) {
        while (rightPointer - leftPointer >= (cutoff - 1)) {
            //choose random pivot in range
            int pivot = r.nextInt(rightPointer - leftPointer) + leftPointer;
            //partition
            int partitionPoints = leftToRight1Pivot(a, leftPointer, rightPointer, pivot);
            //recursively sort the smaller partition
            //and change the pointer to simulate the other
            if (((partitionPoints - 1) - leftPointer) < (rightPointer - (partitionPoints + 1))) {
                QuickSort2(a, leftPointer, partitionPoints - 1, cutoff, r);
                leftPointer = partitionPoints + 1;
            } else {
                QuickSort2(a, partitionPoints + 1, rightPointer, cutoff, r);
                rightPointer = partitionPoints - 1;
            }

        }

    }
    /***********End QuickSort2**********************/

    /***********QuickSort3**********************/
    public static void QuickSort3(int[] a, int n, int cutoff) {
        Random r = new Random();
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort3(a, 0, n - 1, cutoff, r);
        insertionSort(a, n);

    }
    public static void AlmostQS3(int[] a, int n, int cutoff) {
        Random r = new Random();
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort3(a, 0, n - 1, cutoff, r);
        //insertionSort(a,n);
    }
    private static void QuickSort3(int[] a, int leftPointer, int rightPointer, int cutoff, Random r) {
        while (rightPointer - leftPointer >= (cutoff - 1) && leftPointer <= rightPointer) {

            pair partitionPoints = leftToRight2Pivot(a, leftPointer, rightPointer, r);
            // calculate the sizes of the partitions
            int sizeOfLessThan = (partitionPoints.getLeft() - 1) - leftPointer;
            int sizeOfGreaterThan = rightPointer - (partitionPoints.getRight() + 1);
            int sizeOfMiddlePartition = (partitionPoints.getRight() - 1) - (partitionPoints.getLeft() + 1);
            // sort the smallest 2 partitions recursively and simulate the third call with a loop
            if (sizeOfGreaterThan > sizeOfLessThan && sizeOfGreaterThan > sizeOfMiddlePartition) {
                //less than
                QuickSort3(a, leftPointer, partitionPoints.getLeft() - 1, cutoff, r);
                //middle
                QuickSort3(a, partitionPoints.getLeft() + 1, partitionPoints.getRight() - 1, cutoff, r);
                leftPointer = partitionPoints.getRight() + 1;//greater than
            } else if (sizeOfLessThan > sizeOfGreaterThan && sizeOfLessThan > sizeOfMiddlePartition) {
                //greater than
                QuickSort3(a, partitionPoints.getRight() + 1, rightPointer, cutoff, r);
                //middle
                QuickSort3(a, partitionPoints.getLeft() + 1, partitionPoints.getRight() - 1, cutoff, r);
                rightPointer = partitionPoints.getLeft() - 1;//less than
            } else {
                //less than
                QuickSort3(a, leftPointer, partitionPoints.getLeft() - 1, cutoff, r);
                //greater than
                QuickSort3(a, partitionPoints.getRight() + 1, rightPointer, cutoff, r);
                rightPointer = partitionPoints.getRight() - 1; //middle
                leftPointer = partitionPoints.getLeft() + 1;
            }
        }

    }
    /***********End QuickSort3**********************/
    /***********QuickSort4**********************/
    public static void QuickSort4(int[] a, int n, int cutoff) {
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort4(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }

    private static void QuickSort4(int[] a, int leftPointer, int rightPointer, int cutoff) {
        while (rightPointer - leftPointer >= (cutoff - 1)) {
            int pivot = 0 + leftPointer;
            pair partitionPoints = outsideIn(a, leftPointer, rightPointer, pivot);
            if ((partitionPoints.getLeft() - leftPointer) < (rightPointer - partitionPoints.right)) {
                QuickSort4(a, leftPointer, partitionPoints.getLeft(), cutoff);
                leftPointer = partitionPoints.getRight();
            } else {
                QuickSort4(a, partitionPoints.getRight(), rightPointer, cutoff);
                rightPointer = partitionPoints.getLeft();
            }

        }

    }
    /***********End QuickSort4**********************/
    /***********QuickSort5**********************/
    public static void QuickSort5(int[] a, int n, int cutoff) {
        cutoff = (cutoff < 2) ? 2 : cutoff;
        QuickSort5(a, 0, n - 1, cutoff);
        insertionSort(a, n);
    }

    private static void QuickSort5(int[] a, int leftPointer, int rightPointer, int cutoff) {
        while (rightPointer - leftPointer >= (cutoff - 1)) {
            int pivot = 0 + leftPointer;
            int partitionPoints = leftToRight1Pivot(a, leftPointer, rightPointer, pivot);
            if (((partitionPoints - 1) - leftPointer) < (rightPointer - (partitionPoints + 1))) {
                QuickSort5(a, leftPointer, partitionPoints - 1, cutoff);
                leftPointer = partitionPoints + 1;
            } else {
                QuickSort5(a, partitionPoints + 1, rightPointer, cutoff);
                rightPointer = partitionPoints - 1;
            }

        }

    }

    /***********End QuickSort5**********************/


    private static int leftToRight1Pivot(int[] a, int lastSmall, int lastIndex, int pivot) {
        int pivotValue = a[pivot];// save pivot value
        // swap the pivot and the first element
        swap(a, pivot, lastSmall);
        pivot = lastSmall;
        int firstUnknown = lastSmall + 1;
        //a flag helps with big arrays
        // if the array has a lot of values that are equal to the pivot
        boolean pivotDuplicate = false;
        while (firstUnknown <= lastIndex) {
            // keep advancing the first unknown until
            // it runs of the end of the array
            // or
            // it is smaller than the pivotValue in that case swap it
            if (a[firstUnknown] > pivotValue) {
                firstUnknown++;
            } else {
                boolean pivotAndFUEqual = a[firstUnknown] == pivotValue;
                if (pivotAndFUEqual) {
                    pivotDuplicate = (!pivotDuplicate);
                }
                //sometimes swap and sometimes don't
                if (pivotAndFUEqual && pivotDuplicate) {
                    firstUnknown++;
                } else {
                    lastSmall++;
                    swap(a, lastSmall, firstUnknown);
                    firstUnknown++;
                }
            }
        }
        swap(a, pivot, lastSmall);
        return lastSmall;
    }

    private static pair leftToRight2Pivot(int[] a, int firstIndex, int lastIndex, Random r) {
        int lastSmall, firstBig, firstUnknown, smallPivot, smallPivotValue, bigPivot, bigPivotValue;
        if ((lastIndex - firstIndex) < 2) {
            //if array only has 2 elements decide which is bigger
            //and swap if needed
            if (a[firstIndex] >= a[lastIndex]) {
                swap(a, firstIndex, lastIndex);
            }
            lastSmall = firstIndex;
            firstBig = lastIndex;
        } else {
            //choose the pivots
            int pivot1 = r.nextInt(lastIndex - firstIndex) + (firstIndex);
            swap(a, firstIndex, pivot1);
            pivot1 = firstIndex;
            int pivot2 = r.nextInt(lastIndex - (firstIndex + 1)) + (firstIndex + 1);
            //decide which pivot value is bigger
            // and put it in its right place
            if (a[pivot1] > a[pivot2]) {
                bigPivot = pivot1;
                bigPivotValue = a[pivot1];
                smallPivot = pivot2;
                smallPivotValue = a[pivot2];
            } else {
                bigPivot = pivot2;
                bigPivotValue = a[pivot2];
                smallPivot = pivot1;
                smallPivotValue = a[pivot1];
            }
            swap(a, firstIndex, smallPivot);
            //handle the case where the big pivot
            // comes to the first index
            if (bigPivot == firstIndex) {
                bigPivot = smallPivot;
            }
            swap(a, lastIndex, bigPivot);
            smallPivot = firstIndex;
            bigPivot = lastIndex;
            firstBig = bigPivot;
            lastSmall = smallPivot;
            firstUnknown = lastSmall + 1;
            //handle duplicate values with pivot
            // so we have unnecessary swaps
            boolean pivotDuplicate = false;
            while (firstUnknown < firstBig) {

                if (a[firstUnknown] == smallPivotValue) {
                    pivotDuplicate = (!pivotDuplicate);
                }

                if (smallPivotValue < a[firstUnknown] && a[firstUnknown] <= bigPivotValue) {
                    //the FU belong in the middle
                    firstUnknown++;
                } else if (a[firstUnknown] > bigPivotValue) {
                    //the FU belong in the big part
                    firstBig--;
                    swap(a, firstUnknown, firstBig);
                } else {
                    //the FU belong in the small part
                    // but to handle duplicate pivot values
                    // we sometimes consider values = to pivot in middle
                    if (a[firstUnknown] == smallPivotValue && pivotDuplicate) {
                        firstUnknown++;
                    } else {
                        lastSmall++;
                        swap(a, firstUnknown, lastSmall);
                        firstUnknown++;
                    }
                }


            }
            swap(a, smallPivot, lastSmall);
            swap(a, bigPivot, firstBig);
        }
        return new pair(lastSmall, firstBig);
    }


    private static pair outsideIn(int[] a, int leftPointer, int rightPointer, int pivot) {
        int pivotValue = a[pivot];// save the value of the pivot
        while (leftPointer <= rightPointer) {//while the pointers didn't overlap
            //find a value that needs swapping
            while (leftPointer < rightPointer && a[leftPointer] < pivotValue) {
                leftPointer++;
            }
            //find a value that needs swapping
            while (leftPointer < rightPointer && a[rightPointer] > pivotValue) {
                rightPointer--;
            }
            // if the pointers are not equal swap them
            // if they are equal advance one of them so they cross
            if (rightPointer != leftPointer) {
                swap(a, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            } else {
                if (a[leftPointer] <= pivotValue) {
                    leftPointer++;
                } else {//a[rightPointer] > pivotValue
                    rightPointer--;
                }
            }
        }

        return new pair(rightPointer, leftPointer);
    }

    /***********Heap Sort BU**********************/
    public static void HeapSortBU(int[] a, int n) {
        //Build heap
        buildHeapBU(a, n);
        // start from the end and
        // swap the first and last elements
        // then trickle down the first element into its right place
        for (int i = n - 1; i >= 1; i--) {
            swap(a, 0, i);
            trickleDown(a, 0, i);
        }
    } // heapsort with linear buildheap

    private static void buildHeapBU(int[] a, int n) {
        for (int i = n - 1; i >= 1; i--) {
            if (a[i] <= a[(i - 1) / 2]) {
                // do nothing if its less than or equal
            } else {
                // trickle up if the element is greater than its parent
                trickleUp(a, i, n);
            }
        }
    }
    /***********End Heap Sort BU**********************/
    /***********Heap Sort TD**********************/
    public static void HeapSortTD(int[] a, int n) {
        //Build heap
        buildHeapTD(a, n);
        // start from the end and
        // swap the first and last elements
        // then trickle down the first element into its right place
        for (int i = n - 1; i >= 1; i--) {
            swap(a, 0, i);
            trickleDown(a, 0, i);
        }
    } // heapsort with linear buildheap

    private static void buildHeapTD(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            trickleDown(a, i, n);
            //check if any of the current node parents
            // need to be trickled down
            for (int j = i; j > 0; j = (j - 1) / 2) {
                if (a[(j - 1) / 2] < a[j]) {
                    trickleDown(a, (j - 1) / 2, n);
                }
            }

        }
    }

    /***********End Heap Sort TD**********************/
    private static void trickleUp(int[] a, int i, int n) {
        int save = a[i];
        boolean exit = false;
        while (((i - 1) / 2) >= 0 && !exit) {
            if (save > a[(i - 1) / 2]) {
                a[i] = a[(i - 1) / 2];
                if (i > 0) {
                    trickleDown(a, i, n);
                }
                if (i - 1 < 0) {//end of array
                    exit = true;
                }
                i = (i - 1) / 2;

            } else {
                exit = true;
            }
        }
        a[i] = save;
    }

    private static void trickleDown(int[] a, int i, int n) {
        int save = a[i];
        boolean exit = false;
        boolean secondChildExist = (2 * i + 2) < n;
        boolean firstChildExist = (2 * i + 1) < n;

        while ((secondChildExist || firstChildExist) && !exit) {
            if (secondChildExist) {
                if (a[2 * i + 2] > a[2 * i + 1] && save < a[2 * i + 2]) {
                    a[i] = a[2 * i + 2];
                    i = 2 * i + 2;
                } else if (save < a[2 * i + 1]) {
                    a[i] = a[2 * i + 1];
                    i = 2 * i + 1;
                } else {
                    exit = true;
                }
            } else if (firstChildExist && save < a[2 * i + 1]) {
                a[i] = a[2 * i + 1];
                i = 2 * i + 1;
            } else {
                exit = true;

            }
            firstChildExist = (2 * i + 1) < n;
            secondChildExist = (2 * i + 2) < n;

        }
        a[i] = save;
    }

    /*
      swap method perform basic swap that is needed any of the sorts
      and doesn't swap if the 2 indices are the same
     */
    private static void swap(int[] a, int swap, int with) {
        if (swap == with) {
        } else {
            int save = a[swap];
            a[swap] = a[with];
            a[with] = save;
        }
    }

    /***********insertionSort**********************/
    public static void insertionSort(int[] a, int n) {
        //start from the second element in the array and insert every element
        for (int i = 1; i <= n; i++) {
            insert(a, i);
        }
    }// Insertion Sort

    private static void insert(int[] a, int n) {
        int i;
        int save = a[n - 1];
        //shift all the elements one spot
        for (i = n - 2; i >= 0 && save < a[i]; i--) {
            a[i + 1] = a[i];
        }
        a[i + 1] = save;
    }

    /***********End insertionSort**********************/
    public static String myName() {
        return "Bishoy Abdelamlik";
    }


}

// use this class to return two values in the outside-in and the 2-pivot // partition methods
class pair {
    public int left, right;

    public pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    // some getters below
    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}