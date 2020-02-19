package main.com.codility;
/*
@author Rohit P
@version 1.0
@since 2020-02-19
 */
public class Task1 {

    private static final int MIN_VALUE=1;
    private static final int MAX_VALUE=50000;

    public static void main(String[] args) {
     int minNumber = solution(28);
     System.out.println(minNumber);
    }

    public static int solution(int number){
        if(!validateInput(number)) return 0;
        int digitSum = digitSum(number);
        return findMinNumber(number,digitSum);
    }

    /*
      This method validate input number.
      @param int number
      @return boolean
   */
    private static boolean validateInput(int N){
        if( N>=MIN_VALUE && N <=MAX_VALUE) return true;
        return false;
    }

    /*
        This method find the minimum number whose digit sum is equal with given number's digits sum
        @param int number
        @param int digit sum of the given number
        @return int minimum number
     */
    private static int findMinNumber(int num,int digitSum){
        num++;
        if(digitSum(num)==digitSum) {
            return num;
        }
        return findMinNumber(num,digitSum);
    }

    /*
        This method calculate the sum of digits of the given number
        @param int input number
        @return int sum of digits
     */
    private static int digitSum(int number)
    {
        int ans = 0;
        while (number != 0)
        {
            ans += number % 10;
            number /= 10;
        }
        return ans;
    }
}
