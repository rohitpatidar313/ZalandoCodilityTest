package main.com.codility;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/*
@author Rohit P
@version 1.0
@since 2020-02-19
 */
public class Task2 {
    private static final int CONSTANT_ONE=-1;
    private static final int MIN_VALUE=1;
    private static final int MAX_VALUE=50000;

    public static void main(String[] args) {
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 6, 0, 4};

        int fairIndex = solution(A,B);
        System.out.println("Fair-index of the given arrays is:---->"+fairIndex);
    }

    public static int solution(int[] A, int[] B){
        if(!validateInput(A.length,B.length)) return 0;
        // Time complexity of this solution is O(n)
        int fairIndex = partitionOptimize(A,B);

        // Time complexity of this solution is O(n^2)
        //int fairIndexUnoptimized = partition(A,B);
        if (fairIndex != CONSTANT_ONE)
        {
            return fairIndex;
             //printArray(A, 0, fairIndex - 1);
             //printArray(A, fairIndex, A.length - 1);
             //printArray(B, 0, fairIndex - 1);
             //printArray(B, fairIndex, A.length - 1);
        }
        else {
            return 0;
        }
    }

    /*
    Partition the array into two sub-arrays with the same sum.
    This is the optimized solution with time complexity is Big O(n)
    @param A array of integers
    @param B array of integers
    @return int This returns fair Index of A & B
     */
    private static int partitionOptimize(int[] A, int[] B)
    {
        int totalSumA = Arrays.stream(A).sum();
        int totalSumB = Arrays.stream(B).sum();

        // variable to maintain sum of processed elements
        int sumSoFarA = 0;
        int sumSoFarB = 0;

        for (int i = 0; i < A.length; i++)
        {
            // if sum of A[0..i-1] is equal to A[i, n-1] and B[0..i-1] is equal to B[i, n-1]
            if ((sumSoFarA == totalSumA - sumSoFarA) && (sumSoFarB==totalSumB-sumSoFarB)) {
                return i;
            }
            sumSoFarA += A[i];
            sumSoFarB += B[i];
        }
        return -1;
    }

    /*
   This solution is NOT optimized and time complexity is Big O(n^2)
   @param A array of integers
   @param B array of integers
   @return int This returns fair Index of A & B
    */
    private static int partition(int[] A,int[] B)
    {
        if(A.length != B.length) return -1;
        // do for each element of the array
        for (int i = 0; i < A.length; i++)
        {
            int leftSumA = 0;
            int leftSumB = 0;
            for (int j = 0; j < i; j++) {
                leftSumA += A[j];
                leftSumB += B[j];
            }
            int rightSumA = 0;
            int rightSumB = 0;
            for (int j = i; j < A.length; j++) {
                rightSumA += A[j];
                rightSumB += B[j];
            }
            if ((leftSumA == rightSumA) && (leftSumB==rightSumB)
                    && (leftSumA == rightSumB) && (leftSumB == rightSumA) ) {
                return i;
            }
        }
        return -1;
    }

    /*
       This method print the sub-array A[start,end] & B[start,end].
       This method is not used currently as scope of the task is return only fair index not the array elements.
       @param array this is the array of integers
       @param start this is the initial index of the array
       @param end this is the end index of the array
       @return void
     */
    private static void printArray(int[] arrary, int start, int end)
    {
        System.out.println(IntStream.range(start, end + 1)
                .mapToObj(k -> arrary[k])
                .collect(Collectors.toList()));
    }

    /*
    This method validate input array length A & B.
    @param int length of array A
    @param int length of array B
    @return boolean
     */
    private static boolean validateInput(int AArrLen, int BArrLen){
        if(AArrLen >= MIN_VALUE && BArrLen >= MIN_VALUE && AArrLen <= MAX_VALUE && BArrLen <= MAX_VALUE && (AArrLen == BArrLen))
            return true;
        return false;
    }
}
