import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Fibotest {
    int[][] cases = {{0,0}, {1,1} , {2,1} , {3,2} , {4,3}};

    @Test
    void testFibo(){

//        assertEquals(0, new Fibo().fibo(0));
//        assertEquals(1, new Fibo().fibo(1));
//        assertEquals(1, new Fibo().fibo(2));
//        assertEquals(2, new Fibo().fibo(3));
//        assertEquals(3, new Fibo().fibo(4));
        for(int i=0; i < cases.length; i++){
            int order = cases[i][0];
            int expected = cases[i][1];
            assertEquals(expected, new Fibo().fibo(order));
        }
    }

    @Test
    void testFiboWithIteration(){
        for(int i=0; i < cases.length ; i++){
            int order = cases[i][0];
            int expected = cases[i][1];
            assertEquals(expected, new Fibo().fiboIter(order));
        }
    }
}
