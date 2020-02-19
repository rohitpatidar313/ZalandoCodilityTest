package test;

import main.com.codility.Task2;
import org.junit.Assert;
import org.junit.Test;

public class Task2Test {

    @Test
    public void testInvalidNumber(){
        int[] A={0};
        int[] B={};
        Assert.assertEquals(Task2.solution(A,B),0);
    }

    @Test
    public void testValidFairIndex(){
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 6, 0, 4};
        Assert.assertEquals(Task2.solution(A,B),2);
    }

    @Test
    public void testInValidFairIndex(){
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 5, 0, 4};
        Assert.assertEquals(Task2.solution(A,B),0);
    }

    @Test
    public void testDiffArraySize(){
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 5};
        Assert.assertEquals(Task2.solution(A,B),0);
    }

    @Test
    public void testAllNegativeNum(){
        int[] A = {-4, -1, -2, -3};
        int[] B = {-9,4,-4,-1};
        Assert.assertEquals(Task2.solution(A,B),2);
    }
}
