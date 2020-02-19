package test;

import main.com.codility.Task1;
import org.junit.Assert;
import org.junit.Test;

public class Task1Test {

    @Test
    public void testInvalidNumber(){
        Assert.assertEquals(Task1.solution(0),0);
    }

    @Test
    public void testValidNumber(){
        Assert.assertEquals(Task1.solution(28),37);
    }

    @Test
    public void testMaxNumber(){
        Assert.assertEquals(Task1.solution(50001),0);
    }

    @Test
    public void testMinNumber(){
        Assert.assertEquals(Task1.solution(1),10);
    }

    @Test
    public void testNegativeNumber(){
        Assert.assertEquals(Task1.solution(-11),0);
    }

    @Test
    public void testLargeNumber(){
        Assert.assertEquals(Task1.solution(8897),8969);
    }
}
